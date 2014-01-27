package com.grafcode.contactsfileviewer.model;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ContactsFileReaderTest {
	
	@SuppressWarnings("unused")
	@Test (expected = IOException.class)
	public void testNoFileExists() throws IOException, IllegalStateException, URISyntaxException {
		ContactsFileReader contactsFileReader = new ContactsFileReader("blah");
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
