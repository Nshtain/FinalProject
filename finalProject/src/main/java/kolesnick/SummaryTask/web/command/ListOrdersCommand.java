package kolesnick.SummaryTask.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.exception.DBException;

public class ListOrdersCommand extends Command {

	private static final long serialVersionUID = 1863978254689586513L;

	private static final Logger LOG = LogManager.getLogger(ListOrdersCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Commands starts");

		HttpSession session = request.getSession();
		List<Contract> userOrderList = DBManager.getInstance().getAllContracts();
		LOG.trace("Found in DB: userOrderList --> " + userOrderList);

		// put user orders list to request
		session.setAttribute("userOrderList", userOrderList);
		LOG.trace("Set the session attribute: userOrderList --> " + userOrderList);

		LOG.debug("Commands finished");
		return Path.PAGE_LIST_ORDERS;
	}

}
