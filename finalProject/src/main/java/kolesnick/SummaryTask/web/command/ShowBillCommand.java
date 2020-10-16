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
import kolesnick.SummaryTask.db.entity.Bill;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.exception.DBException;

public class ShowBillCommand extends Command {

	private static final long serialVersionUID = -6724357338018708331L;
	private static final Logger LOG = LogManager.getLogger(ShowBillCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();
		Contract contract = manager.findUserContract(Integer.parseInt(request.getParameter("contractId")));
		HttpSession session = request.getSession();
		Bill bill = new Bill();
		Car car = manager.findCar(contract.getCarId());
		double driverPrice = contract.isWithDriver() ? 100 * contract.getRentalTerm() : 0;
		double totalPrice = (car.getPrice() * contract.getRentalTerm()) + (car.getDamage() * car.getPrice() / 100) + driverPrice;  
		bill.setContractId(contract.getId());
		bill.setTotalPrice(totalPrice);
		
		session.setAttribute("bill", bill);
		LOG.trace("Set the request attribute: bill --> " + bill);

		String forward = Path.PAGE_VIEW_BILL;

		LOG.debug("Command finished");
		return forward;
	}
}
