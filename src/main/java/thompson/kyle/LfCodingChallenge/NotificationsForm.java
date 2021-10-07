package thompson.kyle.LfCodingChallenge;

public class NotificationsForm {
	
	private String fName;
	
	private String lName;
	
	private String notifType1;
	
	private String emailAddress;
	
	private String notifType2;
	
	private String phoneNumber;
	
	private String supervisor;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getNotifType1() {
		return notifType1;
	}

	public void setNotifType1(String notifType1) {
		this.notifType1 = notifType1;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getNotifType2() {
		return notifType2;
	}

	public void setNotifType2(String notifType2) {
		this.notifType2 = notifType2;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	public boolean isValid() {
		if (fName.isBlank() || lName.isBlank() || supervisor.isBlank()) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("First Name: " + fName + "\n");
		sb.append("Last Name: " + lName + "\n");
		
		if (!(notifType1 == null || notifType1.isBlank())) {
			sb.append("Email : " + emailAddress + "\n");
		}
		
		if (!(notifType2 == null || notifType2.isBlank())) {
			sb.append("Phone Number : " + phoneNumber + "\n");
		}
		
		sb.append("Supervisor : " + supervisor + "\n");
		
		return sb.toString();
	}
	
	

}
