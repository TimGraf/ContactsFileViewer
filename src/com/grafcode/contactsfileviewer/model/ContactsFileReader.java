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
	
	public ContactsModel buildContactsModelFromFile() throws Exception {
		String        nextLine = fileReader.readLine(); // read header line but don't use it
		ContactsModel model    = new ContactsModel();
		
		while ((nextLine = fileReader.readLine()) != null) {
			String[] tokens  = nextLine.split(VALUE_SEPERATOR);
            
			if (tokens.length == 0) {
				throw new Exception("Invalid CSV file.");
			}
            
			Contact  contact = Contact.createContactFromTokens(tokens);
            
			model.addContact(contact);
		}
		
		fileReader.close();
		
		return model;
	}
}