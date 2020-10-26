package kolesnick.SummaryTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.Status;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.exception.DBException;
import kolesnick.SummaryTask.exception.Messages;

public class UpdateContractStatusCommand extends Command {

	private static final long serialVersionUID = 2822224108554496813L;

	private static final Logger LOG = LogManager.getLogger(UpdateContractStatusCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();

		String forward = Path.PAGE_ERROR_PAGE;

		int contractId = Integer.parseInt(request.getParameter("contractId"));

		Contract contract = manager.findContract(contractId);
		Car car = manager.findCar(contract.getCarId());
		Status status = null;
		if (request.getParameter("decline") != null) {
			status = Status.DECLINED;
			if (request.getParameter("cause") != null) {
				status.setDescription(request.getParameter("cause"));
			}
		}
		if (request.getParameter("confirm") != null) {
			status = Status.CONFIRMED;
		}
		
		String damageString = request.getParameter("damageValue");
		if (damageString != null) {
			if (damageString.length() < 1 && damageString.length() > 2) {
				LOG.trace(Messages.ERR_DAMAGE_OUT_OF_BOUNDS + ": " + damageString);
				throw new DBException(Messages.ERR_DAMAGE_OUT_OF_BOUNDS);
			}
			
			int damage = Integer.parseInt(damageString);
			if (damage > 0) {
				if (request.getParameter("damage") != null) {
					status = Status.DAMAGE;
					car.setDamage(damage);
					manager.updateCar(car);
				}	
			}else {
				if (request.getParameter("close") != null) {
					status = Status.CLOSED;
					car.setDamage(damage);
					manager.updateCar(car);
				}			
			}
		}
		
		if (request.getParameter("close") != null) {
			status = Status.CLOSED;
			car.setDamage(0);
			manager.updateCar(car);
		}	
		

		if (manager.updateContractStatus(status, contract.getId())) {
			LOG.trace("Update contract status. contract -->" + contract);
			forward = Path.COMMAND_LIST_ORDERS;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
