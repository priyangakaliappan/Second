package com.healpal.care

import java.util.Date;

class TreatingDoctor {
	Patient patient
	Doctor doctor
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static belongsTo = [Patient,Doctor]
	
	static mapping = {
		id column: "treating_doctor_rowid", generator: "identity"
		patient column: "patient_fk"
		doctor column: "doctor_fk"
		version false
	}

    static constraints = {
		rowAltered nullable: true
    }
}
