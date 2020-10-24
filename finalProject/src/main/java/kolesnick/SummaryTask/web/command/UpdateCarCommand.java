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
import kolesnick.SummaryTask.exception.Messages;

public class UpdateCarCommand extends Command {

	private static final long serialVersionUID = 3658170312391672347L;
	private static final Logger LOG = LogManager.getLogger(UpdateCarCommand.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, DBException {
		LOG.debug("Command starts");


		String brandString = request.getParameter("brand");
		String modelString = request.getParameter("model");
		String typeString = request.getParameter("type");
		String imageString = request.getParameter("image");
		String earOfIssueString = request.getParameter("earOfIssue");
		String qualityClassString = request.getParameter("qualityClass");
		String priceString = request.getParameter("price");

		if (brandString.length() < 2 && brandString.length() > 25) {
			LOG.trace(Messages.ERR_BRAND_OUT_OF_BOUNDS + ": " + brandString);
			throw new DBException(Messages.ERR_BRAND_OUT_OF_BOUNDS);
		}
		if (modelString.length() < 1 && modelString.length() > 25) {
			LOG.trace(Messages.ERR_MODEL_OUT_OF_BOUNDS + ": " + modelString);
			throw new DBException(Messages.ERR_MODEL_OUT_OF_BOUNDS);
		}
		if (typeString.length() < 4 && typeString.length() > 45) {
			LOG.trace(Messages.ERR_TYPE_OUT_OF_BOUNDS + ": " + typeString);
			throw new DBException(Messages.ERR_TYPE_OUT_OF_BOUNDS);
		}
		if (imageString.length() < 4 && imageString.length() > 45) {
			LOG.trace(Messages.ERR_IMAGE_OUT_OF_BOUNDS + ": " + imageString);
			throw new DBException(Messages.ERR_IMAGE_OUT_OF_BOUNDS);
		}
		if (earOfIssueString.length() != 4) {
			LOG.trace(Messages.ERR_EAR_OF_ISSUE_OUT_OF_BOUNDS + ": " + earOfIssueString);
			throw new DBException(Messages.ERR_EAR_OF_ISSUE_OUT_OF_BOUNDS);
		}
		if (qualityClassString.length() < 3 && qualityClassString.length() > 45) {
			LOG.trace(Messages.ERR_QUALITY_CLASS_OUT_OF_BOUNDS + ": " + qualityClassString);
			throw new DBException(Messages.ERR_QUALITY_CLASS_OUT_OF_BOUNDS);
		}
		if (priceString.length() < 3 && priceString.length() > 4) {
			LOG.trace(Messages.ERR_PRICE_OUT_OF_BOUNDS + ": " + priceString);
			throw new DBException(Messages.ERR_PRICE_OUT_OF_BOUNDS);
		}

		DBManager manager = DBManager.getInstance();

		Car car = new Car();

		car.setBrand(brandString);
		car.setModel(modelString);
		car.setType(typeString);
		car.setImage(imageString);
		car.setEarOfIssue(Integer.parseInt(earOfIssueString));
		car.setQualityClass(qualityClassString);
		car.setPrice(Double.parseDouble(priceString));
		car.setId(Integer.parseInt(request.getParameter("carId")));
		
		String forward = Path.PAGE_ERROR_PAGE;

		if (manager.updateCar(car)) {
			LOG.trace("Update car in DB: car --> " + car);
			forward = Path.PAGE_CREATE_CAR;
		}

		LOG.debug("Command finished");
		return forward;
	}
}
