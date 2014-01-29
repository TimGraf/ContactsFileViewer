package com.grafcode.contactsfileviewer.model;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact {
	private static final int NUMBER_OR_PROPERTIES = 19;
	
	public enum MAILING_LIST {DIGEST, YES, NO};
	
	private String userName;
	private String userId;
	private String title;
	private String memberId;
	private String companyName;
	private Date joinedGroupDate;
	private Date lastGroupVisitDate;
	private Date lastAttendedDate;
	private int rsvpTotal;
	private int rsvpYes;
	private int rsvpMaybe;
	private int rsvpNo;
	private int numberAttended;
	private int numberNoShows;
	private boolean intro;
	private boolean photo;
	private boolean assistantOrganizer;
	private MAILING_LIST malingList;
	private URI profileUri;
	
	public static Contact createContactFromTokens(String[] tokens) throws Exception {
		
		if (tokens == null) {
			throw new IllegalArgumentException("Argument must not be null.");
		} else if (tokens.length != NUMBER_OR_PROPERTIES) {
			throw new IllegalArgumentException("Argument array size must be: " + NUMBER_OR_PROPERTIES + ".");
		}
		
		return new Contact(tokens);	
	}

	private Contact(String[] tokens) throws Exception {
		this.userName = tokens[0];
		this.userId = tokens[1];
		this.title = tokens[2];
		this.memberId = tokens[3];
		this.companyName = tokens[4];
		this.joinedGroupDate = stringTokenToDate(tokens[5]);
		this.lastGroupVisitDate = stringTokenToDate(tokens[6]);
		this.lastAttendedDate = stringTokenToDate(tokens[7]);
		this.rsvpTotal = stringTokenToInt(tokens[8]);
		this.rsvpYes = stringTokenToInt(tokens[9]);
		this.rsvpMaybe = stringTokenToInt(tokens[10]);
		this.rsvpNo = stringTokenToInt(tokens[11]);
		this.numberAttended = stringTokenToInt(tokens[12]);
		this.numberNoShows = stringTokenToInt(tokens[13]);
		this.intro = yesNoStringTokenToBoolean(tokens[14]);
		this.photo = yesNoStringTokenToBoolean(tokens[15]);
		this.assistantOrganizer = yesNoStringTokenToBoolean(tokens[16]);
		this.malingList = stringTokenToEnum(tokens[17]);
		this.profileUri = stringTokenToUri(tokens[18]);
	}
	
	static Date stringTokenToDate(String token) throws Exception {
		Date date = null;
		
		if (token.length() > 0) {
			SimpleDateFormat inputDateFormat = new SimpleDateFormat();
			
			// assume dates are either mm/dd/yy or mm/dd/yyyy
			inputDateFormat.applyPattern("d/m/y");
			
			date = inputDateFormat.parse(token);
		}
		
		return date;
	}
	
	static String dateToFormattedString(Date date) {
		String dateString = "";
		
		if (date != null) {
			SimpleDateFormat outputDateFormat = new SimpleDateFormat();
			
			outputDateFormat.applyPattern("yyyy/mm/dd");
			
			dateString = outputDateFormat.format(date);
		}
		
		return dateString;
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
	
	static URI stringTokenToUri(String token) throws Exception {
		return new URI(token);
	}

	public String getUserName() {
		return userName;
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
	
	public String getJoinedGroupDateAsString() {
		return dateToFormattedString((Date)joinedGroupDate.clone());
	}

	public String getLastGroupVisitDateAsString() {
		return dateToFormattedString((Date)lastGroupVisitDate.clone());
	}

	public String getLastAttendedDateAsString() {
		return dateToFormattedString((Date)lastAttendedDate.clone());
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