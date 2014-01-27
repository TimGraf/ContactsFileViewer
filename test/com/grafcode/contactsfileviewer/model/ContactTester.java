package com.grafcode.contactsfileviewer.model;

import java.net.URISyntaxException;
import java.text.ParseException;

import org.junit.Test;

public class ContactTester {
	
	@Test (expected = IllegalArgumentException.class)
	public void testNullTokensObject() throws URISyntaxException, ParseException {
		Contact.createContactFromTokens(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidNumberOfTokensObject() throws URISyntaxException, ParseException {
		Contact.createContactFromTokens(new String[] {"", "", ""});
	}
	
	String   validLine   = "Adam Creeger,user 11328521,,11328521,Oracle,18/11/2010,20/09/2011,16/08/2011,7,6,0,1,5,1,Yes,Yes,No,Digest,http://www.meetup.com/San-Francisco-Grails-Cafe-Centro/members/11328521/";
	String[] validTokens = validLine.split(",");
	
	@Test
	public void testExpectedUserName() throws URISyntaxException, ParseException {
		Contact contact = Contact.createContactFromTokens(validTokens);
		org.junit.Assert.assertEquals("User name not what was expected.", contact.getUserName(), "Adam Creeger");
	}
	
	@Test
	public void testExpectedGroupJoinedDateFormat() throws URISyntaxException, ParseException {
		Contact contact = Contact.createContactFromTokens(validTokens);
		org.junit.Assert.assertEquals("Date format not what was expected.", "2010/11/18", contact.getJoinedGroupDateAsString());
	}
}
