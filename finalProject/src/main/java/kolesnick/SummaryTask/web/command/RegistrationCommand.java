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

public class RegistrationCommand extends Command {

	private static final long serialVersionUID = 1048967190060021805L;
	private static final Logger LOG = LogManager.getLogger(RegistrationCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		HttpSession session = request.getSession();
		DBManager manager = DBManager.getInstance();

		User user = (User) session.getAttribute("user");

		user.setFirstname(request.getParameter("firstname"));
		user.setName(request.getParameter("name"));
		user.setLastname(request.getParameter("lastname"));
		user.setAdress(request.getParameter("adress"));
		user.setPasport(request.getParameter("pasport"));
		user.setTel(Integer.parseInt(request.getParameter("tel")));

		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.updateUser(user)) {
			LOG.trace("Update user : user --> " + user);
			forward = Path.PAGE_MAKE_ORDER;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
