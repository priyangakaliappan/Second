package com.healpal.care

class SideEffects {

	String sideEffectsType
	Short isActive
	Date rowCreated
	Date rowAltered

	static mapping = {
		id column: "side_effects_rowid", generator: "identity"
		version false
	}

	static constraints = {
		sideEffectsType maxSize: 150, unique: true
		rowAltered nullable: true
	}
}
