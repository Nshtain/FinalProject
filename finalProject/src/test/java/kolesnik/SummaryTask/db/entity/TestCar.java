package kolesnik.SummaryTask.db.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.User;

public class TestCar {
	private Car car = new Car();

	@Test
	public void testGetBrand() {
		car.setBrand("brand");
		assertEquals(car.getBrand(), "brand");
	}

	@Test
	public void testSetBrand() {
		car.setBrand("brand");
		assertEquals(car.getBrand(), "brand");
	}

	@Test
	public void testGetModel() {
		car.setModel("model");
		assertEquals(car.getModel(), "model");
	}

	@Test
	public void testSetModel() {
		car.setModel("model");
		assertEquals(car.getModel(), "model");
	}

	@Test
	public void testGetType() {
		car.setType("type");
		assertEquals(car.getType(), "type");
	}

	@Test
	public void testSetType() {
		car.setType("type");
		assertEquals(car.getType(), "type");
	}

	@Test
	public void testGetImage() {
		car.setImage("img");
		assertEquals(car.getImage(), "img");
	}

	@Test
	public void testSetImage() {
		car.setImage("img");
		assertEquals(car.getImage(), "img");
	}

	@Test
	public void testGetEarOfIssue() {
		car.setEarOfIssue(123);
		assertEquals(car.getEarOfIssue(), 123);
	}

	@Test
	public void testSetEarOfIssue() {
		car.setEarOfIssue(123);
		assertEquals(car.getEarOfIssue(), 123);
	}

	@Test
	public void testGetQualityClass() {
		car.setQualityClass("qc");
		assertEquals(car.getQualityClass(), "qc");
	}

	@Test
	public void testSetQualityClass() {
		car.setQualityClass("qc");
		assertEquals(car.getQualityClass(), "qc");
	}

	@Test
	public void testGetPrice() {
		car.setPrice(123);
		assertTrue(car.getPrice() == 123);
	}

	@Test
	public void testSetPrice() {
		car.setPrice(123);
		assertTrue(car.getPrice() == 123);
	}

	@Test
	public void testIsRentered() {
		car.setRentered(true);
		assertTrue(car.isRentered());
	}

	@Test
	public void testSetRentered() {
		car.setRentered(true);
		assertTrue(car.isRentered());
	}

	@Test
	public void testGetDamage() {
		car.setDamage(123);
		assertTrue(car.getDamage() == 123);
	}

	@Test
	public void testSetDamage() {
		car.setDamage(123);
		assertTrue(car.getDamage() == 123);
	}

}
