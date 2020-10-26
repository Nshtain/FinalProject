package kolesnik.SummaryTask.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.exception.Messages;

public class TestMassage {

	@Test
	public void test() {
		assertEquals(new Messages().getClass(), Messages.class);
	}

}
