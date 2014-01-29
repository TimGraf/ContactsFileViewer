package com.grafcode.contactsfileviewer.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ContactsFileReaderTest {
	
	@SuppressWarnings("unused")
	@Test (expected = Exception.class)
	public void testNoFileExists() throws Exception {
		ContactsFileReader contactsFileReader = new ContactsFileReader("blah");
		ContactsModel model = contactsFileReader.buildContactsModelFromFile();
	}
	
	@Test
	public void testModelLoded() {
		try {
			ContactsFileReader contactsFileReader = new ContactsFileReader("./data/contacts.csv");
			ContactsModel model = contactsFileReader.buildContactsModelFromFile();
			
			org.junit.Assert.assertFalse("Model should not be empty", (model.getTotalNumberOfContactsStored() == 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
