package com.healpal.care

class Mailbox {

	Short isActive
	Date rowCreated
	Date rowAltered
	MailboxType mailboxType
	Patient patient

	/*static hasMany = [messagesForMailboxFkReceiver: Message,
	                  messagesForMailboxFkSender: Message]*/
	static belongsTo = [MailboxType, Patient]

	// TODO you have multiple hasMany references for class(es) [Message] 
	//      so you'll need to disambiguate them with the 'mappedBy' property:
	/*static mappedBy = [messagesForMailboxFkReceiver: "mailboxByMailboxFkReceiver",
	                   messagesForMailboxFkSender: "mailboxByMailboxFkSender"]*/

	static mapping = {
		id column: "mailbox_rowid", generator: "identity"
		mailboxType column :'mailbox_type_fk'
		patient column :'patient_fk'
		version false
	}

	static constraints = {
		rowAltered nullable: true
	}
}
