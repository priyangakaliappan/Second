package com.healpal.care

class CancerStatus {

	String cancerStatusType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "cancer_status_rowid", generator: "identity"
		version false
	}

	static constraints = {
		cancerStatusType maxSize: 150//, unique: true
		rowAltered nullable: true
		cancerStatusType(validator: { val, obj ->
			def similarUser = CancerStatus.findByCancerStatusTypeIlike(val)
			return !similarUser || obj.id == similarUser.id
		  })
	}
}
