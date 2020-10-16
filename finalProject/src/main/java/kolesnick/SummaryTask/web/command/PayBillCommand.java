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
import kolesnick.SummaryTask.exception.DBException;

public class PayBillCommand extends Command {

	private static final long serialVersionUID = -5121591630399781471L;
	private static final Logger LOG = LogManager.getLogger(PayBillCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();
		
		HttpSession session = request.getSession();
		Bill bill = (Bill) session.getAttribute("bill");
		manager.updateContractStatus(Status.PAID, bill.getContractId());
		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.addBill(bill)) {
			LOG.trace("Create new bill in DB: bill --> " + bill);
			forward = Path.COMMAND_USER_CONTRACT;
		}
		
		LOG.debug("Command finished");
		return forward;
	}

}
