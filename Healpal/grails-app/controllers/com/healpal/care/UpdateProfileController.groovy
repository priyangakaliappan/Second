/**
 * Author 		: Subhapriya M
 * Project 		: HealPal
 * Date			: 15/11/2015
 * Description  : Update Profile
 *
 * #   Name       		Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1  Subhapriya M      1.0       15/11/2015        Initial Creation
 *
 * */
package com.healpal.care
import com.healpal.care.TempQuestionService
import com.healpal.care.CancerStatusService
import com.healpal.care.DiagnosisService
import java.text.DateFormat
import java.text.SimpleDateFormat
class UpdateProfileController {
	def TempQuestionService tempQuestionService;
	def ProfileService profileService;
	def CancerStatusService cancerStatusService;
	def DiagnosisService diagnosisService;
	def AuditEventService auditEventService;
	
	def index() {
	}
	
	/**
	 * Edit and update detailed Gender Identity
	 * @params
	 */
	def genderIdentity(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty()) {
				def value=params.ans
				def question="Gender identity"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	/**
	 * Edit and update Race
	 * @params
	 */
	def race(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty()) {
				def value=params.ans
				def question="Select your Race"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Edit and update Personal Interest
	 * Can select Multiple options
	 * @params
	 */
	def personalInterest(){
		authorizeMe();
		try {
			def editValue=""
			HealpalUser user=session.user
			if(request.post){
				if(params!=null && params.answer!=null && !params.answer.equals("") && params.question!=null && !params.question.equals("")){
					def interestedIn = params.answer
					def question="I am interested in"
					def questionans = null
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						if(interestedIn.toString().contains(",")){
							interestedIn.each {
								questionans = tempQuestionService.save(params.question,it, user)
							}
						}else{
							questionans = tempQuestionService.save(params.question, interestedIn, user)
						}
						if(questionans !=null) {
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ")
			}
			def personalInterest = PersonalInterest.createCriteria().list {}
			[personalInterest:personalInterest, value:editValue]
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update Cancer Stage
	 * @params
	 */
	def cancerStage(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty()) {
				def value=params.ans
				def question="Stage of cancer"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update Pathology biopsy tumor type
	 * @params
	 */
	def pathologyType1(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty()) {
				def value=params.ans
				def question="Pathology biopsy tumor type 1"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update Pathology biopsy tumor type
	 * @params
	 */
	
	def pathologyType2(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.answer!=null && !params.answer.isEmpty()) {
				def value=params.answer
				def question="Pathology biopsy tumor type 2"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update undergo Molecular Testing option
	 * @params
	 */
	
	def undergoneMolecularTesting(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty()) {
				def deleteQuestion="Please choose which molecular test or tests have been performed"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					def value=params.ans
					def question="I have undergone molecular testing for my cancer"
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update Molecular Tests
	 * Can choose Multiple options
	 * @params
	 */
	
	def molecularTests(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="I have undergone molecular testing for my cancer";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
				}
			}
			if(params!=null && params.ans!=null && !params.ans.equals("")) {
				def value=params.ans
				def question="Please choose which molecular test or tests have been performed"
				def questionans=null
				boolean temp=tempQuestionService.updateProfile(question,  user)
				if(temp){
					if(value.toString().contains(",")){
						value.each {
							questionans = tempQuestionService.save(question,it, user)
						}
					}else{
						questionans = tempQuestionService.save(question, value, user)
					}
					if(questionans !=null) {
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def answers = ans.replaceAll("@"," ")
				[value:answers]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update undergo Surgery option
	 * @params
	 */
	
	def undergoSurgery(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.equals("")) {
				def deleteQuestion="What type of surgical procedure did you Undergo or are scheduled to undergo?"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					def value=params.ans
					def question="Did you undergo surgery for your cancer?"
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:value]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update surgical procedure types
	 * Can choose Multiple options
	 * @params
	 */ 
	
	def surgicalProcedureType(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did you undergo surgery for your cancer?";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}
			if(params!=null && ((params.ans!=null && !params.ans.equals("")) || params.otherz!=null)) {
				def value=params.ans
				def question="What type of surgical procedure did you Undergo or are scheduled to undergo?"
				def questionans=null
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					if(params.otherz && params.otherz!=null && params.otherOptions!=null){
						questionans = tempQuestionService.save(question,params.otherOptions, user)
					}
					if(value && value!=null && value!="null"){
						if(value.toString().contains(",")){
							value.each {
								questionans = tempQuestionService.save(question,it, user)
							}
						}
						else{
							questionans = tempQuestionService.save(question, value, user)
						}
					}
					if(questionans !=null) {
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				def otherValue=null
				def check=editValue.subSequence(1, editValue.length()-1).split(",")
				for(int i=0;i<check.size();i++){
					if(!check[i].equals(" ")&&!check[i].contains("Axillary Lymph Node Dissection")&&!check[i].contains("Breast Reconstruction (Implant)")&&!check[i].contains("Implant Chemotheraphy port")&&!check[i].contains("Lumpectomy")&&!check[i].contains("Sentinal lymph node biopsy")&&!check[i].contains("Other")&&!check[i].contains("Breast REconstruction")&&!check[i].contains("Double Mastectomy")&&!check[i].contains("Long-term catheter")&&!check[i].contains("Mastectomy")&&!check[i].contains("Surgery")){
						otherValue=check[i]
					}
				}


				[value:editValue,others:otherValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * Edit and update profile photo
	 * @params
	 */

	def profilePhoto(){
		try {
			authorizeMe();
			def documentName = null
			HealpalUser user = session.user
			if(request.post && user){
				if(params != null && params.uploadPhoto) {
					def saveFile = profileService.saveImage(request,user)
				}
				else{
					//do Nothing
				}
				flash.msg="Your profile has been updated"
				redirect (controller :'profile' ,action :'editProfile')
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Get List of About you from database
	 * Edit and update About you
	 * @params
	 */
	
	def IAma(){
		authorizeMe();
		try {
			def editValue =""
			def iamList=AboutYou.createCriteria().list {order("rowCreated","asc")}
			if(params!=null && params.iAm!=null && !params.iAm.isEmpty()) {
				def question="I am a";
				def iAmId=params.iAm
				HealpalUser user=session.user
				def value=AboutYou.get(iAmId)?.aboutYouName
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption aboutYouSave=tempQuestionService.save(question,value,user)
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect (controller :'profile' ,action :'editProfile',params:[question:question])
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
			}
			[iamList:iamList, value:editValue]
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	/**
	 * Get List of HealthInsurance from database
	 * Edit and update HealthInsurance
	 * Can choose Multiple options
	 * @params
	 */
	def healthInsurance(){
		try{
			authorizeMe()
			def editValue=""
			def questionans = null
			HealpalUser healpalUser = session.user;
			if(request.post){
				if(params!=null && params.healthInsurance!=null && !params.healthInsurance.equals("")){
					questionans = profileService.savePatientInsurance(params, healpalUser)
					if(questionans !=null) {
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:"Type of health insurance"])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ")
			}
			def healthInsurance = HealthInsurance.createCriteria().list {}
			[healthInsurance:healthInsurance, value:editValue]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Get List of Cancer status from database
	 * Edit and update Cancer status
	 * @params
	 */
	
	def statusOfCancer(){
		authorizeMe();
		try {
			def editValue=""
			if(params && params.value!=null && !params.value.isEmpty()){
				HealpalUser healpalUser = session.user;
				def updateStatus=cancerStatusService.updateStatus(params, healpalUser);
				if(updateStatus!=null){
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:"profile",action:"editProfile",params:[question:"Describe the current status of your cancer"])
				}
			}else{
				//do nothing
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ")
			}
			def cancerStatus=CancerStatus.createCriteria().list {
				
			}
			[cancerStatusList:cancerStatus, value:editValue]
		}

		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	/**
	 * Get List of Cancer diagnosis from database
	 * Edit and update Cancer diagnosis
	 * @params
	 */
	
	def stateYourDiagnosis(){
		try{
			authorizeMe();
			def editValue=""
			if(params !=null && params.diagnosis!=null && ! params.diagnosis.isEmpty() && session.user){
				HealpalUser healpalUser = session.user;
				def Id=params.diagnosis
				PatientDiagnosis diagnosis=diagnosisService.addPatientDiagnosis(new PatientDiagnosis(),params,healpalUser,Id)
				if(diagnosis !=null){
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:"profile", action:"editProfile",,params:[question:"State your diagnosis"])
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value= ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				editValue = Diagnosis.findByDiagnosisName(value.toString())
			}
			[diagnosisList:diagnosisService.getdiagnosisList(), value:editValue]
		}catch(Exception exception){
			throw exception
		}
	}
	
	/**
	 * Edit and update Date of cancer diagnosis
	 * @params
	 */
	
	def dateOfCancerDiagnosis(){
		try{
			authorizeMe();
			if(request.post){
				HealpalUser user=session.user
				if(params != null){
					PatientDiagnosis updatePatientDignosis=profileService.addDateOfDignosis(params,user)
					if(updatePatientDignosis!=null && updatePatientDignosis.validate()){
						Person personDob=user?.person
						def date1=personDob?.dob
						DateFormat formatDate1 = new SimpleDateFormat("yyyy", Locale.US);
						int dob =Integer.parseInt(formatDate1.format(date1));
						def a2=updatePatientDignosis?.dateOfCancerDiagnosis
						int dob1 =Integer.parseInt(formatDate1.format(a2));
						if(dob1>=dob){
							String calculate=dob1-dob
							PatientDiagnosis patientDiagnosis=PatientDiagnosis.findByPatient(Patient.findByPerson(user?.person))
							patientDiagnosis.ageOfDiagnosis=Integer.parseInt(calculate);
							def ageDiagnosis = patientDiagnosis.save(flush:true);
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:"profile",action:"editProfile",params:[question:"Date of cancer diagnosis"])
						}else{
						//do nothing						
						}
					}
					else{
						//do nothing
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				HealpalUser user=session.user
				def ans = params.answers
				Person personDOB=user?.person
				String value =  ans.substring(1, ans.indexOf("@"))
				String birthDate=personDOB.dob

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd")
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.s")

				Date dateee = formatter.parse(value)
				Date dob=formatter1.parse(birthDate)
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
				String date = DATE_FORMAT.format(dateee);
				String dateOfBirth=DATE_FORMAT.format(dob);
				[dateOfCancerDiagnosis:date,dateOfBirth:dateOfBirth]
			}
		}catch(Exception e){
		}
	}
	
	/**
	 * Automatically canculated age at diagnosis displays
	 * Cannot able to edit or update
	 * Age calculates by date of birth & date of cancer diagnosis
	 * @params
	 */
	
	def ageAtDiagnosis(){
		try{
			if(request.post){
				if(params !=null && !params.isEmpty() && params.age !=null &&  !params.age.isEmpty()){
					HealpalUser healpalUser = session.user;
					PatientDiagnosis ageDiagnosis=diagnosisService.addPatientDiagnosisAge(params,healpalUser)
					if(ageDiagnosis !=null){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:"profile" ,action:"editProfile",params:[question:"Your age at Diagnosis"])
					}
				}
			}else{
				//do nothing
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue= ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}catch(Exception exception){
		}
	}
	
	
	def her2Positive(){
		authorizeMe();
		try{
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				[value:editValue]
			}
		}catch(Exception e){

		}
	}
	
	/**
	 * Common method used for Her 2 Positive, ER Positive, PR Positive to edit/update
	 * @params
	 */
	
	def updatePositive(){
		authorizeMe();
		try{
			if(params.type && params.value!=null){
				def type=""
				if(params.type!=""){
					if(params.type=="HER"){
						type=params.type+" 2 positive"
					}
					else{
						type=params.type+" positive"
					}
				}
				HealpalUser healpalUser = session.user;
				def updateHer=profileService.updatePositive(params, healpalUser);
				auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
				flash.msg="Your profile has been updated"
				redirect(controller:"profile",action:"editProfile",params:[question:type])
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	def erPositive(){
		authorizeMe();
		try{
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				[value:editValue]
			}
		}catch(Exception e){

		}
	}
	
	def prPositive(){
		authorizeMe();
		try{
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				[value:editValue]
			}
		}catch(Exception e){

		}
	}
	
	/**
	 * Edit and update Gender
	 * @params
	 */
	
	def myGender(){
		try{
			authorizeMe();
			HealpalUser user=session.user
			if(params != null && params.genderType!= null && params.genderType!= ""){
				Person genderUpdate=profileService.updateGender(params, user);
				if(genderUpdate!=null && genderUpdate.validate()){
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:"profile",action:"editProfile",params:[question:"Gender"])
				}
			}
			else{
				//do nothing
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}catch(Exception e){
		}
	}
	
	/**
	 * Edit and update Date of birth
	 * Updated into Person table
	 * Compares date of diagnosis and date of birth to calculate age of diagnosis 
	 * @params
	 */
	
	def dateOfBirth(){
		try{
			authorizeMe();
			if(request.post){
				HealpalUser user=session.user
				if(params != null ){
					Person updatePerson=profileService.addPersonDob(params,user)
					if(updatePerson!=null && updatePerson.validate()){
						//session.dob=updatePerson?.dob
						def date1=updatePerson?.dob
						DateFormat formatDate1 = new SimpleDateFormat("yyyy", Locale.US);
						int dob =Integer.parseInt(formatDate1.format(date1));
						PatientDiagnosis diagnosisDate=PatientDiagnosis.findByPatient(Patient.findByPerson(user?.person))
						def a2=diagnosisDate.dateOfCancerDiagnosis
						int dob1 =Integer.parseInt(formatDate1.format(a2));
						println dob1>=dob
						if(dob1>=dob){
							String calculate=dob1-dob
							PatientDiagnosis patientDiagnosis=PatientDiagnosis.findByPatient(Patient.findByPerson(user?.person))
							patientDiagnosis.ageOfDiagnosis=Integer.parseInt(calculate);
							def ageDiagnosis = patientDiagnosis.save(flush:true);
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:"profile",action:"editProfile",params:[question:"Select your Date of Birth"])
						}else{
							flash.msg="Probably your Date of Birth is not correct. Please enter your Date of Birth"
						}





						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:"profile",action:"editProfile",params:[question:"Select your Date of Birth"])
					}
					else{
						//do nothing
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				HealpalUser user=session.user
				def ans = params.answers
				String value =  ans.substring(0, ans.indexOf("@"))

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd")
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.s")
				Date dateee = formatter.parse(value)

				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
				String date = DATE_FORMAT.format(dateee);
				PatientDiagnosis diagnosisDate=PatientDiagnosis.findByPatient(Patient.findByPerson(user?.person))
				String doc=diagnosisDate.dateOfCancerDiagnosis.toString();
				Date formatDate=formatter1.parse(doc)
				String dateOfDiagnosis = DATE_FORMAT.format(formatDate);
				[dateOfBirth:date,dateOfDiagnosis:dateOfDiagnosis]}
		}catch(Exception e){
		}

	}
	/**
	 * Edit and update Where do you live
	 * displays values from PatientAddress, address tables
	 * Zipcode automatically calculates state, city and country
	 * @params
	 */
	
	def whereDoYouLive(){
		try{
			authorizeMe();
			def city=""
			def state=""
			def zipCode=""
			def country=""
			if(request.post){
				HealpalUser healpalUser = session.user;
				Person currentPerson = healpalUser?.person
				Patient patient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
				def address=profileService.saveAddress(params,healpalUser);

				if(address!=null){
					def isExistPatientAddress=PatientAddress.findAllByPatient(Patient.findByPerson(healpalUser?.person))
					if(isExistPatientAddress && isExistPatientAddress!=null && isExistPatientAddress.size()>0){
						def deleteStatus = PatientAddress.executeUpdate("delete from PatientAddress p where p.patient="+patient?.id);
					}


					PatientAddress patientAddress=new PatientAddress()
					patientAddress.patient = Patient.findByPerson(healpalUser?.person)
					patientAddress.address=address
					patientAddress.isActive = Short.valueOf("1")
					patientAddress.rowCreated = new Date()
					patientAddress.save()
					flash.msg="Your profile has been updated"
					redirect(controller:'profile',action:'editProfile',params:[question:"Where do you live ?"])
					if (!patientAddress.validate()){
						patientAddress.errors.each {println it }
					}else{
						//do nothing
					}
				}

			}

			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				ArrayList answers = new ArrayList();
				def editValue = ans.substring(1, ans.length()-1).replaceAll("@", " ")
				def splitAns = editValue.replaceAll(", ,", ",").split(", ")
				splitAns.each { answers.add(it) }
				city = answers[0];
				state =answers[1];
				country =answers[2];
				zipCode = answers[3];
			}
			[city:city,state:state,country:country,zipCode:zipCode]

		}catch(Exception e){
			e.printStackTrace()
		}}
	/**
	 * Get List of Ethnicity from database
	 * Edit and update ethnicity
	 * @params
	 */
	def ethnicity(){
		authorizeMe();
		try {
			def editValue=""
			def ethnicityView=Ethnicity.createCriteria().list { order("rowCreated","asc") }
			HealpalUser user = session.user
			if(params!=null && params.ethnicityId!=null && !params.ethnicityId.isEmpty())
			{
				def ethnicityId = params.ethnicityId
				Person person = Person.get(user.person?.id)
				if(person){
					person.ethnicity= Ethnicity.get(ethnicityId)
					def saveStatus=person.save(flush:true)
					if(saveStatus!=null){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect (controller :'profile' ,action :'editProfile',,params:[question:"Select your Ethnicity"])
					}

				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
			}
			[ethnicityView:ethnicityView, value:editValue]
		}

		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Get List of Highest Level of Education from database
	 * Edit and update Education Level
	 * @params
	 */
	
	def highestLevelofEducation(){
		authorizeMe();
		try{
			def editValue=""
			HealpalUser healpalUser = session.user;
			if(params!=null &&  params.educationId !=null && !params.educationId.equals("")){
				profileService.savePatientEducation(params,healpalUser);
				flash.msg="Your profile has been updated"
				redirect(controller:'profile',action:'editProfile',params:[question:"Highest level of education"])
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
			}
			def education = Education.createCriteria().list {}
			[education:education, value:editValue]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Edit and update About yourself
	 * Contains about yourself, and passionate about fields
	 * @params
	 */
	
	
	def aboutYourself(){
		authorizeMe();
		try{
			HealpalUser healpalUser = session.user;
			if(healpalUser!=null && !healpalUser.equals("")){
				if(request.post){
					def aboutYourself = params.aboutYourself
					def passionate = params.passionate
					if(aboutYourself!=null && !aboutYourself.equals("") || passionate!=null && !passionate.equals("")){
						Person currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
						profileService.savePatientAbout(params,currentPerson);
					}else{
						//do nothing
					}
					flash.msg="Your profile has been updated"
					redirect (controller :'profile' ,action :'editProfile',params:[question:"About you and your Passion"])
				}
			}else{
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				boolean check=true
				def describe
				def passion
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 ).replaceAll(", ,", ",").trim().split(",").each {
					if(check){
						describe = it
					}else{
						passion = it
					}
					check = false
				}
				[describe:describe,passion:passion ]
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * Get List of surgery results from database
	 * Edit and update surgery results
	 * @params
	 */
	

	def surgeryResults(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params !=null && params.ans !=null && !params.ans.equals("")){
				def value=params.ans
				def question="Results of your surgery"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value =  ans.replaceAll("@"," ").substring(1, ans.length()-1)
				[value:value]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update Surgery date
	 * @params
	 */
	
	def surgeryDate(){
		try{
			authorizeMe();
			HealpalUser user=session.user
			if(request.post){
				if(params != null ){
					String stringDate =params.surgery
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy")
					Date date = formatter.parse(stringDate)
					SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
					String dates = DATE_FORMAT.format(date);
					String question="Date of surgery";
					String answer=dates;
					boolean tempQues=tempQuestionService.updateProfile(question, user)
					if(tempQues){
						TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)
						if(addQuestion!=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:"profile",action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				ArrayList selectedDate = new ArrayList()
				String value =  ans.substring(1, ans.indexOf(","))
				String getYear= ans.substring(ans.lastIndexOf("@"),13)
				def answers = value.split("@").each { selectedDate.add(it) }
				def yearSelected=getYear.substring(1,getYear.length())
				def month = selectedDate[0]
				def date = selectedDate[1]
				def year=yearSelected
				String extractDate=month+" "+date+", "+year
				DateFormat formatDate = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
				Date dateee = formatDate.parse(extractDate)
				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
				String dates = DATE_FORMAT.format(dateee);
				[dateOfSurgery:dates]



			}

		}catch(Exception e){
		}
	}
	
	/**
	 * Edit and update undergo Chemotheraphy option
	 * @params
	 */
	
	def undergoChemotherapy(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params !=null && params.ans !=null && !params.ans.equals("") && params.question !=null && !params.question.equals("")){
				def value=params.ans
				def question=params.question
				def deleteTempQuestion="Please choose the chemotherapy drug or drugs given to you"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteTempQuestion, user)
				if(deleteTemp){
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value =  ans.replaceAll("@"," ").substring(1, ans.length()-1)
				[value:value]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Get List of Chemotherapy Drugs from database
	 * Edit and update Chemotherapy Drugs
	 * Can choose Multiple options
	 * @params
	 */
	
	def chemotherapyDrugs(){
		try{
			def editValue=""
			def questionans = null
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did you undergo Chemotherapy?";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}
			if(request.post){
				def chemotherapyNames = params.chemotherapy
				if(params !=null && chemotherapyNames!=null && !chemotherapyNames.equals("") && params.question !=null && !params.question.equals("")){
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						if(chemotherapyNames.toString().contains(",")){
							chemotherapyNames.each{
								questionans = tempQuestionService.save(params.question, it, user)}
						}else{
							questionans = tempQuestionService.save(params.question, chemotherapyNames, user)
						}
						if(questionans !=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:params.question])
						}
					}}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue= ans.replaceAll("@", " ")
			}
			def chemotheraphy = ChemotherapyDrugs.createCriteria().list {}
			[chemotheraphy:chemotheraphy, value:editValue]
		}catch(Exception e){
		}
	}
	
	/**
	 * Edit and update Metastatict Treatments
	 * Can choose Multiple options
	 * @params
	 */
	
	def undergoMetastatictTreatment(){
		authorizeMe();
		try{
			def editValue=""
			def questionans = null
			HealpalUser user=session.user
			if(request.post){
				def metastaticBreastCancer = params.metastaticBreastCancer
				if(params !=null && metastaticBreastCancer !=null && !metastaticBreastCancer.equals("") && params.question !=null && !params.question.equals("")){
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						if(metastaticBreastCancer.toString().contains(",")){
							metastaticBreastCancer.each{
								questionans = tempQuestionService.save(params.question, it, user)
							}
						}else{
							questionans = tempQuestionService.save(params.question, metastaticBreastCancer, user)
						}

						if(questionans !=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:params.question])
						}}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue= ans.replaceAll("@", " ")
			}
			def metastaticBreastCancer = MetastaticBreastCancer.createCriteria().list {}
			[metastaticBreastCancer:metastaticBreastCancer, value:editValue]
		}catch(Exception e){
		}
	}
	/**
	 * Edit and update undergo Hormonal Therapy option
	 * @params
	 */
	
	def undergoHormonalTherapy(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params !=null && params.ans !=null && !params.ans.equals("") && params.question !=null && !params.question.equals("")){
				def deleteQuestion="Please choose the hormone therapy drug or drugs given to you"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					def value=params.ans
					def question=params.question
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Get List of Hormone therapy drugs from database
	 * Edit and update Hormone therapy drugs
	 * Can choose Multiple options
	 * @params
	 */
	
	def hormoneTherapyDrugs(){
		try{
			authorizeMe();
			def editValue=""
			def questionans = null
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did You Undergo Hormonal therapy";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}
			if(request.post){
				def hormoneTherapy = params.hormoneTherapy
				if(params !=null && hormoneTherapy !=null && !hormoneTherapy.equals("") && params.question !=null && !params.question.equals("")){
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						if(hormoneTherapy.toString().contains(",")){
							hormoneTherapy.each{
								questionans = tempQuestionService.save(params.question, it, user)
							}
						}else{
							questionans = tempQuestionService.save(params.question, hormoneTherapy, user)
						}

						if(questionans !=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:params.question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", "")
			}
			def hormoneTherapy = HormoneTherapy.createCriteria().list {}
			[hormoneTherapy:hormoneTherapy, value:editValue]
		}catch(Exception e){
		}
	}
	
	/**
	 * Edit and update undergo Targeted option
	 * @params
	 */
	
	def undergoTargetedTherapy(){
		authorizeMe();
		try{

			def questionans = null

			if(params !=null && params !="" && params.question !=null && params.question !="" &&  params.answer !=null &&  params.answer !="" )
			{
				HealpalUser user=session.user
				def deleteQuestion="Please choose the targeted therapy or therapies given to you"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						questionans = tempQuestionService.save(params.question, params.answer, user)
						if(questionans !=null)
						{
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:params.question])
						}
					}	}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}catch(Exception e){}
	}
	
	/**
	 * Get List of Targeted therapies from database
	 * Edit and update Targeted therapies
	 * Can choose Multiple options
	 * @params
	 */
	
	def targetedTherapies(){
		authorizeMe();
		try{
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did You Undergo targeted therapy";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}
			if(request.post)
			{
				def question="Please choose the targeted therapy or therapies given to you"
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					for(int i = 1; i <= 4; i++){
						def ans =params.("answer"+i)
						if(ans!=null)
						{
							TempQuestionOption temp=tempQuestionService.save(question, ans, user)
						}
						else
						{
							//do nothing
						}
					}
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:'profile',action:"editProfile",params:[question:question])
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				[value:editValue]
			}
		}catch(Exception e){

		}
	}
	
	/**
	 * Edit and update undergo Radiation option
	 * @params
	 */
	
	def undergoRadiation(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.equals("")) {
				def deleteQuestion="Which type of radiation treatment did you receive or are scheduled to receive?"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					def value=params.ans
					def question="Did you undergo radiation treatment?"
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:value]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Get List of radiation treatments from database
	 * Edit and update radiation treatments
	 * Can choose Multiple options
	 * @params
	 */
	
	def radiationTreatments(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did you undergo radiation treatment?";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}
			if(params!=null && params.ans!=null && !params.ans.equals("")) {
				def value=params.ans
				def question="Which type of radiation treatment did you receive or are scheduled to receive?"
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
					if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:'profile',action:"editProfile",params:[question:question])
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def value = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:value]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update undergo clinical trial option
	 * @params
	 */
	
	def undergoClinicalTrial(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.equals("")) {
				def deleteQuestion="Please state the clinical trial you  participated in"
				boolean deleteTemp=tempQuestionService.updateProfile(deleteQuestion, user)
				if(deleteTemp){
					def value=params.ans
					def question="Did you participate in any clinical trial"
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Edit and update clinicical trial
	 * @params
	 */
	
	def clinicalTrial(){
		authorizeMe();
		try{
			HealpalUser user=session.user
			if(params.answer!=null){
				def question="Did you participate in any clinical trial";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
				}
			}

			if(request.post){
				if(params !=null && !params.isEmpty() && params.participated !=null &&  !params.participated.isEmpty()){
					String question="Please state the clinical trial you  participated in"
					String answer=params.participated
					boolean tempQues=tempQuestionService.updateProfile(question, user)
					if(tempQues){
						TempQuestionOption participatedQuestion=tempQuestionService.save(question, answer,user)
						if(participatedQuestion !=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:"profile", action:"editProfile",params:[question:question])
						}

						else{
						}

					}


				}

			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").substring(1,ans.length()-1 )
				[value:editValue]
			}
		}catch(Exception exception){

		}
	}
	
	/**
	 * Get List of side Effects from database
	 * Edit and update side Effects
	 * Can choose Multiple options
	 * @params
	 */
	
	def sideEffects(){
		authorizeMe();
		try{
			HealpalUser user=session.user
			if(request.post)
			{
				def question="Please select the side effects you have experienced during your cancer treatment"
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					for(int i = 1; i <= 15; i++){
						def ans =params.("answer"+i)
						if(ans!=null)
						{
							TempQuestionOption temp=tempQuestionService.save(question, ans, user)
						}
						else
						{
						}
					}
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:'profile',action:"editProfile",params:[question:question])
				}			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ")
				[value:editValue]
			}
		}
		catch(Exception exce)
		{

		}
	}
	
	/**
	 * Edit and update undergo Medical Condition option
	 * @params
	 */
	
	def anyMedicalConditions(){
		authorizeMe();
		try {
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.equals("") && params.question!=null & !params.question.equals("") ) {
				def value=params.ans
				def question=params.question
				def patient=Patient.findByPerson(user?.person);
				boolean deleteMedicalCondition=true
				def isExistMedicalCondition=PatientMedicalCondition.findAllByPatient(patient);
				if(isExistMedicalCondition.size()>0){
					deleteMedicalCondition=PatientMedicalCondition.executeUpdate("delete from PatientMedicalCondition p where p.patient="+patient?.id);
				}
				if(deleteMedicalCondition){
					boolean temp=tempQuestionService.updateProfile(question, user)
					if(temp){
						TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, user);
						if(addtempQuestionAgain!=null & addtempQuestionAgain.validate()){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:'profile',action:"editProfile",params:[question:"Do you have any associated medical conditions?"])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				def editValue = ans.replaceAll("@", " ").subSequence(1, ans.length()-1)
				[value:editValue]
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}
	
	/**
	 * Get List of medical Conditions from database
	 * Edit and update medical Conditions
	 * Can choose Multiple options
	 * @params
	 */
	
	def medicalConditions(){
		try{
			authorizeMe();
			def editValue=""
			HealpalUser healpalUser = session.user;
			if(params.answer!=null){
				def question="Do you have any associated medical conditions?";
				def value=params.answer;
				boolean tempQues=tempQuestionService.updateProfile(question, healpalUser)
				if(tempQues){
					TempQuestionOption addtempQuestionAgain=tempQuestionService.save(question, value, healpalUser);
				}

			}
			if(request.post){
				def medicalConditionIds = params.medicalCondition
				def othercancers=params.otherCancer;
				def othermedicals=params.otherMedical;
				if(healpalUser!=null && !healpalUser.equals("") || ((medicalConditionIds!=null && !medicalConditionIds.equals(""))||(othercancers!=null && !othercancers.equals(""))||(othermedicals!=null && !othermedicals.equals(""))))
				{
					profileService.saveMedicalCondition(medicalConditionIds,healpalUser,othercancers,othermedicals);
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:'profile',action:"editProfile",params:[question:"Please choose any associated medical conditions"])

				}
			}
			def medicalConditionList = MedicalCondition.createCriteria().list{
				eq("isActive",Short.valueOf("1"))
				order('id','asc')
				not{ like('medicalConditionType','others_%') }
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue = ans.replaceAll("@", " ")
			}
			[medicalConditionList:medicalConditionList, value:editValue]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	/**
	 * Get List of combination Chemotherapy from database
	 * Edit and update combination Chemotherapy
	 * Can choose Multiple options
	 * @params
	 */
	
	def combinationChemotherapy(){
		try{
			authorizeMe();
			def editValue =""
			def questionans = null
			HealpalUser user=session.user
			if(request.post){
				def combinechemotherapy = params.combinechemotherapy
				if(params !=null && combinechemotherapy !=null && !combinechemotherapy.equals("") && params.question !=null && !params.question.equals("")){
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						int countt= params.selectedDrugs.toInteger()
						if(countt>1){
							combinechemotherapy.each{
								questionans = tempQuestionService.save(params.question, it, user)
							}
						}else{
							questionans = tempQuestionService.save(params.question, combinechemotherapy, user)
						}

						if(questionans !=null){
							auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
							flash.msg="Your profile has been updated"
							redirect(controller:"profile" , action:'editProfile',params:[question:params.question])
						}
					}
				}
			}
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				editValue  = ans.replaceAll("@", " ")
			}
			def combinationChemotheraphy = CombinationChemotherapyDrugs.createCriteria().list {}
			[combinationChemotheraphy:combinationChemotheraphy,value:editValue]
		}catch(Exception e){
		}
	}

	/**
	 * Edit and update Treating doctor details
	 * Includes doctor's name, phone number and valid zipcode
	 * @params
	 */
	
	def treatingDoctor(){
		try{
			authorizeMe();
			HealpalUser user=session.user
			if(request.post){
				if(params != null && params.treatingDoctor!= null && !params.treatingDoctor.isEmpty() && params.zipcode!= null && !params.zipcode.isEmpty() && params.contactNumber!= null && !params.contactNumber.isEmpty()){
					TreatingDoctor doctorDetails=profileService.detailsAboutDoctor(params,user)
					if(doctorDetails!=null && doctorDetails.validate()){
						auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
						flash.msg="Your profile has been updated"
						redirect(controller:"profile",action:"editProfile",params:[question:"Details of your treating doctor"])
					}
					else{
						//do nothing
					}
				}
			}
			if(params.others!=null){
				boolean deleteTreatedDoctor=TreatingDoctor.executeUpdate("delete from TreatingDoctor p where p.patient="+Patient.findByPerson(user?.person)?.id);
				if(deleteTreatedDoctor){
					auditEventService . save(AuditEventType.updatedProfile, Role.patient, session)
					flash.msg="Your profile has been updated"
					redirect(controller:"profile",action:"editProfile")
				}
			}
			def doctorName=""
			def phoneNumber=""
			def zipCode=""
			if(params!=null && params.answers !=null && !params.answers.isEmpty()){
				def ans = params.answers
				ArrayList answers = new ArrayList();
				def editValue = ans.substring(1, ans.length()-1).replaceAll("@", " ")
				def splitAns = editValue.replaceAll(", ,", ",").split(", ")
				splitAns.each { answers.add(it) }
				doctorName = answers[0];
				phoneNumber = answers[1];
				zipCode = answers[2];
				[doctorName:doctorName,phoneNumber:phoneNumber,zipCode:zipCode ]
			}
		}catch(Exception e){
		}

	}
	/**
	 * Method to check session
	 * proceed only if the logged user is a patient
	 */

	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
}
