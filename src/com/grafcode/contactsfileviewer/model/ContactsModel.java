package com.grafcode.contactsfileviewer.model;

import java.util.Collection;
import java.util.LinkedList;

public class ContactsModel {
	LinkedList<Contact> contacts = new LinkedList<Contact>();
	
	public ContactsModel() {
	}
	
	public ContactsModel(Collection<Contact> contacts) {
		addCollectionOfContacts(contacts);
	}
	
	public void addCollectionOfContacts(Collection<Contact> contacts) {
		contacts.addAll(contacts);
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
}