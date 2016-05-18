package com.healpal.care

import grails.transaction.Transactional

@Transactional
class DemographicService {

	def serviceMethod() {
	}
	
	def viewAll(params) {
		def demographic = Demographic.createCriteria().list(params) {
			if(params.sort == null && params.order == null){
				order('rowCreated','desc')
			}
		}
		return demographic
	}
}
