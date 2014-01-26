package com.grafcode.contactsfileviewer.view;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import com.grafcode.contactsfileviewer.model.ContactsModel;

public class ContactsViewer {
	
	private ContactsModel contactsStore;
	
	public ContactsViewer(ContactsModel contactsStore) {
		this.contactsStore = contactsStore;
	}

	Collection getSortedUniquePropertiesList(Collection properties) {
		Set set = new TreeSet();
		
		set.addAll(properties);
		
		return set;
	}
}
