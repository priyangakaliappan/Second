/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      :
 * Description : Index Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0               Initial Creation
 *
 */

package com.healpal.home

import java.text.DateFormat;
import java.text.SimpleDateFormat

import com.healpal.care.AboutYou;
import com.healpal.care.AskAnswersHomePage;
import com.healpal.care.CancerStage;
import com.healpal.care.CancerStatus;
import com.healpal.care.Diagnosis;
import com.healpal.care.DiagnosisService;
import com.healpal.care.DoctorAddress;
import com.healpal.care.HealpalUser;
import com.healpal.care.HomeService
import com.healpal.care.Patient;
import com.healpal.care.PatientAddress;
import com.healpal.care.PatientDiagnosis;
import com.healpal.care.PatientMatchController;
import com.healpal.care.PatientMatchService
import com.healpal.care.PatientReviewAnswers;
import com.healpal.care.ProfilePhoto;
import com.healpal.care.QuestionsAboutReview;
import com.healpal.care.ReviewAbout;
import com.healpal.care.ShareYourStory;
import com.healpal.care.TempQuestionOption;
import com.healpal.care.Treatment;
import com.healpal.care.WriteAReview
import com.healpal.care.ShareYourStoryComments;
import com.healpal.care.WriteAReviewComments;
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile
class HomeController {

	def DiagnosisService diagnosisService
	def PatientMatchService patientMatchService
	def PatientMatchController patientMatchController
	def HomeService homeService

	def index() {
		if(session != null && session.user){
			HealpalUser user=session.user;
			def diagnosisList = Diagnosis.list();
			def cancerStageList = CancerStage.list();
			def cancerStatusList = AboutYou.list();
			//def photo=ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath;
			[diagnosisList:diagnosisList,cancerStageList:cancerStageList,cancerStatusList:cancerStatusList]
			//redirect controller:'auth' ,action:'jsRoleCheck'
		}else{
			def diagnosisList = Diagnosis.list();
			def cancerStageList = CancerStage.list();
			def cancerStatusList = AboutYou.list();
			[diagnosisList:diagnosisList,cancerStageList:cancerStageList,cancerStatusList:cancerStatusList]
		}
	}

	def learn() {
		try{
			[learn:'active',diagnosis : diagnosisService.getdiagnosisList()]
		}catch(Exception exception){
			exception . printStackTrace()
		}
	}
	def match() {
		[match:'active']
	}
	def connect() {
		[connect:'active']
	}
	def introduction(){
		if(session.healpalAgree != null && session.healpalAgree.equals("AgreeWithHealapl")){
			redirect(controller:'BreastCancer' ,action:'index')
		}
	}
	def howItWorks(){
		[howItWorks:'active']
	}

	def filterMatchPatientList(){
		ArrayList patientList = new ArrayList();
		ArrayList patientMatchSerchList = new ArrayList();
		ArrayList patientMatchList = new ArrayList();
		ArrayList photoName = new ArrayList();
		try{
			def diagnosis = params.diagnosis
			def cancerStage = params.cancerStage
			def cancerStatus = params.cancerStatus
			def patientMatchMap =  patientMatchService.getAllPatientMatch();
			if(patientMatchMap!=null && !patientMatchMap.equals("")){
				for(int i=0;i<patientMatchMap.size();i++){
					def patientMatch = patientMatchMap.get(i);
					patientList.add(patientMatch);
				}
			}else{
				//do nothing
			}

			if(patientList!=null && !patientList.equals("")){
				for(int i=0;i<patientList.size();i++){
					def patientMatch = patientList.get(i);
					//****************FRom Date ,To Date , zipcode,cancer status and cancer stage Filter Starts********************************************
					if(diagnosis!=null && !diagnosis.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStatus!=null && !cancerStatus.equals("")){
						println "inside Home :filterMatchPatientList()-->diagnosis cancer status,,cancer stage filter !!!!!!!!"
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						def patientDiagnosis = PatientDiagnosis.findByPatientAndDiagnosis(patientMatch?.patient,Diagnosis.get(diagnosis?.toString().toLong()));
						if(patientDiagnosis!=null && !patientDiagnosis.equals("") &&
						patientStageOfCancerName!=null && !patientStageOfCancerName.equals("")
						&& cancerStage.equals(patientStageOfCancerName) && patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("")
						&& cancerStatus.equals(patientStatusOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(cancerStage!=null && !cancerStage.equals("") && cancerStatus!=null && !cancerStatus.equals("")){
						println "inside Home :filterMatchPatientList()-->cancer status,,cancer stage filter !!!!!!!!"
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("")
						&& cancerStage.equals(patientStageOfCancerName) && patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("")
						&& cancerStatus.equals(patientStatusOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(diagnosis!=null && !diagnosis.equals("") && cancerStage!=null && !cancerStage.equals("") ){
						println "inside Home :filterMatchPatientList()-->diagnosis,cancer stage filter !!!!!!!!"
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						def patientDiagnosis = PatientDiagnosis.findByPatientAndDiagnosis(patientMatch?.patient,Diagnosis.get(diagnosis?.toString().toLong()));
						if(patientDiagnosis!=null && !patientDiagnosis.equals("") &&
						patientStageOfCancerName!=null && !patientStageOfCancerName.equals("")
						&& cancerStage.equals(patientStageOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(diagnosis!=null && !diagnosis.equals("") && cancerStatus!=null && !cancerStatus.equals("")){
						println "inside Home :filterMatchPatientList()-->diagnosis cancer status filter !!!!!!!!"
						def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						def patientDiagnosis = PatientDiagnosis.findByPatientAndDiagnosis(patientMatch?.patient,Diagnosis.get(diagnosis?.toString().toLong()));
						if(patientDiagnosis!=null && !patientDiagnosis.equals("") &&
						patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("")
						&& cancerStatus.equals(patientStatusOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(diagnosis!=null && !diagnosis.equals("")){
						println "inside Home :filterMatchPatientList()-->diagnosis filter !!!!!!!!"
						def patientDiagnosis = PatientDiagnosis.findByPatientAndDiagnosis(patientMatch?.patient,Diagnosis.get(diagnosis?.toString().toLong()));
						if(patientDiagnosis!=null && !patientDiagnosis.equals("")){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(cancerStatus!=null && !cancerStatus.equals("")){
						println "inside Home :filterMatchPatientList()-->cancer status filter !!!!!!!!"
						def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("")
						&& cancerStatus.equals(patientStatusOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else if(cancerStage!=null && !cancerStage.equals("") ){
						println "inside Home :filterMatchPatientList()-->cancer stage filter !!!!!!!!"
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("")
						&& cancerStage.equals(patientStageOfCancerName)){
							patientMatchSerchList.add(patientMatch);
						}
					}else{
						patientMatchSerchList = patientList;
					}
					//****************FRom Date ,To Date , zipcode,cancer status and cancer stage Filter ends********************************************

				}
			}

			/*if(patientMatchSerchList!=null && patientMatchSerchList.size()>0){
			 for(int i =0;i<8;i++){
			 if(i < patientMatchSerchList.size()){
			 def patientMatch = patientMatchSerchList.get(i);
			 if(patientMatch){
			 photoName = 
			 patientMatchList.add(patientMatch);
			 }
			 }
			 }
			 }*/
			render (template:'patientMatchSearch', model:[patientList:patientMatchSerchList])
		}catch(Exception exception){
			exception . printStackTrace()
		}

	}


	/**
	 * @return
	 */
	def fordoctor()
	{
		try{
			[fordoctor:'active']
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}

	}
	def findReview(){
		params.max = Math.min(params.max ? params.int('max') : 4, 100)
		def reviewsList = homeService.getList(params)
		def approvedList = homeService.getapprovedList()
		println '************** '+reviewsList
	def diagnosisList=Diagnosis.createCriteria().list {
	order('diagnosisName','asc')
	}
	def reviewAboutList=ReviewAbout.createCriteria().list { order('reviewAbout','asc')	 }
	session.pagingList = null
   [reviewList : reviewsList , diagnosisList : diagnosisList, reviewAboutList : reviewAboutList,total:approvedList.size() ,offset:0 ,max : params.max]
	}

	def searchReview(){
		def searchVal = params.searchValue
		def reviewList = WriteAReview.createCriteria().list {
			ilike("yourReview","%"+searchVal+"%")
		}
		render(template:"reviewList",model:[reviewList:reviewList]);
	}
	/**
	 * @return
	 */
	def writeAReview()
	{
		try{

			switch(request.method){

				case 'GET':

					def diagnosisList=Diagnosis.createCriteria().list {
							order("diagnosisName",'asc')
					}
					params.max = Math.min(params.max ? params.int('max') : 4, 100)
					def writeASingleReviewList=homeService.getList(params)
					
					def reviewAboutList=ReviewAbout.createCriteria().list { order('reviewAbout','asc')	 }
					render(view:"writeAReview",model:[writeAReview:'active',diagnosisList:diagnosisList,reviewAboutList:reviewAboutList,writeASingleReviewList:writeASingleReviewList,total:WriteAReview.list()?.size() ,offset:0 ,max : params.max])
					
					break;

				case 'POST':
					if(session.user && session.user!=null){
						if(params && params.diagnosis!=null && !params.diagnosis.isEmpty() && params.title !=null && !params.title.isEmpty()
						&& params.yourReview!=null && !params.yourReview.isEmpty())//&& params.cancerExpert!=null && !params.cancerExpert.isEmpty() && params.clinicLocation!=null && !params.clinicLocation.isEmpty()
						{
							HealpalUser user=session.user;
							def addReviews=homeService.writeAReview(request,params,user)
							if(addReviews != null){
								flash.msg="Your review has been added successfully"
							}
							else{
								flash.msg="Review Posted failed due to some errors"
							}
							redirect(controller:"home",action:"writeAReview")
						}
						else{
							//do nothing
						}

						break;
					}

					else{
						redirect controller :'auth' ,action :'doLogout'
					}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
		/*def writeAReviewList=WriteAReview?.createCriteria()?.list{ eq('approved',1)}
		 println "writeAReviewList;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+writeAReviewList
		 render(view:"writeAReview",model:[writeAReviewList:writeAReviewList])*/
	}

	
	
	def singleWriteAReviewPage()
	{
		try
		{
			HealpalUser healpalUser=session.user
			params.max = Math.min(params.max ? params.int('max') : 4, 100)
			def writeASingleReviewList=homeService.getList(params)
			def singlepageList
			def getCommentToPatient
			
		/*def writeASingleReviewList=WriteAReview.createCriteria().list{
			order("rowAltered",'desc')
			eq('approved',1)
		}*/
		
		def commentsList=WriteAReviewComments.createCriteria().list(params){
						eq('writeReviewFk',WriteAReview.get(params.singleReviewId))
					}
		println "commentsList;;;;;;;;;;;;;;;;;;;;;;;;;"+commentsList
		
		int commentSize = WriteAReviewComments.createCriteria().list{
			eq('writeReviewFk',WriteAReview.get(params.singleReviewId))
		}.size();
		if(params.singleReviewId!=null){
			singlepageList = WriteAReview.get(params.singleReviewId)
		}
		else {
			 singlepageList=WriteAReview.createCriteria().list{
				order("rowAltered",'desc')
				maxResults(1)
			}
		}
			 if(session.user){
				 		if(params.comments!=null && params.commentPatient!=null){
				 		getCommentToPatient = WriteAReview.get(params.commentPatient)
				 		WriteAReviewComments shareYourStoryComments=new WriteAReviewComments();
							shareYourStoryComments.comments=params.comments;
				 			shareYourStoryComments.commentedPatient=Patient.findByPerson(healpalUser?.person);
				 			shareYourStoryComments.writeReviewFk=getCommentToPatient
				 			shareYourStoryComments.rowCreated=new Date();
				 			shareYourStoryComments.isActive=Short.valueOf("1")
				 			shareYourStoryComments.save(flush:true);
				 		}}
			
			
		[writeASingleReviewList:writeASingleReviewList,
			singlepageList:singlepageList,offset:0 ,
			max : params.max,total:WriteAReview.list()?.size(),
			commentsList:commentsList,commentsTotal:commentSize,commentsMax:params.max,reviewId:params.singleReviewId ]
		}
		
		catch(Exception exception)
		{
			
		}
	}
	
	
	def ajaxQuestionOptions(){
		def questionsList=QuestionsAboutReview.createCriteria().list {
			eq('reviewAbout', ReviewAbout.get(params.reviewId))
		}

		List<String> options=new ArrayList();
		options.add("Completely covered");
		options.add("Partially covered");
		options.add("Not covered by insurance");
		/*
		 List<String> treatments=new ArrayList();
		 treatments.add("Angiogenesis inhibitors");
		 treatments.add("Biological agents");
		 treatments.add("Biopsy");
		 treatments.add("Cancer surgery");
		 treatments.add("Central venous access catheter");
		 treatments.add("Chemotherapy");
		 treatments.add("Hormone therapy");
		 treatments.add("Immunotherapy");
		 treatments.add("Radiation therapy");
		 treatments.add("Radiosurgery");
		 treatments.add("Sentinel lymph node biopsy");
		 treatments.add("Stereoactive ablative body radiotherapy (SABR)");
		 treatments.add("Surgery");
		 treatments.add("Targeted therapy");
		 treatments.add("other");*/

		def treatmentList=Treatment.createCriteria().list {

		}
		render (template:'reviewQuestions', model:[questionsList:questionsList,options:options,treatments:treatmentList])
	}

	/**
	 * @return
	 */
	def getAnswers(){
		try{
			HealpalUser user = session.user
			params.max = Math.min(params.max ? params.int('max') : 5, 100)
			def askAnswersHomePageList=homeService.getAnswerList(params)
			if(request.post)
			{
				println("inside answers"+session.user)
				if(params.location!=null && params.concise!=null && params.radio!=null)
				{
					println"inside if::::::"
					AskAnswersHomePage answer= homeService.getAnswer(params,user)
					if(answer.validate())
					{
						println("inside validate")
						flash.msg="Your question has been posted to the HealPal Doctors. The answers will be posted within 2-3 days in the site"
					}
					println "answer;;;"+answer
					redirect(action : 'getAnswers')
				}
				else
				{
					println "params;;;;;;;;;;;;;;"+params.radio
					if(params.radio!=null && params.concise!=null && params.location!=null){

						flash.msg="Oops! There were some problems with your review."
					}
				}
			}
			[askAnswersHomePageList:askAnswersHomePageList,answer:AskAnswersHomePage?.createCriteria()?.list{order("rowCreated",'desc')},total:AskAnswersHomePage.list()?.size() ,offset:0 ,max : params.max]
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
		
	}


	/**
	 * @return
	 */
	def examineTreatments(){
		try{
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
	}

	/**
	 * @return
	 */
	def findDoctor()
	{
		try{
			Set<String> cities = new LinkedHashSet<String>();
			Set<String> states = new LinkedHashSet<String>();
			def addressCity = DoctorAddress.createCriteria().list {
				//eq('state','California')
				order('city','asc')
			}
			def addressState = DoctorAddress.createCriteria().list {
				//eq('state','California')
				order('state','asc')
			}
			if(addressCity!=null && addressCity.size()>0){
				addressCity.each{
					cities.add(it?.city);
				}
			}
			if(addressState!=null && addressState.size()>0){
				addressState.each{
					states.add(it?.state);
				}
			}
			[findDoctor:'active',city:cities,state:states]
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}

	}

	def shareYourStory()
	{
		try
		{
			HealpalUser user = session.user
			params.max = Math.min(params.max ? params.int('max') : 4, 100)
			def shareYourStoryList=homeService.getStoryList(params)
			if(request.post)
			{
				if(params!=null && params.diagnosis!=null && !params.diagnosis.isEmpty()
				&& params.storyTitle!=null && !params.storyTitle.isEmpty()
				&& params.yourStory!=null && !params.yourStory.isEmpty()){
					//def shareYourStory = homeService.shareYourStory(Patient.findByPerson(HealpalUser.get(user?.id)?.person)?.id)
					ShareYourStory shareYourStory = homeService.shareYourStory(request,params,user)
					println "shareYourStory;;;;;;;;;;;;;"+shareYourStory
					flash.msg="Share Your Story stored Successfully."
					redirect(action : 'shareYourStory')
				}
				else{
					if(params.diagnosis=="null" || params.storyTitle.isEmpty() || params.yourStory.isEmpty()){
						println "inside loop"
						flash.msg="Oops! There were some problems with your story."
					}
					//flash.alert="Oops! There were some problems with your story."
					//flash.alert="Please check the box to indicate that you've read the terms for submitting your story."
				}
			}
			[shareYourStoryList:shareYourStoryList,diagnosisList:Diagnosis.createCriteria().list {order("diagnosisName",'asc')	},total:ShareYourStory.list()?.size() ,offset:0 ,max : params.max]
		}
		catch(Exception e)
		{
			e.printStackTrace()
		}
		
	}

	def singleStoryPage()
 {
  try
  {
   HealpalUser healpalUser=session.user
   params.max = Math.min(params.max ? params.int('max') : 4, 100)
   def shareYourStoryList=homeService.getStoryList(params)
   def singlepageList
   def getCommentToPatient
  /*def shareYourStoryList=ShareYourStory.createCriteria().list{
   order("rowAltered",'desc')
   eq('approved',1)
  }*/
  
  def commentsList=ShareYourStoryComments.createCriteria().list(params){
      eq('shareYourStoryFk',ShareYourStory.get(params.singleStoryPageId))
     }
  int commentSize = ShareYourStoryComments.createCriteria().list{
	 eq('shareYourStoryFk',ShareYourStory.get(params.singleStoryPageId))
  }.size();

  println "params.singleStoryPageId;;;;;;;;;;;;;;;;;;;;;;;;;"+params.singleStoryPageId
  println "shareYourStoryList;;;;;;;;;;;;;;;;;;;;;;;;;"+shareYourStoryList
  if(params.singleStoryPageId!=null){
   singlepageList = ShareYourStory.get(params.singleStoryPageId)
   println "ss;;;;;;;;;;;;;;;;"+singlepageList
  }
  else {
   println "else loop;;;;;;;;;;;;;;;;;;;;;;;;;"
    singlepageList=ShareYourStory.createCriteria().list{
    order("rowAltered",'desc')
    maxResults(1)
   }
   
    /*if(session.user){
       if(params.comments!=null && params.commentPatient!=null){
       getCommentToPatient = ShareYourStory.get(params.commentPatient)
       ShareYourStoryComments shareYourStoryComments=new ShareYourStoryComments();
       shareYourStoryComments.comments=params.comments;
        shareYourStoryComments.commentedPatient=Patient.findByPerson(healpalUser?.person);
        shareYourStoryComments.shareYourStoryFk=getCommentToPatient
        shareYourStoryComments.rowCreated=new Date();
        shareYourStoryComments.isActive=Short.valueOf("1")
        shareYourStoryComments.save(flush:true);
       }}
    */
   
  }
  [shareYourStoryList:shareYourStoryList,
	  singlepageList:singlepageList,
	  offset:0 ,
	  max : params.max,total:ShareYourStory.list()?.size(),
	  commentsList:commentsList,commentsTotal:commentSize,commentsMax:params.max,storyId:params.singleStoryPageId]
  }
  
  catch(Exception exception)
  {
   
  }
 }
 
 
 
 
 /**
 * @param singleStoryPageId
 * @return
 * @throws Exception
 */
def getPhotoNameForSingleStoryPage(def singleStoryPageId)throws Exception{
	 def currentPatientImage = "";
	 try{
		 
		 
		 //authorizeMe()
		if(params.singleStoryPageId){
			def getCurrentPatientImage=ShareYourStory.get(params.singleStoryPageId)
			 currentPatientImage=getCurrentPatientImage.filePath
		 }
	 }catch(Exception exception){
		exception.printStackTrace();
	 }
	 return currentPatientImage
 }
 
 

def getPhotoNameForSingleReviewPage(def singleReviewId)throws Exception{
	println "singleReviewId "+params.singleReviewId
	def currentPatientImage = "";
	try{
		
		
		//authorizeMe()
	   if(params.singleReviewId){
		   def getCurrentPatientImage=WriteAReview.get(params.singleReviewId)
		   println "getCurrentPatientImage;;;;;;;;;;;;;;;;;;;;;"+getCurrentPatientImage
			currentPatientImage=getCurrentPatientImage.filePath
			println "currentPatientImage;;;;;;;;;;;;;;;;;;;;;"+currentPatientImage
		}
	}catch(Exception exception){
	   exception.printStackTrace();
	}
	return currentPatientImage
}


	
	def getPersonAddress(def patientId){
		def patientAddress = "";
		try{
			if(patientId !=null && !patientId.equals("")){
				def patient = Patient.get(patientId?.toString().toLong());
				if(patient){
					patientAddress = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"));
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
		return patientAddress
		
	}

def getReviewCategory(def patientId,def reviewId){
	def reviewCategory = "";
	try{
		if(patientId !=null && !patientId.equals("") && reviewId!=null && !reviewId.equals("")){
			def patient = Patient.get(patientId?.toString().toLong());
			def review = WriteAReview.get(reviewId);
		if(review && patient){
			def category = PatientReviewAnswers.findByPatientAndWriteAReview(patient,review);
			if(category!=null && category!=""){
				reviewCategory = category?.questionsAboutReview?.reviewAbout?.reviewAbout;
			}
			}
			}
	}catch(Exception exception){
	   exception.printStackTrace();
	}
	return reviewCategory
	
	}

def searchReviews(){
	Calendar now = Calendar.getInstance();
	def reviewsList = null;
	def catgoryList = null;
	Date fromDate = null;
	Date toDate = new Date().clearTime();
	def finalList = null;
	int totalSize = 0;
	if((params.Submitted && params.Submitted!=null)||(params.diagnosis && params.diagnosis!=null)||(params.category && params.category!=null)||(params.Location && params.Location!=null) )
	{		
	println "IFFFFFFFFFFFFFFFFFFFFFFFFFFFF"
	ArrayList<WriteAReview> writeAReviewList = new ArrayList<WriteAReview>();
	if(params.Submitted && params.Submitted!=null){			
		if(params.Submitted == '6'){
			now.add(Calendar.WEEK_OF_YEAR, -1);
			}
		else if(params.Submitted == '7'){
			now.add(Calendar.MONTH, -1);
			}
		else if(params.Submitted == '8'){
			now.add(Calendar.MONTH, -6);
			}
		else if(params.Submitted == '9'){
			now.add(Calendar.YEAR, -1);
			}
		String fromDates = (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.DATE) + "-" + now.get(Calendar.YEAR)
		fromDate = new Date().parse('MM-dd-yyyy', fromDates)
	 }
	
	reviewsList = WriteAReview.createCriteria().list {
	if(params.diagnosis){
	eq("diagnosis",Diagnosis.get(params.diagnosis));
	}
	if(fromDate !=null && toDate!=null){
	between("reviewDate",fromDate, toDate)
	}
	}	
	println "^^^^^^^^^^^^^^^^^^^^^:::::::::::: "+reviewsList
	
	if(params.category){
	 catgoryList = PatientReviewAnswers.createCriteria().list {
		questionsAboutReview{
			reviewAbout{
				eq("id",params.category.toString().toLong())
			}
		}
		
		projections {
			distinct('writeAReview')
		}
	
	}
}
	if(reviewsList && reviewsList!=null && reviewsList.size>0 && params.category && params.category!=null){
		for(int reviewCount=0;reviewCount<reviewsList.size();reviewCount++){
			def review = reviewsList.get(reviewCount);
			if(catgoryList && catgoryList!=null && catgoryList.size>0){
			for(int categoryCount=0;categoryCount<catgoryList.size();categoryCount++){
				def category = catgoryList.get(categoryCount);
				if(category == review){
					writeAReviewList.add(category);
				}
				else{
					//do nothing
				}
			}
			}
			else{
			//do nothing
		}
		}
	}
	
	else if(reviewsList && reviewsList!=null && reviewsList.size>0){
		for(int reviewCount=0;reviewCount<reviewsList.size();reviewCount++){
			def reviews = reviewsList.get(reviewCount);
			writeAReviewList.add(reviews);
		}
	}
	if(writeAReviewList.size>0){
		finalList= homeService.getListWithId(params, writeAReviewList);
		session.pagingList = WriteAReview.createCriteria().list {
			'in'("id",writeAReviewList.id)
			order("rowAltered",'desc')
			eq('approved',1)}
									
		totalSize = WriteAReview.createCriteria().list {
		'in'("id",writeAReviewList.id)
			order("rowAltered",'desc')
			eq('approved',1)
		}.size()
		session.pagingSize = totalSize
	}
	
	}
	else{
		
		finalList = WriteAReview.createCriteria().list(params) {
			order("rowAltered",'desc')
			eq('approved',1)
		}
		
		session.pagingList = null
		
		totalSize = WriteAReview.createCriteria().list {
			order("rowAltered",'desc')
			eq('approved',1)
		}.size()
		
		session.pagingSize = null
	}
	render(template:"searchReviews",model:[reviewList:finalList,total:totalSize,offset:params.offset,max :params.max])
	//return reviewsList
	
	}

def cancerTreatments(){
	try{
		def treatment = params.treatment
		def title
		if(treatment!=null && treatment!=""){
			if(treatment == 'Angiogenesis inhibitors') title = 'Angiogenesis inhibitors'
			if(treatment == 'Biological agents') title = 'Biological agents'
			if(treatment == 'Chemotherapy') title = 'Chemotherapy'
			if(treatment == 'Hormone therapy') title = 'Hormone therapy'
			if(treatment == 'Immunotherapy') title = 'Immunotherapy'
			if(treatment == 'Radiation therapy') title = 'Radiation therapy'
			if(treatment == 'Stereoactive ablative body radiotherapy (SABR)') title = 'Stereoactive ablative body radiotherapy (SABR)'
			if(treatment == 'Surgery') title = 'Surgery'
			if(treatment == 'Targeted therapy') title = 'Targeted therapy'
			
		}
		[title:title]
	}catch(Exception exception){ exception.printStackTrace();}
}



def readMore(){
	
	int maxSize = Integer.parseInt(params.maxSize);
	int maxx=WriteAReview.list()?.size()
	if(params.maxSize!=null){//&& !totalSize<=0 && !maxSize<=0 && !maxSize>=totalSize
		maxx=maxSize+4
	}
	params.max = Math.min(params.max ? params.int('max') : maxx, 100)
	
	def reviewList=homeService.getList(params)
	render (template : 'moreReviews' , model:[reviewList:reviewList,offset:0 ,max : params.max,total:WriteAReview.list()?.size()])
}


def readMoreSinglewriteAReview()
{
	try{
		println "hai;;;;;;;;;;;;;;;;;;;;;;;;;;;;"
		int maxSize = Integer.parseInt(params.maxSize);
		int maxx=WriteAReview.list()?.size()
		if(params.maxSize!=null){//&& !totalSize<=0 && !maxSize<=0 && !maxSize>=totalSize
			maxx=maxSize+4
		}
		params.max = Math.min(params.max ? params.int('max') : maxx, 100)
		
		def writeASingleReviewList=homeService.getList(params)
		render (template : 'moreWriteAReviews' , model:[writeASingleReviewList:writeASingleReviewList,offset:0 ,max : params.max,total:WriteAReview.list()?.size()])
	}
	
	catch(Exception exception)
	{
		exception.printStackTrace()
	}
}

def ajaxPaginate(){
	
	println params.offset;
	println params.size
	def listFinal = null;
	int listSize = 0;
	if(session.pagingList && session.pagingList!=null && session.pagingList.size()>=0){
		listFinal = homeService.getListWithId(params, session.pagingList);
		listSize = session.pagingSize
	}
	else{
		listFinal = homeService.getList(params)
		listSize = WriteAReview.createCriteria().list {
			order("rowAltered",'desc')
			eq('approved',1)//order("reviewDate","desc")
		}.size()
	}
	
	render (template :'searchReviews' ,model:[reviewList :listFinal  ,total:listSize ,offset:params.offset ,max :params.max])
	
	}

def comments(){
	def getCommentToPatient = null;	
	int maxx=WriteAReviewComments.list()?.size()
	int maxSize = Integer.parseInt(params.comment_maxSize);
		if(params.comments!=null && params.commentPatient!=null){
			if(session.user){
		HealpalUser healpalUser=session.user
		getCommentToPatient = WriteAReview.get(params.commentPatient)
		WriteAReviewComments shareYourStoryComments=new WriteAReviewComments();
		   shareYourStoryComments.comments=params.comments;
			shareYourStoryComments.commentedPatient=Patient.findByPerson(healpalUser?.person);
			shareYourStoryComments.writeReviewFk=getCommentToPatient
			shareYourStoryComments.rowCreated=new Date();
			shareYourStoryComments.isActive=Short.valueOf("1")
			def isPosted=shareYourStoryComments.save(flush:true);
			if(isPosted != null){
				//flash.msg="Comment has been posted Successfully";
			}
		}		
	else{
		//flash.msg="Please Sign in to HealPal before post a comment";
		}
		maxx = maxSize
		}
		else{			
			if(params.comment_maxSize!=null){
				maxx=maxSize+4
			}
			}			
		params.max = Math.min(params.max ? params.int('max') : maxx, 100)
	def commentsList=WriteAReviewComments.createCriteria().list(params){
		eq('writeReviewFk',WriteAReview.get(params.commentPatient))
order('rowCreated','desc')
	}
	int commentSize = WriteAReviewComments.createCriteria().list{
		eq('writeReviewFk',WriteAReview.get(params.commentPatient))
	}.size()
	
	
	render(template:'comments',model:[commentsList:commentsList,offset:0 ,commentsMax : params.max,commentsTotal:commentSize,reviewId:params.commentPatient])
		
	}

def singleGetAnswerPage()
{
	try
	{
		HealpalUser healpalUser=session.user
		params.max = Math.min(params.max ? params.int('max') : 5, 100)
		def askAnswersHomePageList=homeService.getAnswerList(params)
	    def singleAnswerList
	/*def askAnswersHomePageList=AskAnswersHomePage.createCriteria().list{
		order("rowCreated",'desc')
	}*/
	println "params.singleGetAnswerPage;;;;;;;;;;;;;;;;;;;;;;;;;"+params.singleAnswerPageId
	println "shareYourStoryList;;;;;;;;;;;;;;;;;;;;;;;;;"+askAnswersHomePageList
	if(params.singleAnswerPageId!=null){
		singleAnswerList = AskAnswersHomePage.get(params.singleAnswerPageId)
		println "singleAnswerList;;;;;;;;;;;;;;;;"+singleAnswerList.answers
		if(singleAnswerList.answers==null){
		flash.msg="No doctor answers yet"
		}
	}
	else {
		println "else loop;;;;;;;;;;;;;;;;;;;;;;;;;"
		 singleAnswerList=AskAnswersHomePage.createCriteria().list{
			order("rowCreated",'desc')
			maxResults(1)
		}
		
		
	}
	[askAnswersHomePageList:askAnswersHomePageList,singleAnswerList:singleAnswerList,total:AskAnswersHomePage.list()?.size() ,offset:0 ,max : params.max]
	}
	
	catch(Exception exception)
	{
		
	}
}

def readMoreQuestions()
{
 try{
  int maxSize = Integer.parseInt(params.maxSize);
  int maxx=AskAnswersHomePage.list()?.size()
  if(params.maxSize!=null){
   maxx=maxSize+5
  }
  params.max = Math.min(params.max ? params.int('max') : maxx, 100)
  
  def askAnswersHomePageList=homeService.getAnswerList(params)
  render (template : 'moreQuestions' , model:[askAnswersHomePageList:askAnswersHomePageList,offset:0 ,max : params.max,total:AskAnswersHomePage.list()?.size()])
 }
 
 catch(Exception exception)
 {
  exception.printStackTrace();
 }
}

def readMoreStories()
{
 try{
  int maxSize = Integer.parseInt(params.maxSize);
  int maxx=ShareYourStory.list()?.size()
  if(params.maxSize!=null){//&& !totalSize<=0 && !maxSize<=0 && !maxSize>=totalSize
   maxx=maxSize+4
  }
  params.max = Math.min(params.max ? params.int('max') : maxx, 100)
  int commentSize = ShareYourStoryComments.createCriteria().list{
	  eq('shareYourStoryFk',ShareYourStory.get(params.commentPatient))
  }.size()
  
  def shareYourStoryList=homeService.getStoryList(params)
  render (template : 'moreStories' , model:[shareYourStoryList:shareYourStoryList,offset:0 ,max : params.max,total:ShareYourStory.list()?.size(),commentTotal:commentSize])
 }
 
 catch(Exception exception)
 {
  exception.printStackTrace();
 }
}



def commentsForStory(){
	HealpalUser healpalUser = session.user
	int maxxVal=ShareYourStoryComments.list()?.size()
	int maxSizeStory = Integer.parseInt(params.comment_maxSize);
	def getCommentToPatient = null;
	
       if(params.comments!=null && params.commentPatient!=null){
		   if(session.user){
	   
       getCommentToPatient = ShareYourStory.get(params.commentPatient)
       ShareYourStoryComments shareYourStoryComments=new ShareYourStoryComments();
       shareYourStoryComments.comments=params.comments;
        shareYourStoryComments.commentedPatient=Patient.findByPerson(healpalUser?.person);
        shareYourStoryComments.shareYourStoryFk=getCommentToPatient
        shareYourStoryComments.rowCreated=new Date();
        shareYourStoryComments.isActive=Short.valueOf("1")
      def isPosted=  shareYourStoryComments.save(flush:true);
		if(isPosted != null){
			//flash.msg="Comment has been posted Successfully";
		}
	   }
    
	else{
		//flash.msg="Please Sign in to HealPal before post a comment";
		}
		maxxVal = maxSizeStory
		}
		else{			
			if(params.comment_maxSize!=null){
				maxxVal=maxSizeStory+4
			}
			}	
		params.max = Math.min(params.max ? params.int('max') : maxxVal, 100)
	def commentsList=ShareYourStoryComments.createCriteria().list(params){
		eq('shareYourStoryFk',ShareYourStory.get(params.commentPatient))
		order('rowCreated','desc')
	}
	println "commentsList;;;;;;;;;;;;;;;;;;;"+commentsList
	int commentSize = ShareYourStoryComments.createCriteria().list{
		eq('shareYourStoryFk',ShareYourStory.get(params.commentPatient))
	}.size()
	println "commentSize;;;;;;;;;;;;;;;;;;;"+commentSize
	render(template:'commentsForStory',model:[commentsList:commentsList,offset:0 ,commentsMax : params.max,commentsTotal:commentSize,storyId:params.commentPatient])
	//render(template:'commentsForStory',model:[commentsList:commentsList,offset:0 ,commentsMax : params.max,commentsTotal:commentSize,reviewId:params.commentPatient])
		
	}


}
