/*
 * Author    : Manikandan
 * Project   : Healpal
 * Date      : 10/01/2016
 * Description : User Authentication and Authorization
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Manikandan    1.0    10/02/2016        Initial Creation
 *
 */
package com.healpal.care
import com.healpal.care.BreastCancerService

class BreastContentController {
static BreastCancerService breastCancerService
    def index() { }
	
	def understandingNumber(){
		[	number:'selected'
			,section:CancerContentRate.about 
			,page:CancerContentRate.about_number
			,sectionAbout : "breast-2b" , previousControl:false ,nextControl:true ,
			nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session ,CancerContentRate.about ,CancerContentRate.about_number)
		]
	}
	
	def normalStructureOfTheBreast(){
		[structure:'selected' ,section:CancerContentRate.about 
			,page:CancerContentRate.about_structure,sectionAbout : "breast-2b", previousControl:false ,nextControl:true 
			,nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session ,CancerContentRate.about ,CancerContentRate.about_structure)
		]
    }
	
	def symptomsAndSigns(){
		[symtoms:'selected' ,section:CancerContentRate.about 
			,page:CancerContentRate.about_symptoms,sectionAbout : "breast-2b", previousControl:false ,nextControl:true 
			,nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session,CancerContentRate.about ,CancerContentRate.about_symptoms)
			]
	}
	
	def causesAndRiskFactors(){
		[refactors:'selected' ,section:CancerContentRate.about 
			,page:CancerContentRate.about_risk,sectionAbout : "breast-2b", previousControl:false ,nextControl:true 
			,nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session,CancerContentRate.about ,CancerContentRate.about_risk)
		]
	}
	
	def secondaryBreastCancer(){
		[metastatic:'selected',section:CancerContentRate.about 
			,page:CancerContentRate.about_secondary,sectionAbout : "breast-2b", previousControl:false ,nextControl:true 
			,nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session,CancerContentRate.about ,CancerContentRate.about_secondary)
			]
	}
	
	def questionsToAskYourDoctorOnTheFirstVisit(){
		[question:'selected' ,section:CancerContentRate.about 
			,page:CancerContentRate.about_question,sectionAbout : "breast-2b", previousControl:false ,nextControl:true 
			,nextTxt:CancerContentRate.section_diagnosis ,nexAction:CancerContentRate.section_diagnosis_action,
			list: cancerContentService .commentList(session,CancerContentRate.about ,CancerContentRate.about_question)
			]
	}
	
	
	/*
	 * 
	 * 
	 * For Diagnosis
	 * 
	 * 
	 */
	
	def theTest(){
		[	theTest:'selected'
			,section:CancerContentRate.diagnosis
			,page:CancerContentRate.diag_test,sectionAbout : "breast-2" ,sectionDiagnosis:'active' ,previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_test)
			
		]
	}
	def confirmationOfDiagnosis(){
		[	confirm:'selected'
			,section:CancerContentRate.diagnosis
			,page:CancerContentRate.diag_confirm,sectionAbout : "breast-2",sectionDiagnosis:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_confirm)
		]
	}
	def breastCancerTumorMarkers(){
		[	tumor:'selected'
			,section:CancerContentRate.diagnosis
			,page:CancerContentRate.diag_tumor,sectionAbout : "breast-2",sectionDiagnosis:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_tumor)
		]
	}
	def understandingTestResults(){
		[	result:'selected'
			,section:CancerContentRate.diagnosis
			,page:CancerContentRate.diag_result,sectionAbout : "breast-2",sectionDiagnosis:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_result)
		]
	}
	def typesAndStagesOfBreastCancer(){
		[	types:'selected'
			,section:CancerContentRate.diagnosis
			,page:CancerContentRate.diag_types,sectionAbout : "breast-2",sectionDiagnosis:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_types)
		]
	}
	def questionsToAskYourDoctorRegardingADiagnosis(){
		[	question:'selected'
			,section:CancerContentRate.about
			,page:CancerContentRate.diag_question,sectionAbout : "breast-2",sectionDiagnosis:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_about ,nextTxt:CancerContentRate.section_treatment 
			,preAction:CancerContentRate.section_about_action ,nexAction:CancerContentRate.section_treatment_action
			,list: cancerContentService .commentList(session ,CancerContentRate.diagnosis ,CancerContentRate.diag_question)
		]
	}
	
	/*
	 * 
	 * TreatmentOptions
	 * 
	 * 
	 */
	
	
	def knowYourBreastCancerCareTeam(){
		[	team:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_team,sectionAbout : "breast-2" ,sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_team)
		]
		
	}
	def treatmentOptions(){
		[	options:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_option,sectionAbout : "breast-2",sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_option)
		]
	
		}
	def alternativeMedicine(){
		[	medicine:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_medicine,sectionAbout : "breast-2",sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_medicine)
		]
	
		}
	def treatmentBasedOnStaging(){
		[	staging:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_staging,sectionAbout : "breast-2",sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_staging)
		]
	
		}
	def sideEffectsOfTreatment(){
		[	effects:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_effects,sectionAbout : "breast-2",sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_effects)
		]
	
		}
	def questionsToAskYourDoctorRegardingBreastCancerTreatment(){
		[	question:'selected'
			,section:CancerContentRate.treatment
			,page:CancerContentRate.treat_question,sectionAbout : "breast-2",sectionTreatment:'active',previousControl:true  
			,nextControl:true ,prevTxt:CancerContentRate.section_diagnosis ,nextTxt:CancerContentRate.section_prevention 
			,preAction:CancerContentRate.section_diagnosis_action ,nexAction:CancerContentRate.section_prevention_action
			,list: cancerContentService .commentList(session ,CancerContentRate.treatment ,CancerContentRate.treat_question)
		]
	
		}
	
	/*
	 * 
	 * preventioEarlyDetection
	 * 
	 * 
	 */
	
	def mammorgam(){
		[	mammogram:'selected'
			,section:CancerContentRate.prevention
			,page:CancerContentRate.prevent_mammogram,sectionAbout : "breast-2",sectionPrevention:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_treatment ,nextTxt:CancerContentRate.section_clinical 
			,preAction:CancerContentRate.section_treatment_action ,nexAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.prevention ,CancerContentRate.prevent_mammogram)
		]
	}
	def additionalScreeningTest(){
		[	screening:'selected'
			,section:CancerContentRate.prevention
			,page:CancerContentRate.prevent_screening,sectionAbout : "breast-2",sectionPrevention:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_treatment ,nextTxt:CancerContentRate.section_clinical 
			,preAction:CancerContentRate.section_treatment_action ,nexAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.prevention ,CancerContentRate.prevent_screening)
		]
}
	/*def payingForBreastCancerScreening(){
	
}
	def medicinesToReduceBreast(){
	
}*/
	def ammericanCancerSocietyRecommendationFor(){
		[	aes:'selected'
			,section:CancerContentRate.prevention
			,page:CancerContentRate.prevent_aes,sectionAbout : "breast-2",sectionPrevention:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_treatment ,nextTxt:CancerContentRate.section_clinical 
			,preAction:CancerContentRate.section_treatment_action ,nexAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.prevention ,CancerContentRate.prevent_aes)
		]
	}
	

	def questionsToAskYourDoctorRegardingBreastCancerScreening(){
		[	question:'selected'
			,section:CancerContentRate.prevention
			,page:CancerContentRate.prevent_question,sectionAbout : "breast-2",sectionPrevention:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_treatment ,nextTxt:CancerContentRate.section_clinical 
			,preAction:CancerContentRate.section_treatment_action ,nexAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.prevention ,CancerContentRate.prevent_question)
		]
}
	
	
/*
 * clinicalTrial
 * 	
 */
	def understandingClinicalTrial(){
		[	understanding:'selected'
			,section:CancerContentRate.clinic
			,page:CancerContentRate.clinic_understanding,sectionAbout : "breast-2",sectionClinical:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_prevention 
			,nextTxt:CancerContentRate.section_lifestyle ,preAction:CancerContentRate.section_prevention_action ,nexAction:CancerContentRate.section_lifestyle_action
			,list: cancerContentService .commentList(session ,CancerContentRate.clinic ,CancerContentRate.clinic_understanding)
		]
	}
	
	//def typesOfClinicalTrials(){}
	def whereCanIFindAClinicalTrial(){
		[	where:'selected'
			,section:CancerContentRate.clinic
			,page:CancerContentRate.clinic_where,sectionAbout : "breast-2",sectionClinical:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_prevention ,nextTxt:CancerContentRate.section_lifestyle 
			,preAction:CancerContentRate.section_prevention_action ,nexAction:CancerContentRate.section_lifestyle_action
			,list: cancerContentService .commentList(session ,CancerContentRate.clinic ,CancerContentRate.clinic_where)
		]
	}
	def questionsToAskYourDoctorRegardingAClinicalTrials(){
		[	question:'selected'
			,section:CancerContentRate.clinic
			,page:CancerContentRate.clinic_question,sectionAbout : "breast-2",sectionClinical:'active'
			,previousControl:true  ,nextControl:true ,prevTxt:CancerContentRate.section_prevention ,nextTxt:CancerContentRate.section_lifestyle 
			,preAction:CancerContentRate.section_prevention_action ,nexAction:CancerContentRate.section_lifestyle_action
			,list: cancerContentService .commentList(session ,CancerContentRate.clinic ,CancerContentRate.clinic_question)
		]
	}

/*
 * 
 * 
 * copingLifeStyle
 */ 


def nutrition (){
	[	nutrition:'selected'
		,section:CancerContentRate.lifeStyle
		,page:CancerContentRate.style_nutrition,sectionAbout : "breast-2",sectionLifestyle:'active'
		,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
		,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_nutrition)
	]
}

def rehabilitationAndExercise (){
	[	exercise:'selected'
		,section:CancerContentRate.lifeStyle
		,page:CancerContentRate.style_exercise,sectionAbout : "breast-2",sectionLifestyle:'active'
		,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
		,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_exercise)
	]
}

def sexualHealthAndFertility (){
	[	fertility:'selected'
		,section:CancerContentRate.lifeStyle
		,page:CancerContentRate.style_fertility,sectionAbout : "breast-2",sectionLifestyle:'active'
		,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
		,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_fertility)
	]
}
def copingWithFatigueAndStress (){
	[	stress:'selected'
			,section:CancerContentRate.lifeStyle
			,page:CancerContentRate.style_stress,sectionAbout : "breast-2",sectionLifestyle:'active'
			,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_stress)
		]
}
def palliativeCareAndPainManagement (){
	[	pain:'selected'
			,section:CancerContentRate.lifeStyle
			,page:CancerContentRate.style_pain,sectionAbout : "breast-2",sectionLifestyle:'active'
			,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_pain)
		]
}
def gettingInvolvedWithHealpal (){
	[	involved:'selected'
			,section:CancerContentRate.lifeStyle
			,page:CancerContentRate.style_involved,sectionAbout : "breast-2",sectionLifestyle:'active'
			,previousControl:true  ,prevTxt:CancerContentRate.section_clinical ,preAction:CancerContentRate.section_clinical_action
			,list: cancerContentService .commentList(session ,CancerContentRate.lifeStyle ,CancerContentRate.style_involved)
		]
}


def cancerContentService
def saveRate(){
	try{
		printme('saveRate' ,'save rate initiated')
//		if(session != null && session.user != null && 
//			session.authority?.equalsIgnoreCase(Role.patient) ){
			
			if(params != null 
			&& params.section != null && !params.section.toString().isEmpty()
			&& params.page != null && !params.page.toString().isEmpty()
			&& params.type != null && !params.type.toString().isEmpty()){
			
				CancerContentRate content = cancerContentService . save(params ,session)
				if(content.validate()){
					render 'Thanks a lot for your response. We shall have more information coming soon.'
				}else{
					render 'Thanks.'
				}
			
			}
//		}else{
//			render 'Please signin '
//		}
	}catch(Exception exception){
		render 'Thanks'
		exception . printStackTrace()
	}
}


def commentSave(){
	try{
		if(session != null && session.user != null && 
			session.authority?.equalsIgnoreCase(Role.patient) ){
		
			CancerContentComment comment = cancerContentService . saveComment(session ,params)
			if(comment.validate()){
				render(template:'comment' ,model:[list: cancerContentService .commentList(session ,params.section ,params.page)])
			}else{
				render('Thanks')
			}
		}else{
			render 'You need to be signed in to comment.'
		}
	}catch(Exception exception){
		render 'Thanks'
		exception.printStackTrace()
	}
}


def getComments(){
	try{
		printme("getComments", "called")
		render(template:'comment' ,model:[list: cancerContentService .commentList(session)])
	}catch(Exception exception){
		exception . printStackTrace()
	}
}


def printme(action ,msg){
	println ">> BreastContentController . " +action+'.'+msg
}

def shareLink(){
	try{
	def userName=params.yourName;
	def url = params.url
	def isSentMail = null;
	def sentEmail=params.emails
	if(sentEmail.toString()!="" && sentEmail.toString().contains(",")){
		println "multipleeeee:::::::::: "
		String[] tokens = sentEmail.split(",");
		println "TOKENS::::: "+tokens
		for(String sendtoMail:tokens){
			isSentMail = breastCancerService.shareLink(sendtoMail,userName,url)
		}
	}
	else{
		println "singleeeee:::::::::: "
		if(sentEmail && sentEmail!=null && !sentEmail.isEmpty()){
		isSentMail = breastCancerService.shareLink(sentEmail,userName,url)
	}
	}	
	if(sentEmail !=null && sentEmail!=""){
		render "true"
	}
	else{
		render "false"
	}
	
	}catch(Exception e){
	e.printStackTrace();
	}
	
	}





}




