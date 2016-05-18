package com.healpal.care

class MolecularTestingController {
	
	def MolecularTestingService molecularTestingService
	def index() { }
	
	def list(){
		
		authorizeMe()
		params.max = Math.min(params.max ? params.int('max') :10, 100)
		[molecularForCancerList:molecularTestingService.getMolecularList(params),molecularForCancerListTotal:MolecularForCancer.list()?.size() ,offset:0 ,max : params.max,searchValue:""]
	}
	
	def add(){
		authorizeMe()
	}
	
	def create(){
		authorizeMe()
		if(params !=null &&  !params.isEmpty()){
			
				def AlreadyExist=MolecularForCancer.findByMolecularForCancerNameIlike(params.molecularForCancerName)
				if(AlreadyExist){
				flash.msg ="MolecularForCancer '"+ params.molecularForCancerName+"'"+" with this name already exists"
						redirect(action:"add")
				}
				else{
				MolecularForCancer molecularForCancer= new MolecularForCancer();
				molecularForCancer.molecularForCancerName=params.molecularForCancerName;
				molecularForCancer.rowCreated=new Date();
				molecularForCancer.isActive=(short)1;
				def molecularForCancerSave=molecularForCancer.save();
				if(molecularForCancerSave){
					//flash.msg="MolecularForCancer Name created successfully"
					flash.msg ="MolecularForCancer '"+molecularForCancerSave.molecularForCancerName+"'"+" name saved successfully"
					redirect(action:"list")
				}else{
				// do nothing
				}
					 }
			}else{
		//do nothing
		}
	}
	
	def delete(){
		authorizeMe()
		if(params.molecularId !=null){
		
		def deleteStatus= MolecularForCancer.executeUpdate("UPDATE MolecularForCancer d SET d.isActive=? WHERE d.id=?",[
				(short)0,
				params.molecularId.toLong()
			])
		if(deleteStatus){
			
			flash.msg = "MolecularForCancer '"+MolecularForCancer.get(params.molecularId).molecularForCancerName+"' name has been made Inactive"
		}
		redirect(action:'list')
		}else{
		}
	}
	
	/*def edit(){
		authorizeMe()
		def editMolecularForCancer=params.molecularId;
		if(editMolecularForCancer){
			def getMolecularForCancer=MolecularForCancer.get(editMolecularForCancer);
			if(getMolecularForCancer){
				
				[Molecular:getMolecularForCancer];
			}
			else{
				flash.msg="No records for current Id";
				redirect(action:"list");
			}
		}
	}*/
	
	
	def edit(){
		authorizeMe()
		if(params.molecularId != null&& !params.molecularId.isEmpty()){
			def getMolecularForCancer=MolecularForCancer.get(params.molecularId);
			if(request.post){
				def alreadyExist=MolecularForCancer.findByMolecularForCancerNameIlike(params.molecularCancerName)
				if(alreadyExist){
					if(!alreadyExist.id.toString().equals(params.molecularId)){
						flash.msg ="MolecularForCancer'"+params.molecularCancerName +"'"+" with this name already exists"
					}else{
					update(params)
					}
				}else{
				update(params)
				}
			}
			[Molecular:getMolecularForCancer]
		}else{
		// do nothing
		}
	}
	
	def update(params){
		authorizeMe()
		if(params.molecularId && params.molecularId!=null && !params.molecularId.isEmpty() && params.molecularCancerName!=null && !params.molecularCancerName.isEmpty()){
			
			
				
				MolecularForCancer updateMolecularForCancer=molecularTestingService.update(params);
				if(updateMolecularForCancer!=null && updateMolecularForCancer.validate()){
					//auditEventService . save(AuditEventType.updatedEthinicity, Role.admin, session)
					flash.msg ="MolecularForCancer '"+updateMolecularForCancer.molecularForCancerName+"'"+" name updated sucessfully"
					redirect(controller:"MolecularTesting" , action:"list");
				}
				else{
					flash.msg= "MolecularForCancer Updation Failed due to some error"
					
					}
			
				
			
			
			/*
			
			def AlreadyExist=MolecularForCancer.findByMolecularForCancerNameIlike(params.molecularCancerName)
			if(AlreadyExist){
			flash.msg ="MolecularForCancer'"+params.molecularCancerName +"'"+" with this name already exists"
					redirect(action:'edit')
				}else{
				def updateStatus= MolecularForCancer.executeUpdate("UPDATE MolecularForCancer d SET d.molecularForCancerName=?,isActive=?, d.rowAltered=? WHERE d.id=?",[
				params.molecularCancerName,
				params.status.equals("active")?(short)1:(short)0,
				new Date(),
				params.MolecularId.toLong()
			])
		if(updateStatus){
			flash.msg = "MolecularForCancer'"+MolecularForCancer.get(params.MolecularId).molecularForCancerName+"'name updated Successfully"
			redirect(action:"list")
		}
		else{
			// do nothing
			}
					 }
			
			
			*/}else{
		
		}
	}
	
	
	def authorizeMe(){
		if(session.user && session.authority.equalsIgnoreCase(Role.admin)){
			//do nothing
		}else{
			redirect controller :'home' ,action :'index'
		}
	}
	
	def cancel(){
		authorizeMe() //***** Check Authorization
		
		redirect(controller:"molecularTesting" , action:"list")

	}
	
	def ajaxPaginate(){
		authorizeMe()
		try{
			render (template :'view' ,model:[molecularForCancerList:molecularTestingService.getMolecularList(params),molecularForCancerListTotal:molecularTestingService.getCount(params) ,offset:0 ,max : params.max,searchValue:params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def searchValues(){
		try{
			params.max = Math.min(params.max ? params.int('max') :10, 100)
			render(template:"view",model:[molecularForCancerList:molecularTestingService.getMolecularList(params),molecularForCancerListTotal:molecularTestingService.getCount(params) ,offset:0 ,max : params.max, searchValue: params.searchValue])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
}
