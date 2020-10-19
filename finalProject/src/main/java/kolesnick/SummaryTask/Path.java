package kolesnick.SummaryTask;

/**
 * Path holder (jsp pages, controller commands).
 */
public final class Path {

	// pages
	public static final String PAGE_LOGIN = "/login.jsp";
	public static final String PAGE_ERROR_PAGE = "/jsp/error_page.jsp";
	public static final String PAGE_LIST_CARS = "/jsp/client/list_cars.jsp";
	public static final String PAGE_LIST_ORDERS = "/jsp/manager/list_orders.jsp";
	public static final String PAGE_SETTINGS = "/jsp/settings.jsp";
	public static final String PAGE_CREATE_CAR = "/jsp/admin/addNewCar.jsp";
	public static final String PAGE_REGISTRATION = "/jsp/client/registration.jsp";
	public static final String PAGE_MAKE_ORDER = "/jsp/client/makeOrder.jsp";
	public static final String PAGE_USER_CONTRACT = "/jsp/client/contract.jsp";
	public static final String PAGE_VIEW_BILL = "/jsp/client/bill.jsp";
	public static final String PAGE_LIST_CLIENT = "/jsp/admin/clients.jsp";

	// commands
	public static final String COMMAND_LIST_ORDERS = "/controller?command=listOrders";
	public static final String COMMAND_LIST_CARS = "/controller?command=listCars";
	public static final String COMMAND_USER_CONTRACT = "/controller?command=userContract";
	public static final String COMMAND_LIST_CLIENT = "/controller?command=clientList";

}