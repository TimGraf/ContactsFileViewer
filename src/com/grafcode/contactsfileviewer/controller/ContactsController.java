package com.grafcode.contactsfileviewer.controller;

import java.util.Collection;

import com.grafcode.contactsfileviewer.model.ContactsFileReader;
import com.grafcode.contactsfileviewer.model.ContactsModel;
import com.grafcode.contactsfileviewer.view.ContactsView;

public class ContactsController {
	ContactsModel contactsModel;
	ContactsView  contactsView;
	
	private ContactsController() {
		contactsView = new ContactsView();
	}
	
	public static ContactsController buildControllerAndInitModelWithFile(String fileName) throws Exception {
		ContactsController contactsController = new ContactsController();
		contactsController.createModelFromFile(fileName);
		
		return contactsController;
	}
	
	void createModelFromFile(String fileName) throws Exception {
		ContactsFileReader fileReader = new ContactsFileReader(fileName);
		
		contactsModel = fileReader.buildContactsModelFromFile();
	}
	
	public void displayUniqueSortedComanyNames() {
		Collection<String> companyNames = contactsModel.getSortedUniqueCompaniesFromContacts();
		
		contactsView.displayCompanyCollection(companyNames);
	}
	
	public void displayAllUserNamesSorted() {
		Collection<String> userNames = contactsModel.getSortedUserNamesFromContacts();
		
		contactsView.displayUserCollection(userNames);
	}
}