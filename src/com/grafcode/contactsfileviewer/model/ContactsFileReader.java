package com.grafcode.contactsfileviewer.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;


public class ContactsFileReader {
	private static String VALUE_SEPERATOR = ",";
	
	private String fileName;
	
	public ContactsFileReader(String fileName) throws IllegalStateException, IOException, URISyntaxException {
		this.fileName = fileName;
	}
	
	public ContactsModel buildContactsModelFromFile() throws Exception {
		BufferedReader fileReader = null;
		ContactsModel  model = new ContactsModel();
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String nextLine   = fileReader.readLine(); // read header line but don't use it
			
			while ((nextLine = fileReader.readLine()) != null) {
				String[] tokens  = nextLine.split(VALUE_SEPERATOR);
	            
				if (tokens.length == 0) {
					throw new Exception("Invalid CSV file.");
				}
	            
				Contact contact = Contact.createContactFromTokens(tokens);
	            
				model.addContact(contact);
			}
		} finally {
			
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		return model;
	}
}