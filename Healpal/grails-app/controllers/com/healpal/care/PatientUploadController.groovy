/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : PatientUploadController
 * Date      : 23-10-2015
 * Description : Upload patient details
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               23-10-2015         Initial Creation
 *
 */
package com.healpal.care

/**
 *
 *
 * @author Priyanga K
 *
 */
import java.text.DateFormat
import java.text.SimpleDateFormat
import com.healpal.encryptdecrypt.BCrypt;

class PatientUploadController {
	def ProfileService profileService;
	def UserRoleService userRoleService
	def UserService userService
	def AuditEventService auditEventService
	def DiagnosisService diagnosisService
	def CancerStatusService cancerStatusService
	def TempQuestionService tempQuestionService
	def ProfileCompletionService profileCompletionService
	def ReferralsService referralsService
	def index() {
		redirect(action:'fileUpload')
	}
	/**
	 * Patient file upload
	 * @return
	 */
	def fileUpload(){
		authorizeMe() //***** Check Authorization
		try{
			if(request.post){
				if(!request.getFile("filecsv")?.empty){
					boolean check = false;
					request.getFile('filecsv')?.inputStream?.toCsvReader(['skipLines':1])?.eachLine { tokens ->
						if(check){
							params. firstName  = tokens[1]?.trim()
							params.lastName = tokens[2]?.trim()
							params.email =tokens[3]?.trim()
							params.password =tokens[4]?.trim()
							params.confirmPassword = tokens[4]?.trim()
							HealpalUser user = profileService . save(params)
							if(user != null && user.validate()) {
								if( tokens[12]?.trim() !=null && !tokens[12]?.trim().isEmpty()) {
									def describe = tokens[12]?.trim().split(",")
									int k=1;
									def aboutYourself
									def passionate
									describe.each{
										if(k==1) {
											aboutYourself = it
										}else {
											passionate = it
										}
										k++
									}
									params.aboutYourself = aboutYourself
									params.passionate = passionate
									Person currentPerson = HealpalUser.get(user?.id?.toString().toLong())?.person
									profileService.savePatientAbout(params,currentPerson);
								}
								if(tokens[13]?.trim() != null && !tokens[13]?.trim().isEmpty()) {
									tempQuestionService.save("I am a",tokens[13]?.trim() , user)
								}

								if(tokens[14]?.trim() !=null && !tokens[14]?.trim().isEmpty()) {
									DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
									Date dateOfBirth = formatDate.parse(tokens[14]?.trim());
									Person updatePerson=profileService.addPersonDob(params,dateOfBirth,user)
								}

								if(tokens[15]?.trim() !=null && !tokens[15]?.trim().isEmpty()){
									Gender gender = Gender.findByGenderName(tokens[15]?.trim())
									Person personn = Person.get(user?.person?.id)
									personn.gender = gender
									personn.rowAltered = new Date()
									personn.save(flush:true)
								}

								if(tokens[16]?.trim() !=null && !tokens[16]?.trim().isEmpty()) {
									tempQuestionService.save("Gender identity (optional)",tokens[16]?.trim() , user)
								}
								if(tokens[17]?.trim() !=null && !tokens[17]?.trim().isEmpty()) {
									def addr =  tokens[17]?.trim().split(",")
									params.city = City.findByCityName(addr[0])?.id;
									params.state = State.findByStateName(addr[1])?.id;
									params.county = County.findByCountyName(addr[2])?.id;
									params.zip = addr[3];
									def address=profileService.saveAddress(params,user);
									if(address!=null) {
										PatientAddress patientAddress=new PatientAddress()
										patientAddress.patient = Patient.findByPerson(user?.person)
										patientAddress.address=address
										patientAddress.isActive = Short.valueOf("1")
										patientAddress.rowCreated = new Date()
										patientAddress.save(flush:true)
									}
								}
								if(tokens[18]?.trim() !=null && !tokens[18]?.trim().isEmpty()) {
									def ethnicityName = tokens[18]?.trim()
									def ethnicityId =Ethnicity.findByEthnicityName(ethnicityName)?.id
									if(ethnicityId !=null && ethnicityId !="") {
										Person person1=Person.get(user?.person.id)
										person1.ethnicity= Ethnicity.get(ethnicityId)
										person1.save(flush:true)
									}
								}
								if(tokens[19]?.trim() !=null && !tokens[19]?.trim().isEmpty()) {
									tempQuestionService.save("Select yout Race", tokens[19]?.trim(), user)
								}
								if(tokens[20]?.trim() !=null && !tokens[20]?.trim().isEmpty()) {
									params.educationId = Education.findByEducationType(tokens[20]?.trim())?.id
									profileService.savePatientEducation(params,user);
								}
								if(tokens[21]?.trim() !=null && !tokens[21]?.trim().isEmpty()) {
									params.healthInsurance = HealthInsurance.findByHealthInsuranceType(tokens[21]?.trim())?.id
									profileService.savePatientInsurance(params, user)
								}
								if(tokens[22]?.trim() !=null && !tokens[22]?.trim().isEmpty()) {

									tempQuestionService.save("I am intrested in", tokens[22]?.trim(), user)
								}
								if(tokens[23]?.trim() !=null && !tokens[23]?.trim().isEmpty()) {
									//params = null;
									params.treatingDoctor =  tokens[23]?.trim()
									Doctor doctorDetails=profileService.add(params,user,null)
								}

								if(tokens[24]?.trim() !=null && !tokens[24]?.trim().isEmpty()) {
									tempQuestionService.save("Describe the current status of your cancer", tokens[24]?.trim(), user)
								}

								if(tokens[25]?.trim() !=null && !tokens[25]?.trim().isEmpty()) {
									def Id= Diagnosis.findByDiagnosisName(tokens[25]?.trim())?.id
									PatientDiagnosis diagnosis=diagnosisService.addPatientDiagnosis(new PatientDiagnosis(),params,user,Id)
								}
								if(tokens[26]?.trim() !=null && !tokens[26]?.trim().isEmpty()) {
									tempQuestionService.save("Stage of cancer", tokens[26]?.trim(), user)
								}
								if(tokens[27]?.trim() !=null && !tokens[27]?.trim().isEmpty()) {
									DateFormat formatDate1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
									Date dateOfDiagnosis = formatDate1.parse(tokens[27]?.trim());
									PatientDiagnosis updatePatientDignosis=profileService.addDateOfDignosis(params,dateOfDiagnosis,user)
								}

								if(tokens[28]?.trim() !=null && !tokens[28]?.trim().isEmpty()) {
									params.ageId = tokens[28]?.trim()
									PatientDiagnosis ageDiagnosis=diagnosisService.addPatientDiagnosisAge(params,user)
								}
								if(tokens[29]?.trim() !=null && !tokens[29]?.trim().isEmpty()) {
									params.type = "HER"
									params.value = tokens[29]?.trim()
									profileService.updatePositive(params, user);
								}
								if(tokens[30]?.trim() !=null && !tokens[30]?.trim().isEmpty()) {
									params.type = "ER"
									params.value = tokens[30]?.trim()
									profileService.updatePositive(params, user);
								}
								if(tokens[31]?.trim() !=null && !tokens[31]?.trim().isEmpty()) {
									params.type = "PR"
									params.value = tokens[31]?.trim()
									profileService.updatePositive(params, user);
								}
								if(tokens[32]?.trim() !=null && !tokens[32]?.trim().isEmpty()) {
									tempQuestionService.save("Pathology biopsy tumor type 1", tokens[32]?.trim(), user)
								}
								if(tokens[33]?.trim() !=null && !tokens[33]?.trim().isEmpty() && tokens[32]?.trim() == "I know for sure") {

									tempQuestionService.save("Pathology biopsy tumor type2", tokens[33]?.trim(), user)
								}
								if(tokens[34]?.trim() !=null && !tokens[34]?.trim().isEmpty() && tokens[32]?.trim() != "I know for sure") {
									tempQuestionService.save("I have undergone molecular testing for my cancer", tokens[34]?.trim(), user)
								}
								if(tokens[35]?.trim() !=null && !tokens[35]?.trim().isEmpty() && tokens[34]?.trim() == "Yes") {
									tempQuestionService.save("Please choose which molecular test or tests have been performed", tokens[35]?.trim(), user)
								}
								if(tokens[36]?.trim() !=null && !tokens[36]?.trim().isEmpty() && tokens[34]?.trim() != "Yes") {
									tempQuestionService.save("Did you undergo surgery for your cancer?", tokens[36]?.trim(), user)
								}
								if(tokens[37]?.trim() !=null && !tokens[37]?.trim().isEmpty() && tokens[36]?.trim() =="Yes" ) {
									tempQuestionService.save("What type of surgical procedure did you Undergo or are scheduled to undergo?", tokens[37]?.trim(), user)
								}
								if(tokens[38]?.trim() !=null && !tokens[38]?.trim().isEmpty() && tokens[36]?.trim() !="Yes") {
									tempQuestionService.save("Results of your surgery", tokens[38]?.trim(), user)
								}
								if(tokens[39]?.trim() !=null && !tokens[39]?.trim().isEmpty()) {
									tempQuestionService.save("Date of surgery", tokens[39]?.trim(), user)
								}
								if(tokens[40]?.trim() !=null && !tokens[40]?.trim().isEmpty()) {
									tempQuestionService.save("Did you undergo Chemotherapy?", tokens[40]?.trim(), user)
								}
								if(tokens[41]?.trim() !=null && !tokens[41]?.trim().isEmpty() && tokens[39]?.trim() == "Yes") {
									tempQuestionService.save("Please choose the chemotherapy drug or drugs given to you", tokens[41]?.trim(), user)
								}
								if(tokens[42]?.trim() !=null && !tokens[42]?.trim().isEmpty() && tokens[39]?.trim() !="Yes") {
									tempQuestionService.save("Please choose the combination chemotherapy administered to you", tokens[42]?.trim(), user)
								}
								if(tokens[43]?.trim() !=null && !tokens[43]?.trim().isEmpty()) {
									tempQuestionService.save("Did you undergo treatment for metastatic breast cancer", tokens[43]?.trim(), user)
								}
								if(tokens[44]?.trim() !=null && !tokens[44]?.trim().isEmpty()) {
									tempQuestionService.save("Did You Undergo Hormonal therapy", tokens[44]?.trim(), user)
								}
								if(tokens[45]?.trim() !=null && !tokens[45]?.trim().isEmpty() && tokens[44]?.trim() =="Yes" ) {
									tempQuestionService.save("Please choose the hormone therapy drug", tokens[45]?.trim(), user)
								}
								if(tokens[46]?.trim() !=null && !tokens[46]?.trim().isEmpty() && tokens[44]?.trim() !="Yes") {
									tempQuestionService.save("Did You Undergo targeted therapy", tokens[46]?.trim(), user)
								}
								if(tokens[47]?.trim() !=null && !tokens[47]?.trim().isEmpty() &&tokens[46]?.trim() == "Yes" ) {
									tempQuestionService.save("Please choose the targeted theraphy or therapies given to you", tokens[47]?.trim(), user)
								}
								if(tokens[48]?.trim() !=null && !tokens[48]?.trim().isEmpty()) {
									tempQuestionService.save("Did you undergo radiation treatment?", tokens[48]?.trim(), user)
								}
								if(tokens[49]?.trim() !=null && !tokens[49]?.trim().isEmpty() && tokens[48]?.trim() == "Yes") {
									tempQuestionService.save("Which type of radiation treatment did you receive", tokens[49]?.trim(), user)
								}
								if(tokens[50]?.trim() !=null && !tokens[50]?.trim().isEmpty() && tokens[48]?.trim() !="Yes") {
									tempQuestionService.save("Did you participate in any clinical trial", tokens[50]?.trim(), user)
								}
								if(tokens[51]?.trim() !=null && !tokens[51]?.trim().isEmpty() && tokens[50]?.trim() == "Yes") {
									tempQuestionService.save("Please state the clinical trial you participated i", tokens[51]?.trim(), user)
								}
								if(tokens[52]?.trim() !=null && !tokens[52]?.trim().isEmpty()) {
									tempQuestionService.save("Please select the side effects you have experienced during your cancer treatment", tokens[52]?.trim(), user)
								}
								if(tokens[53]?.trim() !=null && !tokens[53]?.trim().isEmpty()) {
									tempQuestionService.save("Do you have any associated medical conditions?", tokens[53]?.trim(), user)
								}
								if(tokens[54]?.trim() !=null && !tokens[54]?.trim().isEmpty() && tokens[53]?.trim() == "Yes" ) {
									def medicalConditionIds = MedicalCondition.findByMedicalConditionType(tokens[54]?.trim())?.id
									Person currentPerson1 = Person.get(user?.person?.id)
									Patient patient = Patient.findByPersonAndIsActive(currentPerson1,Short.valueOf("1"));
									MedicalCondition medicalCondition =MedicalCondition.get(medicalConditionIds?.toLong());
									PatientMedicalCondition patientMedicalCondition = new PatientMedicalCondition();
									patientMedicalCondition.medicalCondition = medicalCondition
									patientMedicalCondition.patient = patient
									patientMedicalCondition.isActive = Short.valueOf("1")
									patientMedicalCondition.rowCreated = new Date()
									patientMedicalCondition.save();
								}
								ProfileCompletionDetail profile = new ProfileCompletionDetail()
								profile . rowCreated = new Date()
								profile . profileUpdated = (short)1
								profile . goToProfilePage = "m2"
								profile . healpalUser = user
								profile . patient = Patient.findByPerson(user?.person)
								profile . save(flush:true)
								flash.msg = "User account has been created sucessfully"
							}else
							{
								flash.msg = "User creation failed due to some errors"
							}
						}
						check = true;
					}
				}
			}
		}catch(Exception e){
			println e
		}
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
}

