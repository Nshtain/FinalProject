package kolesnick.SummaryTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.Role;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class AddManagerCommand extends Command {

	private static final long serialVersionUID = 9018388765915503102L;
	private static final Logger LOG = LogManager.getLogger(AddManagerCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();

		User user = new User();

		user.setLogin(request.getParameter("login"));
		user.setPassword(request.getParameter("password"));
		user.setFirstname(request.getParameter("firstname"));
		user.setName(request.getParameter("name"));
		user.setLastname(request.getParameter("lastname"));
		user.setAdress(request.getParameter("adress"));
		user.setPasport(request.getParameter("pasport"));
		user.setTel(Integer.parseInt(request.getParameter("tel")));
		user.setRoleId(Role.MANAGER.ordinal() + 1);

		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.createUser(user)) {
			LOG.trace("Create new user in DB: user --> " + user);
			forward = Path.COMMAND_LIST_CARS;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
