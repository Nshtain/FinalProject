package kolesnick.SummaryTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.exception.DBException;

public class DeleteCarCommand extends Command {

	private static final long serialVersionUID = -3662779713839533675L;
	private static final Logger LOG = LogManager.getLogger(DeleteCarCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");		
		
		String forward = Path.PAGE_ERROR_PAGE;

		if (DBManager.getInstance().deleteCar(Integer.parseInt(request.getParameter("carId")))) {
			LOG.trace("Delete car in DB: carID --> " + request.getParameter("carId"));
			forward = Path.PAGE_CREATE_CAR;
		}

		LOG.debug("Command finished");
		return forward;
	}

}
