/*
 * Author    : Priyanga K
 * Project   : Healpal
 * File      : PatientDocumentController
 * Date      : 23-10-2015
 * Description : view document
 *
 * #   Name           Version           Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               23-01-2016         Initial Creation
 *
 */
package com.healpal.care
/**
 *
 *
 * @author Priyanga K
 *
 */
import java.awt.Desktop;
class PatientDocumentController {
    def index() {}
	def list(){
		try{
		def medicalDoc = PatientMedicalDocument.createCriteria().list {
			patient{
				person{
					order('fullName','asc')
				}}
		}
		def patients = Patient.createCriteria().list {person{order('fullName','asc')}}
		render(view:'view',model:[medicalDoc:medicalDoc,patients:patients])
		}catch(Exception exception){
		exception.printStackTrace();}
		
	}
	def selectPatient(){
		try{
		def personId = params.selectValue
		def medicalDoc = PatientMedicalDocument.createCriteria().list {
			patient{
				person{
					eq('id',personId.toLong())}}
			}
		render(template:'viewDocument',model:[medicalDoc:medicalDoc])
	}catch(Exception exception){
	exception.printStackTrace();}
	}
	def viewDoc(){
		try{
			render(template:'document')
		}catch(Exception exception){
		exception.printStackTrace();}
	}
	def verify(){}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
