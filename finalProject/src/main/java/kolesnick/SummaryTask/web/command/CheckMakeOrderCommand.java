package kolesnick.SummaryTask.web.command;
/**Check can user make order**/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.exception.DBException;

public class CheckMakeOrderCommand extends Command {

	private static final long serialVersionUID = 1644285060302110819L;
	private static final Logger LOG = LogManager.getLogger(CheckMakeOrderCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		HttpSession session = request.getSession();
		String forward = Path.PAGE_LOGIN;

		if (session.getAttribute("user") != null) {
			forward = Path.PAGE_REGISTRATION;
			LOG.trace("Set the session attribute: carId --> " + request.getParameter("carId"));
			session.setAttribute("carId", request.getParameter("carId"));
		}

		LOG.debug("Command finished");
		return forward;
	}

}
