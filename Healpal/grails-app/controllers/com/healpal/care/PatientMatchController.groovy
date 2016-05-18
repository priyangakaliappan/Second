
/**
* Author    : Thirumal R
* Project   : HealPal
* Date      : 11/02/2015
* FileName  : PatientMatchController
*
* #      Name         Version   Modified-Date      Description
* -------------------------------------------------------------------------------------
* 1      Thirumal R     1.0       11/02/2015      Initial Creation
*
*
**/


package com.healpal.care
import java.text.DecimalFormat
class PatientMatchController {
def patientMatchService
def messageService
    def index() {
		redirect(action:'patientMatch');
	}
	def patientMatch(){
		def patientMatchMap;
		def patientMatchMapTotal;
		ArrayList patientKeylist = new ArrayList();
		def messageGroupList
		def cancerStageList 
		def cancerStatusList;
		try{
			   authorizeMe()
			   HealpalUser healpalUser = session.user;
			  // session.sortAge = "";
			  // session.sortLocation = "";
			    params.max = Math.min(params.max ? params.int('max') : 10, 100)
				patientMatchMap = patientMatchService.getPatientMatch(healpalUser,params);
				patientMatchMapTotal = patientMatchService.getPatientMatchTotal(healpalUser,null);
				if(patientMatchMap!=null && !patientMatchMap.equals("")){
					for(int i=0;i<patientMatchMap.size();i++){
						   if(i<10){
							    def patientMatch = patientMatchMap.get(i);
								  patientKeylist.add(patientMatch);
						   }else{
						        //do nothing
						   }
					}
				}else{
				     //do nothing
				}
				messageGroupList = messageService.getGroupList(healpalUser)
				 cancerStageList = CancerStage.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('cancerStageLevel','asc')
				  }
				 cancerStatusList = AboutYou.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('aboutYouName','asc')
				  }
			session.patientKeylist = patientMatchMap;
			[patientList:patientKeylist,patientMatchMapTotal:patientMatchMapTotal?.size(),messageGroupList:messageGroupList,matchActive : 'active',cancerStageList:cancerStageList,isViewed:"no",offset:10 ,max : params.max,cancerStatusList:cancerStatusList]//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(healpalUser?.id)?.person))?.profilePhotoPath
		}catch(Exception exception){
		    exception.printStackTrace();
		}
	}
	
	
	def ajaxPaginatePatientMatch(){
		ArrayList patientMatchMap = new ArrayList();
		ArrayList patientmatchList = new ArrayList();
		try{
			authorizeMe()
			HealpalUser healpalUser = session.user;
			def toAge = params.toAge
			def zipcode = params.zipcode
			def fromAge = params.fromAge
			def selectedCancerStage = params.selectedCancerStage
			def patientMatchSearch = params.patientMatchSearch;
			def selectedCancerStatus = params.selectedCancerStatusList
			if(selectedCancerStage instanceof String){
				if(selectedCancerStage.equalsIgnoreCase("[]")){
					selectedCancerStage = "";
				}
				
			}
			if(selectedCancerStatus instanceof String){
				if(selectedCancerStatus.equalsIgnoreCase("[]")){
					selectedCancerStatus = "";
				}
				
			}
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			int off = Integer.parseInt(params.offset);
			int mSize = off + 10 ;
			if(session.searchVal!=null && !session.searchVal.isEmpty()){
				patientmatchList = session.patientMatchSearchList
				for(int i=0;i<mSize;i++){
					PatientMatch patientMatch = null;
					  if(i < patientmatchList.size()){
						  patientMatch = patientmatchList.get(i);
						  patientMatchMap.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
					  }
				 }
			}else if(toAge!=null && !toAge.isEmpty() && !toAge.equalsIgnoreCase("null") && fromAge!=null && !fromAge.isEmpty() && !fromAge.equalsIgnoreCase("null") || 
				zipcode!=null && !zipcode.isEmpty() && !zipcode.equalsIgnoreCase("null") || selectedCancerStage!=null && !selectedCancerStage.isEmpty() && !selectedCancerStage.equalsIgnoreCase("null") || 
				    patientMatchSearch!=null && !patientMatchSearch.equals("") && !patientMatchSearch.equalsIgnoreCase("null") || selectedCancerStatus!=null && !selectedCancerStatus.isEmpty() && !selectedCancerStatus.equalsIgnoreCase("null")){
				
					if(session.patientKeylistForPagination){
					 patientmatchList = session.patientKeylistForPagination
				  for(int i=0;i<mSize;i++){
					  PatientMatch patientMatch = null;
					    if(i < patientmatchList.size()){
						    patientMatch = patientmatchList.get(i);
						    patientMatchMap.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
					    }
				   }
				}else{
				   //do nothing
				}
			}else{
			      if(session.patientKeylist){
				    patientmatchList = session.patientKeylist
				  for(int i=0;i<mSize;i++){
					  PatientMatch patientMatch = null;
					    if(i < patientmatchList.size()){
						    patientMatch = patientmatchList.get(i);
						    patientMatchMap.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
					    }
				   }
				}else{
				   //do nothing
				}
			}
			params.offset = mSize;
			int totalSize = Integer.parseInt(params.size);
			render (template :'patientMatchList' ,model:[patientList:patientMatchMap ,patientMatchMapTotal:totalSize ,offset:params.offset ,max :params.max,toAge:toAge,zipcode:zipcode,fromAge:fromAge,selectedCancerStage:selectedCancerStage,selectedCancerStatusList:selectedCancerStatus,patientMatchSearch:patientMatchSearch])//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(healpalUser?.id)?.person))?.profilePhotoPath
		}catch(Exception exception){
		  exception.printStackTrace();
		}
	}
	def sendRequest(){
		authorizeMe();
		HealpalUser user;
		def toAge = params.toAge
		def zipcode = params.zipcode
		def fromAge = params.fromAge
		def selectedCancerStage = params.selectedCancerStage
		def selectedCancerStatus = params.selectedCancerStatusList
		if(selectedCancerStage instanceof String){
			if(selectedCancerStage.equalsIgnoreCase("[]")){
				selectedCancerStage = "";
			}
			
		}
		if(selectedCancerStatus instanceof String){
			if(selectedCancerStatus.equalsIgnoreCase("[]")){
				selectedCancerStatus = "";
			}
			
		}
		def patientMatchSearch = params.patientMatchSearch
		ArrayList patientmatchList = new ArrayList();
		ArrayList patientKeylist = new ArrayList();
		def patientMatchMapTotal
		try{
			 user = session.user
			if(params != null && params.patientId != null && params.patientId != ""){
				messageService.sendRequest(params.patientId, user);
				//def patientMatchMap = patientMatchService.getPatientMatch(user);
				if(session.searchVal!=null && !session.searchVal.isEmpty()){
					 patientKeylist = session.patientMatchSearchList
					if(patientKeylist!=null && patientKeylist.size()>0){
						for(int i=0;i<10;i++){
							PatientMatch patientMatch = null;
							  if(i < patientKeylist.size()){
								  patientMatch = patientKeylist.get(i);
								  patientmatchList.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
							  }
						 }
				  }
					patientMatchMapTotal = patientKeylist;
				}else if(toAge!=null && !toAge.isEmpty() && !toAge.equalsIgnoreCase("null") && fromAge!=null && !fromAge.isEmpty() && !fromAge.equalsIgnoreCase("null") ||
					zipcode!=null && !zipcode.isEmpty() && !zipcode.equalsIgnoreCase("null") || selectedCancerStage!=null && !selectedCancerStage.isEmpty() && !selectedCancerStage.equalsIgnoreCase("null") ||
					  patientMatchSearch!=null && !patientMatchSearch.equals("") && !patientMatchSearch.equalsIgnoreCase("null") || selectedCancerStatus!=null && !selectedCancerStatus.isEmpty() && !selectedCancerStatus.equalsIgnoreCase("null")){
					 patientKeylist = session.patientKeylistForPagination
					if(patientKeylist!=null && patientKeylist.size()>0){
						for(int i =0;i<10;i++){
							if(i < patientKeylist.size()){
								def patientMatch = patientKeylist.get(i);
								if(patientMatch){
									patientmatchList.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
								}
							}
						}
					}
					patientMatchMapTotal = patientKeylist;
				}else{
						 patientKeylist = session.patientKeylist
						if(patientKeylist!=null && patientKeylist.size()>0){
							for(int i =0;i<10;i++){
								if(i < patientKeylist.size()){
									def patientMatch = patientKeylist.get(i);
									if(patientMatch){
										patientmatchList.add(PatientMatch.get(patientMatch?.id?.toString()?.toLong()));
									}
								}
							}
						}
						patientMatchMapTotal = patientKeylist
				    /*patientmatchList = session.patientKeylist
					patientMatchMapTotal = patientMatchService.getPatientMatchTotal(user,null);*/
				}
			}else{
				//do nothing
			}
		}catch(Exception exception){
			exception.printStackTrace();
		}
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		//ArrayList patientKeylist = session.patientKeylist;
		render(template:'patientMatchList',model:[patientList:patientmatchList,patientMatchMapTotal:patientMatchMapTotal?.size(),offset:10 ,max : params.max,toAge:toAge,zipcode:zipcode,fromAge:fromAge,selectedCancerStage:selectedCancerStage,patientMatchSearch:patientMatchSearch]);//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(user?.id)?.person))?.profilePhotoPath
	}
	def authorizeMe(){
		if(session.user && session.authority?.equalsIgnoreCase(Role.patient)){
			//do nothing
		}else{
			redirect controller :'auth' ,action :'doLogout'
		}
	}
	def allMatchPatientList(){
		HealpalUser healpalUser;
		def patientMatchMap;
		def cancerStageList
		ArrayList patientKeylist = new ArrayList();
		try{
			    authorizeMe()
				healpalUser = session.user;
				session.sortAge = "";
				session.sortLocation = "";
				patientMatchMap = patientMatchService.getPatientMatch(healpalUser);
				if(patientMatchMap!=null && !patientMatchMap.equals("")){
					for(int i=0;i<patientMatchMap.size();i++){
							def patientMatch = patientMatchMap.get(i);
							patientKeylist.add(patientMatch);
					}
				}else{
					 //do nothing
				}
				def messageGroupList = messageService.getGroupList(healpalUser)
				cancerStageList = CancerStage.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('cancerStageLevel','asc')
				  }
				def cancerStatusList = AboutYou.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('aboutYouName','asc')
				  }
				session.patientKeylist = patientKeylist;
				render(view:'patientMatch',model:[patientList:patientKeylist,messageGroupList:messageGroupList,matchActive : 'active',isViewed:"yes",cancerStageList:cancerStageList,cancerStatusList:cancerStatusList]);//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(healpalUser?.id)?.person))?.profilePhotoPath
			
		}catch(Exception exception){
		   exception.printStackTrace();
		}
	}
	def calPercentage(def points)throws Exception{
		def percentage  ;
		
		try{
			 double percentageVal =  Math.round(points*100.0)/208.0;
			 DecimalFormat df = new DecimalFormat("###.##");
			 percentage = df.format(percentageVal);
		}catch(Exception exception){
		    throw exception;
		}
		return percentage;
	}
	def searchPatientMatch(){
		ArrayList patientMatchList = new ArrayList();
		ArrayList patientSearchList = new ArrayList();
		def healpalUser
		try{
		    authorizeMe()
			def fromAge = params.fromAge;
			def toAge = params.toAge
			def zipcode = params.zipcode;
			def cancerStage = params.cancerStage
			def cancerStatus = params.cancerStatus
			def patientMatchSearch = params.matches
		    def searchVal = params.searchValue
			session.searchVal = searchVal;
			healpalUser = session.user;
			if(toAge!=null && !toAge.isEmpty() && !toAge.equalsIgnoreCase("null") && fromAge!=null && !fromAge.isEmpty() && !fromAge.equalsIgnoreCase("null") ||
				zipcode!=null && !zipcode.isEmpty() && !zipcode.equalsIgnoreCase("null") || cancerStatus!=null && !cancerStatus.isEmpty() && !cancerStatus.equals("false")  ||
				  patientMatchSearch!=null && !patientMatchSearch.equals("") && !patientMatchSearch.equalsIgnoreCase("null") || cancerStage!=null && !cancerStage.isEmpty() && !cancerStage.equals("false")){
				 
				   if(session.patientKeylistForPagination){
					  def patientmatchList = session.patientKeylistForPagination
				       for(int i=0;i<patientmatchList.size();i++){
							def patientMatch = patientmatchList.get(i);
							PatientMatch  match = PatientMatch.get(patientMatch?.id?.toString().toLong())
						    def personId = Person.get(match?.patient?.person?.id?.toString().toLong())?.id;
							def patientList = Person.createCriteria().list{
								eq("id",personId)
								if(searchVal!=null && !searchVal.isEmpty()){
									or{
										ilike("fullName","%"+searchVal+"%")
										//ilike("firstName","%"+searchVal+"%")
									}
								}
							}
							if(patientList!=null && !patientList.isEmpty()){
								patientMatchList.add(match);
							}
					    }
					 }else{
						//do nothing
					 }
				 
			}else{
				ArrayList patientKeylist = session.patientKeylist
				if(patientKeylist!=null && patientKeylist.size()>0){
					for(int i =0;i<patientKeylist.size();i++){
							def patientMatch = patientKeylist.get(i);
							PatientMatch  match = PatientMatch.get(patientMatch?.id?.toString().toLong())
							def personId = Person.get(match?.patient?.person?.id?.toString().toLong())?.id;
							def patientList = Person.createCriteria().list{
								eq("id",personId)
								if(searchVal!=null && !searchVal.isEmpty()){
									or{
										ilike("fullName","%"+searchVal+"%")
										//ilike("firstName","%"+searchVal+"%")
									}
								}
							}
							if(patientList!=null && !patientList.isEmpty()){
								patientMatchList.add(match);
							}
					       }
				         }
			       }
			  if(patientMatchList!=null && patientMatchList.size() > 0){
				  for(int i =0;i<10;i++){
					  if(i < patientMatchList.size()){
						  def patientMatch = patientMatchList.get(i);
						  if(patientMatch){
							  patientSearchList.add(patientMatch);
						  }
					  }
				  }
			  }else{
			    //do nothing
			  }
			  session.patientMatchSearchList = patientMatchList;
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			render(template:'patientMatchList',model:[patientList:patientSearchList,patientMatchMapTotal:patientMatchList?.size(),offset:10 ,max : params.max]);
		
	 }catch(Exception exception){
		    exception.printStackTrace();
	 }
}
	
	def homePageFilter(){
		def patientMatchMap;
		ArrayList patientList = new ArrayList();
		ArrayList patientKeylist = new ArrayList();
		ArrayList patientKeylistPagination = new ArrayList();
		try{
		def cancerStage = params.cancerStage
		def cancerStatus = params.cancerStatus
		authorizeMe()
		HealpalUser healpalUser = session.user;
		patientMatchMap = patientMatchService.getPatientMatchTotal(healpalUser,null);
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
					if(cancerStage!=null && !cancerStage.equals("") && cancerStatus!=null && !cancerStatus.equals("")){
						def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && patientStatusOfCancerName?.trim().equalsIgnoreCase(cancerStatus?.trim())
							&& patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && patientStageOfCancerName?.trim().equalsIgnoreCase(cancerStage?.trim())){
							patientKeylist.add(patientMatch);
						}
						
					}else if(cancerStage!=null && !cancerStage.equals("")){
					def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
					if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && patientStageOfCancerName?.trim().equalsIgnoreCase(cancerStage?.trim())){
						patientKeylist.add(patientMatch);
					}
					}else if(cancerStatus!=null && !cancerStatus.equals("")){
					def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
					if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && patientStatusOfCancerName?.trim().equalsIgnoreCase(cancerStatus?.trim())){
						patientKeylist.add(patientMatch);
					}
					}else{
					   patientKeylist = patientList;
					}
				}
				if(patientKeylist!=null && patientKeylist.size()>0){
					for(int i =0;i<10;i++){
						if(i < patientKeylist.size()){
							def patientMatch = patientKeylist.get(i);
							if(patientMatch){
								patientKeylistPagination.add(patientMatch);
							}
						}
					}
				}
				}
			def messageGroupList = messageService.getGroupList(healpalUser)
			def cancerStageList = CancerStage.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('cancerStageLevel','asc')
				  }
			def cancerStatusList = AboutYou.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('aboutYouName','asc')
				  }
			session.patientKeylist = patientKeylist;
			session.patientKeylistForPagination = patientKeylist;
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			render(view:'patientMatch',model:[patientList:patientKeylistPagination,patientMatchMapTotal:patientKeylist?.size(),messageGroupList:messageGroupList,matchActive : 'active',cancerStageList:cancerStageList,selectedCancerStage:cancerStage,selectedCancerStatusList:cancerStatus,offset:10 ,max : params.max,cancerStatusList:cancerStatusList,photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(healpalUser?.id)?.person))?.profilePhotoPath]);
			
		}catch(Exception ex){
		  ex.printStackTrace();
		}
	}
	
	def filterMatchPatientList(){
		ArrayList patientList = new ArrayList();
		ArrayList patientKeylist = new ArrayList();
		ArrayList patientKeylistPagination = new ArrayList();
		def patientMatchMap;
		int toAge ;
		int fromAge ;
		def cancerStageList
		ArrayList selectedCancerStage=new ArrayList();
		ArrayList selectedCancerStatus=new ArrayList();
		def cancerName = "";
		def cancerStatusVal = "";
		def healpalUser
		def patientMatchSearch = null;
		try{
		authorizeMe()
			def ageFrom = params.fromAge
			def ageTo = params.toAge
			def zipCode = params.zipcode
			ArrayList cancerStage = new ArrayList();
			ArrayList cancerStatus = new ArrayList();
			def cancerStageValue = params.cancerStage
			def cancerStatusValue = params.cancerStatus
			def miles = params.miles;
			healpalUser = session.user;		
			patientMatchSearch = params.matches	;
			String[] cancerStageArr = cancerStageValue.split(",");
			String[] cancerStatusArr = cancerStatusValue.split(",");
			for(int i=0;i<cancerStatusArr.length;i++){
				if(cancerStatusArr[i]!=null && !cancerStatusArr[i].isEmpty()){
				       cancerStatus.add(cancerStatusArr[i]);
				}
			}
			for(int i=0;i<cancerStageArr.length;i++){
				if(cancerStageArr[i]!=null && !cancerStageArr[i].isEmpty()){
				     cancerStage.add(cancerStageArr[i]);
				}
			}
			patientMatchMap = patientMatchService.getPatientMatchTotal(healpalUser,patientMatchSearch);
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
					 if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("") && zipCode!=null && !zipCode.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStatus!=null && !cancerStatus.equals("") && cancerStatus.size()>0 && cancerStage.size()>0){
						 println "inside PatientMatch:filterMatchPatientList()-->age ,zip code,cancer stage ,cancerStatus filter !!!!!!!!"
						 def dateOfBirth = patientMatch?.patient?.person?.dob
						 def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
						 def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						 def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						 boolean isExistCancerStage = false;
						 boolean isExistCancerStatus = false;
							  for(int j=0;j<cancerStage.size();j++){
									  cancerName = cancerStage.get(j);
									  selectedCancerStage.add(cancerName);
									 if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											 && !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											isExistCancerStage = true;
									 }
									
								 }
							  for(int j=0;j<cancerStatus.size();j++){
								  cancerStatusVal = cancerStatus.get(j);
								  selectedCancerStatus.add(cancerStatusVal);
								 if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
										 && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
										isExistCancerStatus = true;
								 }
								
							 }
							  if(dateOfBirth!=null && !dateOfBirth.equals("")){
								  Calendar patientdate =Calendar.getInstance();
								  patientdate.setTime(dateOfBirth);
								  Calendar currDate =Calendar.getInstance();
								  currDate.setTime(new Date());
								  int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
								  toAge = Integer.parseInt(ageTo);
								  fromAge = Integer.parseInt(ageFrom);
								  if(year >= fromAge && year <= toAge && pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) && isExistCancerStage && isExistCancerStatus){
									  patientKeylist.add(patientMatch);
								  }
							  }
					}
					 //****************FRom Date ,To Date , zipcode,cancer status and cancer stage Filter ends********************************************
					//****************FRom Date ,To Date , cancer status and cancer stage Filter Starts********************************************
					 else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("")  && cancerStatus!=null && !cancerStatus.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStatus.size()>0 && cancerStage.size()>0){
						  println "inside PatientMatch:filterMatchPatientList()-->age ,cancer status,cancer stage filter !!!!!!!!"
						  def dateOfBirth = patientMatch?.patient?.person?.dob
						   def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						  def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						     boolean isExistCancerStage = false;
							 boolean isExistCancerStatus = false;
							  for(int j=0;j<cancerStage.size();j++){
									  cancerName = cancerStage.get(j);
									  selectedCancerStage.add(cancerName);
									 if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											 && !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											isExistCancerStage = true;
									 }
									
								 }
							  for(int j=0;j<cancerStatus.size();j++){
								  cancerStatusVal = cancerStatus.get(j);
								  selectedCancerStatus.add(cancerStatusVal);
								 if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
										 && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
										isExistCancerStatus = true;
								 }
								
							 }
							  if(dateOfBirth!=null && !dateOfBirth.equals("")){
								  Calendar patientdate =Calendar.getInstance();
								  patientdate.setTime(dateOfBirth);
								  Calendar currDate =Calendar.getInstance();
								  currDate.setTime(new Date());
								  int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
								  toAge = Integer.parseInt(ageTo);
								  fromAge = Integer.parseInt(ageFrom);
								  if(year >= fromAge && year <= toAge && isExistCancerStage && isExistCancerStatus){
									  patientKeylist.add(patientMatch);
								  }
							   }
					 }
					  //****************FRom Date ,To Date , cancer status and cancer stage Filter ends********************************************
					
					  //****************zipcode , cancer status and cancer stage Filter Starts********************************************
					   
					  else if(zipCode!=null && !zipCode.equals("")  && cancerStatus!=null && !cancerStatus.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStatus.size()>0 && cancerStage.size()>0){
						   println "inside PatientMatch:filterMatchPatientList()-->zip code ,cancer status,cancer stage filter !!!!!!!!"
						    def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
							def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						    def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
							boolean isExistCancerStage = false;
							  boolean isExistCancerStatus = false;
							   for(int j=0;j<cancerStage.size();j++){
									   cancerName = cancerStage.get(j);
									   selectedCancerStage.add(cancerName);
									  if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											  && !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											 isExistCancerStage = true;
									  }
									 
								  }
							   for(int j=0;j<cancerStatus.size();j++){
								  cancerStatusVal = cancerStatus.get(j);
								   selectedCancerStatus.add(cancerStatusVal);
								  if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
										  && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
										 isExistCancerStatus = true;
								  }
								 
							  }
							   
								   if(pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) && isExistCancerStage && isExistCancerStatus){
									   patientKeylist.add(patientMatch);
								   }
						 }
					   //****************zip code , cancer status and cancer stage Filter ends********************************************
					  //****************FRom Date ,To Date , cancer status and zip code Filter Starts********************************************
					   else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("")  && cancerStatus!=null && !cancerStatus.equals("") && zipCode!=null && !zipCode.equals("") && cancerStatus.size()>0){
						   println "inside PatientMatch:filterMatchPatientList()-->age ,cancer status,zip code filter !!!!!!!!"
						   def dateOfBirth = patientMatch?.patient?.person?.dob
						   def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
						   def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
						     boolean isExistCancerStatus = false;
							  for(int j=0;j<cancerStatus.size();j++){
								   cancerStatusVal = cancerStatus.get(j);
								   selectedCancerStatus.add(cancerStatusVal);
								  if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
										  && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
										 isExistCancerStatus = true;
								  }
								 
							  }
							   if(dateOfBirth!=null && !dateOfBirth.equals("")){
								   Calendar patientdate =Calendar.getInstance();
								   patientdate.setTime(dateOfBirth);
								   Calendar currDate =Calendar.getInstance();
								   currDate.setTime(new Date());
								   int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
								   toAge = Integer.parseInt(ageTo);
								   fromAge = Integer.parseInt(ageFrom);
								   if(year >= fromAge && year <= toAge && pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) && isExistCancerStatus){
									   patientKeylist.add(patientMatch);
								   }
								}
							   
							}
					   //****************FRom Date ,To Date , cancer status and zipcode Filter ends********************************************
					  //****************FRom Date ,To Date , zipcode and cancer stage Filter Starts********************************************
					else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("") && zipCode!=null && !zipCode.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStage.size()>0){
						println "inside PatientMatch:filterMatchPatientList()-->age ,zip code,cancer stage filter !!!!!!!!"
						def dateOfBirth = patientMatch?.patient?.person?.dob
						def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
						def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
						for(int j=0;j<cancerStage.size();j++){
									 cancerName = cancerStage.get(j);
									 selectedCancerStage.add(cancerName);
									if(dateOfBirth!=null && !dateOfBirth.equals("")){
										Calendar patientdate =Calendar.getInstance();
										patientdate.setTime(dateOfBirth);
										Calendar currDate =Calendar.getInstance();
										currDate.setTime(new Date());
										int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
										toAge = Integer.parseInt(ageTo);
										fromAge = Integer.parseInt(ageFrom);
										if(year >= fromAge && year <= toAge && pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) &&
											patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											&& !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											patientKeylist.add(patientMatch);
										}
									}
									
								}
					    }
					
					//****************FRom Date ,To Date , zipcode and cancer stage Filter ends********************************************
					//****************FRom Date To Date and zipcode Filter Starts********************************************
							else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("") && zipCode!=null && !zipCode.equals("")){
								println "inside PatientMatch:filterMatchPatientList()-->age ,zip code filter !!!!!!!!"
								def dateOfBirth = patientMatch?.patient?.person?.dob
								def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
								if(dateOfBirth!=null && !dateOfBirth.equals("")){
								Calendar patientdate =Calendar.getInstance();
								patientdate.setTime(dateOfBirth);
								Calendar currDate =Calendar.getInstance();
								currDate.setTime(new Date());
								int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
								toAge = Integer.parseInt(ageTo);
								fromAge = Integer.parseInt(ageFrom);
								if(year >= fromAge && year <= toAge && pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode)){
									patientKeylist.add(patientMatch);
								}
								}
							}
							//****************FRom Date To Date and zipcode Filter ends********************************************
							
							//****************FRom Date ,To Date  and cancer stage Filter Starts********************************************
							else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStage.size()>0){
								println "inside PatientMatch:filterMatchPatientList()-->age ,cancer stage filter !!!!!!!!"
								def dateOfBirth = patientMatch?.patient?.person?.dob
								def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
								for(int j=0;j<cancerStage.size();j++){
										 cancerName = cancerStage.get(j);
										 selectedCancerStage.add(cancerName);
										if(dateOfBirth!=null && !dateOfBirth.equals("")){
										Calendar patientdate =Calendar.getInstance();
										patientdate.setTime(dateOfBirth);
										Calendar currDate =Calendar.getInstance();
										currDate.setTime(new Date());
										int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
										toAge = Integer.parseInt(ageTo);
										fromAge = Integer.parseInt(ageFrom);
										if(year >= fromAge && year <= toAge && patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											&& !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											patientKeylist.add(patientMatch);
										}
										}
									}
								}
							
							//****************FRom Date ,To Date  and cancer stage Filter ends********************************************
							//****************cancer status  and cancer stage Filter Starts********************************************
					 else if(cancerStatus!=null && !cancerStatus.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStatus.size()>0 && cancerStage.size()>0){
								 println "inside PatientMatch:filterMatchPatientList()-->cancer status ,cancer stage filter !!!!!!!!"
								 def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
								 def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
								 boolean isExistCancerStage = false;
								 boolean isExistCancerStatus = false;
							  for(int j=0;j<cancerStage.size();j++){
									  cancerName = cancerStage.get(j);
									  selectedCancerStage.add(cancerName);
									 if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											 && !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											isExistCancerStage = true;
									 }
									
								 }
							  for(int j=0;j<cancerStatus.size();j++){
								  cancerStatusVal = cancerStatus.get(j);
								  selectedCancerStatus.add(cancerStatusVal);
								 if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
										 && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
										isExistCancerStatus = true;
								 }
								
							 }
							  
								  if(isExistCancerStage && isExistCancerStatus){
									  patientKeylist.add(patientMatch);
								  }
							  }
						
							 //****************FRom Date ,To Date  and cancer stage Filter ends********************************************
							
						   //****************FRom Date ,To Date  and cancer status Filter Starts********************************************
							 else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("") && cancerStatus!=null && !cancerStatus.equals("") && cancerStatus.size()>0){
								 println "inside PatientMatch:filterMatchPatientList()-->age ,cancer status filter !!!!!!!!"
								  def dateOfBirth = patientMatch?.patient?.person?.dob
								  def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
								  boolean isExistCancerStatus = false;
									  for(int j=0;j<cancerStatus.size();j++){
										   cancerStatusVal = cancerStatus.get(j);
										   selectedCancerStatus.add(cancerStatusVal);
										  if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
												  && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
												 isExistCancerStatus = true;
										  }
										 
									  }
									   if(dateOfBirth!=null && !dateOfBirth.equals("")){
										   Calendar patientdate =Calendar.getInstance();
										   patientdate.setTime(dateOfBirth);
										   Calendar currDate =Calendar.getInstance();
										   currDate.setTime(new Date());
										   int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
										   toAge = Integer.parseInt(ageTo);
										   fromAge = Integer.parseInt(ageFrom);
										   if(year >= fromAge && year <= toAge && isExistCancerStatus){
											   patientKeylist.add(patientMatch);
										   }
										}
								 }
							 //****************FRom Date ,To Date  and cancer status Filter ends********************************************
							
							//**************** zipcode and cancer stage Filter Starts********************************************
							else if(zipCode!=null && !zipCode.equals("") && cancerStage!=null && !cancerStage.equals("") && cancerStage.size()>0){
								println "inside PatientMatch:filterMatchPatientList()-->zip code,cancer stage filter !!!!!!!!"
								def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
								def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
								for(int j=0;j<cancerStage.size();j++){
										 cancerName = cancerStage.get(j);
										 selectedCancerStage.add(cancerName);
										 if(pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) &&
											patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null
											&& !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
											patientKeylist.add(patientMatch);
										}
									}
							  }
							
							//****************zipcode and cancer stage ends Filter Starts********************************************
							
							//**************** zipcode and cancerStatus Filter Starts********************************************
							 else if(zipCode!=null && !zipCode.equals("") && cancerStatus!=null && !cancerStatus.equals("") && cancerStatus.size()>0){
								 println "inside PatientMatch:filterMatchPatientList()-->zip code,cancerStatus filter !!!!!!!!"
								 def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
								 def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
								boolean isExistCancerStatus = false;
									  for(int j=0;j<cancerStatus.size();j++){
										   cancerStatusVal = cancerStatus.get(j);
										   selectedCancerStatus.add(cancerStatusVal);
										  if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null
												  && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
												 isExistCancerStatus = true;
										  }
										 
									  }
									  if(pZipCode!=null && !pZipCode.equals("") &&  pZipCode.equals(zipCode) && isExistCancerStatus){
										  patientKeylist.add(patientMatch);
									  }
							  }
							
							 //****************zipcode and cancerStatus Filter ends********************************************
							 
							 
				        	//****************FRom Date To Date Filter Starts********************************************
							else if(ageFrom!=null && !ageFrom.equals("") && ageTo!=null && !ageTo.equals("")){
						   println "inside PatientMatch:filterMatchPatientList()-->age  stage filter !!!!!!!!"
							def dateOfBirth = patientMatch?.patient?.person?.dob
							if(dateOfBirth!=null && !dateOfBirth.equals("")){
							Calendar patientdate =Calendar.getInstance();
							patientdate.setTime(dateOfBirth);
							Calendar currDate =Calendar.getInstance();
							currDate.setTime(new Date());
							int year = currDate.get(Calendar.YEAR) - patientdate.get(Calendar.YEAR);
							 toAge = Integer.parseInt(ageTo);
							 fromAge = Integer.parseInt(ageFrom);
							if(year >= fromAge && year <= toAge){
								patientKeylist.add(patientMatch);
							}
							}
						   }
							//****************FRom Date To Date Filter ends********************************************
							
							//****************Zip code Filter starts********************************************
							else if(zipCode!=null && !zipCode.equals("")){
								println "inside PatientMatch:filterMatchPatientList()-->zip code stage filter !!!!!!!!"
								def pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
								if(pZipCode!=null && !pZipCode.equals("") && pZipCode.equals(zipCode)){
									patientKeylist.add(patientMatch);
								}
							}
							//****************zipcode Filter ends********************************************
							//****************cancer stage Filter starts********************************************
							else if(cancerStage!=null && !cancerStage.equals("") &&  cancerStage.size()>0){
								println "inside PatientMatch:filterMatchPatientList()-->cancer stage filter !!!!!!!!"
								def patientStageOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"Stage of cancer")?.value;
								for(int j=0;j<cancerStage.size();j++){
										 cancerName = cancerStage.get(j);
										 selectedCancerStage.add(cancerName);
										if(patientStageOfCancerName!=null && !patientStageOfCancerName.equals("") && cancerName!=null 
											&& !cancerName.equals("") && cancerName?.trim().equals(patientStageOfCancerName?.trim())){
												patientKeylist.add(patientMatch);
									    }
								     }
								}
						   	
							//****************cancer stage Filter ends********************************************
							//****************cancer status Filter ends********************************************
							else if(cancerStatus!=null && !cancerStatus.equals("") && cancerStatus.size()>0){
								println "inside PatientMatch:filterMatchPatientList()-->cancer status filter !!!!!!!!"
								def patientStatusOfCancerName = TempQuestionOption.findByPatientAndQuestionName(patientMatch?.patient,"I am a")?.value;
								
								for(int j=0;j<cancerStatus.size();j++){
										 cancerStatusVal = cancerStatus.get(j);
										 selectedCancerStatus.add(cancerStatusVal);
										if(patientStatusOfCancerName!=null && !patientStatusOfCancerName.equals("") && cancerStatusVal!=null && !cancerStatusVal.equals("") && cancerStatusVal?.trim().equals(patientStatusOfCancerName?.trim())){
												patientKeylist.add(patientMatch);
										}
									 }
								}
							//****************cancer status Filter ends********************************************
							else{
								patientKeylist = patientList;
							}
				}
			}
			
			if(patientKeylist!=null && patientKeylist.size()>0){
				for(int i =0;i<10;i++){
					if(i < patientKeylist.size()){
						def patientMatch = patientKeylist.get(i);
						if(patientMatch){
							patientKeylistPagination.add(patientMatch);
						}
					}
				}
			}
			def messageGroupList = messageService.getGroupList(healpalUser)
			cancerStageList = CancerStage.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('cancerStageLevel','asc')
				  }
			def cancerStatusList = AboutYou.createCriteria().list{
					  eq("isActive",Short.valueOf("1"))
					  order('aboutYouName','asc')
				  }
			session.patientKeylist = patientKeylist;
			session.patientKeylistForPagination = patientKeylist;
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			render(template:'patientMatchList',model:[patientList:patientKeylistPagination,patientMatchMapTotal:patientKeylist?.size(),toAge:ageTo,zipcode:zipCode,fromAge:ageFrom,messageGroupList:messageGroupList,matchActive : 'active',miles:miles,isViewed:"yes",cancerStageList:cancerStageList,selectedCancerStage:selectedCancerStage,selectedCancerStatusList:selectedCancerStatus,offset:10 ,max : params.max,patientMatchSearch:patientMatchSearch,cancerStatusList:cancerStatusList]);//photo:ProfilePhoto.findByPatient(Patient.findByPerson(HealpalUser.get(healpalUser?.id)?.person))?.profilePhotoPath
		
	}catch(Exception exception){
	  exception.printStackTrace();
	}
}
	/*def sortPatientMatch(){
		ArrayList patientMatchlist = session.patientKeylist;
		ArrayList patientKeylist = new ArrayList();
		TreeMap treeMap = new TreeMap();
		def order;
		try{
			authorizeMe()
			if(patientMatchlist){
				println "patientKeylist before::::::::::::::::::::::"+patientMatchlist
				def sortVal = params.sort;
				if(sortVal!=null && !sortVal.equals("") && sortVal.toString().equalsIgnoreCase("age")){
					println "inside age";
					if(patientMatchlist!=null && !patientMatchlist.equals("")){
							for(int i=0;i<patientMatchlist.size();i++){
									def patientMatch = patientMatchlist.get(i);
									def dateOfBirth = patientMatch?.patient?.person?.dob
									Integer age = getAge(dateOfBirth);
									treeMap.put(age, patientMatch);
							}
						}else{
							 //do nothing
						}
						println "inside age"+treeMap;
					if(session.sortAge == null || session.sortAge == ""){
						session.sortAge = "asc";
						if(treeMap!=null && treeMap.size() > 0)	{
							Iterator iter = treeMap.keySet().iterator();
							while(iter.hasNext()){
								Integer key = (Integer) iter.next();
								patientKeylist.add(treeMap.get(key));
							}
						}else{
						  //do nothing
						}				
					}else{
						session.sortAge = "";
						TreeMap desc = treeMap.descendingMap();
						Set set = desc.entrySet();
						Iterator i = set.iterator();
						while(i.hasNext()) {
						  Map.Entry me = (Map.Entry)i.next();
						  patientKeylist.add(me.getValue());
						}
					}
					
				}else if(sortVal!=null && !sortVal.equals("") && sortVal.toString().equalsIgnoreCase("location")){
				println "location"
						if(patientMatchlist!=null && !patientMatchlist.equals("")){
							for(int i=0;i<patientMatchlist.size();i++){
									def patientMatch = patientMatchlist.get(i);
									println "patient"+patientMatch?.patient
									String pZipCode = PatientAddress.findByPatientAndIsActive(patientMatch?.patient,Short.valueOf("1"))?.address?.zipcode;
									treeMap.put(pZipCode, patientMatch);
							}
						}else{
							 //do nothing
						}
						println "treeMap::::::"+treeMap
					if(session.sortLocation == null || session.sortLocation == ""){
						session.sortLocation = "asc";
						if(treeMap!=null && treeMap.size() > 0)	{
							Iterator iter = treeMap.keySet().iterator();
							while(iter.hasNext()){
								String key =  (String)iter.next();
								println "key::::::"+key
								patientKeylist.add(treeMap.get(key));
							}
						}else{
						  //do nothing
						}
					}else{
						session.sortLocation = "";
						TreeMap desc = treeMap.descendingMap();
						Set set = desc.entrySet();
						Iterator i = set.iterator();
						while(i.hasNext()) {
						  Map.Entry me = (Map.Entry)i.next();
						  patientKeylist.add(me.getValue());
						}
					}
				}else{
				patientKeylist = patientMatchlist;
				}
			}else{
			    //do nothing
			}
			println "patientKeylist::::::::::::::::::::::"+patientKeylist
			render(template:'patientMatchList',model:[patientList:patientKeylist]);
		}catch(Exception exception){
		   exception.printStackTrace();
		}
	}*/
	def  getAge(def mPatientDob)throws Exception{
		int year;
		try{
			if(mPatientDob!=null && !mPatientDob.equals("")){
			Calendar currPatientdate =Calendar.getInstance();
			currPatientdate.setTime(new Date());
			Calendar mPatientdate =Calendar.getInstance();
			mPatientdate.setTime(mPatientDob);
			 year = currPatientdate.get(Calendar.YEAR) - mPatientdate.get(Calendar.YEAR);
		}
		}catch(Exception exception){
		  throw exception;
		}
		return year;
	}
	def checkIsConnected(def patientId)throws Exception{
		def status = "";
		def currentPatient
		try{
			authorizeMe()
			if(patientId !=null && !patientId.equals("")){
				HealpalUser healpalUser = session.user;
				if(healpalUser!=null && !healpalUser.equals("")){
					def currentPerson = HealpalUser.get(healpalUser?.id?.toString().toLong())?.person
					if(currentPerson!=null && !currentPerson.equals("")){
						 currentPatient = Patient.findByPersonAndIsActive(currentPerson,Short.valueOf("1"));
					}
				}
				def patient = Patient.get(patientId?.toString().toLong());
				if(patient && currentPatient){
							def isConnected = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(currentPatient,patient,Short.valueOf("1"),Short.valueOf("1"));
							def isInviteSent = PatientChat.findByPatientByPatientFk1AndPatientByPatientFk2AndApproveRequestAndIsActive(currentPatient,patient,Short.valueOf("0"),Short.valueOf("1"));
							if(isConnected!=null && !isConnected.equals("")){
								status = "connected";
						    }else if(isInviteSent!=null && !isInviteSent.equals("")){
							    status = "invitesent";
						    }else{
							 status = "";
						    }
					}else{
				  //do nothing
				}
			}else{
			  //do nothing
			}
		}catch(Exception exception){
		  exception.printStackTrace();
		}
		return status;
	}
	def getPhotoName(def patientId)throws Exception{
		def photoName = "";
		try{
			authorizeMe()
			if(patientId !=null && !patientId.equals("")){
				def patient = Patient.get(patientId?.toString().toLong());
				if(patient){
					photoName = ProfilePhoto.findByPatientAndIsActive(patient,Short.valueOf("1"))?.profilePhotoPath;
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
		return photoName
	}
	def getPhotoNameForFindReview(def personId)throws Exception{
		println "*88888888888888888888888888888"
		def photoName = "";
		println "personId"+personId
		try{
			//authorizeMe()
			if(personId !=null && !personId.equals("")){
				def patient = Patient.findByPerson(Person.get(personId));
				println "************* "+patient
				if(patient){
					photoName = ProfilePhoto.findByPatientAndIsActive(patient,Short.valueOf("1"))?.profilePhotoPath;
					println "*****77"+photoName
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
		return photoName
	}
	def getPhotoNameForDashboard(def personId)throws Exception{
		def photoName = "";
		try{
			authorizeMe()
			if(personId !=null && !personId.equals("")){
				def person = Person.get(personId?.toString().toLong());
				if(person){
					def patient = Patient.findByPersonAndIsActive(person,Short.valueOf("1"));
					if(patient){
					photoName = ProfilePhoto.findByPatientAndIsActive(patient,Short.valueOf("1"))?.profilePhotoPath;
					}
				}
			}
		}catch(Exception exception){
		   exception.printStackTrace();
		}
		return photoName
	}
	
	
}
