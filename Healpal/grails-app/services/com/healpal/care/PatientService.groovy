package com.healpal.care

import grails.transaction.Transactional

@Transactional
class PatientService {
	def UserService userService
    def serviceMethod() {

    }
	
	Patient editProfile(params){
		Patient patient = new Patient()
		
		
		
	}
	
	Patient save(params){
		Patient patient = new Patient()
		Person person = new Person()
		//patient.withTransaction {status->
			try{
				person . firstName = params.firstName
				person . lastName = params.lastName
				person . fullName = params.fullName
				person . phoneNumber = params.phoneNumber
				person . companyName = params.companyName
				person . describeAboutYourself = params.describe
				person . dob = new Date()
				person . emailAddress = params.email
				person . gender = Gender.get(params.gender)
				person . language = Language.get(params.language)
				person . timezone = Timezone.get(params.timezone)
				person . isActive = (short)1
				person . rowCreated = new Date()
				person . ethnicity = Ethnicity.get(params.ethnicity.toLong())
				person . race = Race.get(params.race.toLong())
				person . save(flush:true)
				println person . save(flush:true)
				if(!person.validate()){
										}else{
											patient = new Patient()
											patient = userService.savePatient(patient ,person ,params)
											if(!patient.validate()){
												return patient
												//status.setRollbackOnly()
											}else{
													HealpalUser user = new HealpalUser()
													user = userService.save(user, params, person ,"create")
													if(!user.validate()){
														//status.setRollbackOnly()
														//return user
													}else{
														UserRole urole = new UserRole()
														urole = userRoleService.save(user, "Role.patient" ,urole)
														if(!urole.validate()){
															//status.setRollbackOnly()
															patient = null
														}
													}
											}
											
										
										}
				
				
			}catch(Exception e){
		}
		return patient	
	}
}
