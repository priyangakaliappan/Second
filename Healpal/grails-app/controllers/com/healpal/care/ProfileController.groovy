/**
 * Author 		: Ramesh
 * Project 		: HealPal
 * Date			: 28/10/2015
 * Description  : Profile
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Ramesh      1.0       28/10/2015        Initial Creation
 * 2   Ramesh      1.0       11/11/2015        Modified
 *
 * */
package com.healpal.care

import java.text.DateFormat
import java.text.SimpleDateFormat

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile

import com.healpal.care.TempQuestionService
import com.healpal.care.ProfileCompletionService
import com.stripe.Stripe
import com.stripe.model.Charge

class ProfileController {
	def ProfileService profileService;
	def UserRoleService userRoleService
	def UserService userService
	def AuditEventService auditEventService
	def DiagnosisService diagnosisService
	def CancerStatusService cancerStatusService
	def TempQuestionService tempQuestionService
	def ProfileCompletionService profileCompletionService
	def ReferralsService referralsService
	def PatientMatchService patientMatchService
	/* def index() { }*/

	/**
	 * @return
	 */
	def profileEdit() {
		authorizeMe();
		profileCompletionService . saveMe("profileEdit" ,0 ,session,"")    //profile completion detail save
		try {
			def userId= session.user?.id
			def person=HealpalUser.get(userId)?.person
			if(person.id) {
				if(request.post) {
					def personCall=ProfileService.update(session,params)
				}
				[person:person]
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	def signup(){
		switch(request.method){
			case 'GET':

				break
			case 'POST':
				HealpalUser user = profileService . save(params)
				if(user != null && user.validate()){
					auditEventService . save(AuditEventType.successLogin, Role.patient, session) // audit save
					flash.msg = "User "+user?.person?.firstName + " account has been created sucessfully"
				}else if(user == null){
					flash.msg = "User creation failed due to some errors"
				}else{
					flash.msg = ""
					[user:user]
				}
				break
		}
	}

	def ajaxSignup(){
		switch(request.method){
			case 'GET':
				break
			case 'POST':
				/*if(params != null && params.email != null && !params.email.isEmpty()
				&& params.password != null && !params.password.toString().isEmpty()
				&& params.confirmPassword != null && !params.confirmPassword.toString().isEmpty()
				&& params.firstName != null && !params.firstName.isEmpty()
				&& params.lastName != null && !params.lastName.isEmpty()){*/
			if(params != null && params.email != null && !params.email.isEmpty()
				&& params.password != null && !params.password.toString().isEmpty() && params.username != null && !params.username.toString().isEmpty()){

					//println "ProfileController .ajaxSignup = " +params.firstName+ "initiated"
					HealpalUser user = profileService . save(params)
					
						
					
					if(user != null && user.validate()){
						profileService.newUserMail(user,request)
						auditEventService . userSave(AuditEventType.newUser, Role.patient, user) // audit save
						//render (template:'/home/loginSuccess',model:[msg:"User "+user?.person?.firstName + " account has been created sucessfully"])
						
						println "ProfileController .ajaxSignup = A HealPal Account with a new user "+user?.person?.firstName+" has been created successfully."
						
						boolean creatAccount=false
						if(params.hiddenValues !=null && !params.hiddenValues.isEmpty() && params.hiddenValues !="undefined"){
							creatAccount = true
						}
						//render (template:'/home/loginSuccess',model:[userName:params.email ,password:params.password ,msg:"A HealPal Account with a new user "+user?.person?.firstName+" has been created successfully.",createAccount:creatAccount])
						render (template:'/home/loginSuccess',model:[userName:params.email ,password:params.password ,msg:"Email has been sent to your registered e-mail address. Please click the link and login to HealPal",createAccount:creatAccount])
					}else if(user == null){
						render "User creation failed due to some errors"
					}else{
						render (template:'/home/signup',model:[user:user])
					}
				}else{
					//do nothing
				}
				break
		}
	}



	

	/**
	 * @return
	 */
	def a0(){
		authorizeMe();
		profileCompletionService . saveMe("a0" ,0 ,session,"5")    //profile completion detail save
		try{
			HealpalUser healpalUser = session.user;
			def currentPersonName = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person?.fullName
			def length=currentPersonName.size()
			[currentPersonName:currentPersonName.toString().charAt(0).toUpperCase().toString()+currentPersonName.toString()?.substring(1, length)]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	/**
	 * @return
	 */
	def a1() {
		authorizeMe();
		profileCompletionService . saveMe("a1" ,0 ,session,"5")    //profile completion detail save
	}

	/**
	 * @return
	 */
	/*def a2() {
		authorizeMe();
		profileCompletionService . saveMe("a2" ,0 ,session,"5")    //profile completion detail save
	}*/

	/**
	 * @return
	 */
	def a2w() {
		authorizeMe();
		profileCompletionService . saveMe("a2w" ,0 ,session,"5")    //profile completion detail save
	}

	/*def a3() {
		authorizeMe();
		profileCompletionService . saveMe("a3" ,0 ,session,"5")    //profile completion detail save
	}
*/
	/**
	 * @return
	 */
	/*def a4() {
		authorizeMe();
		profileCompletionService . saveMe("a4" ,0 ,session,"5")    //profile completion detail save
	}
*/
	def a4w() {
		authorizeMe();
		profileCompletionService . saveMe("a4w" ,0 ,session,"5")    //profile completion detail save
	}

	/**
	 * @return
	 */
	def a5(){
		authorizeMe();
		profileCompletionService . saveMe("a5" ,0 ,session,"5") 
		if(params.fromatwoW)
			{
				println "sssssssssssssssssssssss"
				[backToa2W:'true']
			}   //profile completion detail save
	}
	/**
	 * @return
	 */
	def a6(){
		authorizeMe();
		profileCompletionService . saveMe("a6" ,0 ,session,"5")    //profile completion detail save
	}
	/**
	 * @return
	 */
	def a7(){
		authorizeMe();
		profileCompletionService . saveMe("a7" ,0 ,session,"5")    //profile completion detail save
	}

	/**
	 * Call the service method and Save the image and store the path into database
	 * @return
	 */
	def b1(){
		//authorizeMe();
		profileCompletionService . saveMe("b1" ,0 ,session,"10")    //profile completion detail save
		try{
			def documentName = null
			HealpalUser user = session.user
			println "user;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+user
			if(request.post && user){
				println "params.uploadPhoto;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+params.uploadPhoto
				if(params != null) {
					def saveFile = profileService.saveImage(request,user)
					println "saveFile;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+saveFile
				}
				redirect controller :'profile' ,action :'b2'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	def b2(){
		authorizeMe();
		profileCompletionService . saveMe("b2" ,0 ,session,"10")    //profile completion detail save
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
					redirect controller :'profile' ,action :'b3'
				}
			}else{
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	def b3(){
		authorizeMe();
		profileCompletionService . saveMe("b3" ,0 ,session,"10")    //profile completion detail save
		try{
			if(request.post){
				HealpalUser healpalUser = session.user;
				profileService.savePatientAbout(params,healpalUser);
				redirect controller :'profile' ,action :'c1'
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}


	/**
	 * @return
	 */
	def c1(){
		authorizeMe();
		profileCompletionService . saveMe("c1" ,0 ,session,"10")    //profile completion detail save
		try {
			def iamList=AboutYou.createCriteria().list {order("rowCreated","asc")}
			if(params!=null && params.iAm!=null && !params.iAm.isEmpty()) {
				def question="I am a";
				def iAmId=params.iAm
				HealpalUser user=session.user
				def value=AboutYou.get(iAmId)?.aboutYouName
				boolean temp=tempQuestionService.updateProfile(question, user)
				if(temp){
					TempQuestionOption aboutYouSave=tempQuestionService.save(question,value,user)
					redirect controller :'profile' ,action :'c2'
				}
			}
			[iamList:iamList]
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}


	def c3(){
		authorizeMe();
		profileCompletionService . saveMe("c3" ,0 ,session,"10")    //profile completion detail save
		if(request.post){
			redirect controller :'profile' ,action :'c4'
		}
	}

	/**
	 * @return
	 */
	def c4(){
		authorizeMe();
		profileCompletionService . saveMe("c4" ,0 ,session,"10")    //profile completion detail save
		try {

			HealpalUser user=session.user
			if(params.ans!=null && !params.ans.isEmpty() && params !=null) {
				def question="Gender identity"
				def value=params.ans
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption temp=tempQuestionService.save(question,value, user)
					redirect controller :'profile' ,action :'c5'
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def c5(){
		authorizeMe();
		profileCompletionService . saveMe("c5" ,0 ,session,"10")    //profile completion detail save
		/*def stateList = State.createCriteria().list { order("stateName","asc") }
		 def countryList = County.createCriteria().list { order("countyName","asc") }
		 def cityList = City.createCriteria().list { order("cityName","asc") }*/
		if(request.post){
			HealpalUser healpalUser = session.user;
			Person currentPerson = healpalUser?.person
			Patient patient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
			def address=profileService.saveAddress(params,healpalUser);
			if(address!=null)
			{
				def isExistPatientAddress=PatientAddress.findAllByPatient(Patient.findByPerson(healpalUser?.person))
				if(isExistPatientAddress && isExistPatientAddress!=null && isExistPatientAddress.size()>0){
					def deleteStatus = PatientAddress.executeUpdate("delete from PatientAddress p where p.patient="+patient?.id);
				}
				PatientAddress patientAddress=new PatientAddress()
				patientAddress.patient = Patient.findByPerson(healpalUser?.person)
				patientAddress.address=address
				patientAddress.isActive = Short.valueOf("1")
				patientAddress.rowCreated = new Date()
				patientAddress.save(flush:true)
				println "patientAddress"+address
				redirect controller :'profile' ,action :'c6'

				if (!patientAddress.validate()){
					patientAddress.errors.each {println it }
				}else{
					//do nothing
				}
			}
		}else{

			//[cityList:cityList, stateList:stateList, countryList:countryList]
		}
	}
	/**
	 * @return
	 */
	def c6(){
		authorizeMe();
		profileCompletionService . saveMe("c6" ,0 ,session,"15")    //profile completion detail save
		try {
			def ethnicityView=Ethnicity.createCriteria().list { order("rowCreated","asc") }
			HealpalUser user = session.user
			if(params!=null && params.ethnicityId!=null && !params.ethnicityId.isEmpty())
			{
				def ethnicityId = params.ethnicityId
				Person person = Person.get(user.person?.id)
				if(person){
					println  "person;;;;;;;;;;;;;;;;;"+person
					person.ethnicity= Ethnicity.get(ethnicityId)
					person.save(flush:true)
					redirect controller :'profile' ,action :'c7'
				}
			}

			[ethnicityView:ethnicityView]
		}

		catch(Exception e) {
			e.printStackTrace()
		}
	}
	/**
	 * @return
	 */
	def c7(){
		authorizeMe();
		profileCompletionService . saveMe("c7" ,0 ,session,"15")    //profile completion detail save
		try {
			HealpalUser user=session.user
			if(params != null && params.ans!=null && !params.ans.isEmpty()) {
				def value=params.ans
				def question="Select your Race"
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption temp=tempQuestionService.save(question,value, user)
					redirect controller:'profile' ,action:'c8'
				}
			}
			[race:Race.findAll()]
		}
		catch(Exception exception) {
			exception.printStackTrace()
		}
	}
	def c8(){
		authorizeMe();
		profileCompletionService . saveMe("c8" ,0 ,session,"15")    //profile completion detail save
		try{
			HealpalUser healpalUser = session.user;
			if(params!=null &&  params.educationId !=null && !params.educationId.equals("")){
				profileService.savePatientEducation(params,healpalUser);
				redirect(action:'c9')
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		def education = Education.createCriteria().list {}
		[education:education]

	}
	def c9(){
		authorizeMe();
		profileCompletionService . saveMe("c9" ,0 ,session,"15")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser healpalUser = session.user;
			if(request.post){
				if(params!=null && params.healthInsurance!=null && !params.healthInsurance.equals("")){
					questionans = profileService.savePatientInsurance(params, healpalUser)
					if(questionans !=null)
					{
						redirect(action:'ca10')
					}
				}

			}
			def healthInsurance = HealthInsurance.createCriteria().list {}
			[healthInsurance:healthInsurance]
		}catch(Exception exception){
			exception.printStackTrace();
		}

	}
	def ca10(){
		authorizeMe();
		profileCompletionService . saveMe("ca10" ,0 ,session,"15")    //profile completion detail save
		try{
			HealpalUser healpalUser = session.user;
			def questionans = null
			HealpalUser user=session.user
			if(request.post){
				if(params!=null && params.answer!=null && !params.answer.equals("") && params.question!=null && !params.question.equals("")){
					def interestedIn = params.answer
					boolean tempQues=tempQuestionService.updateProfile(params.question, user)
					if(tempQues){
						if(interestedIn.toString().contains(",")){
							interestedIn.each {
								questionans = tempQuestionService.save(params.question,it, healpalUser)
							}
						}else{
							questionans = tempQuestionService.save(params.question, interestedIn, healpalUser)
						}
						if(questionans !=null)
						{
							redirect(action:'ca11')
						}
					}
				}

			}
			def personalInterest = PersonalInterest.createCriteria().list {}
			[personalInterest:personalInterest]

		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	def ca11(){
		try{
			authorizeMe();
			profileCompletionService . saveMe("ca11" ,0 ,session,"15")    //profile completion detail save
			if(request.post){
				HealpalUser user=session.user
				if(params != null && params.treatingDoctor!= null && !params.treatingDoctor.isEmpty() && params.zipcode!= null && !params.zipcode.isEmpty() && params.contactNumber!= null && !params.contactNumber.isEmpty()){
					TreatingDoctor doctorDetails=profileService.detailsAboutDoctor(params,user)
					if(doctorDetails!=null && doctorDetails.validate()){
						redirect(controller:"profile",action:"ca13")
					}
					else{
						//do nothing
					}
				}
			}
		}catch(Exception e){
		}
	}
	/*def ca12(){
	 try{
	 authorizeMe();
	 profileCompletionService . saveMe("ca12" ,0 ,session,"")    //profile completion detail save
	 if(request.post){
	 HealpalUser user=session.user
	 if(params != null && params.zipcode!= null && !params.zipcode.isEmpty() && params.contactNumber!= null && !params.contactNumber.isEmpty()){
	 TreatingDoctor treatingDoctorDetails=profileService.detailsAboutDoctor(params,user)
	 if(treatingDoctorDetails!=null && treatingDoctorDetails.validate()){
	 redirect(controller:"profile",action:"ca13")
	 }
	 else{
	 //do nothing
	 }
	 }
	 }
	 else{
	 [treatingDoctor:params.doctorid]
	 }
	 }catch(Exception e){
	 }
	 }*/


	def ca13()
	{
		try{
			println "inside ca13;;;;;;;;;;;;;;;;;;;;;"
			authorizeMe();
			HealpalUser user=session.user
			profileCompletionService . saveMe("ca13" ,0 ,session,"20")
			
			/*if(ProfilePage.findByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)==null)
			{
				println "inside loop;;;;;;;;;;"
			
			ProfilePage object=new ProfilePage()
			object.profilePageName="ca13";
			object.rowCreated=new Date();
			object.isActive=(short)1
			object.patientFk=Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id
			object.save();
			if(!object . validate()){
				object . errors . each { println it  }
			}
			}
			if(ProfilePage.findAllByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)!=null)
			{
				ProfilePage.saveAll();
			}*/
		}
		catch(Exception exception)
		{
			exception.printStackTrace()
		}
	}



	def d4(){
		try{
			authorizeMe();
			profileCompletionService . saveMe("d4" ,0 ,session,"25")    //profile completion detail save
			if(request.post){
				HealpalUser user=session.user
				//if(params != null && params.diagnosis!= null && !params.month.isEmpty() && params.date!= null && !params.date.isEmpty() && params.year!= null && !params.year.isEmpty()){
					if(params != null){
					//String convertDate=params.month+" "+ params.date+", "+params.year
					//DateFormat formatDate = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
					//Date dateOfDiagnosis = formatDate.parse(convertDate);
					//println"dateOfDiagnosis:::::::::::::"+dateOfDiagnosis
					PatientDiagnosis updatePatientDignosis=profileService.addDateOfDignosis(params,user)
				
					if(updatePatientDignosis!=null && updatePatientDignosis.validate()){
						//def a1=user?.person?.dob
						session.dateOfDiagnosis=updatePatientDignosis?.dateOfCancerDiagnosis
						def date1=session.dob
						DateFormat formatDate1 = new SimpleDateFormat("yyyy", Locale.US);
						int dob =Integer.parseInt(formatDate1.format(date1));
						println"date of birth  :::::::::::::::"+dob
						def a2=updatePatientDignosis?.dateOfCancerDiagnosis
						int dob1 =Integer.parseInt(formatDate1.format(a2));
						println"dob1  :::::::::::::::"+dob1
						/*
						 * To get dob and date of cancer diagnosis
						 */
							DateFormat formatDates = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
							def getDateOfDiagnosis=formatDates.format(a2)
							
							session.getDateOfDiagnosis=getDateOfDiagnosis
							
						if(dob1>dob){
							
							def calculate=dob1-dob
							println"calculate::::::::::::"+calculate
							redirect(controller:"profile",action:"d5",params:[age:calculate])
						}else{
						flash.msg="Probably your Date of Birth or Date of Cancer Diagnosis is not correct. Please enter your Date of Birth"
						redirect(controller:"profile",action:"d4")
						}
						
						
					}
					else{
						//do nothing
					}
				}
			}
			[goToD5:params.goToD5]
		}catch(Exception e){
		}
	}

	def c2(){
		try{
			authorizeMe();
			profileCompletionService . saveMe("c2" ,0 ,session,"25")    //profile completion detail save
			if(request.post){
				HealpalUser user=session.user
				//if(params != null && params.month!= null && !params.month.isEmpty() && params.date!= null && !params.date.isEmpty() && params.year!= null && !params.year.isEmpty()){
					if(params != null){
					//def convertDate=params.dob
				/*	println"convertDate"+convertDate
					DateFormat formatDate = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
					Date dateOfBirth = formatDate.parse(convertDate);
					println"dateOfBirth"+dateOfBirth*/
					Person updatePerson=profileService.addPersonDob(params,user)
					if(updatePerson!=null && updatePerson.validate()){
						session.dob=updatePerson?.dob
						DateFormat formatDates = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
						def getDOB=formatDates.format(updatePerson?.dob)
						session.getDOB=getDOB
						println"updatePerson"+updatePerson
						if(params.goToD4 && params.goToD4 !=null && !params.goToD4.isEmpty() && params.goToD4 != ""){
							redirect(controller:"profile",action:"d4", params:[goToD5:'TRUE'])
						}
						else{
						redirect(controller:"profile",action:"c3")
						}
					}
					else{
						//do nothing
					}
				}
			}
			[backToD4:params.backTod4]
		}catch(Exception e){
		}
	}
	def d6(){
		authorizeMe();
		profileCompletionService . saveMe("d6" ,0 ,session,"25")    //profile completion detail save
	}
	def d7(){
		authorizeMe();
		profileCompletionService . saveMe("d7" ,0 ,session,"25")    //profile completion detail save
	}
	def d8(){
		authorizeMe();
		profileCompletionService . saveMe("d8" ,0 ,session,"25")    //profile completion detail save
	}
	def d9(){
		authorizeMe();
		profileCompletionService . saveMe("d9" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params != null && ((params.optionA!=null && !params.optionA.isEmpty()) ||(params.optionB!=null && !params.optionB.isEmpty()) || (params.optionC!=null && !params.optionC.isEmpty()))){
				String question="Pathology biopsy tumor type 1";
				String answer=""
				if(params.optionA!=null && !params.optionA.isEmpty()){
					answer=params.optionA.toString()
				}
				if(params.optionB!=null && !params.optionB.isEmpty()){
					answer=params.optionB.toString()
				}
				if(params.optionC!=null && !params.optionC.isEmpty()){
					answer=params.optionC.toString()
				}
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)

					if(addQuestion!=null){
						if(params.optionA!=null && !params.optionA.isEmpty()){

							redirect(controller:"profile",action:"da10")
						}
						else{
							redirect(controller:"profile",action:"da11",params:[fromdnine:'@t%r@ue@'])
						}
					}
					else{
					}
				}
			}
		}catch(Exception e){
		}
	}
	def da10(){
		authorizeMe();
		profileCompletionService . saveMe("da10" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params != null && params.answer!=null && !params.answer.isEmpty()){
				String question="Pathology biopsy tumor type 2";
				String answer=params.answer.toString()
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)
					if(addQuestion!=null){
						redirect(controller:"profile",action:"da11")
					}
				}}
		}catch(Exception e){
		}
	}
	def da11(){
		authorizeMe();
		profileCompletionService . saveMe("da11" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params != null && params.answer!=null && !params.answer.isEmpty()){
				String question="I have undergone molecular testing for my cancer";
				String answer=params.answer.toString()
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)
					if(addQuestion!=null){
						if(answer=="Yes"){
							redirect(controller:"profile",action:"da12")
						}else{
							redirect(controller:"profile",action:"e1",params:[fromdaeleven:'@t%r@ue@'])
						}
					}}
			}
			if(params.fromdnine)
			{
				[backTod9:'true']
			}
		}catch(Exception e){
		}
	}
	def da12(){
		authorizeMe();
		profileCompletionService . saveMe("da12" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(request.post){
				String question="Please choose which molecular test or tests have been performed";
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){

					for(int i = 1; i <= 3; i++){
						def ans =params.("answer"+i)
						println ans
						if(ans!=null)
						{
							TempQuestionOption temp=tempQuestionService.save(question, ans, user)
						}
						else
						{
							//do nothing
						}
					}

					redirect(controller:"profile",action:"e1")
				}
			}
		}catch(Exception e){
		}
	}
	def e1(){
		authorizeMe();
		profileCompletionService . saveMe("e1" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params != null && params.answer!=null && !params.answer.isEmpty()){
				String question="Did you undergo surgery for your cancer?";
				String answer=params.answer.toString()
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)
					if(addQuestion!=null){
						if(answer=="Yes"){
							redirect(controller:"profile",action:"e2")
						}else{
							redirect(controller:"profile",action:"f1",params:[fromeone:'@t%r@ue@'])
						}
					}
				}
			}
			if(!params.fromdaeleven.isEmpty())
			{
				[BackToda11:params.fromdaeleven]
			}
		}catch(Exception e){
		}
	}
	def e2(){
		authorizeMe();
		profileCompletionService . saveMe("e2" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(request.post){
				String question="What type of surgical procedure did you Undergo or are scheduled to undergo?";
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					for(int i = 1; i <= 11; i++){
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
					if(params.otherOptions && params.otherOptions!=null && params.others!=null){
						println "othersssssssssssssssssss"
						println "params"+params.otherOptions
						TempQuestionOption temp=tempQuestionService.save(question, params.otherOptions, user)
					}
					redirect(controller:"profile",action:"e3")
				}}
		}catch(Exception e){
		}
	}
	def e3(){
		authorizeMe();
		profileCompletionService . saveMe("e3" ,0 ,session,"30")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params != null && params.answer!=null && !params.answer.isEmpty()){
				String question="Results of your surgery";
				String answer=params.answer.toString()
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption addQuestion=tempQuestionService.save(question, answer,user)
					if(addQuestion!=null){
						redirect(controller:"profile",action:"e4")
					}
				}
			}
			
		}catch(Exception e){
		}
	}
	def e4(){
		authorizeMe();
		profileCompletionService . saveMe("e4" ,0 ,session,"35")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(request.post){
				//if(params != null && params.month!= null && !params.month.isEmpty() && params.date!= null && !params.date.isEmpty() && params.year!= null && !params.year.isEmpty()){
				if(params != null){
					/*String convertDate=params.month+" "+ params.date+", "+params.year
					DateFormat fmt = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
					Date dateOfBirth = fmt.parse(convertDate);
					String resetDate= fmt.format(dateOfBirth)*/
					
					String stringDate =params.surgery
					/*Date date = new Date().parse('M/d/yyyy', stringDate)
					println"surgery date:::::::::::::::::"+date*/
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
							redirect(controller:"profile",action:"f1")
						}
					}
				}
			}

		}catch(Exception e){
		}
	}
	def f1(){
		authorizeMe();
		profileCompletionService . saveMe("f1" ,0 ,session,"35")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser user=session.user
			if(params !=null && params.question !=null && !params.question.equals("") &&  params.answer !=null && !params.answer.equals("")) {
				boolean tempQues=tempQuestionService.updateProfile(params.question, user)
				if(tempQues){
					questionans = tempQuestionService.save(params.question, params.answer, user)
					if(questionans !=null) {
						if(params.answer !=null && !params.answer.equals("") && params.answer.equals("Yes")){
							redirect(action:'f2')
						}
						else{
							redirect(action:'f4',params:[fromfone:'@t%r@ue@'])
						}
					}
				}}
			if(params.fromeone)
			{
				[BackToe1:params.fromeone]
			}
		}catch(Exception e){
		}
	}
	def f2(){
		authorizeMe();
		profileCompletionService . saveMe("f2" ,0 ,session,"35")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser user=session.user
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
							redirect(action:'f3')
						}
					}}
			}
			def chemotheraphy = ChemotherapyDrugs.createCriteria().list {}
			[chemotheraphy:chemotheraphy]
		}catch(Exception e){
		}
	}
	def f3(){
		authorizeMe();
		profileCompletionService . saveMe("f3" ,0 ,session,"40")    //profile completion detail save
		try{
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
							redirect(action:'f4')
						}
					}
				}
			}

			def combinationChemotheraphy = CombinationChemotherapyDrugs.createCriteria().list {}
			[combinationChemotheraphy:combinationChemotheraphy]
		}catch(Exception e){
		}
	}
	def f4(){
		authorizeMe();
		profileCompletionService . saveMe("f4" ,0 ,session,"45")    //profile completion detail save
		try{
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
							redirect(action:'f5')
						}}
				}
			}
			def metastaticBreastCancer = MetastaticBreastCancer.createCriteria().list {}
			[metastaticBreastCancer:metastaticBreastCancer,BackTof1:params.fromfone] 
		}catch(Exception e){
		}
	}
	def f5(){
		authorizeMe();
		HealpalUser user=session.user
		profileCompletionService . saveMe("f5" ,0 ,session,"50")    //profile completion detail save
		/*ProfilePage page=null;
		 page=ProfilePage.findByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
		println "page;11111;;;;;;"+page
		if(page!=null)
		{
			if(page.profilePageName=="ca13"){
			println "page;;;22222222222;;;;"+page.id
			page.profilePageName="f5"
			page.rowCreated=new Date();
			page.save(flush:true)
			println "page.save(flush:true)"+page.save(flush:true)
			}
			if(!page . validate()){
				page . errors . each { println it  }
			
		}
		}*/
	}
	def g1(){
		authorizeMe();
		profileCompletionService . saveMe("g1" ,0 ,session,"55")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser user=session.user
			if(params !=null && params.question !=null && !params.question.equals("") &&  params.answer !=null &&  !params.answer.equals("") ) {
				boolean tempQues=tempQuestionService.updateProfile(params.question, user)
				if(tempQues){
					questionans = tempQuestionService.save(params.question, params.answer, user)
					if(questionans !=null) {
						if(params.answer !=null && !params.answer.equals("")&& params.answer.equals("Yes")){
							redirect(action:'g2')
						}
						else{
							redirect(action:'h1',params:[fromgonePage:'@t%r@ue@'])
						}
					}
				}
			}
		}catch(Exception e){
		}
	}
	def g2(){
		authorizeMe();
		profileCompletionService . saveMe("g2" ,0 ,session,"55")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser user=session.user
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
							redirect(action:'h1')
						}
					}
				}
			}
			def hormoneTherapy = HormoneTherapy.createCriteria().list {}
			[hormoneTherapy:hormoneTherapy]
		}catch(Exception e){
		}
	}


	/**
	 * 
	 * @return
	 */
	def k1()
	{
		authorizeMe();
		profileCompletionService . saveMe("k1" ,0 ,session,"85")    //profile completion detail save
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
							//do nothing
						}
					}
					redirect(controller:"profile",action:"l1")
				}			}
		}
		catch(Exception exce)
		{

		}

	}

	//*************************************
	/**
	 * @return
	 */
	def l1(){
		authorizeMe();
		profileCompletionService . saveMe("l1" ,0 ,session,"90")    //profile completion detail save
	}
	/**
	 * @return
	 */
	def l2(){
		authorizeMe();
		profileCompletionService . saveMe("l2" ,0 ,session,"95")    //profile completion detail save
		try{
			def medicalConditionList = MedicalCondition.createCriteria().list{
				eq("isActive",Short.valueOf("1"))
				order('id','asc')
				not{
				like('medicalConditionType','others_%')
				}
			}
			[medicalConditionList:medicalConditionList]
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	def l3(){
		authorizeMe();
		profileCompletionService . saveMe("l3" ,1,session,"100")    //profile completion detail save
		/*HealpalUser user=session.user
		ProfilePage page=null;
		page=ProfilePage.findByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
	   println "page;11111;;;;;;"+page
	   if(page!=null)
	   {
		   if(page.profilePageName=="j3"){
		   println "page;;;22222222222;;;;"+page.id
		   page.profilePageName="l3"
		   page.rowCreated=new Date();
		   page.save(flush:true)
		   println "page.save(flush:true)"+page.save(flush:true)
		   }
		   if(!page . validate()){
			   page . errors . each { println it  }
		   }
	   }*/
		
		
		try{
			HealpalUser healpalUser = session.user;
			def medicalConditionIds = params.medicalCondition
			def othercancers=params.otherCancer;
			def othermedicals=params.otherMedical;
			if(healpalUser!=null && !healpalUser.equals("") || ((medicalConditionIds!=null && !medicalConditionIds.equals(""))||(othercancers!=null && !othercancers.equals(""))||(othermedicals!=null && !othermedicals.equals("")))){
				profileService.saveMedicalCondition(medicalConditionIds,healpalUser, othercancers,othermedicals);
			}
			
			
			
		   
			
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def l3ViewMatch(){
		try{
		HealpalUser healpalUser = session.user;
		if(healpalUser!=null && !healpalUser.equals("")){
			println "before call service ********";
			patientMatchService.doBatchProcessForCurrentPatient(healpalUser);
		}else{
		   //do nothing
		}
		redirect(controller:'dashboard',action:'view')
		}catch(Exception exception){
		    exception.printStackTrace();
		}
	}
	def m1(){
		authorizeMe();
		if(request.post){
			println " m1 payment process initiated 1"
			try {
				//Set Stripe Secret/Api Key
				Stripe.apiKey = "sk_test_EPEDJ84HJ62x2dIvOkhdfkOA"//"YOUR STRIPE API KEY"
						  
				def amount = Double.parseDouble("50") //params.amount
				def token = params.stripeToken
				println " m1 payment process initiated 2 amnt & token" + amount+""+token
				if(amount && token){
					println "\n\nSTRIPE API KEY : ${Stripe.apiKey} -> TOKEN : ${token} -> AMOUNT : ${amount}\n\n"
					//convert amount into cents
					def amountInCents = (amount * 100) as Integer
					
					//create Stripe parameters object
					def chargeParams = [
						'amount': amountInCents,
						'currency': 'usd',
						'card': token,
						'description': "Order Placed ${amount}"
					]
					Charge.create(chargeParams)
					flash.message = "Successfully charged Stripe"
					redirect action:'m2'
				}
	
			
			} catch (Exception e) {
				flash.message = "Something went wrong ..."
				println("Status is: " + e.printStackTrace());
			}
			redirect action:'m2' // remove me later
			profileCompletionService . saveMe("m1" ,0 ,session,"100")    //profile completion detail save
				
		}
	}

	/**
	 * @return
	 */
	def viewMatch(){
		HealpalUser healpalUser=session.user;
		if(healpalUser){
			patientMatchService.doBatchProcessForCurrentPatient(healpalUser);
			redirect(controller:'patientMatch',action:'patientMatch');
		}
	}
	
	
	
	def m2(){
		authorizeMe();
		try{
		 profileCompletionService . saveMe("m2" ,0,session,"100")
		 HealpalUser healpalUser=session.user;
	     if(request.post)
		 {
		  if(healpalUser!=null && !healpalUser.equals("")){
		   boolean profileCompleted=profileService.savePatientAccountDetails(healpalUser);
		   if(profileCompleted){
			
			println "ProfileController .m2 file uploading initiated 1"
			if(request instanceof MultipartHttpServletRequest){ println "ProfileController .m2 file uploading initiated 2"
			 
			 
			 request.getFiles('url[]').each{obj->
			  
			  if(!obj.empty){
			   println "ProfileController .m2 file uploading initiated 3"
			   
			   CommonsMultipartFile file = obj
			   println  file.getOriginalFilename()
			   
			   //CommonsMultipartFile file = request.getFile('docFile')
			   String fileName = file.getOriginalFilename()
			   println "ProfileController .m2 file uploading initiated 4" + fileName
			   if(fileName){
				String extension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
				//if(extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg")){
				 println "inside png "
				 profileService . saveDocument(request, session, "assets/patient_medical_document/" ,obj)
				 profileService . savePatientDocument(session,  "assets/patient_medical_document/" ,extension)
				//}
			   }
			  }else{
			   println "** choosen AddHeaderLogo file is an EMPTY its cannot empty ."
			  }
			 }
			 
			 profileCompletionService . saveMe("m2" ,1,session)    //profile completion detail save
			 println "before call service ********";
			 patientMatchService.doBatchProcessForCurrentPatient(healpalUser);
			 auditEventService . save(AuditEventType.addedProfile, Role.patient, session)
			}
			redirect(controller:'dashboard',action:'view')
		   }
		  }
		 }
		}catch(Exception exception){
		 exception.printStackTrace();
		}
	   }

	def questionOptionFormat(){
		authorizeMe();
		profileCompletionService . saveMe("questionOptionFormat" ,0 ,session,"")    //profile completion detail save
		def optionsFormat=QuestionOptionsFormat.createCriteria().list {

		}
		def questionCategory=QuestionCategory.createCriteria().list {

		}
		[OptionsFormat:optionsFormat,questionCategory:questionCategory]
	}

	/**
	 * Update the person HER positive
	 * @return
	 */
	def updatePositive(){
		authorizeMe();
		profileCompletionService . saveMe("updatePositive" ,0 ,session," ")    //profile completion detail save
		try{
			if(params.type && params.value){
				HealpalUser healpalUser = session.user;
				profileService.updatePositive(params, healpalUser);
			}else{
				//do nothing
			}
			render ""
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	/**
	 * Check Authorize whether the user is patient or not. If patient allow to access else logout
	 * @return
	 */
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}


	def diagnosisSave(){
		authorizeMe();
		profileCompletionService . saveMe("diagnosisSave" ,0 ,session," ")    //profile completion detail save
		try{
			if(params !=null && ! params.isEmpty() && session.user){
				HealpalUser healpalUser = session.user;
				def Id=params.diagnosis
				PatientDiagnosis diagnosis=diagnosisService.addPatientDiagnosis(new PatientDiagnosis(),params,healpalUser,Id)
				if(diagnosis !=null){
					flash.msg ="  About You Name Saved Successfully"
					redirect(action:"c1")
				}else{
					redirect(action:"d2")
				}

			}
		}catch(Exception exception){
			throw exception
		}
	}


	def d1(){
		authorizeMe();
		profileCompletionService . saveMe("d1" ,0 ,session,"25")    //profile completion detail save
		try
		{
			[cancerStatusList:cancerStatusService.getCancerStatusList(params)]
		}

		catch(Exception exception)
		{
			exception.printStackTrace()
		}

	}

	def d2(){
		authorizeMe();
		profileCompletionService . saveMe("d2" ,0 ,session,"25")    //profile completion detail save
		try{
			[diagnosisList:diagnosisService.getdiagnosisList()]
		}catch(Exception exception){
			throw exception
		}

	}
	/**
	 * @return
	 */
	def d3(){
		authorizeMe();
		profileCompletionService . saveMe("d3" ,0 ,session,"25")    //profile completion detail save
		try
		{
			HealpalUser user=session.user
			if(params!=null && params.ans!=null && !params.ans.isEmpty())
			{
				def value=params.ans
				def question="Stage of cancer"
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption temp=tempQuestionService.save(question, value, user)
					redirect(action:"d4")
				}
			}
		[cancerStage : CancerStage.findAll()]
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
	}

	def d5(){
		authorizeMe();
		profileCompletionService . saveMe("d5" ,0 ,session,"25")    //profile completion detail save
		try{
			if(request.post){
				if(params !=null && !params.isEmpty() && params.age !=null &&  !params.age.isEmpty()){
					println "::::::::::::::::"+params.age
					HealpalUser healpalUser = session.user;
					PatientDiagnosis ageDiagnosis=diagnosisService.addPatientDiagnosisAge(params,healpalUser)
					if(ageDiagnosis !=null){
						flash.msg ="  About You Name Saved Successfully"
						redirect(action:"d6")
					}
				}
				else{
				}
			}else{

			}
			[age:params.age]
		}catch(Exception exception){

		}
	}


	def updateCancerStatus(){
		authorizeMe();
		profileCompletionService . saveMe("updateCancerStatus" ,0 ,session,"")    //profile completion detail save
		try{
			if(params.value){
				HealpalUser healpalUser = session.user;
				cancerStatusService.updateStatus(params, healpalUser);
			}else{
				//do nothing
			}
			render ""
		}catch(Exception exception){
			exception.printStackTrace();
		}

	}


	def h1(){
		authorizeMe();
		profileCompletionService . saveMe("h1" ,0 ,session,"60")    //profile completion detail save
		try{
			def questionans = null
			HealpalUser user=session.user
			if(params !=null && params !="" && params.question !=null && params.question !="" &&  params.answer !=null &&  params.answer !="" )
			{
				boolean tempQues=tempQuestionService.updateProfile(params.question, user)
				if(tempQues){
					questionans = tempQuestionService.save(params.question, params.answer, user)
					if(questionans !=null)
					{
						if(params.answer !=null && params.answer !="" && params.answer == "Yes"){
							redirect(action:'h2')}
						else{
							redirect(action:'h3')
						}
					}				}
			}
			if(params.fromgonePage!="" && !params.fromgonePage.isEmpty())
			{
				[fromG1:true]
			}
		}catch(Exception e){}

	}
	def h2(){
		authorizeMe();
		profileCompletionService . saveMe("h2" ,0 ,session,"60")    //profile completion detail save
		try{
			HealpalUser user=session.user
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
					redirect(controller:"profile",action:"h3")
				}
			}

		}catch(Exception e){

		}
	}
	def h3(){
		authorizeMe();
		HealpalUser user=session.user
		profileCompletionService . saveMe("h3" ,0 ,session,"70")    //profile completion detail save
		/*ProfilePage page=null;
		page=ProfilePage.findByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
	   println "page;11111;;;;;;"+page
	   if(page!=null)
	   {
		   if( page.profilePageName=="f5")
		   {
		   println "page;;;22222222222;;;;"+page.id
		   page.profilePageName="h3"
		   page.rowCreated=new Date();
		   page.save(flush:true)
		   println "page.save(flush:true)"+page.save(flush:true)
		   }
		   if(!page . validate()){
			   page . errors . each { println it  }
		   
	   }
	   }*/
	
		
		
		
	}

	def i1(){
		authorizeMe();
		profileCompletionService . saveMe("i1" ,0 ,session,"75")    //profile completion detail save
		try{
			HealpalUser user=session.user

			if(params != null && ((params.optionA!=null && !params.optionA.isEmpty()) ||(params.optionB!=null && !params.optionB.isEmpty()) || (params.optionC!=null && !params.optionC.isEmpty()))){
				String question="Did you undergo radiation treatment?";
				String answer=""
				if(params.optionA!=null && !params.optionA.isEmpty()){
					answer=params.optionA.toString()
				}
				if(params.optionB!=null && !params.optionB.isEmpty()){
					answer=params.optionB.toString()
				}
				if(params.optionC!=null && !params.optionC.isEmpty()){
					answer=params.optionC.toString()
				}
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption radiationQuestion=tempQuestionService.save(question, answer,user)
					if(radiationQuestion!=null){
						if(params.optionA!=null && !params.optionA.isEmpty()){
							redirect(controller:"profile",action:"i2")

						}
						else{
							redirect(controller:"profile",action:"j1",params:[fromione:'@t%r@ue@'])
						}

					}
					else{
						// do nothing
					}
				}

			}


		}catch(Exception e){

		}

	}

	def i2(){
		authorizeMe();
		profileCompletionService . saveMe("i2" ,0 ,session,"75")    //profile completion detail save
		try{
			HealpalUser user=session.user
			if(params !=null && !params.isEmpty() && params.Answer !=null && !params.Answer.isEmpty()){
				String question="Which type of radiation treatment did you receive or are scheduled to receive?";
				String answer=params.Answer
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption radiationTreatment=tempQuestionService.save(question, answer,user)
					if(radiationTreatment !=null){
						redirect(controller:"profile",action:"j1")
					}else{

					}
				}else{
					// do nothing
				}

			}
		}catch(Exception exception){
			exception.printStackTrace()
		}

	}

	def j1(){
		authorizeMe();
		profileCompletionService . saveMe("j1" ,0 ,session,"75")    //profile completion detail save
		try{
			HealpalUser user=session.user

			if(params != null && ((params.optionA!=null && !params.optionA.isEmpty()) ||(params.optionB!=null && !params.optionB.isEmpty()) || (params.optionC!=null && !params.optionC.isEmpty()))){
				String question="Did you participate in any clinical trial";
				String answer=""
				if(params.optionA!=null && !params.optionA.isEmpty()){
					answer=params.optionA.toString()
				}
				if(params.optionB!=null && !params.optionB.isEmpty()){
					answer=params.optionB.toString()
				}
				if(params.optionC!=null && !params.optionC.isEmpty()){
					answer=params.optionC.toString()
				}
				boolean tempQues=tempQuestionService.updateProfile(question, user)
				if(tempQues){
					TempQuestionOption Question=tempQuestionService.save(question, answer,user)
					if(Question!=null){
						if(params.optionA!=null && !params.optionA.isEmpty()){
							redirect(controller:"profile",action:"j2")

						}
						else{
							redirect(controller:"profile",action:"j3")
						}

					}
					else{
						// do nothing
					}
				}
			}
			if(params.fromione){
				[BackToi1:params.fromione]
			}
		}catch(Exception e){

		}
	}

	def j2(){
		authorizeMe();
		profileCompletionService . saveMe("j2" ,0 ,session,"75")    //profile completion detail save
		try{
			if(request.post){
				if(params !=null && !params.isEmpty() && params.participated !=null &&  !params.participated.isEmpty()){
					HealpalUser user=session.user

					String question="Please state the clinical trial you  participated in"
					String answer=params.participated
					boolean tempQues=tempQuestionService.updateProfile(question, user)
					if(tempQues){
						TempQuestionOption participatedQuestion=tempQuestionService.save(question, answer,user)
						if(participatedQuestion !=null){
							//flash.msg ="  About You Name Saved Successfully"
							redirect(action:"j3")
						}

						else{
						}

					}


				}
			}
		}catch(Exception exception){

		}
	}

	def j3(){
		authorizeMe();
		HealpalUser user=session.user
		profileCompletionService . saveMe("j3" ,0 ,session,"80")    //profile completion detail save
	
	/*	ProfilePage page=null;
		page=ProfilePage.findByPatientFk(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
	   println "page;11111;;;;;;"+page
	   if(page!=null)
	   {
		   if( page.profilePageName=="h3"){
		   println "page;;;22222222222;;;;"+page.id
		   page.profilePageName="j3"
		   page.rowCreated=new Date();
		   page.save(flush:true)
		   println "page.save(flush:true)"+page.save(flush:true)}
		   if(!page . validate()){
			   page . errors . each { println it  }
		   
	   }
	   }*/
		
		
		
	}


	/**
	 * Update the person gender who is logged in
	 * @return
	 */
	def updateGender(){
		try{
			println "inside updateGender..>>>>>>>>>>>>>>>>>>>>>>>>>>>     "+params.genderType
			authorizeMe();
			HealpalUser user = session.user
			if(params && params.genderType && user){
				profileService.updateGender(params, user);
			}else{
				//do nothing
			}
			render "success"
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}

	def saveQuestionValue(){
		authorizeMe();
		profileCompletionService . saveMe("saveQuestionValue" ,0 ,session,"")    //profile completion detail save
		try{
			if(params && params.question && params.answer){
				HealpalUser user = session.user
				profileService.saveQuestionAnswer(params, user);
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	def editProfile(){

		try{
			authorizeMe();
			HealpalUser user = session.user
			ArrayList editProfileResults=profileService.editProfile(user);
			
			/*def cc=Patient.findByPerson(user?.person)
			println"cc::::"+cc
			def QuestionList=ProfileQuestionAnswer.createCriteria().list{
				eq("isActive",(short)1)
				eq("patient" ,cc)
			}*/
			
			
			
			if(editProfileResults){
				int i=1;
				def AboutYouProfile=null
				def AboutYourCondition=null
				def profilePhoto=null
				def photo=null
				def patientName=null
				editProfileResults.each {
					if(i==1){
						AboutYouProfile=it;
					}
					else if(i==2){
						AboutYourCondition=it;
					}
					else if(i==3){
						patientName=it;
					}
					else if(i==4){
						profilePhoto=it;
					}
					i++;
				}

				[editAboutYouProfile:AboutYouProfile,editAboutYourCondition:AboutYourCondition,profilePhoto:profilePhoto,patientName:patientName,editPermission:'granted',question:params.question,profileActive :'active']//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath,

			}
		}catch(Exception exception){
			println exception
		}


	}
	def viewProfile(){

		try{
			authorizeMe();
			def viewProfile
			HealpalUser user = session.user
			ArrayList editProfileResults=profileService.editProfile(user);
			println "*************"+editProfileResults
			println "***************************"
				int i=1;
				def AboutYouProfile=null
				def AboutYourCondition=null
				def profilePhoto=null
				def patientName=null
				if(editProfileResults){
				editProfileResults.each {
					if(i==1){
						AboutYouProfile=it;
					}
					else if(i==2){
						AboutYourCondition=it;
					}
					else if(i==3){
						patientName=it;
					}
					else if(i==4){
						profilePhoto=it;
					}
					i++;
				}
				}
				if(params.viewProfile)
				{
					viewProfile = params.viewProfile
				}
				render(view:'editProfile',model:[editAboutYouProfile:AboutYouProfile,editAboutYourCondition:AboutYourCondition,profilePhoto:profilePhoto,patientName:patientName,profileActive :'active',viewProfile:viewProfile])

			
		}catch(Exception exception){
			println exception
		}




	}

}
