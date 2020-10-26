package kolesnik.SummaryTask.db.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.Status;
import kolesnick.SummaryTask.db.entity.Bill;

public class TestBill {
private Bill bill = new Bill();
	@Test
	public void testGetTotalPrice() {
		bill.setTotalPrice(12);
		assertTrue(bill.getTotalPrice() == 12);
	}

	@Test
	public void testSetTotalPrice() {
		bill.setTotalPrice(12);
		assertTrue(bill.getTotalPrice() == 12);
	}

	@Test
	public void testGetContractId() {
		bill.setContractId(12);
		assertTrue(bill.getContractId() == 12);
	}

	@Test
	public void testSetContractId() {
		bill.setContractId(12);
		assertTrue(bill.getContractId() == 12);
	}

	@Test
	public void testGetCarId() {
		bill.setCarId(12);
		assertTrue(bill.getCarId() == 12);
	}

	@Test
	public void testSetCarId() {
		bill.setCarId(12);
		assertTrue(bill.getCarId() == 12);
	}

	@Test
	public void testGetStatus() {
		bill.setStatus(Status.CLOSED);
		assertTrue(bill.getStatus() == Status.CLOSED);
	}

	@Test
	public void testSetStatus() {
		bill.setStatus(Status.CLOSED);
		assertTrue(bill.getStatus() == Status.CLOSED);
	}

	@Test
	public void testGetUserId() {
		bill.setUserId(12);
		assertTrue(bill.getUserId() == 12);
	}

	@Test
	public void testSetUserId() {
		bill.setUserId(12);
		assertTrue(bill.getUserId() == 12);
	}

}
