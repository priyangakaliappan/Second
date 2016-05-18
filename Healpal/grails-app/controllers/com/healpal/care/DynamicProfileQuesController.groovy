/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 11/03/2015
 * Description : List  ,Create ,Edit ,Delete of Profile Questions
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0     11/10/2015        Initial Creation changes
 *
 */

package com.healpal.care

class DynamicProfileQuesController {

	def ProfileQuestionService profileQuestionService
	def AuditEventService auditEventService
	
    def index() { }
	
	
	def view(){
		try{
			authorizeMe() //***** Check Authorization
			session.tempOptionsList = null
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			[questions : profileQuestionService.getList(params) ,total:ProfileQuestions.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	
	def create(){
		try{
			authorizeMe() //***** Check Authorization
		
			switch(request.method){
				case 'GET':
					[action:'create' ,quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
				break
				case 'POST':
				if(params != null && params.questionCategory != null && !params.questionCategory.isEmpty()
					&& params.questionLabel != null && !params.questionLabel.toString().isEmpty()
					&& params.questionOptionsFormat != null && !params.questionOptionsFormat.toString().isEmpty()
					&& params.questionText != null && !params.questionText.isEmpty()
					&& params.skip != null && !params.skip.isEmpty()
					&& params.gender != null && !params.gender.isEmpty()){
					
					println "DynamicProfileQuesController . create = question creation initiated"					//Debug code
					// question details save
					ProfileQuestions ques = profileQuestionService . save(params ,new ProfileQuestions() ,new QuestionLabel() ,new QuestionText() ,"create")
					
					if(ques != null && ques.validate()){
						// once question saved options format will save in QuestionOptionsFormat table
						if(!QuestionOptionsFormat.get(params.questionOptionsFormat)?.questionOptionsFormat?.equalsIgnoreCase(QuestionOptionsFormat.textField)){
							// question options save
							if(profileQuestionService . questionOptinSave(params, ques, session)){  								// Adding question and options
								auditEventService . save(AuditEventType.addedProfileQuestion, Role.admin, session) 					// audit save
					flash.msg ="Profile Question  '"+ques?.questionText?.questionText+"'"+" name saved successfully"
								println ""+ques?.id+":Question has been created sucessfully"										//Debug code	
								redirect action:'view'
							}}else{
						auditEventService . save(AuditEventType.addedProfileQuestion, Role.admin, session) 					// audit save
						flash.msg ="Profile Question  '"+ques?.questionText?.questionText+"'"+" name saved successfully"
						println ""+ques?.id+":Question has been created sucessfully"										//Debug code
						redirect action:'view'
						} 					
					}else if(ques == null){
						flash.msg = "Profile Questions creation failed due to some errors"
						[quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
					}else{
						flash.msg = ""
						[action:'create' ,profileQuestion:ques ,quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
					}
					
				}else{
					//do nothing
				}
				break
			}

			
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def edit(){
		try{
			authorizeMe() //***** Check Authorization

				switch(request.method){
					
					case 'GET' :
							println "DynamicProfileQuesController . edit = question edit initiated"
							ProfileQuestions ques = null
							if(params.quesId != null && params.quesId != null){
								ques = ProfileQuestions . get(params.quesId)
								profileQuestionService . getOptionsforQuestion(params ,session)
							}else{
								//do nothing
							}
					[action:'edit' ,list:profileQuestionService.getOptionsList(session) ,profileQuestion:ques ,quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
					break;
					case 'POST' :
					if(params != null && params.questionCategory != null && !params.questionCategory.isEmpty()
						&& params.questionLabel != null && !params.questionLabel.toString().isEmpty()
						&& params.questionOptionsFormat != null && !params.questionOptionsFormat.toString().isEmpty()
						&& params.questionText != null && !params.questionText.isEmpty()
						&& params.skip != null && !params.skip.isEmpty()
						&& params.gender != null && !params.gender.isEmpty()
						&& params.quesHiddenid != null && !params.quesHiddenid.isEmpty()){
						// update question
						ProfileQuestions ques = profileQuestionService . save(params ,ProfileQuestions.get(params.quesHiddenid?.toLong()) ,ProfileQuestions.get(params.quesHiddenid?.toLong())?.questionLabel ,ProfileQuestions.get(params.quesHiddenid?.toLong())?.questionText ,"edit")
						if(ques != null && ques.validate()){
							def msg
							// questions options delete
							int deletedCount = profileQuestionService . optionsOfquesionDelete(params)
							ProfileQuestionsOptions quesOptions = profileQuestionService . questionOptinSave(params, ques, session)				// Adding question and options
							
								if(quesOptions != null && deletedCount != 0 && deletedCount > 0 && session.tempOptionsList?.size() > deletedCount){
									println "Few options added & and details changed to Question:" + params.quesHiddenid
								}else if(quesOptions != null && deletedCount != 0 && deletedCount > 0 && session.tempOptionsList?.size() < deletedCount){
									println "Few opions are removed from & details changed to Question:" + params.quesHiddenid
								}else if(quesOptions != null && deletedCount == 0 && session.tempOptionsList?.size() > 0){
									println "New options added & details changed to question :" + params.quesHiddenid
								}else if(deletedCount != 0 && deletedCount > 0 && session.tempOptionsList?.size() ==0){
									println "All options removed from & details changed question :" + params.quesHiddenid
								}else if(deletedCount != 0 && deletedCount > 0 && session.tempOptionsList?.size() == deletedCount){
									println "Question details has been changed successfully :" + params.quesHiddenid
								}
							auditEventService . save(AuditEventType.updatedProfileQuestion, Role.admin, session) 						// audit save
							//flash.msg = "Question details has been changed successfully"
							
							flash.msg ="Profile Question  '"+ques?.questionText?.questionText+"'"+" has been updated successfully"
							println ""+ques?.id+":Question details has been changed successfully"										//Debug code
							redirect action:'view'
							
						}else if(ques == null){
							flash.msg = "Profile Questions creation failed due to some errors"
							[quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
						}else{
							flash.msg = ""
							[action:'edit' ,profileQuestion:ques ,quesCategorys:profileQuestionService.getQuestionCategory() ,diagnosisList : profileQuestionService.getDiagnosis() ,optionsFormat :profileQuestionService.getOptionsFormat()]
						}
					}
					break;
				}
			
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def doDelete(){
		try{
			authorizeMe() 	//***** Check Authorization
				if(params.quesId != null && !params.quesId.toString().isEmpty()){
						int updateCount = profileQuestionService . makeInactive(params)
						if(updateCount > 0){
							auditEventService . save(AuditEventType.deletedProfileQuestion, Role.admin, session) 			// audit save
							println ""+params.quesId+":Question has been made inactive"	
							flash.msg ="Profile Question '"+params.quesId+"'"+" has been made Inactive"									//Debug code
							
						}
					}else{
					//do nothing
				}
			redirect action:'view'
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def optionEdit(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			switch(request.method){
					
				case 'GET' :
							println "DynamicProfileQuesController . optionEdit = option edit initiated"					//Debug code
							render(template:'optionForm',model:[optionAction:'optionEdit' ,questionOption : params.opId?QuestionOptions.get(params.opId?.toLong()):null])
				break;
				
				case 'POST' : 
				if(params != null && params.questionOptions != null && !params.questionOptions.isEmpty()
					&& params.hiddenOptionId != null && !params.hiddenOptionId.isEmpty()){ print "1"
					// exist option update
					QuestionOptions option = profileQuestionService . optionSave(params, QuestionOptions.get(params.hiddenOptionId), "edit")
					
					if(option != null && option.validate()){
						println "DynamicProfileQuesController . optionEdit = "+option?.id+": option updated sucessfully"				//Debug code
						auditEventService . save(AuditEventType.updatedQuestionOption, Role.admin, session)
						profileQuestionService .addOptionsToSession(option, session)
						render(template:'optionList' ,model :[list:profileQuestionService.getOptionsList(session) ,msg:option?.questionOptions+' details has been changed'])
					}else if(option == null){
							render "Options for Questions creation failed due to errors"
					}else{
							render(template:'optionList' ,model:[option : option])
					}
				}
				break;
			}
			}
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	
	def optionCreate(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
				switch(request.method){
						
					case 'GET' :
								render(template:'optionForm',model:[optionAction:'optionCreate'])
					break;
					
					case 'POST' :
					if(params != null && params.questionOptions != null && !params.questionOptions.isEmpty()){ 
						// new option save
						
						QuestionOptions option = profileQuestionService . optionSave(params, new QuestionOptions(), "create")
						if(option != null && option.validate()){
							profileQuestionService .addOptionsToSession(option, session)
							auditEventService . save(AuditEventType.addedQuestionOption, Role.admin, session)
							
							render(template:'optionList' ,model :[list:profileQuestionService.getOptionsList(session) ,msg:option?.questionOptions+' has been created successfully'])
						}else if(option == null){
								render "Options for Questions creation failed due to errors"
						}else{
								render(template:'optionList' ,model:[option : option])
						}
					}
					break;
				}
			}
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	
	def optionDelete(){
		try{ 
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){ 
					if(params.opId != null && !params.opId.toString().isEmpty() && profileQuestionService . removeOptionFromSession(params, session)){
						
						render(template:'optionList' ,model :[list:profileQuestionService.getOptionsList(session) ,msg:QuestionOptions.get(params.opId?.toLong())?.questionOptions+' has been removed'])
					}else{
						render(template:'optionList' ,model :[list:profileQuestionService.getOptionsList(session) ,msg:'Unable to remove option'])
					}
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def ajaxPaginate(){
		try{
			if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
					render (template :'list' ,model:[questions : profileQuestionService.getList(params) ,total:profileQuestionService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
			}else{
					//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def isExist(){
		try{ 
			if(params.quesText != null && !params.quesText.toString().isEmpty()){
				
					render profileQuestionService.isExist(params)
			}
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	
	
	//******************************************
	 def authorizeMe(){
		 if(session.user && session.authority?.equalsIgnoreCase(Role.admin)){
			 
		 }else{ 
			 redirect controller :'auth' ,action :'doLogout'
		 }
	 }
	 def searchValues(){
		 try{
			 params.max = Math.min(params.max ? params.int('max') :10, 100)
			 render(template:"list",model:[questions : profileQuestionService.getList(params) ,total:profileQuestionService.getCount(params)  ,offset:0 ,max : params.max, searchValue: params.searchValue])
		 }catch(Exception exception){ exception.printStackTrace() }
	 }
}
