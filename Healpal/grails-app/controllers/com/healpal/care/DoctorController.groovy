/*
 * Author    : Priyanga K
 * Project   : Healpal
 * Date      :
 * Description : Index Controller
 *
 * #   Name       Version   Modified-Date      Description
 * -------------------------------------------------------------------------------------
 * 1   Priyanga K    1.0               Initial Creation
 *
 */
package com.healpal.care

import java.awt.Point;

import com.sun.javafx.sg.prism.ShapeEvaluator.Geometry;

import grails.converters.JSON

class DoctorController {
	def DoctorService doctorService
	def index() {}
	
	/**
	 * get specialty
	 * @param city
	 * @return
	 */
	def doctorCity(){
		try{
			def specialty = doctorService.getSpecialty()
			def state
			if(params.city !=null && params.city!=""){
				state = DoctorAddress.findByCity(params.city)?.state
			}
			[specialty: specialty,location:params.city+", "+state,keyword:params.keyword,city:params.city,state:state]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * display list of cities
	 * @param location
	 * @return
	 */
	def doctorState(){
		try{
			def cityList = DoctorAddress.createCriteria().list() { order('city','asc') }
			[location:params.location,cityList:cityList]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * get doctor profile details
	 * @param doctorId
	 * @param doctorName
	 * @return
	 */
	def doctorDetails(){
		try{
			def doctorProfile
			if(params.doctorId!=null && params.doctorId!=""){
				doctorProfile= Doctor.createCriteria().list(){
					eq('id',params.doctorId.toLong())
				}
			}
			else if(params.doctorName!=null && params.doctorName!=""){
				doctorProfile = Doctor.createCriteria().list(){
					eq('doctorName',params.doctorName.toString())
				}
			}
			[doctorProfile:doctorProfile]
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * search doctors and displayed filterd doctors
	 * @param keyword
	 * @param location
	 * @return
	 */
	def searchDoctors(){
		try{
			def doctorList
			def city
			def state
			if(params!=null && params!=""){
				doctorList = doctorService.findDoctors(params)
				def specialty = doctorService.getSpecialty()
				def cityState = doctorService.getCityState(params)
				if(cityState!=null && cityState.size()>0){
					city = cityState[0]
					state = cityState[1]
				}
				if(request.post){
					render(template:'doctors',model:[doctorList:doctorList,specialty:specialty,keyword:params.keyword,location:params.location,city:city])
				}
				else{
					render(view:'doctorList',model:[doctorList:doctorList,specialty:specialty,keyword:params.keyword,location:params.location,city:city,state:state])
				}
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * search doctors by specialty and location
	 * @param specialty
	 * @param location
	 * @return
	 */
	def doctorSpecialty(){
		try{
			def doctorList
			def city, state
			if(params.specialty !=null && params.specialty !="" && params.location!=null && params.location !=""){

				Set<Long> doctorIds = new LinkedHashSet<Long>();
				def doctorSpecialty =Doctor.findAllBySpecialty(params.specialty);

				if(doctorSpecialty!=null && doctorSpecialty.size()>0){
					doctorSpecialty.each {
						doctorIds.add(it?.id);
					}
				}
				def cityState = doctorService.getCityState(params)
				if(cityState!=null && cityState.size()>0){
					city = cityState[0]
					state = cityState[1]
				}
				if(doctorIds.size()>0){
					doctorList = Doctor.createCriteria().list(){
						'in'('id',doctorIds)
						doctorAddress{
							eq('city',city)
							if(state!=null && state!=""){
								eq('state',state)
							}
						}
					}
				}
			}
			render(view:'doctorList',model:[doctorList:doctorList,location:params.location,keyword:params.specialty,specialty:doctorService.getSpecialty(),city:city,state:state])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * search doctors by treatment and location
	 * @param treatmentId
	 * @param location
	 * @return
	 */
	def doctorTreatment(){
		try{
			def doctorList=""
			if(params.treatmentId !=null && params.treatmentId !=""){

				Set<Long> doctorIds = new LinkedHashSet<Long>();
				def doctorTreatment = DoctorTreatment.findAllByTreatment(Treatment.get(params.treatmentId));

				if(doctorTreatment!=null && doctorTreatment.size()>0){
					doctorTreatment.each {
						doctorIds.add(it?.doctor?.id);
					}
				}
				if(doctorIds.size()>0){
					doctorList = Doctor.createCriteria().list(){ 'in'('id',doctorIds) }
				}
			}
			render(view:'doctorList',model:[doctorList:doctorList,location:params.location,keyword:params.keyword,specialty:doctorService.getSpecialty()])
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * get all locations for autocomplete
	 * @param location
	 * @return
	 */
	def getLocation(){
		try{
			Set<String> searchLocation = new LinkedHashSet<String>()
			def address = DoctorAddress.createCriteria().list() {
				ilike('city',params.location+"%")
			}
			if(!address.isEmpty() && address.size()>0){
				address.each{
					searchLocation.add(it?.city+', '+it?.state)
				}
			}
			render searchLocation as JSON
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * get all doctors for autocomplete
	 * @param keyword
	 * @return
	 */
	def getdoctors(){
		try{
			Set<String> searchKeyword = new LinkedHashSet<String>()
			def  doctorList = Doctor.createCriteria().list() {
				ilike('doctorName',params.keyword+"%")
				order('doctorName','asc')
			}
			if(!doctorList.isEmpty() && doctorList.size()>0)
				doctorList.each {
					searchKeyword.add(it?.doctorName)
				}
			def  specialty = Doctor.createCriteria().list() {
				ilike('specialty',params.keyword+"%")
				order('specialty','asc')
			}
			if(!specialty.isEmpty() && specialty.size()>0)
				specialty.each {
					searchKeyword.add(it?.specialty)
				}
			/*def treatment = Treatment.findAll()
			 if(!treatment.isEmpty() && treatment.size()>0)
			 treatment.each {
			 searchKeyword.add(it?.treatmentName)
			 }*/
			render searchKeyword as JSON
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	def filterByDistance(){
		
		def doctorList,city,state
		def specialty = doctorService.getSpecialty()
		
		def cityState = doctorService.getCityState(params)
		if(cityState!=null && cityState.size()>0){
			city = cityState[0]
			state = cityState[1]
		}
		if(params!=null && params!=""){
			doctorList = doctorService.getDoctorsByDistance(params,city,state)
		}
	render(template:'doctors',model:[doctorList:doctorList,specialty:specialty,keyword:params.keyword,location:params.location,city:city])
	}
}
