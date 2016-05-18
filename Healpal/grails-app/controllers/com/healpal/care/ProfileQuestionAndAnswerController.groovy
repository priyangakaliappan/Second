package com.healpal.care
import com.healpal.care.ProfileQuestionAnswerService
class ProfileQuestionAndAnswerController {
	def ProfileQuestionAnswerService profileQuestionAnswerService;
	private int nquestionNumber=0;
    def index() { }
	
	
	def add(){
		try{
			authorizeMe();
		if(request.post){
			def profileQuestion=params.profileQuestion
			def answer=params.answer
			HealpalUser user=session.user
			boolean isExists =profileQuestionAnswerService.updateProfile(params, user)
			if(isExists){
				ProfileQuestionAnswer saveProfile=null;			
			if(answer.toString().contains(",")){
				answer.each {				
				 saveProfile=profileQuestionAnswerService.save(profileQuestion,it,user)			
				}
				if(saveProfile!=null){
					nquestionNumber++;
					redirect controller :'ProfileQuestionAndAnswer' ,action :'createProfile'
				}
				}
			else{
				saveProfile=profileQuestionAnswerService.save(profileQuestion,answer,user)
				if(saveProfile!=null){
					nquestionNumber++;
					redirect controller :'ProfileQuestionAndAnswer' ,action :'createProfile'
				}
			}
			}
			}
		}catch(Exception exception){
		exception.printStackTrace();
		}
	}
	
	def createProfile() {	
		try{			
		authorizeMe();
		int nextOffset=nquestionNumber	
		def getProfileQuestions = ProfileQuestions.createCriteria().list(max: 1,offset: nextOffset) {
			order("id","asc")			
		} 
		if(getProfileQuestions.size()<=0){
			nquestionNumber=0;
			redirect(controller:"dashboard",action:"view")
		}
		ProfileQuestions nextProfileQuestion=null;
		ProfileQuestionsOptions options=null;
		getProfileQuestions.each{
			nextProfileQuestion=it;
		}
		
		def questionOption=ProfileQuestionsOptions.createCriteria().list {
			eq("profileQuestions",nextProfileQuestion)
		}
		/*questionOption.each{
			options=it;
		}*/
		def question=nextProfileQuestion;
		def answerOptions=questionOption
		render(view:'createProfile',model:[question:nextProfileQuestion,answerOptions:answerOptions])
		}catch(Exception exception){
		exception.printStackTrace();
		}		
	}	
	
	def back(){
		try{
			authorizeMe();
		if(nquestionNumber>0){
		nquestionNumber--;
		}
		redirect controller :'ProfileQuestionAndAnswer' ,action :'createProfile'
		}catch(Exception exception){
		exception.printStackTrace();
		}
	}
	
	def nextQuestion(){
		try{
			authorizeMe();
		if(nquestionNumber>=0){
			nquestionNumber++;
		}		
		redirect controller :'ProfileQuestionAndAnswer' ,action :'createProfile'
		}catch(Exception exception){
		exception.printStackTrace();
		}
		}
	
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	
}
