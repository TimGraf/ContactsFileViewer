package com.grafcode.contactsfileviewer.model;

import java.net.URI;
import java.util.Date;

public class Contact {
	public enum MAILING_LIST {DIGEST, YES, NO};
	
	private String       name;
	private String       userId;
	private String       title;
	private String       memberId;
	private String       companyName;
	private Date         joinedGroupDate;
	private Date         lastGroupVisitDate;
	private Date         lastAttendedDate;
	private int          rsvpTotal;
	private int          rsvpYes;
	private int          rsvpMaybe;
	private int          rsvpNo;
	private int          numberAttended;
	private int          numberNoShows;
	private boolean      intro;
	private boolean      photo;
	private boolean      assistantOrganizer;
	private MAILING_LIST malingList;
	private URI          profileUri;
}
