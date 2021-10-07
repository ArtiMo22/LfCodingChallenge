package thompson.kyle.LfCodingChallenge;

public class FormValidator {

	
	public static void validate (NotificationsForm form) throws NotificationsFormException {
		validateFirstName(form.getfName());
		validateLastName(form.getlName());
		validateSupervisor(form.getSupervisor());
		validatePhoneNumber(form.getPhoneNumber());
		validateEmailAddress(form.getEmailAddress());
	}
	
	private static void validateFirstName(String fName) throws NotificationsFormException {
		if (fName.isBlank()) {
			throw new NotificationsFormException("First Name is missing");
		}
		if (!fName.matches("[a-zA-Z]+")) {
			throw new NotificationsFormException("First Name must contain only letters");
		}
	}
	
	private static void validateLastName(String lName) throws NotificationsFormException {
		if (lName.isBlank()) {
			throw new NotificationsFormException("Last Name is missing");
		}
		if (!lName.matches("[a-zA-Z]+")) {
			throw new NotificationsFormException("Last Name must contain only letters");
		}
	}
	
	private static void validateSupervisor(String supervisor) throws NotificationsFormException{
		if (supervisor.isBlank()) {
			throw new NotificationsFormException("Supervisor is missing");
		}
	}
	
	private static void validatePhoneNumber(String phone) throws NotificationsFormException {
		if (phone != null 
				&& !phone.isBlank() 
				&& !phone.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
			throw new NotificationsFormException("Phone number is not properly formatted");
		}
	}
	
	private static void validateEmailAddress(String email) throws NotificationsFormException {
		if (email != null 
				&& !email.isBlank() 
				&& !email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
			throw new NotificationsFormException("Email Address is not properly formatted");
		}
	}
	
}
