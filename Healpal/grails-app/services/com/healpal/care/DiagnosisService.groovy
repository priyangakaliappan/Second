package com.healpal.care

import java.util.Date;

import grails.transaction.Transactional

@Transactional
class DiagnosisService {

	def serviceMethod() {
	}

	def addPatientDiagnosis(PatientDiagnosis diagnosis,params,healpalUser,Id){

		Person personId=null;
		Patient patientId=null;
		PatientDiagnosis patientDiagnosis=null;
		try{
			personId=healpalUser?.person
			patientId=Patient.findByPerson(personId)
			def diagnosisId=Diagnosis.get(Id)
			
			
			def patientDiagnosisUpdate = PatientDiagnosis.createCriteria().list{
				eq("patient",patientId)
			}
			if(patientDiagnosisUpdate){
				patientDiagnosis = PatientDiagnosis.get(patientDiagnosisUpdate?.id)
			}else{
				patientDiagnosis=new PatientDiagnosis()
			}
			
			patientDiagnosis.isActive=(short)1;
			patientDiagnosis.rowCreated=new Date();
			patientDiagnosis.diagnosis=diagnosisId;
			patientDiagnosis.patient=patientId;
			def diagnosisSave = patientDiagnosis.save(flush:true);
			return diagnosisSave
		}
		catch(Exception exception) {
			throw exception
		}
	}

	def getdiagnosisList(){
		try{
			return Diagnosis.createCriteria().list(){
				order('diagnosisName','asc')
				eq('isActive',(short)1)
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	
	
	def getDiagnosisAllList(params){
		try{
			return Diagnosis.createCriteria().list(params){
				if(params.sort == null && params.order == null){
					order('rowCreated','desc')
				}
				if(params.searchValue != null && params.searchValue != "") ilike("diagnosisName", "%"+params.searchValue+"%")
			}
		}catch(NullPointerException  | ArrayIndexOutOfBoundsException exception){
			throw exception
		}
	}
	
	def addPatientDiagnosisAge(params,HealpalUser healpalUser){
		try{
			if(params && params.age && healpalUser){
				PatientDiagnosis patientDiagnosis=PatientDiagnosis.findByPatient(Patient.findByPerson(healpalUser?.person))
				patientDiagnosis.ageOfDiagnosis=Integer.parseInt(params.age)
				def ageDiagnosis = patientDiagnosis.save(flush:true);
				return ageDiagnosis
			}else{
				//do nothing					
			}
		}catch(Exception exception) {
			throw exception
		}
	}
	
	
	def addCancerStatus(params,HealpalUser healpalUser){
		if(healpalUser){
			Person person=healpalUser?.person
			person.cancerStatus= CancerStatus.get(status)
			println"person.cancerStatus:::::::::"+person.cancerStatus
			def cancerStatus=person.save(flush:true)
			return cancerStatus
		}
		
	}
	
	
	Diagnosis doSave(Diagnosis diagnosisSave,params){
		try{
			Diagnosis Types= new Diagnosis();
			Types.diagnosisName=params.DiagnosisName
			Types.rowCreated=new Date();
			Types.isActive=(short)1;
			diagnosisSave=Types.save();
			return diagnosisSave
		}catch(Exception exception){
		throw exception
		}
	}


	Diagnosis doUpdate(Diagnosis diagnosisUpdate,updatedId,params){
		try{
			if(updatedId !=null && !updatedId.isEmpty()){
			Diagnosis diagnosisTypes=Diagnosis.get(updatedId);
			diagnosisTypes.diagnosisName =params.DiagnosisName
			diagnosisTypes.isActive = params.status.equals("active")?(short)1:(short)0;
			diagnosisTypes.rowAltered = new Date();
			diagnosisUpdate = diagnosisTypes.save();
			return diagnosisUpdate
			}else{
			// do nothing
			}
		}catch(Exception exception){
			throw exception
		}
	}

	Diagnosis doDelete(Diagnosis diagnosisDelete,params){
		Diagnosis deleteStatus = new Diagnosis()
		deleteStatus.withTransaction {status->
			try{
				if(params.diagId !=null && !params.diagId.isEmpty()){
					def delete = Diagnosis.executeUpdate("UPDATE Diagnosis p SET p.isActive=? WHERE p.id=?",[
						(short)0,
						params.diagId.toLong()
					])
					if(delete){
						return deleteStatus
					}
				}
			}catch(Exception e){
				throw e
			}
		}
	}
	def getCount(params){
		try{
			return Diagnosis.createCriteria().list(){
				if(params.searchValue != null && params.searchValue != "") ilike("diagnosisName", "%"+params.searchValue+"%")
			}?.size()
		}catch(Exception exception){
			throw exception
		}
	}
}
