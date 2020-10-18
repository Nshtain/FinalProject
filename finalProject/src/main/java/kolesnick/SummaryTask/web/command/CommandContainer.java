package kolesnick.SummaryTask.web.command;

import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Holder for all commands.<br/>
 */
public class CommandContainer {
	
	private static final Logger LOG = LogManager.getLogger();
	
	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		// common commands
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("viewSettings", new ViewSettingsCommand());
		commands.put("noCommand", new NoCommand());
		commands.put("checkMakeOrder", new CheckMakeOrderCommand());

		
		// client commands
		commands.put("listCars", new ListCarCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("makeOrder", new MakeOrderCommand());
		commands.put("userContract", new UserContractCommand());
		commands.put("payBill", new PayBillCommand());
		commands.put("showBill", new ShowBillCommand());
		

		// manager commands
		commands.put("listOrders", new ListOrdersCommand());
		commands.put("updateContractStatus", new UpdateContractStatusCommand());
		
		
		// admin commands
		commands.put("addNewCar", new CreateCarCommand());
		commands.put("deleteCar", new DeleteCarCommand());
		commands.put("updateCar", new UpdateCarCommand());
		commands.put("addManager", new AddManagerCommand());
		commands.put("clientList", new ClientListCommand());
		commands.put("updateClientStatus", new UpdateClientStatusCommand());

		
		LOG.debug("Command container was successfully initialized");
		LOG.trace("Number of commands --> " + commands.size());
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found, name --> " + commandName);
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}
	
}