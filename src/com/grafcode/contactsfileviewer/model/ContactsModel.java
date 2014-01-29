package com.grafcode.contactsfileviewer.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

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
	
	public int getTotalNumberOfContactsStored() {
		return contacts.size();
	}
	
	public Collection<String> getSortedUserNamesFromContacts() {
		LinkedList<String> userNames = new LinkedList<String>();
		
		for (Iterator<Contact> i = contacts.iterator(); i.hasNext(); ) {
			userNames.add(i.next().getUserName());
		}
		
		Collections.sort(userNames);
		
		return userNames;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<String> getSortedUniqueCompaniesFromContacts() {
		LinkedList<String> companies = new LinkedList<String>();
		
		for (Iterator<Contact> i = contacts.iterator(); i.hasNext(); ) {
			companies.add(i.next().getCompanyName());
		}
		
		return getSortedUniquePropertiesCollection(companies);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	Collection getSortedUniquePropertiesCollection(Collection properties) {
		Set set = new TreeSet();
		
		set.addAll(properties);
		
		return set;
	}
}