package kolesnik.SummaryTask.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.Status;
import kolesnick.SummaryTask.db.entity.Bill;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class TestDBManager extends Mockito{
	
	private DBManager manager = mock(DBManager.class);

	@Test
	public void testFindCars() throws DBException {
		when(manager.findCars()).thenReturn(new ArrayList<Car>());
		assertEquals(manager.findCars().getClass(), ArrayList.class);
	}

	@Test
	public void testAddNewCar() throws DBException {
		Car car = new Car();
		when(manager.addNewCar(car)).thenReturn(true);
		assertTrue(manager.addNewCar(car));
	}

	@Test
	public void testFindCar() throws DBException {
		Car car = new Car();
		when(manager.findCar(1)).thenReturn(car);
		assertEquals(manager.findCar(1), car);
	}

	@Test
	public void testDeleteCar() throws DBException {
		when(manager.deleteCar(1)).thenReturn(true);
		assertTrue(manager.deleteCar(1));
	}

	@Test
	public void testUpdateCar() throws DBException {
		Car car = new Car();
		when(manager.updateCar(car)).thenReturn(true);
		assertTrue(manager.updateCar(car));
	}

	@Test
	public void testFindUser() throws DBException {
		User user = new User();
		when(manager.findUser(1)).thenReturn(user);
		assertEquals(manager.findUser(1), user);
	}

	@Test
	public void testFindUserByLogin() throws DBException {
		User user = new User();
		when(manager.findUserByLogin("login")).thenReturn(user);
		assertEquals(manager.findUserByLogin("login"), user);
	}

	@Test
	public void testUpdateUser() throws DBException {
		User user = new User();
		when(manager.updateUser(user)).thenReturn(true);
		assertTrue(manager.updateUser(user));
	}

	@Test
	public void testCreateUser() throws DBException {
		User user = new User();
		when(manager.createUser(user)).thenReturn(true);
		assertTrue(manager.createUser(user));
	}

	@Test
	public void testGetAllClient() throws DBException {
		List<User> user = new ArrayList<User>();
		when(manager.getAllClient()).thenReturn(user);
		assertEquals(manager.getAllClient(), user);
	}

	@Test
	public void testCreateContract() throws DBException {
		Contract contract = new Contract();
		when(manager.createContract(contract)).thenReturn(true);
		assertTrue(manager.createContract(contract));
	}

	@Test
	public void testFindContract() throws DBException {
		Contract contract = new Contract();
		when(manager.findContract(1)).thenReturn(contract);
		assertEquals(manager.findContract(1), contract);
	}

	@Test
	public void testGetAllContracts() throws DBException {
		List<Contract> contract = new ArrayList<Contract>();
		when(manager.getAllContracts()).thenReturn(contract);
		assertEquals(manager.getAllContracts(), contract);
	}

	@Test
	public void testUpdateContractStatus() throws DBException {
		when(manager.updateContractStatus(Status.CLOSED, 1)).thenReturn(true);
		assertTrue(manager.updateContractStatus(Status.CLOSED, 1));
	}

	@Test
	public void testFindUserContractUser() throws DBException {
		User user = new User();
		List<Contract> contract = new ArrayList<Contract>();
		when(manager.findUserContract(user)).thenReturn(contract);
		assertEquals(manager.findUserContract(user), contract);
	}

	@Test
	public void testFindUserContractInt() throws DBException {
		Contract contract = new Contract();
		when(manager.findUserContract(1)).thenReturn(contract);
		assertEquals(manager.findUserContract(1), contract);
	}

	@Test
	public void testAddBill() throws DBException {
		Bill bill = new Bill();
		when(manager.addBill(bill)).thenReturn(true);
		assertTrue(manager.addBill(bill));
	}

}
