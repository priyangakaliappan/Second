package com.healpal.care

class HealpalUser implements Serializable{

	String userName
	String password
	Date passwordExpires
	Date lockExpires
	Date lastLoginDate
	Short badLoginAttempts = 0
	Boolean enabled
	Boolean accountLocked
	Boolean accountExpired
	Boolean passwordExpired
	Short isActive
	Date rowCreated
	Date rowAltered
	Person person
	
	static hasMany = [securityQAndAs: SecurityQAndA ,
					userRoles: UserRole ,
					auditEvents: AuditEvent ,
					profileCompletionDetails:ProfileCompletionDetail,
					patientMedicalDocuments: PatientMedicalDocument,
					breastContentRates: CancerContentRate,
					cancerContentComments: CancerContentComment]
	static belongsTo = [Person]

	static mapping = {
		id column: "healpal_user_rowid", generator: "identity"
		person column :'person_fk'
		version false
	}

	static constraints = {
		userName maxSize: 128 //, unique: true
		password maxSize: 100
		lockExpires nullable: true
		lastLoginDate nullable: true
		passwordExpires nullable : true
		rowAltered nullable: true
		userName(validator: { val, obj ->
			def similarUser = HealpalUser.findByUserNameIlike(val)
			return !similarUser || obj.id == similarUser.id
		  })
	}
}
