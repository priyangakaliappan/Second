package com.healpal.care


class ShareYourStoryComments {

	String comments
	Patient commentedPatient
	ShareYourStory shareYourStoryFk
	Date rowCreated
	Date rowAltered
	Short isActive

	static belongsTo = [ShareYourStory,Patient]
	static mapping = {
		id column: "comments_id", generator: "identity"
		shareYourStoryFk column :"share_your_story_fk"
		commentedPatient column: "commented_patient"
		version false
	}

	static constraints = {
		comments nullable: true
		commentedPatient nullable: true
		shareYourStoryFk nullable: true
		rowAltered nullable: true
	}
}
