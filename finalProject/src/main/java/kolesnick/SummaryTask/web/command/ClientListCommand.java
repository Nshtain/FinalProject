package kolesnick.SummaryTask.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class ClientListCommand extends Command {

	private static final long serialVersionUID = 6053432491067344656L;
	private static final Logger LOG = LogManager.getLogger(ClientListCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Commands starts");
		
		List<User> clientList = DBManager.getInstance().getAllClient();
		LOG.trace("Found in DB: clientList --> " + clientList);
				
		// put user orders list to request
		request.setAttribute("clientList", clientList);		
		LOG.trace("Set the request attribute: clientList --> " + clientList);
		
		LOG.debug("Commands finished");
		return Path.PAGE_LIST_CLIENT;
	}

}
