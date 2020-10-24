package kolesnick.SummaryTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.Role;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;
import kolesnick.SummaryTask.exception.Messages;

/**
 * Login command.
 */
public class LoginCommand extends Command {

	private static final long serialVersionUID = -3071536593627692473L;

	private static final Logger LOG = LogManager.getLogger(LoginCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		HttpSession session = request.getSession();

		// obtain login and password from a request
		DBManager manager = DBManager.getInstance();
		String login = request.getParameter("login");
		LOG.trace("Request parameter: login --> " + login);

		String password = request.getParameter("password");
		
		if (login.length() < 4 && login.length() > 16) {
			LOG.trace(Messages.ERR_LOGGIN_OUT_OF_BOUNDS + ": " + login);
			throw new DBException(Messages.ERR_LOGGIN_OUT_OF_BOUNDS);
		}
		if (password.length() < 4 && password.length() > 32) {
			LOG.trace(Messages.ERR_PASSWORD_OUT_OF_BOUNDS + ": " + password);
			throw new DBException(Messages.ERR_PASSWORD_OUT_OF_BOUNDS);
		}
		
		if (request.getParameter("newAcc") != null) {
			LOG.trace("Try to create a new acc");

			User user = manager.findUserByLogin(login);
			if (user != null) {
				LOG.trace("This login is already taken");
				throw new DBException("This login is already taken");
			}
			user = new User();
			user.setLogin(login);
			user.setPassword(password);
			user.setRoleId(3);
			manager.createUser(user);
		}

		User user = manager.findUserByLogin(login);
		LOG.trace("Found in DB: user --> " + user);

		if (user == null || !password.equals(user.getPassword())) {
			throw new DBException("Cannot find user with such login/password");
		}

		if (user.isBlocked()) {
			throw new DBException("Your acc was blocked");
		}

		Role userRole = Role.getRole(user);
		LOG.trace("userRole --> " + userRole);

		String forward = Path.PAGE_ERROR_PAGE;

		if (userRole == Role.ADMIN) {
			forward = Path.PAGE_CREATE_CAR;
		}

		if (userRole == Role.MANAGER) {
			forward = Path.COMMAND_LIST_ORDERS;
		}

		if (userRole == Role.CLIENT) {
			forward = Path.COMMAND_LIST_CARS;
		}

		session.setAttribute("user", user);
		LOG.trace("Set the session attribute: user --> " + user);

		session.setAttribute("userRole", userRole);
		LOG.trace("Set the session attribute: userRole --> " + userRole);

		LOG.info("User " + user + " logged as " + userRole.toString().toLowerCase());

		LOG.debug("Command finished");
		return forward;
	}

}