package com.grafcode.contactsfileviewer.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import com.grafcode.contactsfileviewer.model.ContactsFileReader;
import com.grafcode.contactsfileviewer.model.ContactsModel;

public class ContactsController {
	ContactsModel contactsModel;
	
	public void createModelFromFile(String fileName) throws IllegalStateException, IOException, URISyntaxException {
		ContactsFileReader fileReader = new ContactsFileReader(fileName);
		
		contactsModel = fileReader.createContactsStoreFromFile();
	}

}