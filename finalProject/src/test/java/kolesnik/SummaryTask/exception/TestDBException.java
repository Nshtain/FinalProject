package kolesnik.SummaryTask.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.exception.DBException;

public class TestDBException {

	@Test
	public void testDBException() {
		assertEquals(new DBException().getClass(), DBException.class);
	}

	@Test
	public void testDBExceptionStringThrowable() {
		assertEquals(new DBException(new String()).getClass(), DBException.class);
	}

	@Test
	public void testDBExceptionString() {
		assertEquals(new DBException(new String(), new Throwable()).getClass(), DBException.class);
	}

}
