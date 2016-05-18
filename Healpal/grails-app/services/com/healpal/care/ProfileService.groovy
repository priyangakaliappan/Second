package com.healpal.care

import grails.transaction.Transactional;

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date;

import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import com.healpal.date.DateConvention
import com.healpal.encryptdecrypt.BCrypt;
import com.healpal.encryptdecrypt.CryptographyUtil;

@Transactional
class ProfileService implements org.springframework.context.ResourceLoaderAware {
	LinkGenerator grailsLinkGenerator

	def UserRoleService userRoleService
	def UserService userService
	def ResourceLoader resourceLoader
	def serviceMethod() {
	}

	Person update(session,params) {
		try {
			def userId= session.user?.id
			Person person=HealpalUser.get(userId)?.person
			person.firstName=params.firstname
			person.lastName=params.lastName
			person.rowAltered = new Date()
			person.isActive=params.status.equals("active")?(short)1:(short)0
			person.save(flush:true)
		}
		catch(Exception e){
			e.printStackTrace()
		}
	}


	HealpalUser save(params){
		HealpalUser user = new HealpalUser()
		/*if(params != null && params.email != null && !params.email.isEmpty()
		&& params.password != null && !params.password.toString().isEmpty()
		&& params.confirmPassword != null && !params.confirmPassword.toString().isEmpty()
		&& params.firstName != null && !params.firstName.isEmpty()
		&& params.lastName != null && !params.lastName.isEmpty()){*/
		if(params != null && params.email != null && !params.email.isEmpty()
			&& params.password != null && !params.password.toString().isEmpty() && 
			params.username != null && !params.username.toString().isEmpty()){
			user.withTransaction {status->
				try{
					Person person = new Person()
					person = userService.savePerson(person ,params ,"create")
					if(!person.validate()){
						//							person.errors.each{
						//								println it
						//							}
					}else{
						Patient patient = new Patient()
						patient = userService.savePatient(patient ,person ,params)
						if(!patient.validate()){
							status.setRollbackOnly()
							//							patient.errors.each{
							//								println it
							//							}
						}else{
							user = userService.save(user, params, person ,"create")
							if(!user.validate()){
								status.setRollbackOnly()
								//								user.errors.each{
								//									println it
								//								}
								return user
							}else{
								UserRole urole = new UserRole()
								params.role = Role.findByAuthority(Role.patient)?.id
								params.healpalUser = user?.id
								urole = userRoleService.save(params, new UserRole() ,"create")
								if(!urole.validate()){
									status.setRollbackOnly()
									//									urole.errors.each{
									//										println it
									//									}
									user = null
								}
							}
						}
					}
				}
				catch(Exception e){
					status.setRollbackOnly()
					user = null
				}
			}
		}else{
			//do nothing
		}
		return user
	}


	/**
	 * Save the image and store the path into database
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception
	 */
	def saveImage(request, com.healpal.care.HealpalUser user) throws Exception {
		try{
			println "******** user?.person **************"+user?.person
			if(user?.person){
				CommonsMultipartFile f = request.getFile('uploadPhoto')
				println "******** CommonsMultipartFile **************"+f
				println "******** request.getFile('uploadPhoto') **************"+request.getFile('uploadPhoto')
				String name =f.getOriginalFilename()
				println "******** name **************"+name
				if(name){
					String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
					String fileName = name.substring(0,name.lastIndexOf('.'));
					name =  user?.person.id+"." + extension
				}
				println "********extension name **************"+name
				def serveletContext = ServletContextHolder.servletContext
				def storagePath =resourceLoader.getResource("/assets/patient-photo/").getFile() //serveletContext.getRealPath("assets/patient-photo/")
				//def storagePathDirectory = new File( storagePath )
				println "********storagePath **************"+storagePath
				if( !storagePath.exists() ){
					println("creating directory ${storagePath}")
					if(storagePath.mkdirs()){
						println "SUCCESS"
					}else{
						println "FAILED"
					}
				}
		
				// Store file
		
				if(!f.isEmpty()){
					f.transferTo( new File("${storagePath}/${name}") )
					println("Saved File: ${storagePath}/${name}")
					//return "${storagePath}/${name}"
				}else{
					println "File: ${file.inspect()} was empty"
					//return null
				}
				
				
				ProfilePhoto photo = ProfilePhoto.findByPatient(Patient.findByPerson(user?.person));
				println "********photo **************"+photo
				if(photo){
					photo.profilePhotoPath = name
					photo.patient = Patient.findByPerson(user?.person)
					photo.rowAltered = new Date()
					photo.isActive = (short)1
				}else{
					photo = new ProfilePhoto()
					photo.profilePhotoPath = name
					photo.patient = Patient.findByPerson(user?.person)
					photo.rowCreated = new Date()
					photo.isActive = (short)1
				}
				def profile = photo.save(flush:true)
				if (!photo.validate()){
					photo.errors.each {println it }
				}else{
					// do nothing
				}
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	def saveDocument(request ,session ,def path ,def obj){
		try{
			HealpalUser user = session.user
			CommonsMultipartFile file = obj//request.getFile(paramName)
			String name = file.getOriginalFilename()
			
			if(file.getOriginalFilename()){
				String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
				name =  user?.person.id+"." + extension
			}
			
			def serveletContext = ServletContextHolder.servletContext
			def storagePath = resourceLoader.getResource(path).getFile()//serveletContext.getRealPath(path)
			if( !storagePath.exists()){
				println("creating directory ${storagePath}")
				if(storagePath.mkdirs()){
					println "SUCCESS"
				}else{
					println "FAILED"
				}
			}
	
			// Store file
			file.transferTo( new File("${storagePath}/${name}") )
			println("Saved File: ${storagePath}/${name}")
			
		}catch(Exception exception){
			throw exception
		}
	}
	
	def savePatientDocument(session ,def filePath ,def fileFormat){
		try{
			println "savePatientDocument"
			if(session.user){
				HealpalUser user = session.user
				def filename = user?.person.id+"."+fileFormat
				PatientMedicalDocument document = new PatientMedicalDocument()
				document. fileName = filename
				document. filePath = filePath
				document. fileFormat = fileFormat
				document. rowCreated = new Date()
				document. patient = Patient.findByPerson(user?.person)
				document. healpalUser = user
				document . save(flush:true)
				if(!document.validate()){
					document .errors.each {
						println it
					}
				}
				return document
			}
		}catch(Exception exception){
		throw exception
		}
	}

	def savePatientAbout(params,def currentPerson)throws Exception{
		try{
			if(params!=null && !params.equals("") && currentPerson!=null && !currentPerson.equals("")){
				def aboutYourself = params.aboutYourself
				def passionate = params.passionate
				if(aboutYourself!=null && !aboutYourself.equals("") || passionate!=null && !passionate.equals("")){
					currentPerson.describeAboutYourself = aboutYourself;
					currentPerson.passionateAbout = passionate
					currentPerson.save(flush:true);
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	def saveMedicalCondition(def medicalConditionIds,def healpalUser,String othercancers, String othermedicals)throws Exception{
		try{
			if(healpalUser!=null && !healpalUser.equals("")){
				Person currentPerson = healpalUser?.person
				Patient patient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
				def deleteStatus = PatientMedicalCondition.executeUpdate("delete from PatientMedicalCondition p where p.patient="+patient?.id);
				println "dddddd"+deleteStatus
			if(medicalConditionIds!=null && !medicalConditionIds.equals("") && healpalUser!=null && !healpalUser.equals("")){
				//PatientMedicalCondition patientMedicalCondition=null
				//for(int i=0;i<medicalConditionIds.size();i++){
				//if(medicalConditionIds)
					//println medicalConditionIds[i]
					//def medicalConditionId = medicalConditionIds[i];
					if(medicalConditionIds !=null && !medicalConditionIds.equals("") && patient!=null && !patient.equals("")){
						if(medicalConditionIds.toString().contains(",")){
						medicalConditionIds.each{						
						MedicalCondition medicalCondition =MedicalCondition.get(it?.toString().toLong());
						PatientMedicalCondition patientMedicalCondition = new PatientMedicalCondition();
						patientMedicalCondition.medicalCondition = medicalCondition
						patientMedicalCondition.patient = patient
						patientMedicalCondition.isActive = Short.valueOf("1")
						patientMedicalCondition.rowCreated = new Date()
						patientMedicalCondition.save();
						}
					}
						else{
							MedicalCondition medicalCondition =MedicalCondition.get(medicalConditionIds?.toString().toLong());
							PatientMedicalCondition patientMedicalCondition = new PatientMedicalCondition();
							patientMedicalCondition.medicalCondition = medicalCondition
							patientMedicalCondition.patient = patient
							patientMedicalCondition.isActive = Short.valueOf("1")
							patientMedicalCondition.rowCreated = new Date()
							patientMedicalCondition.save();
						}
				}
			}
					if(othercancers !=null && !othercancers.equals("") ){
							//def deleteStatuss = PatientMedicalCondition.executeUpdate("delete from PatientMedicalCondition p where p.patient="+patient?.id);
						MedicalCondition medicalCondition = new MedicalCondition()
							medicalCondition.medicalConditionType ="others_"+ othercancers
							medicalCondition.rowCreated = new Date()
							medicalCondition.isActive = Short.valueOf("1")
							def saveOtherCancer = medicalCondition.save();
							if(saveOtherCancer !=null)
							{
								PatientMedicalCondition patientMedicalCondition = new PatientMedicalCondition();
								patientMedicalCondition.medicalCondition = saveOtherCancer
								patientMedicalCondition.patient = patient
								patientMedicalCondition.isActive = Short.valueOf("1")
								patientMedicalCondition.rowCreated = new Date()
								patientMedicalCondition.save();
							}
							
							
						}
						if(othermedicals!=null && !othermedicals.equals("") ){
							MedicalCondition medicalCondition = new MedicalCondition()
							medicalCondition.medicalConditionType ="others_"+ othermedicals
							medicalCondition.rowCreated = new Date()
							medicalCondition.isActive = Short.valueOf("1")
							def saveOtherMedical = medicalCondition.save();
							if(saveOtherMedical !=null)
							{
								PatientMedicalCondition patientMedicalCondition = new PatientMedicalCondition();
								patientMedicalCondition.medicalCondition = saveOtherMedical
								patientMedicalCondition.patient = patient
								patientMedicalCondition.isActive = Short.valueOf("1")
								patientMedicalCondition.rowCreated = new Date()
								patientMedicalCondition.save();
							}
						}
				//return patientMedicalCondition
			}
			else{
				println "user null!!!!!!"
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	def savePatientAccountDetails(def healpalUser){
		return true;
	}

	/**
	 * Update the person gender who is logged in
	 * @return
	 */
	def updateGender(params, HealpalUser user){
		try{
			if(params && params.genderType && user){
				Person person = Person.get(user.person?.id)
				if(person){
					person.gender = Gender.findByGenderNameIlike(params.genderType)
					person.rowAltered = new Date()
					person.save(flush:true)
					if (!person.validate()){
						person.errors.each {println it }
					}else{
						//do nothing
					}
				}
				return person
			}
		}catch(Exception exception){
			throw exception
		}
	}

	def saveAddress(params, HealpalUser user){
		def address
		try{

			if(params && user){
				//PatientAddress patient = PatientAddress.findByPatientand(Patient.findByPerson(user?.person))
				//PatientAddress patient=PatientAddress.findByPatient(Patient.findByPerson(user?.person))
				//PatientAddress address=PatientAddress.findByAddress(Address.findByPerson(user?.person))
				Address patientAddress=new Address()
				patientAddress.city = params.city
				patientAddress.state = params.state
				patientAddress.county = params.country
				patientAddress.zipcode = params.zip
				//patientAddress.patient = Patient.findByPerson(user?.person)
				//patientAddress.patient = Address.findByPerson(user?.person)
				patientAddress.isActive = Short.valueOf("1")
				patientAddress.rowCreated = new Date()
				address = patientAddress.save(flush:true);
				if (!patientAddress.validate()){
					patientAddress.errors.each {println it }
				}else{
					//do nothing
				}
			}else{
				println "::::::::::::::::::Params are null values or user null"
			}
			println "address::::::::::"+address
		}catch(Exception exception){
			throw exception
		}
		return address
	}
	def updatePositive(params, HealpalUser user){
		try{
			if(params.type && params.value && user){
				Person person = Person.get(user.person?.id)
				if(person){
					if(params.type != null && params.type == "HER"){
						
						if(params.value=="Yes")
						{
						person.herStatusPositive = params.value
						person.herStatusNegative = "No"
						}
						else if(params.value=="No")
						{
							println "inside herStatusNegative"
							person.herStatusPositive = params.value
							person.herStatusNegative = "Yes"
						}
						
					} else if(params.type != null && params.type == "ER"){
					if(params.value=="Yes")
					{
						person.erStatusPositive = params.value
						person.erStatusNegative = "No"
					}
					else if(params.value=="No")
					{
						person.erStatusPositive = params.value
						person.erStatusNegative = "Yes"
					}
					} else if(params.type != null && params.type == "PR"){
					if(params.value=="Yes")
					{
						person.prStatusPositive = params.value
						person.prStatusNegative = "No"
					}
					else if(params.value=="No")
					{
						person.prStatusPositive = params.value
						person.prStatusNegative = "Yes"
					}
					
					}
					person.rowAltered = new Date()
					person.save(flush:true)
					if (!person.validate()){
						person.errors.each {println it }
					}else{
						//do nothing
					}
				}
			}else{
				log.info("params values or user is null")
			}
		}catch(Exception exception){
			throw exception
		}
	}


	Doctor add(params, session ,Address address){
		try{
			Doctor doctor=new Doctor();
			if(params && session){
				doctor.doctorName = params.treatingDoctor?:(params.firstName?:'')+params.lastName?:''
				doctor.firstName = params.firstName?:''
				doctor.lastName = params.lastName?:''
				doctor.phoneNumber = params.phoneNumber?:''
				doctor.specialty = params.specialty?:''
				if(address){
					doctor.address = address
				}
				doctor.isActive = (short)1
				doctor.rowCreated = new Date()
				doctor.save(flush : true)
				if(!doctor.validate()){
					doctor.errors.each {println it }
				}
			}else{
				//do nothing
			}
			return doctor
		}catch(Exception exception){
			throw exception
		}
	}
	
	/**
	 * create new address for treating doctor
	 * Details about the Doctor created 
	 * Both table fk used to create new TreatingDoctor
	 * @params zipcode,treatingDoctor,lastName,contactNumber
	 * @return created treatingDoctorDetails
	 */

	TreatingDoctor detailsAboutDoctor(params, HealpalUser user)throws Exception{
		try{
			TreatingDoctor treatingDoctorDetails=new TreatingDoctor();
			Address address=new Address();
			if(user && params!= null && params.zipcode!= null && !params.zipcode.isEmpty() && params.contactNumber!= null && !params.contactNumber.isEmpty()){
				address . zipcode = params.zipcode?:''
				address . rowCreated = new Date();
				address . isActive = (short)1;
				address . save();
				if(!address . validate()){
					address . errors . each { println it  }
				}
				else{
					Doctor doctorDetails = new Doctor();
					doctorDetails . doctorName = params.treatingDoctor?:''
					doctorDetails . firstName = params.treatingDoctor?:''
					doctorDetails . lastName = params.lastName?:''
					doctorDetails . phoneNumber = params.contactNumber?:''
					doctorDetails . specialty = params.specialty?:''
					doctorDetails . address = address;
					doctorDetails . rowCreated = new Date();
					doctorDetails.isActive=(short)1;
					doctorDetails.save(flush:true);
					if(!doctorDetails . validate()){
						doctorDetails . errors . each {  println it   }
					}
					else{
						def existTreatingDoctor=TreatingDoctor.findAllByPatient(Patient.findByPerson(user?.person));
						boolean deleteTreatedDoctor=true
						if(existTreatingDoctor!=null && existTreatingDoctor.size()>0){
							deleteTreatedDoctor=TreatingDoctor.executeUpdate("delete from TreatingDoctor p where p.patient="+Patient.findByPerson(user?.person)?.id);
						}
						if(deleteTreatedDoctor){
						treatingDoctorDetails . doctor = doctorDetails;
						treatingDoctorDetails . patient = Patient.findByPerson(user?.person);
						treatingDoctorDetails . isActive = (short)1;
						treatingDoctorDetails . rowCreated = new Date();
						treatingDoctorDetails . save();
						if(!treatingDoctorDetails . validate()){
							treatingDoctorDetails . errors . each {  println it   }
						}
						}
					}
				}
			}
			else{
				//do nothing
			}
			return treatingDoctorDetails
		}catch(Exception exception){
			throw exception
		}
	}
	PatientDiagnosis addDateOfDignosis(params,HealpalUser user)throws Exception{
		try{
			String diagnosisDate =params.diagnosis
			println"diagnosisDate::::::::::::d4::"+diagnosisDate
			Date date = new Date().parse('M/d/yyyy', diagnosisDate)
			println"date:::::::::::::::::"+date
			PatientDiagnosis updatepatientDiagnosis =null;//new PatientDiagnosis();
			if(params && user){
				def patientDiagnosisUpdate = PatientDiagnosis.createCriteria().list{
					eq("patient",Patient.findByPerson(user?.person))
				}
				if(patientDiagnosisUpdate){
					println "***************"
					updatepatientDiagnosis = PatientDiagnosis.get(patientDiagnosisUpdate?.id)
					println "&&&"+updatepatientDiagnosis
					updatepatientDiagnosis . rowCreated = new Date();
				}else{
				println "elseeeeeeeeeeeee"
					updatepatientDiagnosis=new PatientDiagnosis();
					updatepatientDiagnosis . patient= Patient.findByPerson(user?.person);
					updatepatientDiagnosis . rowAltered = new Date();
				}
				updatepatientDiagnosis . dateOfCancerDiagnosis = date;
				println "updatepatientDiagnosis . dateOfCancerDiagnosis"+updatepatientDiagnosis . dateOfCancerDiagnosis
				updatepatientDiagnosis . save(flush:true);
				println "updatepatientDiagnosis"+updatepatientDiagnosis
				if(!updatepatientDiagnosis . validate()){
					updatepatientDiagnosis . errors . each {  println it  }
				}
			}
			else{
				//do nothing
			}
			return updatepatientDiagnosis
		}catch(Exception exception){
			throw exception;
		}
	}

	/**
	 * Update the person date of birth who is logged in
	 * @return updated person
	 */
	
	Person addPersonDob(params,HealpalUser user)throws Exception{
		try{
			
			String stringDate =params.dob
			println"stringDate:::::::::::::::::"+stringDate
			Date date = new Date().parse('M/d/yyyy', stringDate)
			println"date:::::::::::::::::"+date
		
			Person updatePerson=new Person();
			if(params != null){
				
				updatePerson = Person.get(user?.person?.id);
				updatePerson . dob=date
				updatePerson . rowAltered=new Date();
				updatePerson . save(flush:true);
				if(!updatePerson . validate()){
					updatePerson . errors . each { println it  }
				}
			}
			else{
				//do nothing
			}
			return updatePerson
		}catch(Exception exception){
			throw exception;
		}
	}
	
	/**
	 * create new patient health insurance 
	 * If it exists update patient health insurance 
	 * @return patient's health insurance
	 */
	
	def savePatientInsurance(params,def currentPerson)throws Exception{
		try{
			if(params != null && !params . equals("") && currentPerson != null && !currentPerson.equals("")){
				def healthInsurance = params . healthInsurance
				PatientHealthInsurance updateHealthInsurance = null
				if(healthInsurance != null && !healthInsurance . equals("")){
					Patient patient = Patient . findByPerson(currentPerson.person)
					def existHealthInsurance = PatientHealthInsurance . findAllByPatient(patient)
					boolean deletehealthInsurance = true
					if(existHealthInsurance && existHealthInsurance != null){
						existHealthInsurance . each{
							 deletehealthInsurance=false
						 def deleteStatus=PatientHealthInsurance . get(it.id.toLong());
						if(deleteStatus != null){
							deleteStatus . delete();
							if(!deleteStatus . validate()){
								deleteStatus . errors . each {  println it  }
							}
							else{
								deletehealthInsurance = true
							}
							}
							}
					}
						if(deletehealthInsurance){
						
					
					if(healthInsurance . toString() . contains(",")){
						healthInsurance . each {
							updateHealthInsurance = new PatientHealthInsurance();
							updateHealthInsurance . rowCreated = new Date();
							HealthInsurance insurance = HealthInsurance . get(it)
							updateHealthInsurance . healthInsurance = insurance
							updateHealthInsurance . patient = patient
							updateHealthInsurance . rowCreated = new Date()
							updateHealthInsurance . isActive = (short)1
							updateHealthInsurance . save()
						}
					}else{
					updateHealthInsurance = new PatientHealthInsurance();
					updateHealthInsurance . rowCreated = new Date();
						HealthInsurance insurance = HealthInsurance . get(healthInsurance)
						updateHealthInsurance . healthInsurance = insurance
						println patient
						updateHealthInsurance . patient = patient
						updateHealthInsurance . isActive = (short)1
						updateHealthInsurance . save()
					}
						}
				
			}
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	def savePatientEducation(params,def currentPerson)throws Exception{
		try{
			if(params!=null && !params.equals("") && currentPerson!=null && !currentPerson.equals("")){
				def educationId = params.educationId
				if(educationId!=null && !educationId.equals("")){
					Patient patient = Patient.findByPerson(currentPerson.person)
					Education education = Education.get(educationId)
					def existEducation=PatientEducation.findAllByPatient(patient)
					if(existEducation && existEducation!=null && existEducation.size()>0){
						PatientEducation update=PatientEducation.findByPatient(patient);
						update.education=education;
						update.rowAltered=new Date();
						update.save(flush:true)
					}
					else{
					PatientEducation insert = new PatientEducation()
					insert . education = education
					insert . patient = patient
					insert . rowCreated = new Date()
					insert . isActive = (short)1
					insert . save()
					println insert.save()
					}
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			throw exception;
		}
	}
	def saveQuestionAnswer(params, HealpalUser user){
		try{
			if(params && params.question && params.answer){

				TempQuestionOption questionAnswer 	= 	TempQuestionOption.findByQuestionNameIlike(params.question)
				if(questionAnswer){
					//do nothing
				}else{
					questionAnswer 					= 	new TempQuestionOption();
				}

				questionAnswer.questionName 		= 	params.question
				questionAnswer.value 				= 	params.answer
				questionAnswer.patient 				= 	Patient.findByPerson(user?.person)

				questionAnswer.save(flush:true)
				if(!questionAnswer.validate()){
					questionAnswer.errors.each {println it }
				}else{
					//do nothing
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
		}
	}

	
	/**
	 * Get list of all profile questions/answers who logged in
	 * Edit and Update all profile Answers 
	 * @return
	 */
		
ArrayList editProfile(HealpalUser user)throws Exception{
	try{
		if(user){
			Map<String, List<String>> aboutYouList=new HashMap();
			Map<String, List<String>> aboutYourConditionList=new HashMap();
			ArrayList editProfileList=new ArrayList();
			def photoPath=null
			def personName=null
			def aboutYou=TempQuestionOption.createCriteria().list{
				eq("patient",Patient.findByPerson(user?.person))
				or{
				like("questionName","Gender identity")
				like("questionName","Select your Race")
				like("questionName","I am interested in")
				projections {
				distinct('questionName')
				}
				}
				}
			for(int i=0; i<aboutYou.size();i++)
				{
				def ques=TempQuestionOption.createCriteria().list{
					eq("patient",Patient.findByPerson(user?.person))
					like("questionName",aboutYou[i])
				}
				List<String> list1=new LinkedList();
				if(ques){
					int countt=0;
				ques.each {
					if(countt>0){
						list1.add(" , "+it?.value.toString());
					}
					else{
					list1.add(it?.value.toString());
					countt++;
					}
					}
				aboutYouList.put(aboutYou[i].toString(), list1);
				}
				}
				def healthInsurance=PatientHealthInsurance.createCriteria().list{
					eq("patient",Patient.findByPerson(user?.person))
				}
				if(healthInsurance && healthInsurance!=null){
					List<String> healthInsuranceList=new LinkedList();
						int countt=0;
						healthInsurance.each{
						if(countt>0){
							healthInsuranceList.add(", "+it?.healthInsurance?.healthInsuranceType);
						}
						else{
							healthInsuranceList.add(it?.healthInsurance?.healthInsuranceType);
						}
						countt++;
					}
					
				aboutYouList.put("Type of health insurance",healthInsuranceList)
				}
				def personDetails=Person.createCriteria().list{
					eq("id",user?.person?.id.toLong())
				}
				personDetails.each{
					if(it?.dob && it?.dob!=null){
						aboutYouList.put("Select your Date of Birth",it?.dob)
					}
				}
				
				def patientAddress=PatientAddress.createCriteria().list{
					eq("patient",Patient.findByPerson(user?.person))
				}
				
				List<String> addressList=new LinkedList();
				patientAddress.each{
					addressList.add(it?.address?.city);
					addressList.add(", "+it?.address?.state);
					addressList.add(", "+it?.address?.county);
					addressList.add(", "+it?.address?.zipcode);
				}
				List<String> aboutYourselfList=new LinkedList();
				List<String> ethList=new LinkedList();
				List<String> genderList=new LinkedList();
				if(personDetails && personDetails!=null){
				personDetails.each{
				if(it?.describeAboutYourself!=null && it?.passionateAbout){
				aboutYourselfList.add(it?.describeAboutYourself+" , ");
				aboutYourselfList.add(it?.passionateAbout);
				aboutYouList.put("About you and your Passion",aboutYourselfList)
				}
				if(it?.cancerStatus?.cancerStatusType && it?.cancerStatus?.cancerStatusType!=null){
					aboutYourConditionList.put("Describe the current status of your cancer",it?.cancerStatus?.cancerStatusType)
				}
				if(it?.ethnicity?.ethnicityName && it?.ethnicity?.ethnicityName!=null){
					ethList.add(it?.ethnicity?.ethnicityName);
					aboutYouList.put("Select your Ethnicity",ethList)
				}
				if(it?.gender?.genderName && it?.gender?.genderName!=null){
					genderList.add(it?.gender.genderName)
					aboutYouList.put("Gender",genderList)
					}
				if(it?.herStatusPositive && it?.herStatusPositive!=null){
					aboutYourConditionList.put("HER 2 positive",it?.herStatusPositive)
				}
				if(it?.prStatusPositive && it?.prStatusPositive!=null){
					aboutYourConditionList.put("PR positive",it?.prStatusPositive)
					}
				if(it?.erStatusPositive && it?.erStatusPositive!=null){
					aboutYourConditionList.put("ER positive",it?.erStatusPositive)
					}
				}
				}
				if(patientAddress && patientAddress!=null){
					aboutYouList.put("Where do you live ?",addressList)
				}
		// For ..........   About Your Condition.................
				def aboutYourCondition=TempQuestionOption.createCriteria().list{
					eq("patient",Patient.findByPerson(user?.person))
						ne("questionName","Gender identity")
						ne("questionName","Select your Race")
						ne("questionName","I am interested in")
					projections {
					distinct('questionName')
					}
					
					}
				for(int i=0; i<aboutYourCondition.size();i++)
					{
					def ques=TempQuestionOption.createCriteria().list{
						eq("patient",Patient.findByPerson(user?.person))
						like("questionName",aboutYourCondition[i])
					}
					List<String> list1=new LinkedList();
					if(ques){
					int countt=0;
					ques.each {
						if(countt>0){
						list1.add(", "+it?.value.toString());
						}
						else{
							list1.add(it?.value.toString());
						}
						countt++;
							}
					aboutYourConditionList.put(aboutYourCondition[i].toString(), list1);
					}
					}
				
				def diagnosisList=PatientDiagnosis.createCriteria().list(){
						eq('patient',Patient.findByPerson(user?.person))
					}
				if(diagnosisList){
					aboutYourConditionList.put("State your diagnosis",diagnosisList?.diagnosis?.diagnosisName)
					aboutYourConditionList.put("Date of cancer diagnosis",diagnosisList?.dateOfCancerDiagnosis)
					aboutYourConditionList.put("Your age at Diagnosis",diagnosisList?.ageOfDiagnosis)
				}
				def medicalConditions=PatientMedicalCondition.createCriteria().list(){
						eq('patient',Patient.findByPerson(user?.person))
					}
				
				if(medicalConditions && medicalConditions!=null){
					int countt=0;
					List<String> medicalConditionList=new LinkedList();
					medicalConditions.each{
					if(countt>0){
						medicalConditionList.add(", "+it?.medicalCondition?.medicalConditionType);
					}
					else{
						medicalConditionList.add(it?.medicalCondition?.medicalConditionType);
					}
					countt++;
				}
				aboutYourConditionList.put("Please choose any associated medical conditions",medicalConditionList)
				}

				def treatinDoctorDetails=TreatingDoctor.createCriteria().list(){
						eq('patient',Patient.findByPerson(user?.person))
					}
				if(treatinDoctorDetails && treatinDoctorDetails!=null && treatinDoctorDetails.size()>0){
					List<String> treatinDoctor=new LinkedList();
					treatinDoctorDetails.each{
						treatinDoctor.add(it?.doctor?.doctorName);
						treatinDoctor.add(", "+it?.doctor?.phoneNumber);
						treatinDoctor.add(", "+it?.doctor?.address?.zipcode);
					}
					aboutYourConditionList.put("Details of your treating doctor",treatinDoctor);
					
				}
				def educationList=PatientEducation.createCriteria().list(){
					eq('patient',Patient.findByPerson(user?.person))
				}
				if(educationList && educationList!=null && educationList.size()>0){
					List<String> education=new LinkedList();
					educationList.each{
						education.add(it?.education?.educationType);
					}
					aboutYouList.put("Highest level of education",education);
					
				}
// *********** End Of About Your Condition *********** //
				
	def profilePhoto=ProfilePhoto.findByPatient(Patient.findByPerson(user?.person))
	def patientName=Person.get(user?.person?.id)
	
	editProfileList.add(aboutYouList);
	editProfileList.add(aboutYourConditionList);
	if(patientName && patientName?.fullName){
		personName=patientName?.fullName;
		editProfileList.add(personName);
	}
	if(profilePhoto && profilePhoto?.profilePhotoPath){
		photoPath="../assets/patient-photo/"+profilePhoto?.profilePhotoPath
		editProfileList.add(photoPath);
	}
	return editProfileList;
		}
		
		}
	catch(Exception exception){
		throw exception
		}
	
	
	}

def newUserMail(user,request){
	def newAccountMail=user?.person?.emailAddress
	def name=user?.person?.fullName
	def userId = user?.id
	def encryptedId = "KV/9E"+userId+"M8H5AI"
	DateConvention convert = new DateConvention()
    def date = CryptographyUtil.encrypt(convert.convertUtilDateToString(new Date()))
	def content=null;
	def webUrl = this.getWebAppUrl(request)
	if(webUrl != null){ 
	try{ 
		//def image='<img src="cid:Logo" />'
		//String dateStr = '&nbsp;<b>'+new Date().toString()+'</b>'
		def resetURL = '<a href="'+webUrl.toString()+'/accountActive/active?id='+ encryptedId +'&date='+date+' class="table-sign-btn" style="background:#f15922; text-align:center; color:#fff; text-decoration:none; font-size:16px; border:1px solid #f15922; border-radius:3px; width:135px; margin:14px 0px; height:35px; line-height:35px; display:inline-block; font-weight:bold;">Sign In </a>'
		 
		println "resetURL"+resetURL
		
		//content = 'Hi <b>'+name+'</b><br></br><br>'+image+'<br/>Welcome!<br>Your Healpal account has been created.Please Sign in to match and connect with<br></br>members in the Healpal community.<br></br><br></br>'+resetURL+'<br></br><br><br><b>Thanks,</b><br></br><b>The Healpal Team</b>'
	 
		 //content= '<head></head><body><table width="100%" bgcolor="#fff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header"><tbody><tr><td<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth"><tbody><tr><td width="100%"><table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth" bgcolor="#f0eeee" id="mobile-device"><tbody><tr><td><table bgcolor="#f0eeee" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth"><tbody><tr><td width="100%" height="30px" align="center" style="padding:20px 0px 0px; font-size:11px; color:#a0a0a0; text-decoration:underline;">View this email in your browser ><div class="text-center"><a target="_blank" href="#"><img src="cid:Logo" alt="" border="0" style="display:block; border:none; outline:none; text-decoration:none; text-align:center; margin:14px 0px;"></a></div></td></tr><tr><td width="100%"><table id="mobile-device" bgcolor="#fff" width="600" align="center"  bordercolor="#d7d7d7" cellpadding="0" cellspacing="0" class="devicewidth"><tbody><tr><td height="100%" width="600"  align="left" style="border:1px solid #d7d7d7; font-size:14px; line-height:20px; color:#484848; padding:20px; font-weight:normal;  font-family:Arial;">Hi '+name+',<br/><br/>Welcome! <br/> Your HealPal account has been created. Please sign in to match and connect with members in the HealPal community. <br/>'+resetURL+'<br/>Thanks,<BR/>The Healpal Team</td></tr></tbody></table></td></tr><tr><td width="100%">	<table bgcolor="#f0eeee" width="600" align="center"  cellpadding="0" cellspacing="0" class="devicewidth"><tbody><tr><td align="center">	<div class="text-center"><a href="#"><img src="cid:fb" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#"><img src="cid:linkedin" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#"><img src="cid:pinterest" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#"><img src="cid:twitter" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><p style="font-size:12px; color:#8f8f8f; line-height:20px; margin-top:0px;">This email was sent to <a href="#" style="color:#8f8f8f; text-decoration:none;">rekhasharma0809@gmail.com.</a><br/> We value your privacy and will never share your email without your permission.</p><p style="font-size:12px; color:#5a5a5a">©2016 HealPal Inc. All rights reserved.</p></div><br/></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></body>'
		 
				content='<head></head><body><table width="100%" bgcolor="#fff" cellpadding="0" cellspacing="0" border="0" id="backgroundTable" st-sortable="header">'+
						'<tbody><tr><td<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth"><tbody><tr><td width="100%">'+
						'<table width="860" cellpadding="0" cellspacing="0" border="0" align="center" class="devicewidth" bgcolor="#f0eeee" id="mobile-device">'+
						'<tbody><tr><td><table bgcolor="#f0eeee" width="100%" align="center" border="0" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td width="100%" height="30px" align="center" style="padding:20px 0px 0px; font-size:11px; color:#a0a0a0; text-decoration:underline;">'+
						'<div class="text-center"><a target="_blank" href="#"><img src="cid:Logo" alt="" border="0" style="display:block;'+
						' border:none; outline:none; text-decoration:none; text-align:center; margin:14px 0px;"></a></div></td></tr><tr><td width="100%">'+
						'<table id="mobile-device" bgcolor="#fff" width="600" align="center"  bordercolor="#d7d7d7" cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td height="100%" width="600"  align="left" style="border:1px solid #d7d7d7; font-size:14px; line-height:20px; color:#484848; padding:20px; font-weight:normal;  font-family:Arial;">'+
						'Hi '+name+',<br/><br/>Welcome! <br/> Your HealPal account has been created. Please sign in to match and connect with members in the HealPal community. '+
						'<br/>'+resetURL+'<br/>Thanks,<BR/>The HealPal Team</td></tr></tbody></table></td></tr><tr><td width="100%">'+
						'<table bgcolor="#f0eeee" width="600" align="center"  cellpadding="0" cellspacing="0" class="devicewidth">'+
						'<tbody><tr><td align="center">	<div class="text-center"><a href="#"><img src="cid:fb" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:linkedin" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;">'+
						'</a><a href="#"><img src="cid:pinterest" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><a href="#">'+
						'<img src="cid:twitter" align="center" alt="image" border="0" style="display:inline-block; border:none; outline:none; text-decoration:none; text-align:center; margin:10px 5px 5px;"></a><p style="font-size:12px; color:#8f8f8f; line-height:20px; margin-top:0px;">'+
						'This email was sent to <a href="#" style="color:#8f8f8f; text-decoration:none;">'+newAccountMail+'.</a><br/> '+
						'We value your privacy and will never share your email without your permission.</p><p style="font-size:12px; color:#5a5a5a">©2016 HealPal Inc. All rights reserved.</p></div><br/></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></body>'

		
		
	sendMail {
		multipart true
		to newAccountMail
		subject "Welcome to HealPal"
		html content
		inline 'Logo', 'image/png', resourceLoader.getResource("/assets/new-design/img/logo.png").getFile()
		inline 'fb', 'image/png', resourceLoader.getResource("/assets/new-design/img/fb-icon.png").getFile()
		inline 'linkedin', 'image/png', resourceLoader.getResource("/assets/new-design/img/linkedin-icon.png").getFile()
		inline 'pinterest', 'image/png', resourceLoader.getResource("/assets/new-design/img/pinterest-icon.png").getFile()
		inline 'twitter', 'image/png', resourceLoader.getResource("/assets/new-design/img/twitter-icon.png").getFile()
	}
	}catch(Exception exception){
		throw exception
		}
	}else{
	// do nothing
	}
}

/**
 * Invitation for friends through email 
 * @params sendToMail
 * send to single/multiple mails
 * @return
 */

def inviteMail(String sendToMail){
	try{
		if(sendToMail && sendToMail!=null && !sendToMail.isEmpty()){
			
		def toMail=sendToMail.toString();
	sendMail {
		to toMail
		subject "Hello user"
		body 'Please visit healpal.me'
	}
	}
	}catch(Exception exception){
	throw exception
	}
	
}


def getWebAppUrl(request)throws Exception{
	def contexturl = null
	try{
		def path = request.getHeader("Referer")
		def webUrl =path.toString().substring(0,path.toString().indexOf("/",path.toString().indexOf("//")+2))
		contexturl = webUrl + request.getContextPath()
	}catch(Exception exception){
		throw exception
	}
	return contexturl
}

/*String resource() {

	// Generate: /link-generator/css/main.css
	
	grailsLinkGenerator.resource(dir: 'css', file: 'main.css')
	
	}*/
	
	
	
}
