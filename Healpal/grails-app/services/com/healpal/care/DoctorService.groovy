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

import grails.transaction.Transactional

@Transactional
class DoctorService {

	def serviceMethod() {
	}

	/**
	 * returns doctors list
	 * @param keyword
	 * @return
	 */
	def findDoctors(params){
		try{
			def doctorList, city, state
			Set<Long> doctorIds = new LinkedHashSet<Long>();
			if(params.keyword!=null && params.keyword!=""){

				def speciality = Doctor.findAllBySpecialtyIlike(params.keyword+'%')
				def doctors = Doctor.findAllByDoctorNameIlike(params.keyword+'%')

				if(speciality!=null && speciality!="" && speciality.size()>0){
					speciality.each {
						doctorIds.add(it?.id)
					}
				}
				if(doctors!=null && doctors!="" && doctors.size()>0){
					doctors.each{
						doctorIds.add(it?.id)
					}
				}
				//println "DOCTORIDS::::" + doctorIds
				/*def treatment = Treatment.createCriteria().list(){ilike('treatmentName','%'+params.keyword+'%')}
				 if(treatment!=null && treatment!="" && treatment.size()>0){
				 def doctorTreatment = DoctorTreatment.createCriteria().list(){ 'in'('treatment',treatment) }
				 if(doctorTreatment!=null && doctorTreatment!="" && doctorTreatment.size()>0){
				 doctorTreatment.each {
				 doctorIds.add(it?.doctor?.id)
				 }
				 }
				 }*/
			}
			def cityState = getCityState(params)
				if(cityState!=null && cityState.size()>0){
					city = cityState[0]
					state = cityState[1]
				}
			if(doctorIds!= null && doctorIds.size()>0){
				doctorList =Doctor.createCriteria().list(){
					'in'('id',doctorIds)
					if(params.location!=null && params.location!=""){
						doctorAddress{
							eq('city',city)
							if(state!=null && state!=""){
								eq('state',state)
							}
						}
					}
				}
			}
			if(doctorList !=null && doctorList.size()>0){
				return doctorList
			}else{
				return null
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	
	/**
	 * returns list of specialty
	 * @return
	 */
	def getSpecialty(){
		try{
			Set<String> specialty = new LinkedHashSet<String>();
			def specialtyList = Doctor.createCriteria().list() {
				isNotNull("specialty")
				order('specialty','asc')
			}
			if(specialtyList != null &&specialtyList!="" && specialtyList.size()>0){
				specialtyList.each{
					specialty.add(it?.specialty)
				}
			}
			return specialty
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	/**
	 * returns city and state
	 * @return
	 */
	def getCityState(params){
		try{
			def city, state
			ArrayList<String> citystate = new ArrayList<String>()
			if(params.location!=null && params.location !="" && params.location.contains(',')) {
				def locationArray = params.location.split(",")
				city =  locationArray[0]
				state = locationArray[1].trim()
			}else{
				city = params.location
			}
			citystate.add(city)
			citystate.add(state)
			return citystate
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	/**
	 * returns list of doctors filtered by distance in miles
	 * @return
	 */
	def getDoctorsByDistance(params, String city, String state){
		try{
			double lat1,lon1,lat2,lon2
			def doctorList
			
			def cityLatiLng = DoctorAddress.findByCityAndState(city,state)
			if(cityLatiLng!=null && cityLatiLng!=""){
				lat1 = cityLatiLng?.latitude
				lon1 = cityLatiLng?.longitude
			}
			def doctors = findDoctors(params)
			Set<Long> doctorIds = new LinkedHashSet<Long>();
			if(doctors!=null && doctors.size()>0){
				doctors.each {
					if(it?.latitude !=null && it?.latitude!="" && it?.longitude!=null && it?.longitude!=""){
						lat2 = it?.latitude
						lon2 = it?.longitude
						def distance = distance(lat1,lon1,lat2,lon2)
						//println it?.street1+"::::" + distance
						if(params.miles!=""){
							if(distance<=params.miles.toDouble()){
								doctorIds.add(it?.id)
							}
						}
					}
				}
			}
			if(doctorIds!=null && doctorIds.size()>0){
				doctorList  = Doctor.createCriteria().list() { 'in'('id',doctorIds) }
			}
			if(doctorList !=null && doctorList.size()>0){
				return doctorList
			}else{
				return null
			}
		}catch(Exception exception){
			exception.printStackTrace()
		}
	}
	/**
	 * returns get distance of cities in miles
	 * @return
	 */
	def distance(def lat1, def lon1, def lat2, def lon2) {
		if(lat1!=null && lat1!="" && lon1!=null && lon1!="" && lat2!=null && lat2!="" && lon2!=null && lon2!=""){
			double theta = lon1 - lon2;
			double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
			dist = Math.acos(dist);
			dist = rad2deg(dist);
			dist = dist * 60 * 1.1515;
			return (dist); // in miles
		}else{
			return 0;
		}
	}
	/*::  This function converts decimal degrees to radians ::*/
	def deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	/*::  This function converts radians to decimal degrees ::*/
	def rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
