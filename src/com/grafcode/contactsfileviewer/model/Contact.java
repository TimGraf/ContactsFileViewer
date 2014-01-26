package com.grafcode.contactsfileviewer.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

public class Contact {
	private static final int NUMBER_OR_PROPERTIES = 19;
	
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
	
	public static Contact createContactFromTokens(String[] tokens) throws URISyntaxException {
		
		if (tokens == null) {
			throw new IllegalArgumentException("Argument must not be null.");
		} else if (tokens.length != NUMBER_OR_PROPERTIES) {
			throw new IllegalArgumentException("Argument array size must be: " + NUMBER_OR_PROPERTIES + ".");
		}
		
		return new Contact(tokens);	
	}
	
	static Date stringTokenToDate(String token) {
		// XXX
		return new Date();
	}
	
	static int stringTokenToInt(String token) {
		return Integer.parseInt(token);
	}
	
	static boolean yesNoStringTokenToBoolean(String token) {
		return token.equalsIgnoreCase("yes");
	}
	
	static MAILING_LIST stringTokenToEnum(String token) {
		MAILING_LIST tokenEnum = MAILING_LIST.YES;
		
		if (token.equalsIgnoreCase("no")) {
			tokenEnum = MAILING_LIST.NO;
		}
		
		if (token.equalsIgnoreCase("digest")) {
			tokenEnum = MAILING_LIST.DIGEST;
		}
		
		return tokenEnum;
	}
	
	static URI stringTokenToUri(String token) throws URISyntaxException {
		return new URI(token);
	}

	private Contact(String[] tokens) throws URISyntaxException {
		this.name 				= tokens[0];
		this.userId 			= tokens[1];
		this.title 				= tokens[2];
		this.memberId 			= tokens[3];
		this.companyName 		= tokens[4];
		this.joinedGroupDate 	= stringTokenToDate(tokens[5]);
		this.lastGroupVisitDate = stringTokenToDate(tokens[6]);
		this.lastAttendedDate 	= stringTokenToDate(tokens[7]);
		this.rsvpTotal 			= stringTokenToInt(tokens[8]);
		this.rsvpYes 			= stringTokenToInt(tokens[9]);
		this.rsvpMaybe 			= stringTokenToInt(tokens[10]);
		this.rsvpNo 			= stringTokenToInt(tokens[11]);
		this.numberAttended 	= stringTokenToInt(tokens[12]);
		this.numberNoShows 		= stringTokenToInt(tokens[13]);
		this.intro 				= yesNoStringTokenToBoolean(tokens[14]);
		this.photo 				= yesNoStringTokenToBoolean(tokens[15]);
		this.assistantOrganizer = yesNoStringTokenToBoolean(tokens[16]);
		this.malingList 		= stringTokenToEnum(tokens[17]);
		this.profileUri 		= stringTokenToUri(tokens[18]);
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public Date getJoinedGroupDate() {
		return (Date)joinedGroupDate.clone();
	}

	public Date getLastGroupVisitDate() {
		return (Date)lastGroupVisitDate.clone();
	}

	public Date getLastAttendedDate() {
		return (Date)lastAttendedDate.clone();
	}

	public int getRsvpTotal() {
		return rsvpTotal;
	}

	public int getRsvpYes() {
		return rsvpYes;
	}

	public int getRsvpMaybe() {
		return rsvpMaybe;
	}

	public int getRsvpNo() {
		return rsvpNo;
	}

	public int getNumberAttended() {
		return numberAttended;
	}

	public int getNumberNoShows() {
		return numberNoShows;
	}

	public boolean isIntro() {
		return intro;
	}

	public boolean isPhoto() {
		return photo;
	}

	public boolean isAssistantOrganizer() {
		return assistantOrganizer;
	}

	public MAILING_LIST getMalingList() {
		return malingList;
	}

	public URI getProfileUri() {
		return profileUri;
	}
}