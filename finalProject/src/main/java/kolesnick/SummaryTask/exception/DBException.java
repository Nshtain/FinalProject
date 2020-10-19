package kolesnick.SummaryTask.exception;

/**
 * An exception that provides information on a database access error.
 */
public class DBException extends Exception {

	private static final long serialVersionUID = 8288779062647218916L;

	public DBException() {
		super();
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	public DBException(String message) {
		super(message);
	}
}
