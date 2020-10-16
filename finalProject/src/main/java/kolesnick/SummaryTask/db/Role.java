package kolesnick.SummaryTask.db;

import kolesnick.SummaryTask.db.entity.User;

/**
 * Role entity.
 */

public enum Role {
	ADMIN, MANAGER, CLIENT;
	
	public static Role getRole(User user) {
		int roleId = user.getRoleId();
		return Role.values()[roleId-1];
	}
	
	public String getName() {
		return name().toLowerCase();
	}
	
}
