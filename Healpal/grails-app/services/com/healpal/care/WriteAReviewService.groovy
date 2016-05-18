package com.healpal.care

import grails.transaction.Transactional

@Transactional
class WriteAReviewService {

    def serviceMethod() {

    }
	
	def viewAll(params)
	{
		def writeAreview
		try{
			writeAreview = WriteAReview.createCriteria().list() {
				println "writeAreview;;;;;;;;;;;;;;"+writeAreview
				//if(params.sort == null && params.order == null){
					println "inside if loop"
					order('rowCreated','desc')
				//}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return writeAreview
	}
	
	
	WriteAReview update(WriteAReview reviewUpdate ,params){
		try{
			WriteAReview writeAReview=WriteAReview.get(params.writeAReviewId);
			//shareYourStory.patientFk = params.patientName
					writeAReview.reviewTitle = params.storyTitle
					writeAReview.yourReview = params.yourReview
					writeAReview.isActive = params.status.equals("active")?(short)1:(short)0
					writeAReview.rowAltered = new Date()
			reviewUpdate = writeAReview.save();
			return reviewUpdate
		}catch(Exception exception){
			throw exception
		}
	}
	
	
	def approve(WriteAReview writeAReviewUpdate,params)throws Exception
	{
		println "inside approve;;;;;;;;;;;;;;;;;;"
		try{
		println "service;;;;;;;;;;;;;;"
		WriteAReview writeAReview=WriteAReview.get(params.writeAReviewId);
		writeAReview.approved = 1
		writeAReview.rowAltered = new Date()
		writeAReviewUpdate = writeAReview.save();
		return writeAReviewUpdate
		}
		catch(Exception exception){
			throw exception
		}
	}
}
