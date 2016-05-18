package com.healpal.care

class UserRole {

	Short isActive
	Date rowCreated
	Date rowAltered
	Role role
	HealpalUser healpalUser

	static belongsTo = [HealpalUser, Role]

	static mapping = {
		id column: "user_role_rowid", generator: "identity"
		role column : 'role_fk'
		healpalUser column : 'user_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
		healpalUser unique: true
	}
}
