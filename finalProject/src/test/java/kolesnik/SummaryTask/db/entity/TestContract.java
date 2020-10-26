package kolesnik.SummaryTask.db.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.Status;
import kolesnick.SummaryTask.db.entity.Contract;

public class TestContract {
private Contract contract = new Contract();
	@Test
	public void testGetRentalTerm() {
		contract.setRentalTerm(123);
		assertTrue(contract.getRentalTerm() == 123);
	}

	@Test
	public void testSetRentalTerm() {
		contract.setRentalTerm(123);
		assertTrue(contract.getRentalTerm() == 123);
	}

	@Test
	public void testGetCarId() {
		contract.setCarId(3);
		assertTrue(contract.getCarId() == 3);
	}

	@Test
	public void testSetCarId() {
		contract.setCarId(3);
		assertTrue(contract.getCarId() == 3);
	}

	@Test
	public void testGetUserId() {
		contract.setUserId(3);
		assertTrue(contract.getUserId() == 3);
	}

	@Test
	public void testSetUserId() {
		contract.setUserId(3);
		assertTrue(contract.getUserId() == 3);
	}

	@Test
	public void testGetStatus() {
		contract.setStatus(Status.CLOSED);
		assertEquals(contract.getStatus(), Status.CLOSED);
	}

	@Test
	public void testSetStatus() {
		contract.setStatus(Status.CLOSED);
		assertEquals(contract.getStatus(), Status.CLOSED);
	}

	@Test
	public void testIsWithDriver() {
		contract.setWithDriver(true);
		assertTrue(contract.isWithDriver());
	}

	@Test
	public void testSetWithDriver() {
		contract.setWithDriver(true);
		assertTrue(contract.isWithDriver());
	}

}
