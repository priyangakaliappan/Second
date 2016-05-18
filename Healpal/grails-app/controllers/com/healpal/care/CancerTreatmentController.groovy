package com.healpal.care

class CancerTreatmentController {
   static CancerTreatmentService cancerTreatmentService
   
    def index() { }

	def saveRate(){
		try{
			printme('saveRate' ,'save rate initiated')
				
				if(params != null && params.title != null && params.type != null ){
				
					CancerTreatmentRate content = cancerTreatmentService . save(params ,session)
					if(content.validate()){
						render 'Thanks a lot for your response. We shall have more information coming soon.'
					}else{
						render 'Thanks'
					}
				
				}
	
		}catch(Exception exception){
			render 'Thanks'
			exception . printStackTrace()
		}
	}
	def printme(action ,msg){
		println ">> CancerTreatmentController . " +action+'.'+msg
	}
	
	def view(){
		def groupValue
		try{
			def cancerVal = CancerTreatmentRate.executeQuery("Select c.cancerType, SUM(c.satisfactoryCount) ,SUM(c.perfectCount),SUM(c.notClearCount),SUM(c.notWhatIWantedCount)  from CancerTreatmentRate c  group by c.cancerType ")
			println "cancerVal;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;"+cancerVal
			for(int i=0;i<cancerVal.size();i++){
				 groupValue = cancerVal.get(i);
				println "groupValue;;;;;;;;;;;;;;;;;;;"+groupValue
			}
			[cancerVal:cancerVal] 
		
		}
		catch(Exception exception){
			exception.printStackTrace()
		}
		
		
	}
	
	
	
	}
