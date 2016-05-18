package com.healpal.care

import org.springframework.aop.ThrowsAdvice;

import grails.transaction.Transactional
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.codehaus.groovy.grails.web.context.ServletContextHolder

@Transactional
class HomeService implements org.springframework.context.ResourceLoaderAware {
	def ResourceLoader resourceLoader
	def serviceMethod() {
	}


	def shareYourStory(request,params ,HealpalUser user) throws Exception {
		try{
			println "request.getFile('uploadPhoto')  "+request.getFile('uploadPhoto')
			def name
			if(Diagnosis.get(params.diagnosis)!=null){
				ShareYourStory shareYourStory = new ShareYourStory()
				
				
				//photo Upload
				
						println "******** user?.person **************"+user?.person
						if(user?.person){
							CommonsMultipartFile f = request.getFile('uploadPhoto')
							println "******** CommonsMultipartFile **************"+f
							println "******** request.getFile('uploadPhoto') **************"+request.getFile('uploadPhoto')
							 name =f.getOriginalFilename()
							println "******** name **************"+name
							if(name){
								String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
								String fileName = name.substring(0,name.lastIndexOf('.'));
								name =  user?.person.id+"." + extension
							}
							println "********extension name **************"+name
							def serveletContext = ServletContextHolder.servletContext
							println "serveletContext;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+serveletContext
							println "resourceLoader;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+resourceLoader
							def storagePath =resourceLoader.getResource("/assets/reviewsPhotos/").getFile() //serveletContext.getRealPath("assets/patient-photo/")
							//def storagePathDirectory = new File( storagePath )
							println "********storagePath **************"+storagePath
							println "********storagePath **************"+name
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
							}/*else{
								println "File: ${file.inspect()} was empty"
								//return null
							}*/
							
							
							
						}
				
				
				shareYourStory.diagnosis=Diagnosis.get(params.diagnosis)
				String stringDate =params.narrationDate
				Date narrationDate = new Date().parse('M/d/yyyy', stringDate)
				shareYourStory.narrationDate=narrationDate
				shareYourStory.yourStatus=params.radio
				shareYourStory.yourStory=params.yourStory
				shareYourStory.filePath=name
				shareYourStory.storyTitle=params.storyTitle
				shareYourStory.rowCreated=new Date();
				shareYourStory.isActive=(short)1;
				shareYourStory.approved=0;
				shareYourStory.patientFk=Patient.findByPerson(user?.person);
				
				
				
					
				
				
				
				
				shareYourStory.save(flush:true)
				return shareYourStory
			}
		}
		catch(Exception exception) {
			throw exception
		}
	}

	def getAnswer(params ,HealpalUser user)throws Exception {
		try {
			println("inside service ::::")
			AskAnswersHomePage answer=new AskAnswersHomePage();
			answer.yourQuestionIsRelatedTo=params.radio
			println "yourQuestionIsRelatedTo"+params.radio
			answer.yourQuestion=params.concise
			println "yourQuestion"+params.concise
			answer.yourLocation=params.location
			println "yourLocation"+params.location
			answer.rowCreated=new Date();
			answer.isActive=(short)1
			answer.patientFk = Patient.findByPerson(user?.person);
			println "patientFk"+Patient.findByPerson(user?.person);
			answer.approved=0;
			answer.save(flush:true);
			return answer
		}
		catch(Exception exception) {
			throw exception
		}
	}

	def writeAReview(request,params ,HealpalUser user)throws Exception {
		def name
		try{
			if(params && params.diagnosis != null && !params.diagnosis.isEmpty() && params.title != null && !params.title.isEmpty()
			&& params.yourReview != null && !params.yourReview.isEmpty()){//&& params.cancerExpert!=null && !params.cancerExpert.isEmpty() && params.clinicLocation!=null && !params.clinicLocation.isEmpty() 
			
			WriteAReview addReview = new WriteAReview();
			
			println " user?.person ******"+user?.person
			println "************ "+request.getFile('uploadPhoto')
			if(user?.person){
			 CommonsMultipartFile f = request.getFile('uploadPhoto')
			 println " CommonsMultipartFile ******"+f
			 println " request.getFile('uploadPhoto') ******"+request.getFile('uploadPhoto')
			  name =f.getOriginalFilename()
			 println " name ******"+name
			 if(name){
			  String extension = name.substring(name.lastIndexOf('.') + 1, name.length());
			  String fileName = name.substring(0,name.lastIndexOf('.'));
			  name =  user?.person.id+"." + extension
			 }
			 println "********extension name **************"+name
			 def serveletContext = ServletContextHolder.servletContext
			 println "serveletContext;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+serveletContext
			 println "resourceLoader;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+resourceLoader
			 def storagePath =resourceLoader.getResource("/assets/reviewsPhotos/").getFile() //serveletContext.getRealPath("assets/patient-photo/")
			 //def storagePathDirectory = new File( storagePath )
			 println "********storagePath **************"+storagePath
			 println "********storagePath **************"+name
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
			 }/*else{
			  println "File: ${file.inspect()} was empty"
			  //return null
			 }*/
			 
			 
			 
			}
//shareYourStory.filePath=name
			
			
			String rate = params.rateId1?.toString()+","+params.rateId2?.toString()+","+params.rateId3?.toString()+","+params.rateId4?.toString()+","+params.rateId5?.toString()+","+params.rateId6?.toString()+","+params.rateId7?.toString()+","+params.rateId8?.toString()+","+params.rateId9?.toString()
			Date reviewDate = null;
			if(params.reviewDate){
			String stringDate = params.reviewDate
			println 'sssssssssss:::::::: '+stringDate
			reviewDate = new Date().parse('M/d/yyyy', stringDate)
			println "new::::::::::: "+reviewDate
			}			
			addReview.diagnosis = Diagnosis.get(params.diagnosis);
			addReview.patient = Patient.findByPerson(user?.person);
			addReview.reviewDate = reviewDate?:null;
			addReview.reviewTitle = params.title?:''
			addReview.yourReview = params.yourReview?:''
			addReview.rating = rate?:''
			addReview.cancerExpert = params.cancerExpert?:''
			addReview.clinicLocation = params.clinicLocation?:''
			addReview.reviewAboutExpert = params.reviewExpert?:''
			addReview.filePath = name
			addReview.rowCreated = new Date();
			addReview.isActive = (short)1;
			addReview.approved = 0;
			//addReview.quesAndAns=PatientReviewAnswers.findAllByPatient(Patient.findByPerson(user?.person)).id
			addReview.save();
			def isReviewAdded = addReview.save();
			println 'save'+	addReview.save();
			for(int i=0;i<2;i++){
				if(params.("question"+i) && params.("question"+i) != null){
					PatientReviewAnswers pra = new PatientReviewAnswers();
					pra.questionsAboutReview = QuestionsAboutReview.get(params.("question"+i))
					if(params.("reviewAnswer_text"+i)!=null)	{
						pra.answer = params.("reviewAnswer_text"+i);
					}
					else if(params.treatment != null){
						if(params.otherOption != null && !params.otherOption.isEmpty()){
							pra.answer = params.otherOption
						}
						else{
							pra.answer = params.treatment
						}
					}
					else{
						pra.answer = params.reviewAnswer_radio
					}
					pra.patient=Patient.findByPerson(user?.person)
					if(isReviewAdded != null){
						pra.writeAReview = isReviewAdded;
					}
					pra.isActive = (short)1;
					pra.rowCreated = new Date();
					pra.save();
				}
			}
			
			return isReviewAdded;
			}
			else{
					return null;
				}
		}
		catch(Exception exception) {
			throw exception
		}
	}
	
	def getList(params){		
		try{
			return WriteAReview.createCriteria().list(params){				
					order("rowAltered",'desc')
			eq('approved',1)		
			}
		}catch(Exception exception){
			throw exception
		}
		
	}
	
	def getapprovedList(){
		try{
			return WriteAReview.createCriteria().list(){
					//order("rowAltered",'desc')
					eq('approved',1)
			}
		}catch(Exception exception){
			throw exception
		}		
		
	}	
	
	def getListWithId(params, ArrayList reviewList){
		try{
			return WriteAReview.createCriteria().list(params){
					'in'("id",reviewList?.id)
						order("rowAltered",'desc')
			eq('approved',1)
			}
		}catch(Exception exception){
			throw exception
		}
		
	}
	
	def getStoryList(params){
		try{
		 return ShareYourStory.createCriteria().list(params){
		   order("rowAltered",'desc')
		   eq('approved',1)
		 }
		}catch(Exception exception){
		 throw exception
		}
		
	   }
	
	def getAnswerList(params){
		try{
		 return AskAnswersHomePage.createCriteria().list(params){
		   order("rowCreated",'desc')
		 }
		}catch(Exception exception){
		 throw exception
		}
		
	   }
	
}
