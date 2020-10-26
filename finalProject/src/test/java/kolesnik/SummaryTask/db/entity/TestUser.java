package kolesnik.SummaryTask.db.entity;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.entity.User;

public class TestUser {
private User user = new User();
	@Test
	public void testGetLogin() {
		user.setLogin("login");
		assertEquals(user.getLogin(), "login");
	}

	@Test
	public void testSetLogin() {
		user.setLogin("login");
		assertEquals(user.getLogin(), "login");	
	}

	@Test
	public void testGetPassword() {
		user.setPassword("pass");
		assertEquals(user.getPassword(), "pass");	
	}

	@Test
	public void testSetPassword() {
		user.setPassword("pass");
		assertEquals(user.getPassword(), "pass");	
	}

	@Test
	public void testGetAdress() {
		user.setAdress("adress");
		assertEquals(user.getAdress(), "adress");	
	}

	@Test
	public void testSetAdress() {
		user.setAdress("adress");
		assertEquals(user.getAdress(), "adress");
	}

	@Test
	public void testGetName() {
		user.setName("name");
		assertEquals(user.getName(), "name");
	}

	@Test
	public void testSetName() {
		user.setName("name");
		assertEquals(user.getName(), "name");
	}

	@Test
	public void testGetFirstname() {
		user.setFirstname("fname");
		assertEquals(user.getFirstname(), "fname");
	}

	@Test
	public void testSetFirstname() {
		user.setFirstname("fname");
		assertEquals(user.getFirstname(), "fname");
	}

	@Test
	public void testGetLastname() {
		user.setLastname("lname");
		assertEquals(user.getLastname(), "lname");
	}

	@Test
	public void testSetLastname() {
		user.setLastname("lname");
		assertEquals(user.getLastname(), "lname");
	}

	@Test
	public void testGetPasport() {
		user.setPasport("pasport");
		assertEquals(user.getPasport(), "pasport");
	}

	@Test
	public void testSetPasport() {
		user.setPasport("pasport");
		assertEquals(user.getPasport(), "pasport");
	}

	@Test
	public void testGetTel() {
		user.setTel(123);
		assertEquals(user.getTel(), 123);
	}

	@Test
	public void testSetTel() {
		user.setTel(123);
		assertEquals(user.getTel(), 123);
	}

	@Test
	public void testGetRoleId() {
		user.setRoleId(3);
		assertEquals(user.getRoleId(), 3);
	}

	@Test
	public void testSetRoleId() {
		user.setRoleId(3);
		assertEquals(user.getRoleId(), 3);
	}

	@Test
	public void testIsBlocked() {
		user.setBlocked(true);
		assertEquals(user.isBlocked(), true);
	}

	@Test
	public void testSetBlocked() {
		user.setBlocked(true);
		assertEquals(user.isBlocked(), true);
	}

}
