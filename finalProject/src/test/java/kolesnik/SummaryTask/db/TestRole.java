package kolesnik.SummaryTask.db;

import static org.junit.Assert.*;

import org.junit.Test;

import kolesnick.SummaryTask.db.Role;
import kolesnick.SummaryTask.db.entity.User;

public class TestRole {

	@Test
	public void testGetRole() {
		User user = new User();
		user.setRoleId(1);
		assertEquals(Role.getRole(user), Role.ADMIN);
	}

	@Test
	public void testGetName() {
		assertEquals(Role.ADMIN.getName(), "admin");
	}

}
