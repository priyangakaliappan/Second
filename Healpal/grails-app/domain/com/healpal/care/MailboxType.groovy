package com.healpal.care

class MailboxType {

	String mailboxTypeName
	Short isActive
	Date rowCreated
	Date rowAltered
	
	static final String inbox ="Inbox"
	static final String sent ="Sent"

	static hasMany = [mailboxes: Mailbox , mailboxTypes:MailboxType]
	
	static mappedBy = [referralsesForReceiverMaiboxTypeFk: "mailboxTypeByReceiverMaiboxTypeFk",
		referralsesForSenderMaiboxTypeFk: "mailboxTypeBySenderMaiboxTypeFk"]

	static mapping = {
		id column: "mailbox_type_rowid", generator: "assigned"
		version false
	}

	static constraints = {
		mailboxTypeName maxSize: 20, unique: true
		rowAltered nullable: true
	}
}
