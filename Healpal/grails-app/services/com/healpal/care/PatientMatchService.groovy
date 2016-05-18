/**
 * Author    : Thirumal R
 * Project   : HealPal
 * Date      : 11/02/2015
 * FileName  : PatientMatchService
 *
 * #      Name         Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1      Thirumal R     1.0       11/02/2015      Initial Creation
 *
 *
 **/
package com.healpal.care

import java.text.DecimalFormat
import java.text.SimpleDateFormat;
import groovy.transform.Synchronized
import grails.transaction.Transactional

@Transactional
class PatientMatchService {

    def serviceMethod() {

    }
	
	//*****************Batch Process for Patient Match starts***********************
	@Synchronized
	def doBatchProcess(){
		Patient currentPatient = null;
		TreeMap patientMatchMap = null;
		try{
			// println "PatientMatchService-doBatchProcess()---> Background Process start for patient Match!!!!!!!!"
			def patientList = Patient.createCriteria().list{
				eq("isActive",Short.valueOf("1"))
			}
			if(patientList!=null && patientList.size()>0){
				for(int i=0;i<patientList.size();i++){
					patientMatchMap = new TreeMap();
				     currentPatient = patientList.get(i);
					 if(currentPatient!=null && !currentPatient.equals("")){
						 def patientCancerTypeName = getPatientCancerTypeName(currentPatient);
						 def patientMasterCancerName = Diagnosis.findByDiagnosisName("Breast")?.diagnosisName;
						 if(patientCancerTypeName!=null && !patientCancerTypeName.equals("") && patientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
						 def patientStageOfCancer = getPatientStageOfCancer(currentPatient);
						 def ageOfDiagnosis    = getAgeOfDiagnosis(currentPatient);
						 def herStatusPositive = getHerStatusPositive(currentPatient);
						 def herStatusNegative = getHerStatusNegative(currentPatient);
						 def erStatusPositive  =  getErStatusPositive(currentPatient);
						 def erStatusNegative  =  getErStatusNegative(currentPatient);
						 def prStatusPositive  =  getPrStatusPositive(currentPatient);
						 def prStatusNegative  =  getPrStatusNegative(currentPatient);
						 def patientDob = currentPatient?.person?.dob
						 def patientRace = getRace(currentPatient);
						 def patientPathologic = getPathologicType(currentPatient);
						 def patientZipCode = getPatientZipCode(currentPatient);
						 def patientMedicalConditionType = getPatientMedicalConditionType(currentPatient);
						 def patientEducationType = getPatientEducationType(currentPatient);
						// def patientHealthInsuranceType = getPatientHealthInsurance(currentPatient);
						 def mPatientList = Patient.createCriteria().list{
							 eq("isActive",Short.valueOf("1"))
							 ne("id",currentPatient?.id)
						 }
						 if(mPatientList!=null && mPatientList.size >0){
							 for(int j=0;j<mPatientList.size();j++){
								 int points = 0;
								 def mPatient = mPatientList.get(j);
								 if(mPatient !=null && !mPatient.equals("")){
									 def mPatientCancerTypeName = getPatientCancerTypeName(mPatient);
										 if(mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("") && mPatientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
											 //*************** Static *************************
											 def mPatientStageOfCancer = getPatientStageOfCancer(mPatient);
											 def mAgeOfDiagnosis = getAgeOfDiagnosis(mPatient);
											 def mPatientDob = mPatient?.person?.dob
											 def mPatientRace = getRace(mPatient);;
											 def mPatientZipCode = getPatientZipCode(mPatient);
											 def mPatientEducationType = getPatientEducationType(mPatient);
											// def mPatientHealthInsuranceType = getPatientHealthInsurance(mPatient);
											 
											 //*************** Dynamic *************************
											 def mHerStatusPositive = getHerStatusPositive(mPatient);
											 def mHerStatusNegative = getHerStatusNegative(mPatient);
											 def mErStatusPositive =  getErStatusPositive(mPatient);
											 def mErStatusNegative =  getErStatusNegative(mPatient);
											 def mPrStatusPositive =  getPrStatusPositive(mPatient);
											 def mPrStatusNegative =  getPrStatusNegative(mPatient);
											 def mPatientPathologic = getPathologicType(mPatient);
											 def mPatientMedicalConditionType = getPatientMedicalConditionType(mPatient);
											 
											 // ******************* points *******************************
											 
											 //*************** Static *************************
											 def cancerTypePoints = getCancerTypePoints(mPatientCancerTypeName,patientCancerTypeName);
											 def ageOfDiagnosisPoints = getAgeOfDiagnosisPoints(mAgeOfDiagnosis,ageOfDiagnosis);
											 def cancerStagePoints = getCencerStagePoints(mPatientStageOfCancer,patientStageOfCancer);
											 def racePoints = getRacePoints(mPatientRace,patientRace);
											 def zipCodePoints = getZipcodePoints(mPatientZipCode,patientZipCode);
											 def educationPoints = getEducationPoints(mPatientEducationType,patientEducationType);
											 def healthInsurancePoints = getPatientHealthInsurancePoints(currentPatient,mPatient);
											 def dobPoints = getDobPoints(patientDob,mPatientDob);
											 
											 //*************** Dynamic *************************
											 def treatmentPoints = getTreatmentPoints(currentPatient,mPatient);
											 def herStatusPositivePoints = getHerStatusPositivePoints(mHerStatusPositive,herStatusPositive);
											 def herStatusNegativePoints = getHerStatusNegativePoints(mHerStatusNegative,herStatusNegative);
											 def erStatusPositivePoints =  getErStatusPositivePoints(mErStatusPositive,erStatusPositive);
											 def erStatusNegativePoints =  getErStatusNegativePoints(mErStatusNegative,erStatusNegative);
											 def prStatusPositivePoints =  getPrStatusPositivePoints(mPrStatusPositive,prStatusPositive);
											 def prStatusNegativePoints =  getPrStatusNegativePoints(mPrStatusNegative,prStatusNegative);
											 def pathologicPoints = getPathologicPoints(mPatientPathologic,patientPathologic);
											 def medicalConditionPoints = getMedicalConditionPoints(mPatientMedicalConditionType,patientMedicalConditionType);
											 points = cancerTypePoints + ageOfDiagnosisPoints + cancerStagePoints + dobPoints + racePoints + zipCodePoints + medicalConditionPoints + educationPoints + healthInsurancePoints + pathologicPoints + herStatusPositivePoints + herStatusNegativePoints + erStatusPositivePoints + erStatusNegativePoints + prStatusPositivePoints + prStatusNegativePoints + treatmentPoints;
											 patientMatchMap.put(mPatient?.id,points)
											 }else{
												// println "PatientMatchService-doBatchProcess()---> current patient do not have Breast Cancer!!!!!!!"
										  }
								 }else{
								 // println "PatientMatchService-doBatchProcess()---> mPatient is empty!!!!!!!!"
								 }
								 
							 }
						 }else{
						 // println "PatientMatchService-doBatchProcess()---> mPatient list is empty!!!!!!!!"
						 }
					 }else{
						// println "PatientMatchService-doBatchProcess()---> current patient do not have Breast Cancer!!!!!!!"
					 }
					 }else{
						  // println "PatientMatchService-doBatchProcess()---> healpal current patient is null..!!!!!!!!"
					 }
					 
					 if(patientMatchMap!=null && patientMatchMap.size() > 0){
						// PatientMatch.executeUpdate("DELETE FROM PatientMatch p WHERE p.currentPatient=?",[currentPatient]);
						 List list = new LinkedList(patientMatchMap.entrySet());
					     //put sorted list into map again
						 for (Iterator it = list.iterator(); it.hasNext();) {
							 Map.Entry entry = (Map.Entry)it.next();
							 Patient matchPatient = Patient.get(entry.getKey()?.toString().toLong());
							 def percentage = calPercentage(entry.getValue());
							 insertPatientMatch(matchPatient,currentPatient,percentage);
						 }
					}else{
					  //  println "PatientMatchService-doBatchProcess()--> patientMatchMap list is empty!!!!!!!!"
					}
				}
			}else{
			// println "PatientMatchService-doBatchProcess()-Patient list is empty!!!!!";
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
  //******************Batch Process for Patient Match ends *************************
	
	
	
//******************Batch Process for currentPatiient *************************
	
	def doBatchProcessForCurrentPatient(def healpalUser){
		Patient currentPatient = null;
		TreeMap patientMatchMap = null;
		def patientList;
		try{
			       patientMatchMap = new TreeMap();
			      // println "PatientMatchService-doBatchProcess()---> Background Process start for current patient Match!!!!!!!!"
			         def currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
					 //println "currentPerson::::::::::::::::::::::::::"+currentPerson
					 if(currentPerson!=null && !currentPerson.equals("")){
						  currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
						 //println "currentPatient:::::::::::::::::::::::"+currentPatient
					 }else{
						//do nothing
					 }
			         if(currentPatient!=null && !currentPatient.equals("")){
						 def patientCancerTypeName = getPatientCancerTypeName(currentPatient);
						 def patientMasterCancerName = Diagnosis.findByDiagnosisName("Breast")?.diagnosisName;
						 if(patientCancerTypeName!=null && !patientCancerTypeName.equals("") && patientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
						 def patientStageOfCancer = getPatientStageOfCancer(currentPatient);
						 def ageOfDiagnosis    = getAgeOfDiagnosis(currentPatient);
						 def herStatusPositive = getHerStatusPositive(currentPatient);
						 def herStatusNegative = getHerStatusNegative(currentPatient);
						 def erStatusPositive  =  getErStatusPositive(currentPatient);
						 def erStatusNegative  =  getErStatusNegative(currentPatient);
						 def prStatusPositive  =  getPrStatusPositive(currentPatient);
						 def prStatusNegative  =  getPrStatusNegative(currentPatient);
						 def patientDob = currentPatient?.person?.dob
						 def patientRace = getRace(currentPatient);
						 def patientPathologic = getPathologicType(currentPatient);
						 def patientZipCode = getPatientZipCode(currentPatient);
						 def patientMedicalConditionType = getPatientMedicalConditionType(currentPatient);
						 def patientEducationType = getPatientEducationType(currentPatient);
						// def patientHealthInsuranceType = getPatientHealthInsurance(currentPatient);
						 def mPatientList = Patient.createCriteria().list{
							 eq("isActive",Short.valueOf("1"))
							 ne("id",currentPatient?.id)
						 }
						 if(mPatientList!=null && mPatientList.size >0){
							 for(int j=0;j<mPatientList.size();j++){
								 int points = 0;
								 def mPatient = mPatientList.get(j);
								 if(mPatient !=null && !mPatient.equals("")){
									 def mPatientCancerTypeName = getPatientCancerTypeName(mPatient);
										 if(mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("") && mPatientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
											 //*************** Static *************************
											 def mPatientStageOfCancer = getPatientStageOfCancer(mPatient);
											 def mAgeOfDiagnosis = getAgeOfDiagnosis(mPatient);
											 def mPatientDob = mPatient?.person?.dob
											 def mPatientRace = getRace(mPatient);;
											 def mPatientZipCode = getPatientZipCode(mPatient);
											 def mPatientEducationType = getPatientEducationType(mPatient);
											// def mPatientHealthInsuranceType = getPatientHealthInsurance(mPatient);
											 
											 //*************** Dynamic *************************
											 def mHerStatusPositive = getHerStatusPositive(mPatient);
											 def mHerStatusNegative = getHerStatusNegative(mPatient);
											 def mErStatusPositive =  getErStatusPositive(mPatient);
											 def mErStatusNegative =  getErStatusNegative(mPatient);
											 def mPrStatusPositive =  getPrStatusPositive(mPatient);
											 def mPrStatusNegative =  getPrStatusNegative(mPatient);
											 def mPatientPathologic = getPathologicType(mPatient);
											 def mPatientMedicalConditionType = getPatientMedicalConditionType(mPatient);
											 
											 // ******************* points *******************************
											 
											 //*************** Static *************************
											 def cancerTypePoints = getCancerTypePoints(mPatientCancerTypeName,patientCancerTypeName);
											 def ageOfDiagnosisPoints = getAgeOfDiagnosisPoints(mAgeOfDiagnosis,ageOfDiagnosis);
											 def cancerStagePoints = getCencerStagePoints(mPatientStageOfCancer,patientStageOfCancer);
											 def racePoints = getRacePoints(mPatientRace,patientRace);
											 def zipCodePoints = getZipcodePoints(mPatientZipCode,patientZipCode);
											 def educationPoints = getEducationPoints(mPatientEducationType,patientEducationType);
											 def healthInsurancePoints = getPatientHealthInsurancePoints(currentPatient,mPatient);
											 def dobPoints = getDobPoints(patientDob,mPatientDob);
											 
											 //*************** Dynamic *************************
											 def treatmentPoints = getTreatmentPoints(currentPatient,mPatient);
											 def herStatusPositivePoints = getHerStatusPositivePoints(mHerStatusPositive,herStatusPositive);
											 def herStatusNegativePoints = getHerStatusNegativePoints(mHerStatusNegative,herStatusNegative);
											 def erStatusPositivePoints =  getErStatusPositivePoints(mErStatusPositive,erStatusPositive);
											 def erStatusNegativePoints =  getErStatusNegativePoints(mErStatusNegative,erStatusNegative);
											 def prStatusPositivePoints =  getPrStatusPositivePoints(mPrStatusPositive,prStatusPositive);
											 def prStatusNegativePoints =  getPrStatusNegativePoints(mPrStatusNegative,prStatusNegative);
											 def pathologicPoints = getPathologicPoints(mPatientPathologic,patientPathologic);
											 def medicalConditionPoints = getMedicalConditionPoints(mPatientMedicalConditionType,patientMedicalConditionType);
											 points = cancerTypePoints + ageOfDiagnosisPoints + cancerStagePoints + dobPoints + racePoints + zipCodePoints + medicalConditionPoints + educationPoints + healthInsurancePoints + pathologicPoints + herStatusPositivePoints + herStatusNegativePoints + erStatusPositivePoints + erStatusNegativePoints + prStatusPositivePoints + prStatusNegativePoints + treatmentPoints;
											 patientMatchMap.put(mPatient?.id,points)
												 if(patientMatchMap!=null && patientMatchMap.size() >=20 ){
													 j = mPatientList.size();
												 }
											 }else{
												// println "PatientMatchService-doBatchProcess()---> current patient do not have Breast Cancer!!!!!!!"
										  }
								 }else{
								//  println "PatientMatchService-doBatchProcess()---> mPatient is empty!!!!!!!!"
								 }
								
							 }
						 }else{
						//  println "PatientMatchService-doBatchProcess()---> mPatient list is empty!!!!!!!!"
						 }
					 }else{
						// println "PatientMatchService-doBatchProcess()---> current patient do not have Breast Cancer!!!!!!!"
					 }
					 }else{
						 //  println "PatientMatchService-doBatchProcess()---> healpal current patient is null..!!!!!!!!"
					 }
					 if(patientMatchMap!=null && patientMatchMap.size() > 0){
						// PatientMatch.executeUpdate("DELETE FROM PatientMatch p WHERE p.currentPatient=?",[currentPatient]);
						 List list = new LinkedList(patientMatchMap.entrySet());
						 //put sorted list into map again
						 for (Iterator it = list.iterator(); it.hasNext();) {
							 Map.Entry entry = (Map.Entry)it.next();
							 Patient matchPatient = Patient.get(entry.getKey()?.toString().toLong());
							 def percentage = calPercentage(entry.getValue());
							 insertPatientMatchForCurrentpatient(matchPatient,currentPatient,percentage);
						 }
					}else{
						// println "PatientMatchService-doBatchProcess()--> patientMatchMap list is empty!!!!!!!!"
					}
				
			
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

def insertPatientMatch(Patient matchPatient,Patient currentPatient,def percentage)throws Exception{
		try{
			if(matchPatient!=null && !matchPatient.equals("") && currentPatient!=null && !currentPatient.equals("") && percentage!=null && !percentage.toString().equals("")){
			  def isExist = PatientMatch.findByCurrentPatientAndPatient(currentPatient,matchPatient);
			  double percen = Double.parseDouble(percentage);
			  if(isExist!=null && !isExist.equals("")){
				  PatientMatch.executeUpdate("UPDATE  PatientMatch p set p.percentage=? WHERE p.currentPatient=? AND p.patient=?",[percen,currentPatient,matchPatient]);
				   }else{
				  PatientMatch pMatch = new PatientMatch();
				  pMatch.patient = matchPatient
				  pMatch.currentPatient = currentPatient
				  pMatch.percentage = percen
				  pMatch.isActive = (short)1
				  pMatch.rowCreated = new Date()
				  pMatch.save()
			  }
			 
			}
		}catch(Exception exception){
		  throw exception;
		}
}
def insertPatientMatchForCurrentpatient(Patient matchPatient,Patient currentPatient,def percentage)throws Exception{
		try{
			if(matchPatient!=null && !matchPatient.equals("") && currentPatient!=null && !currentPatient.equals("") && percentage!=null && !percentage.toString().equals("")){
			  def isExist = PatientMatch.findByCurrentPatientAndPatient(currentPatient,matchPatient);
			  double percen = Double.parseDouble(percentage);
			  if(isExist!=null && !isExist.equals("")){
				  //PatientMatch.executeUpdate("Delete from  PatientMatch p  WHERE p.currentPatient=? AND p.patient=?",[currentPatient,matchPatient]);
			  }else{
				  PatientMatch pMatch = new PatientMatch();
			  pMatch.patient = matchPatient
			  pMatch.currentPatient = currentPatient
			  pMatch.percentage = percen
			  pMatch.isActive = (short)1
			  pMatch.rowCreated = new Date()
			  pMatch.save()
			  }
			  
			}
		}catch(Exception exception){
		  throw exception;
		}
	}
	def calPercentage(def points)throws Exception{
		def percentage  ;
		
		try{
			 double percentageVal =  Math.round(points*100.0)/208.0;
			 DecimalFormat df = new DecimalFormat("###");
			 percentage = df.format(percentageVal);
		}catch(Exception exception){
			throw exception;
		}
		return percentage;
	}
	//**************************** Get All Patient Match List *********************
	 def getAllPatientMatch()throws Exception{
		 def isOtherpatientConnected;
		 def isReqSent;
		 def patientMatchList
		 try{
						 patientMatchList = PatientMatch.createCriteria().list(){
							  eq("isActive",Short.valueOf("1"))
							  order('percentage','desc')
							  
						   }
						 
		 }catch(Exception exception){
		   throw Exception;
		 }
		 return patientMatchList
	 }
	
	//**************************** Get Patient Match List *********************
	def getPatientMatch(def healpalUser,params)throws Exception{
		Patient currentPatient = null;
		Person currentPerson = null;
		def isOtherpatientConnected;
		def isReqSent;
		ArrayList matchedPatient = new ArrayList();
		def patientMatchList
		try{
			if(healpalUser!=null && !healpalUser.equals("")){
				currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
				if(currentPerson!=null && !currentPerson.equals("")){
					 currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
					 if(currentPatient!=null && !currentPatient.equals("")){
						 
						  patientMatchList = PatientMatch.createCriteria().list(){
							 eq("currentPatient",currentPatient)
							 eq("isActive",Short.valueOf("1"))
							 order('percentage','desc')
							 
						  }
						  //println "currentPatient::::::::::::::::::::::"+currentPatient
						  //println "patientMatchList::::::::::::::::::::::"+patientMatchList.size()
						  if(patientMatchList !=null && patientMatchList.size()>0){
							  for(int i=0;i<patientMatchList.size();i++){
								 def patientMatch = patientMatchList.get(i);
								  //println "patientMatch?.patient::::::"+patientMatch?.patient
								  if(patientMatch){
									  def isConnected = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(currentPatient,patientMatch?.patient,Short.valueOf("1"),Short.valueOf("1"));
									// println "isConnected:::::::::::::::"+isConnected
									   if(!isConnected){
										   isOtherpatientConnected = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(patientMatch?.patient,currentPatient,Short.valueOf("1"),Short.valueOf("1"));
									//	   println "isOtherpatientConnected:::::::::::::::"+isOtherpatientConnected
										   if(!isOtherpatientConnected){
										   isReqSent =   PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(patientMatch?.patient,currentPatient,Short.valueOf("0"),Short.valueOf("1"));
										//   println "isReqSent:::::::::::::::"+isReqSent
										   if(!isReqSent){
											matchedPatient.add(patientMatch);
									    }
									 }
									   
									}
								 }
							 }
							 // println "final matchedPatient::::size()"+matchedPatient.size()
						  }else{
						    //do nothing
						  }
					  }else{
					    // println "PatientMatchService-patientmatch()--> healpal patient is null..!!!!!!!!"
					  }
				}else{
				   //do nothing
				}
			}else{
			//  println "PatientMatchService-getPatientMatch()--> healpal user is null..!!!!!!!!"
			}
		}catch(Exception exception){
		  throw Exception;
		}
		return matchedPatient
	}
	//**************************** Get Patient Match List *********************
	 def getPatientMatchTotal(def healpalUser,def patientMatchSearch)throws Exception{
		 Patient currentPatient = null;
		 Person currentPerson = null;
		 def isOtherpatientConnected;
		 def isReqSent;
		 ArrayList matchedPatient = new ArrayList();
		 def patientMatchList
		 try{
			 if(healpalUser!=null && !healpalUser.equals("")){
				 currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
				 if(currentPerson!=null && !currentPerson.equals("")){
					  currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
					  if(currentPatient!=null && !currentPatient.equals("")){
						   patientMatchList = PatientMatch.createCriteria().list(){
							  eq("currentPatient",currentPatient)
							  eq("isActive",Short.valueOf("1"))
							  if(patientMatchSearch!=null && !patientMatchSearch.equals("") && patientMatchSearch.equalsIgnoreCase("0-20")){
								between("percentage",new Double(0),new Double(20))
							  }else if(patientMatchSearch!=null && !patientMatchSearch.equals("") && patientMatchSearch.equalsIgnoreCase("20-40")){
							    between("percentage",new Double(20),new Double(40))
							  }else if(patientMatchSearch!=null && !patientMatchSearch.equals("") && patientMatchSearch.equalsIgnoreCase("40-60")){
							    between("percentage",new Double(40),new Double(60))
							  }else if(patientMatchSearch!=null && !patientMatchSearch.equals("") && patientMatchSearch.equalsIgnoreCase("60-80")){
							    between("percentage",new Double(60),new Double(80))
							  }else if(patientMatchSearch!=null && !patientMatchSearch.equals("") && patientMatchSearch.equalsIgnoreCase("80-100")){
							  	between("percentage",new Double(80),new Double(100))
							  }else{
							     //do nothing
							  }
							  order('percentage','desc')
							  
						   }
						   if(patientMatchList !=null && patientMatchList.size()>0){
							   for(int i=0;i<patientMatchList.size();i++){
								  def patientMatch = patientMatchList.get(i);
								   //println "patientMatch?.patient::::::"+patientMatch?.patient
								   if(patientMatch){
									   def isConnected = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(currentPatient,patientMatch?.patient,Short.valueOf("1"),Short.valueOf("1"));
									 // println "isConnected:::::::::::::::"+isConnected
										if(!isConnected){
											isOtherpatientConnected = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(patientMatch?.patient,currentPatient,Short.valueOf("1"),Short.valueOf("1"));
									 //	   println "isOtherpatientConnected:::::::::::::::"+isOtherpatientConnected
											if(!isOtherpatientConnected){
											isReqSent =   PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(patientMatch?.patient,currentPatient,Short.valueOf("0"),Short.valueOf("1"));
										 //   println "isReqSent:::::::::::::::"+isReqSent
											if(!isReqSent){
											 matchedPatient.add(patientMatch);
										 }
									  }
										
									 }
								  }
							  }
							  // println "final matchedPatient::::size()"+matchedPatient.size()
						   }else{
							 //do nothing
						   }
					   }else{
						 // println "PatientMatchService-patientmatch()--> healpal patient is null..!!!!!!!!"
					   }
				 }else{
					//do nothing
				 }
			 }else{
			 //  println "PatientMatchService-getPatientMatch()--> healpal user is null..!!!!!!!!"
			 }
		 }catch(Exception exception){
		   throw Exception;
		 }
		 return matchedPatient
	 }
	//*****************************
	/*def patientMatch(def healpalUser)throws Exception{
		TreeMap patientMatchMap = new TreeMap();
		Patient currentPatient = null;
		Person currentPerson = null;
		try{
			if(healpalUser!=null && !healpalUser.equals("")){
				 currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
				//println "currentPerson::::::::::::::::::::::::::"+currentPerson
				if(currentPerson!=null && !currentPerson.equals("")){
					 currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
					//println "currentPatient:::::::::::::::::::::::"+currentPatient
				}else{
				   //do nothing
				}
				
				if(currentPatient!=null && !currentPatient.equals("")){		
					def patientCancerTypeName = getPatientCancerTypeName(currentPatient);
					def patientMasterCancerName = Diagnosis.findByDiagnosisName("Breast cancer")?.diagnosisName;
					if(patientCancerTypeName!=null && !patientCancerTypeName.equals("") && patientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
					def patientStageOfCancer = getPatientStageOfCancer(currentPatient);
					def ageOfDiagnosis    = getAgeOfDiagnosis(currentPatient);
					def herStatusPositive = getHerStatusPositive(currentPatient);
					def herStatusNegative = getHerStatusNegative(currentPatient);
					def erStatusPositive  =  getErStatusPositive(currentPatient);
					def erStatusNegative  =  getErStatusNegative(currentPatient);
					def prStatusPositive  =  getPrStatusPositive(currentPatient);
					def prStatusNegative  =  getPrStatusNegative(currentPatient);
					def patientDob = currentPerson?.dob
					//println "patientDob:::::::::::::::"+patientDob					
					def patientRace = currentPerson?.race?.raceName;
					def patientPathologic = getPathologicType(currentPatient); 
					//println "patientPathologic:::***********************************************"+patientPathologic
					def patientZipCode = getPatientZipCode(currentPatient);
					def patientMedicalConditionType = getPatientMedicalConditionType(currentPatient);
					def patientEducationType = getPatientEducationType(currentPatient);
					def patientHealthInsuranceType = getPatientHealthInsurance(currentPatient);
					def patientList = Patient.createCriteria().list{
						eq("isActive",Short.valueOf("1"))
						ne("id",currentPatient?.id)
					}
					if(patientList!=null && patientList.size >0){
						//println "patientList:::::::::::::::::::::::"+patientList
						for(int i=0;i<patientList.size();i++){
							int points = 0;
							def mPatient = patientList.get(i);
							//println "mPatient::::::::::"+mPatient
							if(mPatient !=null && !mPatient.equals("")){
								def mPatientCancerTypeName = getPatientCancerTypeName(mPatient);
									if(mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("") && mPatientCancerTypeName.toString().equalsIgnoreCase(patientMasterCancerName)){
										//*************** Static *************************
										def mPatientStageOfCancer = getPatientStageOfCancer(mPatient);
										def mAgeOfDiagnosis = getAgeOfDiagnosis(mPatient);
										def mPatientDob = mPatient?.person?.dob
										def mPatientRace = mPatient?.person?.race?.raceName;
										def mPatientZipCode = getPatientZipCode(mPatient);
									    def mPatientEducationType = getPatientEducationType(mPatient);
										def mPatientHealthInsuranceType = getPatientHealthInsurance(mPatient);
										
										//*************** Dynamic *************************
										def mHerStatusPositive = getHerStatusPositive(mPatient);
										def mHerStatusNegative = getHerStatusNegative(mPatient);
										def mErStatusPositive =  getErStatusPositive(mPatient);
										def mErStatusNegative =  getErStatusNegative(mPatient);
										def mPrStatusPositive =  getPrStatusPositive(mPatient);
										def mPrStatusNegative =  getPrStatusNegative(mPatient);
										def mPatientPathologic = getPathologicType(mPatient);
										def mPatientMedicalConditionType = getPatientMedicalConditionType(mPatient);
										
										//println "mPatientPathologic##################################"+mPatientPathologic
										// ******************* points *******************************
										
										//*************** Static *************************
										def cancerTypePoints = getCancerTypePoints(mPatientCancerTypeName,patientCancerTypeName);
										def ageOfDiagnosisPoints = getAgeOfDiagnosisPoints(mAgeOfDiagnosis,ageOfDiagnosis);
									    def cancerStagePoints = getCencerStagePoints(mPatientStageOfCancer,patientStageOfCancer);
										def racePoints = getRacePoints(mPatientRace,patientRace);
										def zipCodePoints = getZipcodePoints(mPatientZipCode,patientZipCode);
										def educationPoints = getEducationPoints(mPatientEducationType,patientEducationType);
										def healthInsurancePoints = getHealthInsurancePoints(mPatientHealthInsuranceType,patientHealthInsuranceType);
										def dobPoints = getDobPoints(patientDob,mPatientDob);
										
										//*************** Dynamic *************************
										def treatmentPoints = getTreatmentPoints(currentPatient,mPatient);
										def herStatusPositivePoints = getHerStatusPositivePoints(mHerStatusPositive,herStatusPositive);
										def herStatusNegativePoints = getHerStatusNegativePoints(mHerStatusNegative,herStatusNegative);
										def erStatusPositivePoints =  getErStatusPositivePoints(mErStatusPositive,erStatusPositive);
										def erStatusNegativePoints =  getErStatusNegativePoints(mErStatusNegative,erStatusNegative);
										def prStatusPositivePoints =  getPrStatusPositivePoints(mPrStatusPositive,prStatusPositive);
										def prStatusNegativePoints =  getPrStatusNegativePoints(mPrStatusNegative,prStatusNegative);
										def pathologicPoints = getPathologicPoints(mPatientPathologic,patientPathologic);
										def medicalConditionPoints = getMedicalConditionPoints(mPatientMedicalConditionType,patientMedicalConditionType);
										println "treatmentPoints:::::::::::::::::::::"+treatmentPoints
										points = cancerTypePoints + ageOfDiagnosisPoints + cancerStagePoints + dobPoints + racePoints + zipCodePoints + medicalConditionPoints + educationPoints + healthInsurancePoints + pathologicPoints + herStatusPositivePoints + herStatusNegativePoints + erStatusPositivePoints + erStatusNegativePoints + prStatusPositivePoints + prStatusNegativePoints + treatmentPoints;
									    //println "********points********"+points
										patientMatchMap.put(mPatient?.id,points)
										//println "mPatient ::::::"+mPatient + " ::::::points::::::::::::::::::::::::"+ points 
										}else{
											println "patientmatch()--> current patient do not have Breast Cancer!!!!!!!"
									 }
							}else{
							 println "patientmatch()--> Patient is empty!!!!!!!!"
							}
							
						}
					}else{
					 println "patientmatch()--> Patient list is empty!!!!!!!!"
					}
				}else{
				    println "patientmatch()--> current patient do not have Breast Cancer!!!!!!!"
				}
				}else{
				      println "patientmatch()--> healpal patient is null..!!!!!!!!"
				}
			}else{
			  println "patientmatch()--> healpal user is null..!!!!!!!!"
			}
		}catch(Exception exception){
		  throw exception;
		}
		return patientMatchMap;
	}*/
	
	
	def getCancerTypePoints(def mPatientCancerTypeName,def patientCancerTypeName) throws Exception{
		int cancerTypePoint = 0;
		try{
			if(mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("") && patientCancerTypeName!=null && !patientCancerTypeName.equals("") && patientCancerTypeName.toString().trim().equals(mPatientCancerTypeName.toString().trim())){
				cancerTypePoint = 20;
		    }else{
			    cancerTypePoint = 0;
		    }
		}catch(Exception exception){
		      throw exception
		}
		return cancerTypePoint;
	}
	def getAgeOfDiagnosisPoints(def mAgeOfDiagnosis,def ageOfDiagnosis)throws Exception{
		int ageOfDiagnosisPoint = 0;
		try{
			if(mAgeOfDiagnosis!=null && !mAgeOfDiagnosis.equals("") && ageOfDiagnosis!=null && !ageOfDiagnosis.equals("") && mAgeOfDiagnosis.toString().trim().equals(ageOfDiagnosis.toString().trim())){
				ageOfDiagnosisPoint = 5;
			}else{
				ageOfDiagnosisPoint = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return ageOfDiagnosisPoint;
	}
	
	
	
	
	def getHerStatusPositivePoints(def mHerStatusPositive,def herStatusPositive)throws Exception{
		int herStatusPositivePoints = 0;
		try{
			if(mHerStatusPositive!=null && !mHerStatusPositive.equals("") && herStatusPositive!=null && !herStatusPositive.equals("") 
				 && mHerStatusPositive.toString().trim().equalsIgnoreCase(herStatusPositive.toString().trim())){
				   herStatusPositivePoints = 10;
			}else{
				   herStatusPositivePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return herStatusPositivePoints;
	}
	def getHerStatusNegativePoints(def mHerStatusNegative,def herStatusNegative)throws Exception{
		int herStatusNegativePoints = 0;
		try{
			if(mHerStatusNegative!=null && !mHerStatusNegative.equals("") && herStatusNegative!=null && !herStatusNegative.equals("") 
				 && mHerStatusNegative.toString().trim().equalsIgnoreCase(herStatusNegative.toString().trim())){
				   herStatusNegativePoints = 10;
			}else{
				   herStatusNegativePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return herStatusNegativePoints;
	}
	def getErStatusPositivePoints(def mErStatusPositive,def erStatusPositive)throws Exception{
		int erStatusPositivePoints = 0;
		try{
			if(mErStatusPositive!=null && !mErStatusPositive.equals("") && erStatusPositive!=null && !erStatusPositive.equals("") 
				 && mErStatusPositive.toString().trim().equalsIgnoreCase(erStatusPositive.toString().trim())){
				   erStatusPositivePoints = 10;
			}else{
				   erStatusPositivePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return erStatusPositivePoints;
	}
	def getErStatusNegativePoints(def mErStatusNegative,def erStatusNegative)throws Exception{
		int erStatusNegativePoints = 0;
		try{
			if(mErStatusNegative!=null && !mErStatusNegative.equals("") && erStatusNegative!=null
				 && mErStatusNegative.toString().trim().equalsIgnoreCase(erStatusNegative.toString().trim())){
				   erStatusNegativePoints = 10;
			}else{
				   erStatusNegativePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return erStatusNegativePoints;
	}
	def getPrStatusPositivePoints(def mPrStatusPositive,def prStatusPositive)throws Exception{
		int prStatusPositivePoints = 0;
		try{
			if(mPrStatusPositive!=null && !mPrStatusPositive.equals("") && prStatusPositive!=null && !prStatusPositive.equals("")
				 && mPrStatusPositive.toString().trim().equalsIgnoreCase(prStatusPositive.toString().trim())){
				   prStatusPositivePoints = 10;
			}else{
				   prStatusPositivePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return prStatusPositivePoints;
	}
	def getPrStatusNegativePoints(def mPrStatusNegative,def prStatusNegative)throws Exception{
		int prStatusNegativePoints = 0;
		try{
			if(mPrStatusNegative!=null && !mPrStatusNegative.equals("") && prStatusNegative!=null && !prStatusNegative.equals("") 
				 && mPrStatusNegative.toString().trim().equalsIgnoreCase(prStatusNegative.toString().trim())){
				   prStatusNegativePoints = 10;
			}else{
				   prStatusNegativePoints = 0;
			}
		}catch(Exception exception){
		   throw exception
		}
		return prStatusNegativePoints;
	}
	
	def getPathologicPoints(def mPatientPathologic,def patientPathologic)throws Exception{
		int pathologicPoints = 0;
		try{
			if(mPatientPathologic!=null && !mPatientPathologic.equals("") && patientPathologic!=null && !patientPathologic.equals("") && patientPathologic.toString().trim().equals(mPatientPathologic.toString().trim())){
				pathologicPoints = 20;
			}else{
				pathologicPoints = 0;
			}
		}catch(Exception exception){
		  throw exception
		}
		return pathologicPoints;
	}
	def getCencerStagePoints(def mPatientStageOfCancer,def patientStageOfCancer) throws Exception{
		int cancerStagePoint = 0;
		try{
			if(mPatientStageOfCancer!=null && !mPatientStageOfCancer.equals("") && patientStageOfCancer!=null && !patientStageOfCancer.equals("") && patientStageOfCancer.toString().trim().equals(mPatientStageOfCancer.toString().trim())){
				cancerStagePoint = 20;
			}else{
				cancerStagePoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return cancerStagePoint;
	}
	
	def  getDobPoints(def patientDob,def mPatientDob)throws Exception{
		int dobPoints = 0;
		try{
			if(patientDob!=null && !patientDob.equals("") && mPatientDob!=null && !mPatientDob.equals("")){
			Calendar currPatientdate =Calendar.getInstance();
			currPatientdate.setTime(patientDob);
			Calendar mPatientdate =Calendar.getInstance();
			mPatientdate.setTime(mPatientDob);
			int year = currPatientdate.get(Calendar.YEAR) - mPatientdate.get(Calendar.YEAR);
			if(year <= 5 && year >= -5){
				dobPoints = 5;
			}else{
			    dobPoints = 0;
			}
		 }
		}catch(Exception exception){
		  throw exception;
		}
		return dobPoints;
	}
	
	def getRacePoints(def mPatientRace,def patientRace) throws Exception{
		int racePoint = 0;
		try{
			if(mPatientRace!=null && !mPatientRace.equals("") && patientRace!=null && !patientRace.equals("") && patientRace.toString().trim().equals(mPatientRace.toString().trim())){
				racePoint = 5;
			}else{
				racePoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return racePoint;
	}
	
	def getZipcodePoints(def mPatientZipCode,def patientZipCode) throws Exception{
		int zipPoint = 0;
		try{
			if(mPatientZipCode!=null && !mPatientZipCode.equals("") && patientZipCode!=null && !patientZipCode.equals("") && patientZipCode.toString().trim().equals(mPatientZipCode.toString().trim())){
				zipPoint = 10;
			}else{
				zipPoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return zipPoint;
	}
	def getMedicalConditionPoints(def mPatientMedicalConditionType, def patientMedicalConditionType) throws Exception{
		int medicalConditionPoint = 0;
		try{
			if(mPatientMedicalConditionType!=null && !mPatientMedicalConditionType.equals("") && patientMedicalConditionType!=null && !patientMedicalConditionType.equals("") && patientMedicalConditionType.toString().trim().equals(mPatientMedicalConditionType.toString().trim())){
				medicalConditionPoint = 5;
			}else{
				medicalConditionPoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return medicalConditionPoint;
	}
	def getEducationPoints(def mPatientEducationType,def patientEducationType) throws Exception{
		int educationPoint = 0;
		try{
			if(mPatientEducationType!=null && !mPatientEducationType.equals("") && patientEducationType!=null && !patientEducationType.equals("") && patientEducationType.toString().trim().equals(mPatientEducationType.toString().trim())){
				educationPoint = 3;
			}else{
				educationPoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return educationPoint;
	}
	def getHealthInsurancePoints(def mPatientHealthInsuranceType,def patientHealthInsuranceType) throws Exception{
		int healthInsurancePoint = 0;
		try{
			if(mPatientHealthInsuranceType!=null && !mPatientHealthInsuranceType.equals("") && patientHealthInsuranceType!=null && !patientHealthInsuranceType.equals("") && patientHealthInsuranceType.toString().trim().equals(mPatientHealthInsuranceType.toString().trim())){
				healthInsurancePoint = 5;
			}else{
				healthInsurancePoint = 0;
			}
		}catch(Exception exception){
			  throw exception
		}
		return healthInsurancePoint;
	}
	
	//get patient cancer type
	def getPatientCancerTypeName(def patient)throws Exception{
		def patientCancerTypeName = "";
		try{
			if(patient!=null && !patient.equals("")){
			   patientCancerTypeName = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.diagnosis?.diagnosisName;
			}else{
			  //do nothing
			}
		}catch(Exception exception){
		    throw exception
		}
		return patientCancerTypeName;
	}
	
	//get age of diagnosis
	def getAgeOfDiagnosis(def patient)throws Exception{
		def ageOfDiagnosis;
		try{
			if(patient!=null && !patient.equals("")){
				ageOfDiagnosis = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.ageOfDiagnosis;
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return ageOfDiagnosis
	}
	//get her status positive
	def getHerStatusPositive(Patient patient)throws Exception{
		def herStatusPositive;
		try{
			if(patient!=null && !patient.equals("")){
				herStatusPositive = patient?.person?.herStatusPositive
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return herStatusPositive;
	}
	//get her status negative
	def getHerStatusNegative(Patient patient)throws Exception{
		def herStatusNegative
		try{
			if(patient!=null && !patient.equals("")){
				herStatusNegative =  patient?.person?.herStatusNegative
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return herStatusNegative
	}
	//get er status positive
	def getErStatusPositive(Patient patient)throws Exception{
		def erStatusPositive
		try{
			if(patient!=null && !patient.equals("")){
				erStatusPositive =  patient?.person?.erStatusPositive
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return erStatusPositive
	}
	//get er status negative
	def getErStatusNegative(Patient patient)throws Exception{
		def erStatusNegative;
		try{
			if(patient!=null && !patient.equals("")){
				erStatusNegative = patient?.person?.erStatusNegative
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return erStatusNegative
	}
	//get pr status positive
	def getPrStatusPositive(Patient patient)throws Exception{
		def prStatusPositive
		try{
			if(patient!=null && !patient.equals("")){
				prStatusPositive = patient?.person?.prStatusPositive
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return prStatusPositive
	}
	//get pr status negative
	def getPrStatusNegative(Patient patient)throws Exception{
		def prStatusNegative;
		try{
			if(patient!=null && !patient.equals("")){
				prStatusNegative = patient?.person?.prStatusNegative
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		   throw exception;
		}
		return prStatusNegative;
	}
	
	def getRace(def patient)throws Exception{
		def raceName;
		try{
			if(patient!=null && !patient.equals("")){
				raceName = TempQuestionOption.findByPatientAndQuestionName(patient,"Select your Race")?.value;
			 }else{
			   //do nothing
			 }
		}catch(Exception exception){
		    throw exception;
		}
		return raceName;
	}
	
	//get patient stage of breast cancer
	def getPatientStageOfCancer(def patient)throws Exception{
		def patientStageOfCancer = "";
		try{
			if(patient!=null && !patient.equals("")){
			   patientStageOfCancer = TempQuestionOption.findByPatientAndQuestionName(patient,"Stage of cancer")?.value;
			}else{
			//do nothing
		    }
		 }catch(Exception exception){
			throw exception
		}
		return patientStageOfCancer
	}
	//get the zipcode for patient
	def getPatientZipCode(def patient)throws Exception{
		def patientZipCode ="";
		try{
			if(patient!=null && !patient.equals("")){
			   patientZipCode = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"))?.address?.zipcode;
			}else{
			//do nothing
		    }
		}catch(Exception exception){
			throw exception
		}
		return patientZipCode;
	}
	//get the medical condition for patient
	def getPatientMedicalConditionType(def patient)throws Exception{
		def patientMedicalConditionType = "";
		try{
			if(patient!=null && !patient.equals("")){
			    patientMedicalConditionType = PatientMedicalCondition.findByPatientAndIsActive(patient,Short.valueOf("1"))?.medicalCondition?.medicalConditionType;
			}else{
			//do nothing
		   }
		}catch(Exception exception){
			throw exception
		}
		return patientMedicalConditionType;
	}
	//get the education for patient
	def getPatientEducationType(def patient)throws Exception{
		def patientEducationType = "";
		try{
			if(patient!=null && !patient.equals("")){
			    patientEducationType = PatientEducation.findByPatientAndIsActive(patient,Short.valueOf("1"))?.education?.educationType;
			}else{
			//do nothing
		    }
		}catch(Exception exception){
			throw exception
		}
		return patientEducationType
	}
	//get the health insurance for patient
	def getPatientHealthInsurancePoints(Patient currentPatient,Patient mPatient)throws Exception{
		def patientHealthInsuranceTypePoints = 0;
		try{
			if(currentPatient!=null && !currentPatient.equals("") && mPatient!=null && !mPatient.equals("")){
			   def patientHealthInsuranceType = PatientHealthInsurance.createCriteria().list{
				   eq("patient",currentPatient)
				   eq("isActive",Short.valueOf("1"))
			   }
			   if(patientHealthInsuranceType!=null && !patientHealthInsuranceType.equals("")){
				   for(int i=0;i<patientHealthInsuranceType.size();i++){
					   def healthInsuranceType = patientHealthInsuranceType.get(i)?.healthInsurance;
					   if(healthInsuranceType!=null && !healthInsuranceType.equals("")){
							   def checkPatientHealthInsurance = PatientHealthInsurance.createCriteria().list{
								   eq("patient",mPatient)
								   eq("healthInsurance",healthInsuranceType)
							 }
							   if(checkPatientHealthInsurance!=null && checkPatientHealthInsurance.size()>0){
									   patientHealthInsuranceTypePoints = 5;
							   }else{
								   
							   }
						  
					   }
					 }
			   }else{
			      //do nothing
			   }
			}else{
			//do nothing
		    }
		}catch(Exception exception){
			throw exception
		}
		return patientHealthInsuranceTypePoints;
	}
	
	//get the Pathologic Type for patient
	def  getPathologicType(def patient)throws Exception{
		def patientPathologicType = "";
		try{
			if(patient!=null && !patient.equals("")){
				patientPathologicType = TempQuestionOption.findByPatientAndQuestionName(patient,"Pathology biopsy tumor type 2")?.value;
			}else{
			  //do nothing
			}
		}catch(Exception exception){
		  throw exception;
		}
		return patientPathologicType;
	}
	
	def getTreatmentPoints(Patient currentPatient,Patient mPatient)throws Exception{
		def treatmentPoints = 0;
		def surgicalpoints = 0;
		def chemotherapypoints = 0;
		def radiationpoints = 0;
		def hormonalpoints = 0;
		def targetedpoints = 0;
		def surgicalQuestion = "What type of surgical procedure did you Undergo or are scheduled to undergo?";
		def chemotherapyQuestion = "Please choose the chemotherapy drug or drugs given to you";
		def radiationQuestion = "Which type of radiation treatment did you receive or are scheduled to receive?";
		def hormonalQuestion = "Please choose the hormone therapy drug or drugs given to you";
		def targetedQuestion = "Please choose the targeted therapy or therapies given to you";
		try{
			if(currentPatient!=null && !currentPatient.equals("") && mPatient!=null && !mPatient.equals("")){
				
				//***************Surgical Question **********************************
				
				def currSurPatientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
					    eq("patient",currentPatient)
						eq("questionName",surgicalQuestion,[ignoreCase: true])
				}
				if(currSurPatientTempQuestionAndAns!=null && currSurPatientTempQuestionAndAns.size() > 0){
					for(int i=0;i<currSurPatientTempQuestionAndAns.size();i++){
						def tempQuestionAndAns = currSurPatientTempQuestionAndAns.get(i);
						if(tempQuestionAndAns!=null && !tempQuestionAndAns.equals("")){
							def answer = tempQuestionAndAns?.value;
							if(answer!=null && !answer.equals("")){
								def patientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
									eq("patient",mPatient)
									eq("questionName",surgicalQuestion,[ignoreCase: true])
									eq("value",answer,[ignoreCase: true])
							   }
								if(patientTempQuestionAndAns!=null && patientTempQuestionAndAns.size()>0 && surgicalpoints == 0){
								    	surgicalpoints = 10;
								}else{
								    // surgicalpoints = 0;
								}
							}else{
							   //do nothing
							}
						}
						
					}
					
				}else{
				  //do nothing
				}
				
				 
				 //***************chemotherapy Question **********************************
				
				def currChePatientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
					    eq("patient",currentPatient)
						eq("questionName",chemotherapyQuestion,[ignoreCase: true])
				}
				if(currChePatientTempQuestionAndAns!=null && currChePatientTempQuestionAndAns.size() > 0){
					for(int i=0;i<currChePatientTempQuestionAndAns.size();i++){
						def tempQuestionAndAns = currChePatientTempQuestionAndAns.get(i);
						if(tempQuestionAndAns!=null && !tempQuestionAndAns.equals("")){
							def answer = tempQuestionAndAns?.value;
							if(answer!=null && !answer.equals("")){
								def patientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
									eq("patient",mPatient)
									eq("questionName",chemotherapyQuestion,[ignoreCase: true])
									eq("value",answer,[ignoreCase: true])
							   }
								if(patientTempQuestionAndAns!=null && patientTempQuestionAndAns.size()>0 && chemotherapypoints == 0){
								    	chemotherapypoints = 10;
								}else{
								    // surgicalpoints = 0;
								}
							}else{
							   //do nothing
							}
						}
						
					}
					
				}else{
				  //do nothing
				}
				
				
				//***************radiation Question **********************************
				 
				 def currRadPatientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
						 eq("patient",currentPatient)
						 eq("questionName",radiationQuestion,[ignoreCase: true])
				 }
				 if(currRadPatientTempQuestionAndAns!=null && currRadPatientTempQuestionAndAns.size() > 0){
					 for(int i=0;i<currRadPatientTempQuestionAndAns.size();i++){
						 def tempQuestionAndAns = currRadPatientTempQuestionAndAns.get(i);
						 if(tempQuestionAndAns!=null && !tempQuestionAndAns.equals("")){
							 def answer = tempQuestionAndAns?.value;
							 if(answer!=null && !answer.equals("")){
								 def patientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
									 eq("patient",mPatient)
									 eq("questionName",radiationQuestion,[ignoreCase: true])
									 eq("value",answer,[ignoreCase: true])
								}
								 if(patientTempQuestionAndAns!=null && patientTempQuestionAndAns.size()>0 && radiationpoints == 0){
										 radiationpoints = 10;
								 }else{
									 // surgicalpoints = 0;
								 }
							 }else{
								//do nothing
							 }
						 }
						 
					 }
					 
				 }else{
				   //do nothing
				 }
				 
				 
				 //***************hormonal Question **********************************
				  
				  def currHorPatientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
						  eq("patient",currentPatient)
						  eq("questionName",hormonalQuestion,[ignoreCase: true])
				  }
				  if(currHorPatientTempQuestionAndAns!=null && currHorPatientTempQuestionAndAns.size() > 0){
					  for(int i=0;i<currHorPatientTempQuestionAndAns.size();i++){
						  def tempQuestionAndAns = currHorPatientTempQuestionAndAns.get(i);
						  if(tempQuestionAndAns!=null && !tempQuestionAndAns.equals("")){
							  def answer = tempQuestionAndAns?.value;
							  if(answer!=null && !answer.equals("")){
								  def patientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
									  eq("patient",mPatient)
									  eq("questionName",hormonalQuestion,[ignoreCase: true])
									  eq("value",answer,[ignoreCase: true])
								 }
								  if(patientTempQuestionAndAns!=null && patientTempQuestionAndAns.size()>0 && hormonalpoints == 0){
										  hormonalpoints = 10;
								  }else{
									  // surgicalpoints = 0;
								  }
							  }else{
								 //do nothing
							  }
						  }
						  
					  }
					  
				  }else{
					//do nothing
				  }
				  
				  //***************targeted Question **********************************
				   
				   def currTarPatientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
						   eq("patient",currentPatient)
						   eq("questionName",targetedQuestion,[ignoreCase: true])
				   }
				   if(currTarPatientTempQuestionAndAns!=null && currTarPatientTempQuestionAndAns.size() > 0){
					   for(int i=0;i<currTarPatientTempQuestionAndAns.size();i++){
						   def tempQuestionAndAns = currTarPatientTempQuestionAndAns.get(i);
						   if(tempQuestionAndAns!=null && !tempQuestionAndAns.equals("")){
							   def answer = tempQuestionAndAns?.value;
							   if(answer!=null && !answer.equals("")){
								   def patientTempQuestionAndAns = TempQuestionOption.createCriteria().list{
									   eq("patient",mPatient)
									   eq("questionName",targetedQuestion,[ignoreCase: true])
									   eq("value",answer,[ignoreCase: true])
								  }
								   if(patientTempQuestionAndAns!=null && patientTempQuestionAndAns.size()>0 && targetedpoints == 0){
										   targetedpoints = 10;
								   }else{
									   // surgicalpoints = 0;
								   }
							   }else{
								  //do nothing
							   }
						   }
						   
					   }
					   
				   }else{
					 //do nothing
				   }
				   treatmentPoints = surgicalpoints + chemotherapypoints + radiationpoints + hormonalpoints + targetedpoints;
				   
				/*
				def patientTreatmentList = PatientTreatment.createCriteria().list{
					eq("patient",currentPatient)
				}
				if(patientTreatmentList!=null && patientTreatmentList.size() > 0){
					
					for(int i=0;i<patientTreatmentList.size();i++){
						def treatment = patientTreatmentList.get(i);
						if(treatment!=null && !treatment.equals("")){
							def currTreatmentList = PatientTreatment.createCriteria().list{
								eq("patient",mPatient)
								eq("treatment",treatment)
							}
							
							if(currTreatmentList!=null && !currTreatmentList.equals("") && currTreatmentList.size()>0){
								treatmentPoints = treatmentPoints + 10;
							}
						}
					}
				}else{
				  //do nothing
				}
			*/}else{
			  //do nothing
			}
		}catch(Exception exception){
		 throw exception;
		}
		return treatmentPoints;
	}
	
	//get cancer stage name
	def cancerStage(def patientId){
		def cancerName = "";
		try{
			if(patientId!=null && !patientId.equals("")){
				Patient patient = Patient.get(patientId?.toString().toLong())
				 cancerName = PatientCancerStage.findByPatientAndIsActive(patient,Short.valueOf("1"))?.cancerStage?.cancerStageLevel;
			}else{
			  //do nothing
			}
			
		}catch(Exception exception){
		  exception.printStackTrace();
		}
		return cancerName;
	}
	
	//get patient active years
	def getPatientActiveYear(def patientId){
		def year;
		try{
			if(patientId!=null && !patientId.equals("")){
				Patient patient = Patient.get(patientId?.toString().toLong())
				 def date = patient.rowCreated
				 Calendar patientdate =Calendar.getInstance();
				 patientdate.setTime(date);
				 year = patientdate.get(Calendar.YEAR);
			}else{
			  //do nothing
			}
			
		}catch(Exception exception){
		  exception.printStackTrace();
		}
		return year;
	}
	
	
	//*****************Dynamic Batch Process for Patient Match starts***********************
	 @Synchronized
	 def doDynamicBatchProcess(){
		 Patient currentPatient = null;
			  try{
				  // println "PatientMatchService-doBatchProcess()---> Background Process start for patient Match!!!!!!!!"
				  def patientList = Patient.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
				  }
				  if(patientList!=null && patientList.size()>0){
					  for(int i=0;i<patientList.size();i++){
						   currentPatient = patientList.get(i);
						   if(currentPatient!=null && !currentPatient.equals("")){
							   def patientCancerTypeName = getDynamicPatientCancerTypeName(currentPatient);
								def mPatientList = Patient.createCriteria().list{
								   eq("isActive",Short.valueOf("1"))
								   ne("id",currentPatient?.id)
							   }
							   if(mPatientList!=null && mPatientList.size >0){
								   for(int j=0;j<mPatientList.size();j++){
									   int points = 0;
									   int totalPoints = 0;
									   def mPatient = mPatientList.get(j);
									   if(mPatient !=null && !mPatient.equals("")){
										 def mPatientCancerTypeName = getDynamicPatientCancerTypeName(mPatient);
										 if(patientCancerTypeName!=null && !patientCancerTypeName.equals("")
											  && mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("")
											  && mPatientCancerTypeName.equals(patientCancerTypeName)){
												 //here added diagnosis points
												 points = points + 20;
												 totalPoints = totalPoints + 20;
												 //here added dob points
												 def mPatientDob = mPatient?.person?.dob
												 def patientDob = currentPatient?.person?.dob
												 def dobPoints = getDynamicDobPoints(patientDob,mPatientDob);
												 totalPoints = totalPoints + 5;
												 points = points + dobPoints;
												 //here added zip code points
												 def patientZipCode = getDynamicPatientZipCode(currentPatient);
												 def mPatientZipCode = getDynamicPatientZipCode(mPatient);
												 def zipCodePoints = getDynamicZipcodePoints(mPatientZipCode,patientZipCode);
												 totalPoints = totalPoints + 10;
												 points = points + zipCodePoints;
												 //here added race points
												 def patientRace = getDynamicRace(currentPatient);
												 def mPatientRace = getDynamicRace(mPatient);
												 def racePoints = getDynamicRacePoints(mPatientRace,patientRace);
												 totalPoints = totalPoints + 5;
												 points = points + racePoints;
												 //here added education points
												 def patientEducationType = getDynamicPatientEducationType(currentPatient);
												 def mPatientEducationType = getDynamicPatientEducationType(mPatient);
												 def educationPoints = getDynamicEducationPoints(mPatientEducationType,patientEducationType);
												 totalPoints = totalPoints + 3;
												 points = points + educationPoints;
												 //here added health insurance points
												 def healthInsurancePoints = getDynamicPatientHealthInsurancePoints(currentPatient,mPatient);
												 totalPoints = totalPoints + 5;
												 points = points + healthInsurancePoints;
												 //here added cancer stage points
												 def patientStageOfCancer = getDynamicPatientStageOfCancer(currentPatient);
												 def mPatientStageOfCancer = getDynamicPatientStageOfCancer(mPatient);
												 def cancerStagePoints = getDynamicCencerStagePoints(mPatientStageOfCancer,patientStageOfCancer);
												 totalPoints = totalPoints + 20;
												 points = points + cancerStagePoints;
												 //here add age of diagnosis points
												 def ageOfDiagnosis    = getDynamicAgeOfDiagnosis(currentPatient);
												 def mAgeOfDiagnosis = getDynamicAgeOfDiagnosis(mPatient);
												 def ageOfDiagnosisPoints = getDynamicAgeOfDiagnosisPoints(mAgeOfDiagnosis,ageOfDiagnosis);
												 totalPoints = totalPoints + 5;
												 points = points + ageOfDiagnosisPoints;
												 
												 Diagnosis diagnosis= Diagnosis.findByDiagnosisName(patientCancerTypeName);
												 doProcess(diagnosis,currentPatient,mPatient,points,totalPoints);
										  }else{
												  //do nothing
											  }
												   
									  }else{
									   // println "PatientMatchService-doBatchProcess()---> mPatient is empty!!!!!!!!"
									   }
									   
								   }
							   }else{
							   // println "PatientMatchService-doBatchProcess()---> mPatient list is empty!!!!!!!!"
							   }
						  }else{
								// println "PatientMatchService-doBatchProcess()---> healpal current patient is null..!!!!!!!!"
						   }
						   
				   }
				  }else{
				  // println "PatientMatchService-doBatchProcess()-Patient list is empty!!!!!";
				  }
			  }catch(Exception exception){
				  exception.printStackTrace();
			  }
		  }
	 
	 
			   def doProcess(Diagnosis diagnosis,Patient currentPatient,Patient mPatient,int points,int totalPoints){
				  
				   try{
					   if(diagnosis && currentPatient && mPatient){
						   def profileQuestions = ProfileQuestions.createCriteria().list{
								   eq("isActive",Short.valueOf("1"))
								   eq("diagnosis",diagnosis)
							   }
						   println "profileQuestions:::"+profileQuestions
						   if(profileQuestions!=null && profileQuestions.size()>0){
							   for(int i=0;i<profileQuestions.size();i++){
									def profile = profileQuestions.get(i);
									totalPoints = totalPoints + profile?.patientMatchPoints;
									def currPatientAnswer = ProfileQuestionAnswer.findByPatientAndProfileQuestionsAndIsActive(currentPatient,profile,Short.valueOf("1"))?.answer;
									def matchPatientAnswer = ProfileQuestionAnswer.findByPatientAndProfileQuestionsAndIsActive(mPatient,profile,Short.valueOf("1"))?.answer;
									if(currPatientAnswer!=null && !currPatientAnswer.equals("")
										&& matchPatientAnswer!=null && !matchPatientAnswer.equals("")
										&& currPatientAnswer.equals(matchPatientAnswer)){
											points = points + profile?.patientMatchPoints;
								  }else{
									   //do nothing
								  }
							   }
						   }else{
							  //println "profileQuestions is null"
						   }
						   
						  }else{
							  //println "diagnosis or currentPatient or mPatient is null"
						 }
						  
						  println "points::::::::::::"+points
						  println "totalPoints::::::::::::"+totalPoints
						  println "mPatient::::::::::::"+mPatient
						  println "currentPatient::::::::::::"+currentPatient
						  def percentage = calculateDynamicPercentage(points,totalPoints);
						  println "percentage::::::::::::"+percentage
						  dynamicInsertPatientMatch(mPatient,currentPatient,percentage);
						  
				   }catch(Exception exception){
						  exception.printStackTrace();
					  }
			   }
			   def calculateDynamicPercentage(int points,int totalPoints)throws Exception{
				   def percentage  ;
				   
				   try{
						double percentageVal =  Math.round(points*100.0)/totalPoints;
						DecimalFormat df = new DecimalFormat("###");
						percentage = df.format(percentageVal);
				   }catch(Exception exception){
					   throw exception;
				   }
				   return percentage;
			   }
			   def dynamicInsertPatientMatch(Patient matchPatient,Patient currentPatient,def percentage)throws Exception{
				   try{
					   if(matchPatient!=null && !matchPatient.equals("") && currentPatient!=null && !currentPatient.equals("") && percentage!=null && !percentage.toString().equals("")){
						 def isExist = PatientMatch.findByCurrentPatientAndPatient(currentPatient,matchPatient);
						 double percen = Double.parseDouble(percentage);
						 if(isExist!=null && !isExist.equals("")){
							 PatientMatch.executeUpdate("UPDATE  PatientMatch p set p.percentage=? WHERE p.currentPatient=? AND p.patient=?",[percen,currentPatient,matchPatient]);
							  }else{
							 PatientMatch pMatch = new PatientMatch();
							 pMatch.patient = matchPatient
							 pMatch.currentPatient = currentPatient
							 pMatch.percentage = percen
							 pMatch.isActive = (short)1
							 pMatch.rowCreated = new Date()
							 pMatch.save()
						 }
						
					   }
				   }catch(Exception exception){
					 throw exception;
				   }
		   }
			   //get patient cancer type
			   def getDynamicPatientCancerTypeName(def patient)throws Exception{
				   def patientCancerTypeName = "";
				   try{
					   if(patient!=null && !patient.equals("")){
						  patientCancerTypeName = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.diagnosis?.diagnosisName;
					   }else{
						 //do nothing
					   }
				   }catch(Exception exception){
					   throw exception
				   }
				   return patientCancerTypeName;
			   }
			   
			   //get age of diagnosis
			   def getDynamicAgeOfDiagnosis(def patient)throws Exception{
				   def ageOfDiagnosis;
				   try{
					   if(patient!=null && !patient.equals("")){
						   ageOfDiagnosis = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.ageOfDiagnosis;
						}else{
						  //do nothing
						}
				   }catch(Exception exception){
					  throw exception;
				   }
				   return ageOfDiagnosis
			   }
			   
			   def getDynamicRace(def patient)throws Exception{
				   def raceName;
				   try{
					   if(patient!=null && !patient.equals("")){
						   raceName = TempQuestionOption.findByPatientAndQuestionName(patient,"Select your Race")?.value;
						}else{
						  //do nothing
						}
				   }catch(Exception exception){
					   throw exception;
				   }
				   return raceName;
			   }
			   
			   //get patient stage of breast cancer
			   def getDynamicPatientStageOfCancer(def patient)throws Exception{
				   def patientStageOfCancer = "";
				   try{
					   if(patient!=null && !patient.equals("")){
						  patientStageOfCancer = TempQuestionOption.findByPatientAndQuestionName(patient,"Stage of cancer")?.value;
					   }else{
					   //do nothing
					   }
					}catch(Exception exception){
					   throw exception
				   }
				   return patientStageOfCancer
			   }
			   //get the zipcode for patient
			   def getDynamicPatientZipCode(def patient)throws Exception{
				   def patientZipCode ="";
				   try{
					   if(patient!=null && !patient.equals("")){
						  patientZipCode = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"))?.address?.zipcode;
					   }else{
					   //do nothing
					   }
				   }catch(Exception exception){
					   throw exception
				   }
				   return patientZipCode;
			   }
			  
			   //get the education for patient
			   def getDynamicPatientEducationType(def patient)throws Exception{
				   def patientEducationType = "";
				   try{
					   if(patient!=null && !patient.equals("")){
						   patientEducationType = PatientEducation.findByPatientAndIsActive(patient,Short.valueOf("1"))?.education?.educationType;
					   }else{
					   //do nothing
					   }
				   }catch(Exception exception){
					   throw exception
				   }
				   return patientEducationType
			   }
			   //get the health insurance for patient
			   def getDynamicPatientHealthInsurancePoints(Patient currentPatient,Patient mPatient)throws Exception{
				   def patientHealthInsuranceTypePoints = 0;
				   try{
					   if(currentPatient!=null && !currentPatient.equals("") && mPatient!=null && !mPatient.equals("")){
						  def patientHealthInsuranceType = PatientHealthInsurance.createCriteria().list{
							  eq("patient",currentPatient)
							  eq("isActive",Short.valueOf("1"))
						  }
						  if(patientHealthInsuranceType!=null && !patientHealthInsuranceType.equals("")){
							  for(int i=0;i<patientHealthInsuranceType.size();i++){
								  def healthInsuranceType = patientHealthInsuranceType.get(i)?.healthInsurance;
								  if(healthInsuranceType!=null && !healthInsuranceType.equals("")){
										  def checkPatientHealthInsurance = PatientHealthInsurance.createCriteria().list{
											  eq("patient",mPatient)
											  eq("healthInsurance",healthInsuranceType)
										}
										  if(checkPatientHealthInsurance!=null && checkPatientHealthInsurance.size()>0){
												  patientHealthInsuranceTypePoints = 5;
										  }else{
											  
										  }
									 
								  }
								}
						  }else{
							 //do nothing
						  }
					   }else{
					   //do nothing
					   }
				   }catch(Exception exception){
					   throw exception
				   }
				   return patientHealthInsuranceTypePoints;
			   }
			   
			   
			   
			   
			   def getDynamicAgeOfDiagnosisPoints(def mAgeOfDiagnosis,def ageOfDiagnosis)throws Exception{
					   int ageOfDiagnosisPoint = 0;
					   try{
						   if(mAgeOfDiagnosis!=null && !mAgeOfDiagnosis.equals("") && ageOfDiagnosis!=null && !ageOfDiagnosis.equals("") && mAgeOfDiagnosis.toString().trim().equals(ageOfDiagnosis.toString().trim())){
							   ageOfDiagnosisPoint = 5;
						   }else{
							   ageOfDiagnosisPoint = 0;
						   }
					   }catch(Exception exception){
						  throw exception
					   }
					   return ageOfDiagnosisPoint;
				   }
				   
			   
			   def getDynamicCencerStagePoints(def mPatientStageOfCancer,def patientStageOfCancer) throws Exception{
					   int cancerStagePoint = 0;
					   try{
						   if(mPatientStageOfCancer!=null && !mPatientStageOfCancer.equals("") && patientStageOfCancer!=null && !patientStageOfCancer.equals("") && patientStageOfCancer.toString().trim().equals(mPatientStageOfCancer.toString().trim())){
							   cancerStagePoint = 20;
						   }else{
							   cancerStagePoint = 0;
						   }
					   }catch(Exception exception){
							 throw exception
					   }
					   return cancerStagePoint;
				   }
				   
				   def  getDynamicDobPoints(def patientDob,def mPatientDob)throws Exception{
					   int dobPoints = 0;
					   try{
						   if(patientDob!=null && !patientDob.equals("") && mPatientDob!=null && !mPatientDob.equals("")){
						   Calendar currPatientdate =Calendar.getInstance();
						   currPatientdate.setTime(patientDob);
						   Calendar mPatientdate =Calendar.getInstance();
						   mPatientdate.setTime(mPatientDob);
						   int year = currPatientdate.get(Calendar.YEAR) - mPatientdate.get(Calendar.YEAR);
						   if(year <= 5 && year >= -5){
							   dobPoints = 5;
						   }else{
							   dobPoints = 0;
						   }
						}
					   }catch(Exception exception){
						 throw exception;
					   }
					   return dobPoints;
				   }
				   
				   def getDynamicRacePoints(def mPatientRace,def patientRace) throws Exception{
					   int racePoint = 0;
					   try{
						   if(mPatientRace!=null && !mPatientRace.equals("") && patientRace!=null && !patientRace.equals("") && patientRace.toString().trim().equals(mPatientRace.toString().trim())){
							   racePoint = 5;
						   }else{
							   racePoint = 0;
						   }
					   }catch(Exception exception){
							 throw exception
					   }
					   return racePoint;
				   }
				   
				   def getDynamicZipcodePoints(def mPatientZipCode,def patientZipCode) throws Exception{
					   int zipPoint = 0;
					   try{
						   if(mPatientZipCode!=null && !mPatientZipCode.equals("") && patientZipCode!=null && !patientZipCode.equals("") && patientZipCode.toString().trim().equals(mPatientZipCode.toString().trim())){
							   zipPoint = 10;
						   }else{
							   zipPoint = 0;
						   }
					   }catch(Exception exception){
							 throw exception
					   }
					   return zipPoint;
				   }
			   
			   def getDynamicEducationPoints(def mPatientEducationType,def patientEducationType) throws Exception{
					   int educationPoint = 0;
					   try{
						   if(mPatientEducationType!=null && !mPatientEducationType.equals("") && patientEducationType!=null && !patientEducationType.equals("") && patientEducationType.toString().trim().equals(mPatientEducationType.toString().trim())){
							   educationPoint = 3;
						   }else{
							   educationPoint = 0;
						   }
					   }catch(Exception exception){
							 throw exception
					   }
					   return educationPoint;
				   }
		//******************Dynamic Batch Process for Patient Match ends *************************
		 
		 
		 
	 
			   
			   
			   //*****************Dynamic Batch Process for current Patient Match starts***********************
				@Synchronized
				def doDynamicBatchProcessForCurrentPatient(def healpalUser){
					Patient currentPatient = null;
						 try{
										 def currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
										 //println "currentPerson::::::::::::::::::::::::::"+currentPerson
										 if(currentPerson!=null && !currentPerson.equals("")){
											  currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
											 //println "currentPatient:::::::::::::::::::::::"+currentPatient
										 }else{
											//do nothing
										 }
									  if(currentPatient!=null && !currentPatient.equals("")){
										  def patientCancerTypeName = getCurrentPatientCancerTypeName(currentPatient);
										   def mPatientList = Patient.createCriteria().list{
											  eq("isActive",Short.valueOf("1"))
											  ne("id",currentPatient?.id)
										  }
										  if(mPatientList!=null && mPatientList.size >0){
											  for(int j=0;j<mPatientList.size();j++){
												  int points = 0;
												  int totalPoints = 0;
												  def mPatient = mPatientList.get(j);
												  if(mPatient !=null && !mPatient.equals("")){
													def mPatientCancerTypeName = getCurrentPatientCancerTypeName(mPatient);
													if(patientCancerTypeName!=null && !patientCancerTypeName.equals("")
														 && mPatientCancerTypeName!=null && !mPatientCancerTypeName.equals("")
														 && mPatientCancerTypeName.equals(patientCancerTypeName)){
															//here added diagnosis points
															points = points + 20;
															totalPoints = totalPoints + 20;
															//here added dob points
															def mPatientDob = mPatient?.person?.dob
															def patientDob = currentPatient?.person?.dob
															def dobPoints = getCurrentPatientDobPoints(patientDob,mPatientDob);
															totalPoints = totalPoints + 5;
															points = points + dobPoints;
															//here added zip code points
															def patientZipCode = getCurrentPatientZipCode(currentPatient);
															def mPatientZipCode = getCurrentPatientZipCode(mPatient);
															def zipCodePoints = getCurrentPatientZipcodePoints(mPatientZipCode,patientZipCode);
															totalPoints = totalPoints + 10;
															points = points + zipCodePoints;
															//here added race points
															def patientRace = getCurrentPatientRace(currentPatient);
															def mPatientRace = getCurrentPatientRace(mPatient);
															def racePoints = getCurrentPatientRacePoints(mPatientRace,patientRace);
															totalPoints = totalPoints + 5;
															points = points + racePoints;
															//here added education points
															def patientEducationType = getCurrentPatientEducationType(currentPatient);
															def mPatientEducationType = getCurrentPatientEducationType(mPatient);
															def educationPoints = getCurrentPatientEducationPoints(mPatientEducationType,patientEducationType);
															totalPoints = totalPoints + 3;
															points = points + educationPoints;
															//here added health insurance points
															def healthInsurancePoints = getCurrentPatientHealthInsurancePoints(currentPatient,mPatient);
															totalPoints = totalPoints + 5;
															points = points + healthInsurancePoints;
															//here added cancer stage points
															def patientStageOfCancer = getCurrentPatientStageOfCancer(currentPatient);
															def mPatientStageOfCancer = getCurrentPatientStageOfCancer(mPatient);
															def cancerStagePoints = getCurrentPatientCencerStagePoints(mPatientStageOfCancer,patientStageOfCancer);
															totalPoints = totalPoints + 20;
															points = points + cancerStagePoints;
															//here add age of diagnosis points
															def ageOfDiagnosis    = getCurrentPatientAgeOfDiagnosis(currentPatient);
															def mAgeOfDiagnosis = getCurrentPatientAgeOfDiagnosis(mPatient);
															def ageOfDiagnosisPoints = getCurrentPatientAgeOfDiagnosisPoints(mAgeOfDiagnosis,ageOfDiagnosis);
															totalPoints = totalPoints + 5;
															points = points + ageOfDiagnosisPoints;
															
															Diagnosis diagnosis= Diagnosis.findByDiagnosisName(patientCancerTypeName);
															doProcessForCurrentPatient(diagnosis,currentPatient,mPatient,points,totalPoints);
													 }else{
															 //do nothing
														 }
															  
												 }else{
												  // println "PatientMatchService-doBatchProcess()---> mPatient is empty!!!!!!!!"
												  }
												  
											  }
										  }else{
										  // println "PatientMatchService-doBatchProcess()---> mPatient list is empty!!!!!!!!"
										  }
									 }else{
										   // println "PatientMatchService-doBatchProcess()---> healpal current patient is null..!!!!!!!!"
									  }
						 }catch(Exception exception){
							 exception.printStackTrace();
						 }
					 }
				
				
						  def doProcessForCurrentPatient(Diagnosis diagnosis,Patient currentPatient,Patient mPatient,int points,int totalPoints){
							 
							  try{
								  if(diagnosis && currentPatient && mPatient){
									  def profileQuestions = ProfileQuestions.createCriteria().list{
											  eq("isActive",Short.valueOf("1"))
											  eq("diagnosis",diagnosis)
										  }
									  println "profileQuestions:::"+profileQuestions
									  if(profileQuestions!=null && profileQuestions.size()>0){
										  for(int i=0;i<profileQuestions.size();i++){
											   def profile = profileQuestions.get(i);
											   totalPoints = totalPoints + profile?.patientMatchPoints;
											   def currPatientAnswer = ProfileQuestionAnswer.findByPatientAndProfileQuestionsAndIsActive(currentPatient,profile,Short.valueOf("1"))?.answer;
											   def matchPatientAnswer = ProfileQuestionAnswer.findByPatientAndProfileQuestionsAndIsActive(mPatient,profile,Short.valueOf("1"))?.answer;
											   if(currPatientAnswer!=null && !currPatientAnswer.equals("")
												   && matchPatientAnswer!=null && !matchPatientAnswer.equals("")
												   && currPatientAnswer.equals(matchPatientAnswer)){
													   points = points + profile?.patientMatchPoints;
											 }else{
												  //do nothing
											 }
										  }
									  }else{
										 //println "profileQuestions is null"
									  }
									  
									 }else{
										 //println "diagnosis or currentPatient or mPatient is null"
									}
									 
									 println "points::::::::::::"+points
									 println "totalPoints::::::::::::"+totalPoints
									 println "mPatient::::::::::::"+mPatient
									 println "currentPatient::::::::::::"+currentPatient
									 def percentage = calculateDynamicPercentageForCurrentPatient(points,totalPoints);
									 println "percentage::::::::::::"+percentage
									 dynamicInsertCurrentPatientMatch(mPatient,currentPatient,percentage);
									 
							  }catch(Exception exception){
									 exception.printStackTrace();
								 }
						  }
						  def calculateDynamicPercentageForCurrentPatient(int points,int totalPoints)throws Exception{
							  def percentage  ;
							  
							  try{
								   double percentageVal =  Math.round(points*100.0)/totalPoints;
								   DecimalFormat df = new DecimalFormat("###");
								   percentage = df.format(percentageVal);
							  }catch(Exception exception){
								  throw exception;
							  }
							  return percentage;
						  }
						  
						  def dynamicInsertCurrentPatientMatch(Patient matchPatient,Patient currentPatient,def percentage)throws Exception{
							  try{
								  if(matchPatient!=null && !matchPatient.equals("") && currentPatient!=null && !currentPatient.equals("") && percentage!=null && !percentage.toString().equals("")){
									def isExist = PatientMatch.findByCurrentPatientAndPatient(currentPatient,matchPatient);
									double percen = Double.parseDouble(percentage);
									if(isExist!=null && !isExist.equals("")){
										PatientMatch.executeUpdate("UPDATE  PatientMatch p set p.percentage=? WHERE p.currentPatient=? AND p.patient=?",[percen,currentPatient,matchPatient]);
										 }else{
										PatientMatch pMatch = new PatientMatch();
										pMatch.patient = matchPatient
										pMatch.currentPatient = currentPatient
										pMatch.percentage = percen
										pMatch.isActive = (short)1
										pMatch.rowCreated = new Date()
										pMatch.save()
									}
								   
								  }
							  }catch(Exception exception){
								throw exception;
							  }
					  }
						  //get patient cancer type
						  def getCurrentPatientCancerTypeName(def patient)throws Exception{
							  def patientCancerTypeName = "";
							  try{
								  if(patient!=null && !patient.equals("")){
									 patientCancerTypeName = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.diagnosis?.diagnosisName;
								  }else{
									//do nothing
								  }
							  }catch(Exception exception){
								  throw exception
							  }
							  return patientCancerTypeName;
						  }
						  
						  //get age of diagnosis
						  def getCurrentPatientAgeOfDiagnosis(def patient)throws Exception{
							  def ageOfDiagnosis;
							  try{
								  if(patient!=null && !patient.equals("")){
									  ageOfDiagnosis = PatientDiagnosis.findByPatientAndIsActive(patient,Short.valueOf("1"))?.ageOfDiagnosis;
								   }else{
									 //do nothing
								   }
							  }catch(Exception exception){
								 throw exception;
							  }
							  return ageOfDiagnosis
						  }
						  
						  def getCurrentPatientRace(def patient)throws Exception{
							  def raceName;
							  try{
								  if(patient!=null && !patient.equals("")){
									  raceName = TempQuestionOption.findByPatientAndQuestionName(patient,"Select your Race")?.value;
								   }else{
									 //do nothing
								   }
							  }catch(Exception exception){
								  throw exception;
							  }
							  return raceName;
						  }
						  
						  //get patient stage of breast cancer
						  def getCurrentPatientStageOfCancer(def patient)throws Exception{
							  def patientStageOfCancer = "";
							  try{
								  if(patient!=null && !patient.equals("")){
									 patientStageOfCancer = TempQuestionOption.findByPatientAndQuestionName(patient,"Stage of cancer")?.value;
								  }else{
								  //do nothing
								  }
							   }catch(Exception exception){
								  throw exception
							  }
							  return patientStageOfCancer
						  }
						  //get the zipcode for patient
						  def getCurrentPatientZipCode(def patient)throws Exception{
							  def patientZipCode ="";
							  try{
								  if(patient!=null && !patient.equals("")){
									 patientZipCode = PatientAddress.findByPatientAndIsActive(patient,Short.valueOf("1"))?.address?.zipcode;
								  }else{
								  //do nothing
								  }
							  }catch(Exception exception){
								  throw exception
							  }
							  return patientZipCode;
						  }
						 
						  //get the education for patient
						  def getCurrentPatientEducationType(def patient)throws Exception{
							  def patientEducationType = "";
							  try{
								  if(patient!=null && !patient.equals("")){
									  patientEducationType = PatientEducation.findByPatientAndIsActive(patient,Short.valueOf("1"))?.education?.educationType;
								  }else{
								  //do nothing
								  }
							  }catch(Exception exception){
								  throw exception
							  }
							  return patientEducationType
						  }
						  //get the health insurance for patient
						  def getCurrentPatientHealthInsurancePoints(Patient currentPatient,Patient mPatient)throws Exception{
							  def patientHealthInsuranceTypePoints = 0;
							  try{
								  if(currentPatient!=null && !currentPatient.equals("") && mPatient!=null && !mPatient.equals("")){
									 def patientHealthInsuranceType = PatientHealthInsurance.createCriteria().list{
										 eq("patient",currentPatient)
										 eq("isActive",Short.valueOf("1"))
									 }
									 if(patientHealthInsuranceType!=null && !patientHealthInsuranceType.equals("")){
										 for(int i=0;i<patientHealthInsuranceType.size();i++){
											 def healthInsuranceType = patientHealthInsuranceType.get(i)?.healthInsurance;
											 if(healthInsuranceType!=null && !healthInsuranceType.equals("")){
													 def checkPatientHealthInsurance = PatientHealthInsurance.createCriteria().list{
														 eq("patient",mPatient)
														 eq("healthInsurance",healthInsuranceType)
												   }
													 if(checkPatientHealthInsurance!=null && checkPatientHealthInsurance.size()>0){
															 patientHealthInsuranceTypePoints = 5;
													 }else{
														 
													 }
												
											 }
										   }
									 }else{
										//do nothing
									 }
								  }else{
								  //do nothing
								  }
							  }catch(Exception exception){
								  throw exception
							  }
							  return patientHealthInsuranceTypePoints;
						  }
						  
						  
						  
						  
						  def getCurrentPatientAgeOfDiagnosisPoints(def mAgeOfDiagnosis,def ageOfDiagnosis)throws Exception{
								  int ageOfDiagnosisPoint = 0;
								  try{
									  if(mAgeOfDiagnosis!=null && !mAgeOfDiagnosis.equals("") && ageOfDiagnosis!=null && !ageOfDiagnosis.equals("") && mAgeOfDiagnosis.toString().trim().equals(ageOfDiagnosis.toString().trim())){
										  ageOfDiagnosisPoint = 5;
									  }else{
										  ageOfDiagnosisPoint = 0;
									  }
								  }catch(Exception exception){
									 throw exception
								  }
								  return ageOfDiagnosisPoint;
							  }
							  
						  
						  def getCurrentPatientCencerStagePoints(def mPatientStageOfCancer,def patientStageOfCancer) throws Exception{
								  int cancerStagePoint = 0;
								  try{
									  if(mPatientStageOfCancer!=null && !mPatientStageOfCancer.equals("") && patientStageOfCancer!=null && !patientStageOfCancer.equals("") && patientStageOfCancer.toString().trim().equals(mPatientStageOfCancer.toString().trim())){
										  cancerStagePoint = 20;
									  }else{
										  cancerStagePoint = 0;
									  }
								  }catch(Exception exception){
										throw exception
								  }
								  return cancerStagePoint;
							  }
							  
							  def  getCurrentPatientDobPoints(def patientDob,def mPatientDob)throws Exception{
								  int dobPoints = 0;
								  try{
									  if(patientDob!=null && !patientDob.equals("") && mPatientDob!=null && !mPatientDob.equals("")){
									  Calendar currPatientdate =Calendar.getInstance();
									  currPatientdate.setTime(patientDob);
									  Calendar mPatientdate =Calendar.getInstance();
									  mPatientdate.setTime(mPatientDob);
									  int year = currPatientdate.get(Calendar.YEAR) - mPatientdate.get(Calendar.YEAR);
									  if(year <= 5 && year >= -5){
										  dobPoints = 5;
									  }else{
										  dobPoints = 0;
									  }
								   }
								  }catch(Exception exception){
									throw exception;
								  }
								  return dobPoints;
							  }
							  
							  def getCurrentPatientRacePoints(def mPatientRace,def patientRace) throws Exception{
								  int racePoint = 0;
								  try{
									  if(mPatientRace!=null && !mPatientRace.equals("") && patientRace!=null && !patientRace.equals("") && patientRace.toString().trim().equals(mPatientRace.toString().trim())){
										  racePoint = 5;
									  }else{
										  racePoint = 0;
									  }
								  }catch(Exception exception){
										throw exception
								  }
								  return racePoint;
							  }
							  
							  def getCurrentPatientZipcodePoints(def mPatientZipCode,def patientZipCode) throws Exception{
								  int zipPoint = 0;
								  try{
									  if(mPatientZipCode!=null && !mPatientZipCode.equals("") && patientZipCode!=null && !patientZipCode.equals("") && patientZipCode.toString().trim().equals(mPatientZipCode.toString().trim())){
										  zipPoint = 10;
									  }else{
										  zipPoint = 0;
									  }
								  }catch(Exception exception){
										throw exception
								  }
								  return zipPoint;
							  }
						  
							  def getCurrentPatientEducationPoints(def mPatientEducationType,def patientEducationType) throws Exception{
								  int educationPoint = 0;
								  try{
									  if(mPatientEducationType!=null && !mPatientEducationType.equals("") && patientEducationType!=null && !patientEducationType.equals("") && patientEducationType.toString().trim().equals(mPatientEducationType.toString().trim())){
										  educationPoint = 3;
									  }else{
										  educationPoint = 0;
									  }
								  }catch(Exception exception){
										throw exception
								  }
								  return educationPoint;
							  }
				   //******************Dynamic Batch Process for current Patient Match ends *************************
}
