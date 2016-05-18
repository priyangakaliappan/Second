package com.care.healpal

import com.healpal.care.HealpalUser;
import com.healpal.care.Patient;
import com.healpal.care.ProfileCompletionDetail;

class UsersTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
	
	def getUserName={attrs->
		def loginUser = attrs.get("user")
		String name = loginUser?.person?.fullName
		String fullName = null
		if(name.length()>10){
			fullName = name.substring(0,6)
		}else {fullName = name }
		out << fullName?.capitalize()
    }
	
	def getPercentage = { attrs ,body->
		HealpalUser loginUser = attrs.get("user")
		def list = ProfileCompletionDetail.findByHealpalUserAndPatient(loginUser ,Patient.findByPerson(loginUser?.person))
		def msg
		if(list && list?.profileUpdated==1 && list?.percentage.equals('100')){
			println "% if"
			msg = "100"
		}else{
			println "% else"
			msg = list?.percentage!= null ?list?.percentage:'0'
		}
		out << msg+"% Completed"
		
	}
	
	
	def recommendMsg = { attrs->
		String str = attrs.get("val")
		String msg = str
		if(str != null && str.length() > 93){
			msg  = str.substring(0, 93)+"..."
		}
		out << msg
	}
}
