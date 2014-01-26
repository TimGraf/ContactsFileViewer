package com.grafcode.contactsfileviewer.view;

import java.util.Collection;
import java.util.Iterator;

public class ContactsView {
	
	public void displayCompanyCollection(Collection<String> companies) {
		System.out.println("\n===== Contacts' Company Names =====");
		
		for (Iterator<String> i = companies.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
	}
	
	public void displayUserCollection(Collection<String> userNames) {
		System.out.println("\n===== Contacts' User Names =====");
		
		for (Iterator<String> i = userNames.iterator(); i.hasNext(); ) {
			System.out.println(i.next());
		}
	}
}
