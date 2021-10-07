package thompson.kyle.LfCodingChallenge;

public class Supervisor implements Comparable<Supervisor>{
	
	private String id;
	
	private String phone;
	
	private String jurisdiction;
	
	private String identificationNumber;
	
	private String firstName;
	
	private String lastName;
	
	@Override
	public int compareTo(Supervisor o) {
		
		if (this.jurisdiction.compareTo(o.jurisdiction) != 0) {
			return this.jurisdiction.compareTo(o.jurisdiction);
		}
		else if (this.lastName.compareTo(o.lastName) != 0) {
			return this.lastName.compareTo(o.lastName);
		}
		else if (this.firstName.compareTo(o.firstName) != 0) {
			return this.firstName.compareTo(o.firstName);
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		return jurisdiction + " - " + lastName + ", " + firstName;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}