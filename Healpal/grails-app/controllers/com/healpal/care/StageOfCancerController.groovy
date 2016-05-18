package com.healpal.care

import java.text.SimpleDateFormat
class StageOfCancerController {
def StageOfCancerService stageOfCancerService
def UserService userService
    def index() { }
	
	def view()
	{
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
		try
		{
			// for loading front end
			def diagnosisList=Diagnosis.createCriteria().list() {
	}
			def viewStageOfCancer=stageOfCancerService.viewAll(params)
			println "viewStageOfCancer;;;;;;;;;;;;;;;;"+viewStageOfCancer
			
			def patientDiagnosisList=PatientDiagnosis.createCriteria().list() {
			}
			println "patientDiagnosisList;;;;;;;;;;;;;;;;"+patientDiagnosisList
			
			/*def stageCancerI=TempQuestionOption.createCriteria().list() {
				eq("questionName","Stage of cancer")
				eq("value","I")
		}
		println "stageCancerI;;;;;;;;;;;;;;;;"+stageCancerI
		println "stageCancerI;;;;;;;;;;;;;;;;"+stageCancerI.size()
		
		def stageCancerII=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","II")
	}
		println "stageCancerII;;;;;;;;;;;;;;;;"+stageCancerII
		println "stageCancerII;;;;;;;;;;;;;;;;"+stageCancerII.size()
		
		def stageCancerIIA=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","IIA")
	}
		println "stageCancerIIA;;;;;;;;;;;;;;;;"+stageCancerIIA
		println "stageCancerIIA;;;;;;;;;;;;;;;;"+stageCancerIIA.size()
		
		def stageCancerIIB=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","IIB")
	}
		println "stageCancerIIB;;;;;;;;;;;;;;;;"+stageCancerIIB
		println "stageCancerIIB;;;;;;;;;;;;;;;;"+stageCancerIIB.size()
		def stageCancerIIIA=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","IIIA")
	}
		
		println "stageCancerIIIA;;;;;;;;;;;;;;;;"+stageCancerIIIA
		println "stageCancerIIIA;;;;;;;;;;;;;;;;"+stageCancerIIIA.size()
		def stageCancerIIIC=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","IIIC")
	}
		println "stageCancerIIIC;;;;;;;;;;;;;;;;"+stageCancerIIIC
		println "stageCancerIIIC;;;;;;;;;;;;;;;;"+stageCancerIIIC.size()
		
		def stageCancerIV=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","IV")
	}
		println "stageCancerIV;;;;;;;;;;;;;;;;"+stageCancerIV
		println "stageCancerIV;;;;;;;;;;;;;;;;"+stageCancerIV.size()
		
		def Recurrent=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","Recurrent")
	}
		println "Recurrent;;;;;;;;;;;;;;;;"+Recurrent
		println "Recurrent;;;;;;;;;;;;;;;;"+Recurrent.size()
		
		def Dontknow=TempQuestionOption.createCriteria().list() {
			eq("questionName","Stage of cancer")
			eq("value","Dont know")
	}
		
		println "Dontknow;;;;;;;;;;;;;;;;"+Dontknow
		println "Dontknow;;;;;;;;;;;;;;;;"+Dontknow.size()*/
			
			[diagnosisList:diagnosisList]
		}
		catch(Exception x)
		{
			println x
		}
		}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	
	
	
	def patientCount()
	{
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
		//Over ALL Count
					def patientCountVal=Patient.count
					
					
		//LastMonth Count
						def lastMonthCount=Patient.all
						Calendar aCalendar = Calendar.getInstance();
						aCalendar.add(Calendar.MONTH, -1);
						aCalendar.set(Calendar.DATE, 1);
						Date firstDateOfPreviousMonth = aCalendar.getTime();
								// set actual maximum date of previous month
						aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
								//read it
						Date lastDateOfPreviousMonth = aCalendar.getTime();
						def firstDateOfPreviousMonth1 = new SimpleDateFormat("yyyy-MM-dd").format(firstDateOfPreviousMonth)
						def	 lastDateOfPreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);
						def lastMonth = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth1+"') and DATE('"+lastDateOfPreviousMonth2+"')");
		
						
						
		//JAN-JUN Month Count
						//def sixMonth = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+firstDateOfPreviousMonth1+"') and DATE('"+lastDateOfPreviousMonth2+"')");
						def currentYear = Calendar.getInstance().get(Calendar.YEAR);
						def janFirstDate=currentYear+"-01-01"
						def JunLastDate=currentYear+"-06-30"
						def janToJunMonthCount = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+janFirstDate+"') and DATE('"+JunLastDate+"')");
					
		//JUL-DEC Month Count
						def julFirstDate=currentYear+"-07-01"
						def decLastDate=currentYear+"-12-31"
						def julToDecMonthCount = Patient.executeQuery("select ae from Patient ae  where DATE(ae.rowCreated) between DATE('"+julFirstDate+"') and DATE('"+decLastDate+"')");
		//Last Six Month Count
						aCalendar.add(Calendar.MONTH, -6);
						aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
						Date PreviousMonth = aCalendar.getTime();
						def PreviousMonth1 = new SimpleDateFormat("yyyy-MM-dd").format(PreviousMonth)
						def	 PreviousMonth2= new SimpleDateFormat("yyyy-MM-dd").format(lastDateOfPreviousMonth);
		[patientCountVal:patientCountVal,lastMonth:lastMonth.size(),janToJunMonthCount:janToJunMonthCount.size(),julToDecMonthCount:julToDecMonthCount.size()]
	}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	def cancerTypeCount()
	{
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
		
		def diagnosisCount=Diagnosis.createCriteria().list {
		}
		def patientDiagnosisCount=PatientDiagnosis.all
		def	breastCount=0;
		def lungCount=0;
		def colonCount=0;
		def prostateCount=0;
		def skinCount=0;
		def kidneyCount=0;
		def bladderCount=0;
		def nHLCount=0;
		def leukemiaCount=0;
		def endometrialCount=0;
		def stomachCount=0;
		def brainCount=0;
		def ovaryCount=0;
		def otherCount=0;
			
		/*for(int i=0;i<patientDiagnosisCount?.diagnosis?.diagnosisName?.size();i++)
		{
			if("Breast Cancer" == patientDiagnosisCount?.diagnosis?.diagnosisName)
			{
				println "patientDiagnosisCount;;;;;;;;;;"+patientDiagnosisCount?.diagnosis?.diagnosisName
			}
		}*/
		
		def patientDiagnosisCount1=PatientDiagnosis.createCriteria().list {
		
		}
		
		for(int i=0;i<patientDiagnosisCount1?.diagnosis?.diagnosisName?.size();i++)
		{
				println "patientDiagnosisCount1?.diagnosis?.diagnosisName;;;;;;;;;;"+patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Breast")
			{
				breastCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Lung")
			{
				lungCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Colon")
			{
				colonCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Prostate")
			{
				prostateCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Skin")
			{
				skinCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Kidney")
			{
				kidneyCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Bladder")
			{
				bladderCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="NHL")
			{
				nHLCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Leukemia")
			{
				leukemiaCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Endometrial")
			{
				endometrialCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Stomach")
			{
				stomachCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Brain")
			{
				brainCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Ovary")
			{
				ovaryCount++;
			}
			
			if(patientDiagnosisCount1?.diagnosis?.diagnosisName.get(i)=="Other")
			{
				otherCount++;
			}
		}
		
		[diagnosisCount:diagnosisCount,breastCount:breastCount,
		 lungCount:lungCount,
		colonCount:colonCount,
		 prostateCount:prostateCount,
		skinCount:skinCount,
		kidneyCount:kidneyCount,
		bladderCount:bladderCount,
		nHLCount:nHLCount,
		 leukemiaCount:leukemiaCount,
		 endometrialCount:endometrialCount,
		stomachCount:stomachCount,
		 brainCount:brainCount,
		 ovaryCount:ovaryCount,
		otherCount:otherCount]
		
		
		
	}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	def stageOfCancerCount()
	{
		
	}
	
	def breastCountList(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
		//def breastCounts = PatientDiagnosis.executeQuery("select patient from PatientDiagnosis   where diagnosis_fk='1'");
		//println "breastCount11"+breastCounts?.person?.fullName
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		println "test"+PatientDiagnosis.list()?.size()
		
		[users : stageOfCancerService.getBreastCancerList(params),total:PatientDiagnosis.list()?.size(),offset:0 ,max : params.max,searchValue:""]
	}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	
	def lungCancerList(){
		if(session.user && session.authority !=null && (session.authority?.equalsIgnoreCase(Role.admin) || session.authority.equalsIgnoreCase(Role.SuperAdmin))){
		def lungCancerList = PatientDiagnosis.executeQuery("select patient from PatientDiagnosis   where diagnosis_fk='2'");
		println "breastCount11"+lungCancerList?.person?.fullName
		
		[lungCancerList:lungCancerList]
	}
		else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	
	def ajaxPaginate(){
		try{
			println "jj"
			println"hiii"+ stageOfCancerService.getCount(params)
			render (template :'breastList' ,model:[users : stageOfCancerService.getBreastCancerList(params) ,total:stageOfCancerService.getCount(params) ,offset:params.offset ,max :params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	def searchValues(){
		try{
			println "sss"+stageOfCancerService.getBreastCancerList(params)
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"breastList",model:[users : stageOfCancerService.getBreastCancerList(params) ,total:stageOfCancerService.getCount(params),offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){ exception.printStackTrace() }
	}
}
