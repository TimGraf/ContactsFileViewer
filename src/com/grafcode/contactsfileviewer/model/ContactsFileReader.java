package com.grafcode.contactsfileviewer.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;


public class ContactsFileReader {
	private static String VALUE_SEPERATOR = ",";
	
	private BufferedReader fileReader;
	
	public ContactsFileReader(String fileName) throws IllegalStateException, IOException, URISyntaxException {
		fileReader = new BufferedReader(new FileReader(fileName));
	}
	
	public ContactsModel buildContactsModelFromFile() throws URISyntaxException, IOException {
		String        nextLine = fileReader.readLine(); // read header line but don't use it
		ContactsModel store    = new ContactsModel();
		
		while ((nextLine = fileReader.readLine()) != null) {
            String[] tokens  = nextLine.split(VALUE_SEPERATOR);
            Contact  contact = Contact.createContactFromTokens(tokens);
            
            store.addContact(contact);
        }
		
		return store;
	}
}