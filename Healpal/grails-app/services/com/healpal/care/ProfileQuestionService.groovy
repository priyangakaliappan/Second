/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 11/03/2015
 * Description : Service for the Profile Question controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0     11/10/2015        Initial Creation
 *
 */

package com.healpal.care

import java.util.Date;

import grails.transaction.Transactional

@Transactional
class ProfileQuestionService {

    def serviceMethod() {

    }
	
	def save(params ,ProfileQuestions ques ,QuestionLabel label ,QuestionText text ,String action){
		ques . withTransaction { status ->
				try{
					ques . skip = params.skip?(params.skip?.toString()?.toInteger()==1)?1:0:0
					ques . isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
					ques . patientMatchPoints = params.patientMatchPoints?params.patientMatchPoints?.toString()?.toInteger():(short)0
					ques . gender = Gender.findByGenderCodeIlike(params.gender)
					ques . questionCategory = QuestionCategory.get(params.questionCategory?.toLong())
					ques . questionLabel = saveQuesLabel(label, params, action)
					ques . questionOptionsFormat = QuestionOptionsFormat.get(params.questionOptionsFormat)
					if(params.diagnosis != null && !params.diagnosis.isEmpty()){
					ques . diagnosis = Diagnosis . get(params.diagnosis?.toLong())}
					ques . questionText = saveQuesText(text, params, action)
					if(action.equalsIgnoreCase("create")){
						ques . rowCreated = new Date() }else{
						ques . rowAltered = new Date()
					}
					ques . save(flush : true)
					if(!ques . validate()){
						ques . errors .each {
							println it
						}
					}
					
					return ques
				}catch(Exception exception){
					exception.printStackTrace()
					status.setRollbackOnly()
				}
		}
	}
	
	
	def saveQuesLabel(QuestionLabel label ,params ,String action){
		try{ 
			if(QuestionLabel.findByQuestionLabelIlike(params.questionLabel)){ 
				label = QuestionLabel.findByQuestionLabelIlike(params.questionLabel)
			}else{ 
				label . questionLabel = params.questionLabel?.trim()
				label . isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
				if(action.equalsIgnoreCase("create")){
					label . rowCreated = new Date() }else{
					label . rowAltered = new Date()
				}
				label . save(flush : true)
				if(!label .validate()){
					label . errors .each {
						println it
					}
				}
			}
			return label
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def saveQuesText(QuestionText text ,params ,String action){
		try{
			if(QuestionText.findByQuestionTextIlike(params.questionText)){ 
				text = QuestionText.findByQuestionTextIlike(params.questionText)
			}else{ 
				text . questionText = params.questionText?.trim()
				text . isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
				if(action.equalsIgnoreCase("create")){
					text . rowCreated = new Date() }else{
					text . rowAltered = new Date()
				}
				text . save(flush : true)
				if(!text .validate()){
					text . errors .each {
						println it
					}
			}
			}
			return text
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def optionSave(params ,QuestionOptions option ,String action){
		try{
			if(QuestionOptions.findByQuestionOptionsIlike(params.questionOptions)){
				option = QuestionOptions.findByQuestionOptionsIlike(params.questionOptions)
			}else{ 
				option . questionOptions = params.questionOptions
				option .isActive = params.isActive?(params.isActive?.toString()?.toInteger()==1)?1:0:1
				if(action.equalsIgnoreCase("create")){
					option . rowCreated = new Date() }else{
					option . rowAltered = new Date()
				}
				option . save(flush : true)
			}
			return option
		}catch(Exception exception){
			throw exception
		}
	}
	
	def addOptionsToSession(QuestionOptions option,session){
		try{ 
			if(option != null && session != null){
				if(session.tempOptionsList == null){
					ArrayList<Long> optionIds = new ArrayList<Long>()
					optionIds.add(option?.id)
					if(optionIds != null){
						session.tempOptionsList = optionIds
					}
				}else{
					ArrayList<Long> optionIds = session.tempOptionsList
					optionIds.add(option?.id)
					if(optionIds != null){
						session.tempOptionsList = optionIds
					}
				}
			}else{
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	boolean removeOptionFromSession(params,session){
		try{
			boolean isRemoved = false
			if(session != null && session.tempOptionsList != null){
				ArrayList<Long> optionIds = session.tempOptionsList
				optionIds . remove(params.opId.toLong())
				session.tempOptionsList = ""
				session.tempOptionsList = optionIds
				isRemoved = true
			}else{
				//do nothing
			}
			return isRemoved
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getOptionsList(session){
		try{
			def list = null
			if(session != null && session.tempOptionsList != null && !session.tempOptionsList.isEmpty()){
				ArrayList<Long> optionIds = session.tempOptionsList
				if(optionIds != null){
					list = QuestionOptions.createCriteria().list(){
						'in'('id',optionIds)
						 eq('isActive',(short)1)
						 order("id", "desc")
					}
				}
			}else{
				//do nothing
			}
			return list
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def questionOptinSave(params , ProfileQuestions ques,session){
		try{ 
			ProfileQuestionsOptions poption = null
			if(session  != null && session.tempOptionsList != null && !session.tempOptionsList.isEmpty()){ 
				ArrayList<Long> optionIds = session.tempOptionsList
				if(optionIds != null){
					QuestionOptions.getAll(optionIds).each{
						if(!ProfileQuestionsOptions.findByProfileQuestionsAndQuestionOptions(ques , it)){ 
							poption = new ProfileQuestionsOptions()
							poption . profileQuestions = ques
							poption . questionOptions =it
							poption . isActive = (short)1
							poption . rowCreated = new Date()
							poption . save(flush : true)
							if(!poption .validate()){
								poption.errors.each{
									println it
								}
							}
						}else{
						//	println "** QuestionOptions with ProfileQuestions already present"
						}
					}
				}
			}else{
				//do nothing
			}
			return poption
		}catch(Exception exception){
			 throw exception
		}
	}
	
	
	def getOptionsforQuestion(params ,session){
		try{
			def list = null
			if(session  != null){
				
				if(ProfileQuestionsOptions.findAllByProfileQuestions(ProfileQuestions.get(params.quesId?.toLong()))){
					list = QuestionOptions.createCriteria().list {
					'in'('id',ProfileQuestionsOptions.createCriteria().list {
									  eq('profileQuestions',ProfileQuestions.get(params.quesId.toLong()))
							 }?.questionOptions?.id
						)
					}
				}
				if(list != null){
					ArrayList<Long> sourceIds = new ArrayList<Long>()
					list . each {
						sourceIds.add(it?.id)
					}
					session.tempOptionsList = sourceIds
				}
			}else{
				//do nothing
			}
			
			return list
		}catch(Exception exception){
			
			 throw exception
		}
	}
	
	def makeInactive(params){
		try{ 
			return ProfileQuestions.executeUpdate("update ProfileQuestions q set q.isActive=0 where q.id=?",[params.quesId?.toLong()])
		}catch(Exception exception){
			 throw exception
		}
	}
	
	
	def optionsOfquesionDelete(params){
		try{
			return ProfileQuestionsOptions.executeUpdate("delete from ProfileQuestionsOptions o where o.profileQuestions=?",[ProfileQuestions.get(params.quesHiddenid?.toLong())])
		}catch(Exception exception){
			 throw exception
		}
	}
	
	
	def getQuestionCategory(){
		try{
			return QuestionCategory.createCriteria().list{
				eq('isActive',(short)1)
			} 
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getDiagnosis(){
		try{
			return Diagnosis.createCriteria().list{
				eq('isActive',(short)1)
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getOptionsFormat(){
		try{
			return QuestionOptionsFormat.createCriteria().list{
				eq('isActive',(short)1)
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def getList(params){
		try{
			return ProfileQuestions.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike("questionText","%"+params.searchValue+"%")}
						and{ilike("isActive","%"+params.searchValue+"%")}
					}
				}
			}
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def isExist(params){
		try{ boolean isExist = false 
			QuestionText text = QuestionText.findByQuestionTextIlike(params.quesText?.toString()?.trim())
			if(params.actionTypeId?.equalsIgnoreCase("edit")){
				if(text){
				isExist = (text?.id==ProfileQuestions.get(params.quesHiddenid.toLong())?.questionText?.id)?false:true}else{
				isExist = false
				}
			}else{  
				isExist = text != null ? true : false
			}
			return isExist
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	def getCount(params){
		try{
			return ProfileQuestions.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != ""){
					or{
						and{ilike("questionText","%"+params.searchValue+"%")}
						and{ilike("isActive","%"+params.searchValue+"%")}
					}
				}
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
