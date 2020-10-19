package kolesnick.SummaryTask.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.Path;
import kolesnick.SummaryTask.db.Role;

/**
 * Security filter.
 */
public class CommandAccessFilter implements Filter {

	private static final Logger LOG = LogManager.getLogger(CommandAccessFilter.class);

	// commands access
	private Map<Role, List<String>> accessMap = new HashMap<Role, List<String>>();
	private List<String> commons = new ArrayList<String>();
	private List<String> outOfControl = new ArrayList<String>();

	public void destroy() {
		LOG.debug("Filter destruction starts");
		// do nothing
		LOG.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LOG.debug("Filter starts");

		if (accessAllowed(request)) {
			LOG.debug("Filter finished");
			chain.doFilter(request, response);
		} else {
			String errorMessasge = "You do not have permission to access the requested resource";

			request.setAttribute("errorMessage", errorMessasge);
			LOG.trace("Set the request attribute: errorMessage --> " + errorMessasge);

			request.getRequestDispatcher(Path.PAGE_ERROR_PAGE).forward(request, response);
		}
	}

	private boolean accessAllowed(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String commandName = request.getParameter("command");
		if (commandName == null || commandName.isEmpty()) {
			return false;
		}

		if (outOfControl.contains(commandName)) {
			return true;
		}

		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			return false;
		}

		Role userRole = (Role) session.getAttribute("userRole");
		if (userRole == null) {
			return false;
		}

		return accessMap.get(userRole).contains(commandName) || commons.contains(commandName);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");

		// roles
		accessMap.put(Role.ADMIN, asList(fConfig.getInitParameter("admin")));
		accessMap.get(Role.ADMIN).add("addNewCar");
		accessMap.get(Role.ADMIN).add("deleteCar");
		accessMap.get(Role.ADMIN).add("updateCar");
		accessMap.get(Role.ADMIN).add("addManager");
		accessMap.get(Role.ADMIN).add("clientList");
		accessMap.get(Role.ADMIN).add("updateClientStatus");

		accessMap.put(Role.CLIENT, asList(fConfig.getInitParameter("client")));
		accessMap.get(Role.CLIENT).add("registration");
		accessMap.get(Role.CLIENT).add("makeOrder");
		accessMap.get(Role.CLIENT).add("userContract");
		accessMap.get(Role.CLIENT).add("payBill");
		accessMap.get(Role.CLIENT).add("showBill");

		accessMap.put(Role.MANAGER, asList(fConfig.getInitParameter("manager")));
		accessMap.get(Role.MANAGER).add("listOrders");
		accessMap.get(Role.MANAGER).add("updateContractStatus");

		LOG.trace("Access map --> " + accessMap);

		// commons
		commons = asList(fConfig.getInitParameter("common"));
		LOG.trace("Common commands --> " + commons);

		// out of control
		outOfControl = asList(fConfig.getInitParameter("out-of-control"));
		outOfControl.add("listCars");
		outOfControl.add("checkMakeOrder");
		outOfControl.add("viewSettings");
		LOG.trace("Out of control commands --> " + outOfControl);

		LOG.debug("Filter initialization finished");
	}

	/**
	 * Extracts parameter values from string.
	 * 
	 * @param str parameter values string.
	 * @return list of parameter values.
	 */
	private List<String> asList(String str) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		return list;
	}

}