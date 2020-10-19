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

public class CreateCarCommand extends Command {

	private static final long serialVersionUID = -649465301098928699L;

	private static final Logger LOG = LogManager.getLogger(CreateCarCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");

		DBManager manager = DBManager.getInstance();

		Car car = new Car();

		car.setBrand(request.getParameter("brand"));
		car.setModel(request.getParameter("model"));
		car.setType(request.getParameter("type"));
		car.setImage(request.getParameter("image"));
		car.setEarOfIssue(Integer.parseInt(request.getParameter("earOfIssue")));
		car.setQualityClass(request.getParameter("qualityClass"));
		car.setPrice(Double.parseDouble(request.getParameter("price")));
		car.setRentered(Boolean.parseBoolean(request.getParameter("rentered")));
		car.setDamage(Integer.parseInt(request.getParameter("damage")));

		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.addNewCar(car)) {
			LOG.trace("Create new car in DB: car --> " + car);
			forward = Path.PAGE_CREATE_CAR;
		}

		LOG.debug("Command finished");
		return forward;
	}
}
