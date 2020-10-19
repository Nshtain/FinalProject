package kolesnick.SummaryTask.web.command;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class UserContractCommand extends Command {

	private static final long serialVersionUID = -934536572128360546L;
	private static final Logger LOG = LogManager.getLogger(UserContractCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {

		LOG.debug("Command starts");
		HttpSession session = request.getSession();

		// get menu items list
		List<Contract> contracts = DBManager.getInstance().findUserContract((User) session.getAttribute("user"));
		LOG.trace("Found in DB: userContracts --> " + contracts);

		// sort menu by price
		Collections.sort(contracts, new Comparator<Contract>() {
			public int compare(Contract o1, Contract o2) {
				return (int) (o1.getStatus().ordinal() - o2.getStatus().ordinal());
			}
		});
		request.setAttribute("contracts", contracts);
		LOG.debug("Command finished");
		return Path.PAGE_USER_CONTRACT;
	}

}
