package kolesnik.SummaryTask.db;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.Fields;

public class TestFields {

	@Test
	public void test() {
		assertEquals(new Fields().getClass(), Fields.class);
	}

}
