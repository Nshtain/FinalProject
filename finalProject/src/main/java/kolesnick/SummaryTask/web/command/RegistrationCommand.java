package kolesnick.SummaryTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;
import kolesnick.SummaryTask.exception.Messages;

public class RegistrationCommand extends Command {

	private static final long serialVersionUID = 1048967190060021805L;
	private static final Logger LOG = LogManager.getLogger(RegistrationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		String firstName = request.getParameter("firstname");
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		String adress = request.getParameter("adress");
		String pasport = request.getParameter("pasport");
		String tel = request.getParameter("tel");
		
		if (firstName.length() < 2 && firstName.length() > 45) {
			LOG.trace(Messages.ERR_FIRST_NAME_OUT_OF_BOUNDS + ": " + firstName);
			throw new DBException(Messages.ERR_FIRST_NAME_OUT_OF_BOUNDS);
		}
		if (name.length() < 2 && name.length() > 45) {
			LOG.trace(Messages.ERR_NAME_OUT_OF_BOUNDS + ": " + name);
			throw new DBException(Messages.ERR_NAME_OUT_OF_BOUNDS);
		}
		if (lastName.length() < 2 && lastName.length() > 45) {
			LOG.trace(Messages.ERR_LAST_NAME_OUT_OF_BOUNDS + ": " + lastName);
			throw new DBException(Messages.ERR_LAST_NAME_OUT_OF_BOUNDS);
		}
		if (adress.length() < 8 && adress.length() > 255) {
			LOG.trace(Messages.ERR_ADRESS_OUT_OF_BOUNDS + ": " + adress);
			throw new DBException(Messages.ERR_ADRESS_OUT_OF_BOUNDS);
		}
		if (pasport.length() != 8) {
			LOG.trace(Messages.ERR_PASSPORT_OUT_OF_BOUNDS + ": " + pasport);
			throw new DBException(Messages.ERR_PASSPORT_OUT_OF_BOUNDS);
		}
		if (tel.length() != 13) {
			LOG.trace(Messages.ERR_TELEPHONE_OUT_OF_BOUNDS + ": " + tel);
			throw new DBException(Messages.ERR_TELEPHONE_OUT_OF_BOUNDS);
		}
		
		HttpSession session = request.getSession();
		DBManager manager = DBManager.getInstance();

		User user = (User) session.getAttribute("user");

		user.setFirstname(firstName);
		user.setName(name);
		user.setLastname(lastName);
		user.setAdress(adress);
		user.setPasport(pasport);
		user.setTel(Integer.parseInt(tel));
		
		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.updateUser(user)) {
			LOG.trace("Update user : user --> " + user);
			forward = Path.PAGE_MAKE_ORDER;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
