package com.grafcode.contactsfileviewer.model;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactsModelTester {
	ContactsFileReader fileReader;
	ContactsModel      contactsModel;
	
	@Before
    public void setUp() throws Exception {
		fileReader    = new ContactsFileReader("./data/contacts.csv");
		contactsModel = fileReader.buildContactsModelFromFile();
    }
	
	@After
    public void tearDown() {
		fileReader    = null;
		contactsModel = null;
    }
	
	@Test
	public void testExpectedUniqueSortedCompanyNames() throws URISyntaxException, ParseException {
		String expectedCompanies = "[Barnes and Noble, Digital Foundry, KaufDA, Levis, LinkedIN, Oracle, Pacific Coast Brewing Co., Rocky Mountain Industries, SF FRB, Sony, SpringSource, Taulia, U.S. Communities, University of California, Violin Memory]";
		
		Collection<String> companyNames = contactsModel.getSortedUniqueCompaniesFromContacts();
		
		String actualComanies = Arrays.toString(companyNames.toArray());
		
		org.junit.Assert.assertEquals("Company name list not what was expected.", expectedCompanies, actualComanies);
	}
}
