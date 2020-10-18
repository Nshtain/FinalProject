package kolesnick.SummaryTask.exception;

import org.apache.logging.log4j.Marker;

/**
 * Holder for messages of exceptions.
 */
public class Messages {

	private Messages() {
		// no op
	}
	
	public static final String ERR_CANNOT_OBTAIN_USER_ORDER_BEANS = "Cannot obtain user order beans";

	public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

	public static final String ERR_CANNOT_OBTAIN_CATEGORIES = "Cannot obtain categories";

	public static final String ERR_CANNOT_OBTAIN_CARS = "Cannot obtain cars";

	public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";

	public static final String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";

	public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";

	public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";

	public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";

	public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";

	public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";

	public static final String ERR_CANNOT_CREATE_CAR = "Cannot create car";

	public static final String ERR_CANNOT_CREATE_CONTRACT = "Cannot create contract";

	public static final String ERR_CANNOT_OBTAIN_CONTRACT = "Cannot obtain contract";

	public static final String ERR_CANNOT_OBTAIN_CAR = "Cannot obtain car";

	public static final String ERR_CANNOT_UPDATE_CONTRACT = "Cannot update contract";

	public static final String ERR_CANNOT_CREATE_BILL = "Cannot create bill";

	public static final String ERR_CANNOT_DELETE_CAR = "Cannot delete car";

	public static final String ERR_CANNOT_UPDATE_CAR = "Cannot update car";

	public static final String ERR_CANNOT_CREATE_USER = "Cannot create user";

	public static final String ERR_CANNOT_OBTAIN_CONTRACTS = "Cannot obtain contracts";

	public static final String ERR_CANNOT_OBTAIN_USER_CLIENT = "Cannot obtain users(client)";
	
}