package kolesnick.SummaryTask.exception;

/**
 * Holder for messages of exceptions.
 */
public class Messages {

	public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

	public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";

	public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";

	public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";

	public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";



	public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";

	public static final String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";

	public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
	
	public static final String ERR_CANNOT_CREATE_USER = "Cannot create user";

	public static final String ERR_CANNOT_OBTAIN_USER_CLIENT = "Cannot obtain users(client)";



	public static final String ERR_CANNOT_OBTAIN_CARS = "Cannot obtain cars";

	public static final String ERR_CANNOT_CREATE_CAR = "Cannot create car";
	
	public static final String ERR_CANNOT_OBTAIN_CAR = "Cannot obtain car";
	
	public static final String ERR_CANNOT_DELETE_CAR = "Cannot delete car";

	public static final String ERR_CANNOT_UPDATE_CAR = "Cannot update car";



	public static final String ERR_CANNOT_CREATE_CONTRACT = "Cannot create contract";

	public static final String ERR_CANNOT_OBTAIN_CONTRACT = "Cannot obtain contract";
	
	public static final String ERR_CANNOT_OBTAIN_CONTRACTS = "Cannot obtain contracts";

	public static final String ERR_CANNOT_UPDATE_CONTRACT = "Cannot update contract";
	
	

	public static final String ERR_CANNOT_CREATE_BILL = "Cannot create bill";
	
	
	public static final String ERR_LOGGIN_OUT_OF_BOUNDS = "Login must be within 4-16 characters";
	
	public static final String ERR_PASSWORD_OUT_OF_BOUNDS = "Login must be within 4-32 characters";

	public static final String ERR_FIRST_NAME_OUT_OF_BOUNDS = "First name must be within 2-45 characters (A-Za-z\\u0410-\\u042F\\u0430-\\u044F)";

	public static final String ERR_NAME_OUT_OF_BOUNDS = "Name must be within 2-45 characters (\\u0410-\\u042F\\u0430-\\u044FA-Za-z)";

	public static final String ERR_LAST_NAME_OUT_OF_BOUNDS = "Last name must be within 2-45 characters (\\u0410-\\u042F\\u0430-\\u044FA-Za-z)";

	public static final String ERR_ADRESS_OUT_OF_BOUNDS = "Adress must be within 8-255 characters";

	public static final String ERR_PASSPORT_OUT_OF_BOUNDS = "Passport must be like FD123456";

	public static final String ERR_TELEPHONE_OUT_OF_BOUNDS = "Telephone must be +380 and 9 digits like +380123456789";

	public static final String ERR_BRAND_OUT_OF_BOUNDS = "Brand must be within 2-25 characters (A-Za-z\\u0410-\\u042F\\u0430-\\u044F)";

	public static final String ERR_MODEL_OUT_OF_BOUNDS = "Model must be within 1-25 characters (A-Za-z\\u0410-\\u042F\\u0430-\\u044F0-9)";

	public static final String ERR_TYPE_OUT_OF_BOUNDS = "Type must be within 4-45 characters (A-Za-z\\u0410-\\u042F\\u0430-\\u044F)";

	public static final String ERR_IMAGE_OUT_OF_BOUNDS = "Image must be within 4-45 characters (like asdf1.jpeg)";

	public static final String ERR_EAR_OF_ISSUE_OUT_OF_BOUNDS = "Ear of issue must be within 1800-2020";

	public static final String ERR_QUALITY_CLASS_OUT_OF_BOUNDS = "Quality class must be within 3-45 characters (A-Za-z\\u0410-\\u042F\\u0430-\\u044F)";

	public static final String ERR_PRICE_OUT_OF_BOUNDS = "Price must be within 100-9000";

	public static final String ERR_RENTAL_TERM_OUT_OF_BOUNDS = "Rental term must be within 1-99";

	public static final String ERR_DAMAGE_OUT_OF_BOUNDS = "Damage must be within 1-99";



}