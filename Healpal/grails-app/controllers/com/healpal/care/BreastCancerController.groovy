package com.healpal.care

class BreastCancerController {

	def BreastCancerService breastCancerService
	
    def index() {
		try{
			HealpalUser user = session.user
			println "BreastCancerController . index called"
				if(params.agree != null && !params.agree.toString().isEmpty()){
					session.healpalAgree = params.agree
					TermsAcceptance terms = breastCancerService.termsAccept(user)
				}else{
					session.healpalAgree = null
				}
			println params.agree
			
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	
	def view(){
		
		try{
			ArrayList list = new ArrayList();
			HashMap map = new HashMap();
			map.put("About", "AboutBreastCancer");
			map.put("Diagnosis", "DiagnosisOfBreastCancer");
			map.put("Treatment Options", "TreatmentOptions");
			map.put("Prevention and Early Detection", "PreventionAndEarlyDetection");
			map.put("Clinical Trails", "ClinicalTrials");
			map.put("Copying Lifestyle", "CopyingAndLifeStyleIssues");
			println"map"+map
			[map:map]
		
		}
		catch(Exception exception){
			exception.printStackTrace()
		}
		
		
	}
	
	def cancerContentPage(){
		ArrayList obj=new ArrayList();
		ArrayList obj1;
		ArrayList obj2;
		def groupValue
		try{
			def cancerSection = params.matches
			//println "cancerSection"+cancerSection
		
		def cancerVal = CancerContentRate.executeQuery("Select c.cancerContentPage, SUM(c.satisfactoryCount) ,SUM(c.perfectCount),SUM(c.notClearCount),SUM(c.notWhatIWantedCount)  from CancerContentRate c Where c.cancerContentSection = '"+cancerSection+"' group by c.cancerContentSection ,c.cancerContentPage ,c.cancerType ")
		println "cancerVal;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+cancerVal
		for(int i=0;i<cancerVal.size();i++){
			 groupValue = cancerVal.get(i);
			println "groupValue;;;;;;;;;;;;;;;;;;;"+groupValue
		}
		render(template:'count', model:[cancerVal:cancerVal] )

		}
		catch(Exception exception){
			exception.printStackTrace()
		}
	}
	

	
	
	
}
