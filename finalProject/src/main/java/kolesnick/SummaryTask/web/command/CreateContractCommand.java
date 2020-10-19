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
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;

public class CreateContractCommand extends Command {

	private static final long serialVersionUID = -8567784285867090191L;
	private static final Logger LOG = LogManager.getLogger(CreateContractCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		HttpSession session = request.getSession();
		DBManager manager = DBManager.getInstance();

		User user = (User) session.getAttribute("user");

		Contract contract = new Contract();

		contract.setRentalTerm(Integer.parseInt(request.getParameter("rentalTerm")));
		contract.setWithDriver(Boolean.parseBoolean(request.getParameter("driver")));
		contract.setCarId(Integer.parseInt((String) (session.getAttribute("carId"))));
		contract.setUserId(user.getId());
		contract.setStatus(Status.NEW);

		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.createContract(contract)) {
			LOG.trace("Create new contract in DB" + contract);
			forward = Path.COMMAND_USER_CONTRACT;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
