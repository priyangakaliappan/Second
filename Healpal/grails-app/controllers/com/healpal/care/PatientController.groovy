package com.healpal.care

class PatientController {
	
	def PatientService patientService
	def UserRoleService userRoleService
	def UserService userService

    def index() {
	}
	
	def save(){
		//Patient patient = patientService . save(params);
		Person insert = new Person()
		insert.setFirstName(params.firstName)
		insert.setLastName(params.lastName)
		insert.setFullName(params.fullName)
		insert.setPhoneNumber(params.phoneNumber)
		insert.setCompanyName(params.companyName)
		insert.setDescribeAboutYourself(params.describe)
		insert.setDob(new Date())
		insert.setEmailAddress(params.email)
		insert.setGender(Gender.get(params.gender))
		insert.setLanguage(Language.get(params.language))
		insert.setTimezone(Timezone.get(params.timezone))
		insert.setIsActive((short)1)
		insert.setRowCreated(new Date())
		insert.setEthnicity(Ethnicity.get(params.ethnicity.toLong()))
		insert.setRace(Race.get(params.race.toLong()))
		insert.save()
		if(insert.save()){
			Patient patient = new Patient()
			patient.setIsActive((short)1)
			patient.setRowCreated(new Date())
			patient.setPerson(insert)
			patient.save()
			if(patient.save()){
			flash.msg = "Patient Detail Inserted Successfully"
			redirect(action:'view')
			}else{
			redirect(action:'create')
			}
		}
	}
	def edit(){
		def editpatient = Patient.get(params.patientId.toLong())
		[editpatient:editpatient]
	}
	def update(){
		Person insert = Person.get(params.personId.toLong())
		insert.setFirstName(params.firstName)
		insert.setLastName(params.lastName)
		insert.setFullName(params.fullName)
		insert.setPhoneNumber(params.phoneNumber)
		insert.setCompanyName(params.companyName)
		insert.setDescribeAboutYourself(params.describe)
		insert.setDob(new Date())
		insert.setEmailAddress(params.email)
		insert.setGender(Gender.get(params.gender))
		insert.setLanguage(Language.get(params.language))
		insert.setTimezone(Timezone.get(params.timezone))
		insert.setIsActive((short)1)
		insert.setRowCreated(new Date())
		insert.setEthnicity(Ethnicity.get(params.ethnicity.toLong()))
		insert.setRace(Race.get(params.race.toLong()))
		insert.save(flush:true);
		if(insert.save(flush:true)){
			flash.msg = "Patient Detail Updated Successfully"
		}
		redirect(action:'view')
	}
	def add(){
		def language = Language.createCriteria().list {}
		def gender = Gender.createCriteria().list{}
		def timezone = Timezone.createCriteria().list{}
		def ethnicity = Ethnicity.createCriteria().list {	}
		def race = Race.createCriteria().list {}
		[language:language,timezone:timezone,gender:gender,ethnicity:ethnicity,race:race]
		
	}
	def view(){
		def gender = Gender.createCriteria().list{}
		def language = Language.createCriteria().list {
		}
		def patientList = Patient.createCriteria().list {
			eq('isActive',(short)1)
		}
		def ethnicity = Ethnicity.createCriteria().list {	}
		def race = Race.createCriteria().list {}
		println gender
		[patientList:patientList,gender:gender,language:language,ethnicity:ethnicity, race:race]
	}
	def delete(){
		if(params.patientId)
		{
		def delete = Patient.executeUpdate("update Patient set isActive=0 where id="+params.patientId.toLong())
		def deletePerosn = Person.executeUpdate("update Person set isActive=0 where id="+params.personId.toLong())
		
		if(delete){
			flash.msg="Patient Deleted Successfully"
			}else{flash.msg="Patient Deleted Failed"}
		}
		redirect(action:'view')
	}

	def cancel(){
		redirect(action:'view')
		}
	
	}
