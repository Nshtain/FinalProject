package kolesnik.SummaryTask.db;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.Status;

public class TestStatus {

	@Test
	public void testGetName() {
		assertEquals(Status.CLOSED.getName(), "closed");
	}

	@Test
	public void testSetDescription() {
		Status status = Status.CLOSED;
		status.setDescription("descr");
		assertEquals(status.getDescription(), "descr");
	}

	@Test
	public void testGetDescription() {
		Status status = Status.CLOSED;
		status.setDescription("descr");
		assertEquals(status.getDescription(), "descr");
	}

}
