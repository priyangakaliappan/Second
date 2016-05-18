package com.healpal.care

class Role {

	String authority
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static final String patient ="Patient"
	static final String expert ="Expert"
	static final String admin ="Admin"
	static final String SuperAdmin ="SuperAdmin"

	static hasMany = [userRoles: UserRole]

	static mapping = {
		id column: "role_rowid", generator: "identity"
		//userRoles cascade: 'all-delete-orphan'
	}

	static constraints = {
		authority maxSize : 25//unique: true
		rowAltered nullable: true
		authority(validator:{val ,obj->
			def similarUser = Role.findByAuthorityIlike(val)
			return !similarUser || obj.id == similarUser.id
		})
	}
}
