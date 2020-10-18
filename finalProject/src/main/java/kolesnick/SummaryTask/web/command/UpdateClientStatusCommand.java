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
import kolesnick.SummaryTask.db.Status;
import kolesnick.SummaryTask.db.entity.Bill;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class UpdateClientStatusCommand extends Command {

	private static final long serialVersionUID = -6238912135892418377L;

	private static final Logger LOG = LogManager.getLogger(UpdateClientStatusCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();
		
		String forward = Path.PAGE_ERROR_PAGE;
		
		int clientId = Integer.parseInt(request.getParameter("clientId"));
		
		User user = manager.findUser(clientId);
		boolean status = !user.isBlocked();
		user.setBlocked(status);

		if (manager.updateUser(user)) {
			LOG.trace("Update status client. client -->" + user);
			forward = Path.COMMAND_LIST_CLIENT;
		}
		
		LOG.debug("Command finished");
		return forward;
	}

}
