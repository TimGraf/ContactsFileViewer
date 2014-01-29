package com.grafcode.contactsfileviewer.model;

import java.io.BufferedReader;
import java.io.FileReader;


public class ContactsFileReader {
	private static String VALUE_SEPERATOR = ",";
	
	private ContactsModel model;
	private String fileName;
	
	public ContactsFileReader(String fileName) throws Exception {
		this.fileName = fileName;
	}
	
	public ContactsModel buildContactsModelFromFile() throws Exception {
		model = new ContactsModel();
		
		readContactsFile();
		
		return model;
	}
	
	void readContactsFile() throws Exception {
		BufferedReader fileReader = null;
		
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String nextLine = fileReader.readLine(); // read header line but don't use it
			
			while ((nextLine = fileReader.readLine()) != null) {
				parseContactData(nextLine);
			}
			
		} finally {
			
			if (fileReader != null) {
				fileReader.close();
			}
		}
	}
	
	void parseContactData(String lineFromFile) throws Exception {
			String[] tokens  = lineFromFile.split(VALUE_SEPERATOR);
            
			if (tokens.length == 0) {
				throw new Exception("Invalid CSV file.");
			}
            
			Contact contact = Contact.createContactFromTokens(tokens);
			model.addContact(contact);
	}
}