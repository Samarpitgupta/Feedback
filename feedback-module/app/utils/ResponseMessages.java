package utils;

public final class ResponseMessages {

	private ResponseMessages() {
	}

	public static final String UNAVAILABLE = "UNAVAILABLE";
	public static final String INVALID = "INVALID";
	public static final String ALREADY_EXISITS = "ALREADYEXISTS";
	public static final String INTERNAL_ERROR = "INTERNALERROR";

	public final class ErrorMessages {
		private ErrorMessages() {
		}

		public static final int CUSTOM_ERROR_ID = 9999;
		public static final String REQUIRED_FIELDS_MISSING = "Required fields are missing. Please add and try again";
		public static final String USER_ROLE_MAPPING_NOTSAVED = "Unable to save the User Role mapping";
		public static final String USER_ID_UNAVAILABLE = "User ID is mandatory. Please add and try again";
		public static final String ROLE_ID_INVALID = "Role ID cannot be Zero. Please check and try again!";
		public static final String FEATURE_NAME_UNAVAILABLE = "Feature Name is mandatory. Please add and try again";
		public static final String FEATURE_CODE_UNAVAILABLE = "Feature Code is mandatory. Please add and try again";
		public static final String FEATURE_URL_UNAVAILABLE = "Feature URL is mandatory. Please add and try again";
		public static final String FEATURE_DETAILS_UNAVAILABLE = "Feature Details are not available. Please check";
		public static final String FEATURE_DETAILS_NOTSAVED = "Unable to save the Feature Details. Please try again later";
		public static final String USER_PROFILE_UNAVAILABLE = "User Profile Details are not found. Please check";
		public static final String USER_NAME_ALREADY_EXISTS = "UserName already exists. Please try with a different input";
		public static final String USER_PROFILE_ID_MANDATORY = "User Profile ID is mandatory. Please check";
		public static final String USER_PROFILE_SAVE_FAILURE = "Could not save the User Profile. Please check";
		public static final String EMAIL_PHONE_ALREADY_EXISTS = "This email or phone number already exists. Please reenter and check ";
		public static final String EMAIL_MANDATORY = "Email Address is mandatory. Please enter and try again";
		public static final String COUNTRY_ID_UNAVAILABLE = "Country ID is mandatory. Please add and try again";
		public static final String COUNTRY_DETAILS_UNAVAILABLE = "Country Details are not available. Please check";
		public static final String LOGOUT_FAILED = "User Log Out action has failed. Please try again";
		public static final String UNAUTHORIZED_PERMISSION = "User does not have permision to create User. Please Check";
		public static final String UNAUTHORIZED_ROLE_MAPPING_PERMISSION = "User does not have role mapping permisoin to  User. Please Check";
	}

}
