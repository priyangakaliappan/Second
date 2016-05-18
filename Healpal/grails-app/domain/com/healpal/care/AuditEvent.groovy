package com.healpal.care

class AuditEvent {

	Date auditEventTime
	Short isActive
	Date rowCreated
	Date rowAltered
	AuditEventType auditEventType
	Patient patient
	HealpalUser healpalUser

	static belongsTo = [AuditEventType, Patient ,HealpalUser]

	static mapping = {
		id column: "audit_event_rowid", generator: "identity"
		table schema:'public'
		auditEventType column:'audit_event_type_fk'
		patient column:'patient_fk'
		healpalUser column:'user_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
		patient nullable:true
		healpalUser nullable:true
	}
}
