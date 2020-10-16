package kolesnick.SummaryTask.web.command;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.DBManager;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.exception.DBException;

/**
 * Lists menu items.
 */
public class ListCarCommand extends Command {

	private static final long serialVersionUID = 7732286214029478505L;

	private static final Logger LOG = LogManager.getLogger(ListCarCommand.class);

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException, DBException {
		
		LOG.debug("Command starts");
		
		// get menu items list
		
		DBManager manager = DBManager.getInstance();
		List<Car> cars = manager.findCars();
		LOG.trace("Found in DB: carsList --> " + cars);
		
		// sort cars by price
		String sort = request.getParameter("sort");
		
		if ("price".equals(sort)) {
			
			Collections.sort(cars, new Comparator<Car>() {
				public int compare(Car o1, Car o2) {
					return (int)(o1.getPrice() - o2.getPrice());
				}
			});		
		}else if ("brand".equals(sort)) {
			Collections.sort(cars, new Comparator<Car>() {
				public int compare(Car o1, Car o2) {
					return (int)(o1.getBrand().compareTo(o2.getBrand()));
				}
			});		
		}
		
		// put car list to the request
		int page = 0;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"))-1;
		}
		request.setAttribute("page", page);		

		request.setAttribute("cars", cars);		
		LOG.trace("Set the request attribute: cars --> " + cars);
		
		LOG.debug("Command finished");
		return Path.PAGE_LIST_CARS;
	}

}