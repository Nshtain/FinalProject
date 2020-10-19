package kolesnick.SummaryTask.db;

/**
 * DB manager. Works with MySQL DB.
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kolesnick.SummaryTask.db.entity.Bill;
import kolesnick.SummaryTask.db.entity.Car;
import kolesnick.SummaryTask.db.entity.Contract;
import kolesnick.SummaryTask.db.entity.User;
import kolesnick.SummaryTask.exception.DBException;
import kolesnick.SummaryTask.exception.Messages;

public final class DBManager {

	private static final Logger LOG = LogManager.getLogger(DBManager.class);

	// //////////////////////////////////////////////////////////
	// singleton
	// //////////////////////////////////////////////////////////

	private static DBManager instance;

	public static synchronized DBManager getInstance() throws DBException {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() throws DBException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/kolesnick_db");
			LOG.trace("Data source ==> " + ds);
		} catch (NamingException ex) {
			LOG.error(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_DATA_SOURCE, ex);
		}
	}

	private DataSource ds;

	// //////////////////////////////////////////////////////////
	// SQL queries
	// //////////////////////////////////////////////////////////

	private static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
	private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	private static final String SQL_UPDATE_USER = "UPDATE user SET user_firstname=?, user_name=?, user_lastname=?, adress=?, pasport=?, tel=?, blocked=? WHERE id=?";
	private static final String SQL_FIND_USER_CLIENT = "SELECT * FROM user WHERE role_id = 3";
	private static final String SQL_CREATE_USER = "INSERT INTO user (login, password, adress, user_name, user_firstname, user_lastname, pasport, tel, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SQL_FIND_ALL_CONTRACTS = "SELECT * FROM contract";
	private static final String SQL_CREATE_CONTRACT = "INSERT INTO `contract` (`rental_term`, `car_id`, `with_driver`, `user_id`, `status_id`) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_FIND_CONTRACT_BY_USER = "SELECT * FROM contract WHERE user_id=?";
	private static final String SQL_FIND_CONTRACT_BY_CONTRACT_ID = "SELECT * FROM contract WHERE id=?";
	private static final String SQL_UPDATE_CONTRACT_STATUS_BY_CONTRACT_ID = "UPDATE contract SET status_id=? WHERE id=?";

	private static final String SQL_FIND_ALL_CARS = "SELECT * FROM car";
	private static final String SQL_UPDATE_CAR = "UPDATE car SET brand=?, model=?, type=?, image=?, ear_of_issue=?, quality_class=?, price=?, rentered=?, damage=? WHERE id=?;";
	private static final String SQL_DELETE_CAR_BY_ID = "DELETE FROM car WHERE id = ?";
	private static final String SQL_FIND_CAR_BY_ID = "SELECT * FROM car WHERE id=?";
	private static final String SQL_CREATE_CAR = "INSERT INTO `car` (`brand`, `model`, `type`, `image`, `ear_of_issue`, `quality_class`, `price`, `rentered`, `damage`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String SQL_CREATE_BILL = "INSERT INTO `bill` (`total_price`, `contract_id`) VALUES (?, ?);";

	/**
	 * Returns a DB connection from the Pool Connections. Before using this method
	 * you must configure the Date Source and the Connections Pool in your
	 * WEB_APP_ROOT/META-INF/context.xml file.
	 * 
	 * @return DB connection.
	 */
	public Connection getConnection() throws DBException {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException ex) {
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
		}
		return con;
	}

	// //////////////////////////////////////////////////////////
	// Entity access methods
	// //////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////
	// Car
	// //////////////////////////////////////////////////////////
	/**
	 * Returns all cars.
	 * 
	 * @return List of car entities.
	 */
	public List<Car> findCars() throws DBException {
		List<Car> carsList = new ArrayList<Car>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_ALL_CARS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				carsList.add(extractCar(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CARS, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CARS, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return carsList;
	}

	/**
	 * Create new car.
	 * 
	 * @return true if create car.
	 */
	public boolean addNewCar(Car car) throws DBException {
		Connection con = null;
		try {
			con = getConnection();
			addNewCar(con, car);
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_CREATE_CAR);
			throw new DBException(Messages.ERR_CANNOT_CREATE_CAR, ex);
		} finally {
			close(con);
		}
		return true;
	}

	/**
	 * Find car by carId.
	 * 
	 * @return found car.
	 */
	public Car findCar(int carId) throws DBException {
		Car car = new Car();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_CAR_BY_ID);
			pstmt.setInt(1, carId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				car = extractCar(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CAR, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CAR, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return car;
	}

	/**
	 * Delete car by id.
	 * 
	 * @return true if delete car.
	 */
	public boolean deleteCar(int carId) throws DBException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_DELETE_CAR_BY_ID);
			pstmt.setInt(1, carId);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_DELETE_CAR, ex);
			throw new DBException(Messages.ERR_CANNOT_DELETE_CAR, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return true;
	}

	/**
	 * Update car.
	 * 
	 * @return true if update car.
	 */
	public boolean updateCar(Car car) throws DBException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_UPDATE_CAR);
			int k = 1;
			pstmt.setString(k++, car.getBrand());
			pstmt.setString(k++, car.getModel());
			pstmt.setString(k++, car.getType());
			pstmt.setString(k++, car.getImage());
			pstmt.setInt(k++, car.getEarOfIssue());
			pstmt.setString(k++, car.getQualityClass());
			pstmt.setDouble(k++, car.getPrice());
			pstmt.setBoolean(k++, car.isRentered());
			pstmt.setInt(k++, car.getDamage());
			pstmt.setInt(k, car.getId());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_UPDATE_CAR, ex);
			throw new DBException(Messages.ERR_CANNOT_UPDATE_CAR, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return true;
	}

	// //////////////////////////////////////////////////////////
	// User
	// //////////////////////////////////////////////////////////

	/**
	 * Returns a user with the given identifier.
	 * 
	 * @param id User identifier.
	 * @return User entity.
	 * @throws DBException
	 */
	public User findUser(int id) throws DBException {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_USER_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}

	/**
	 * Returns a user with the given login.
	 * 
	 * @param login User login.
	 * @return User entity.
	 * @throws DBException
	 */
	public User findUserByLogin(String login) throws DBException {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN);
			pstmt.setString(1, login);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = extractUser(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return user;
	}

	/**
	 * Update user.
	 * 
	 * @param user user to update.
	 * @return
	 * @throws DBException
	 */
	public boolean updateUser(User user) throws DBException {
		Connection con = null;
		try {
			con = getConnection();
			updateUser(con, user);
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_UPDATE_USER, ex);
		} finally {
			close(con);
		}
		return true;
	}

	/**
	 * Create user.
	 * 
	 * @param user user to create.
	 * @return true if create
	 * @throws DBException
	 */
	public boolean createUser(User user) throws DBException {
		Connection con = null;
		try {
			con = getConnection();
			createUser(con, user);
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_CREATE_USER, ex);
		} finally {
			close(con);
		}
		return true;
	}

	/**
	 * Find all users with role = client.
	 * 
	 * @return list users
	 * @throws DBException
	 */
	public List<User> getAllClient() throws DBException {
		List<User> clients = new ArrayList<User>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_USER_CLIENT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				clients.add(extractUser(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_CLIENT, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return clients;
	}

	// //////////////////////////////////////////////////////////
	// Contract
	// //////////////////////////////////////////////////////////

	/**
	 * Create contract.
	 * 
	 * @param contract contract to create.
	 * @return true if create
	 * @throws DBException
	 */
	public boolean createContract(Contract contract) throws DBException {
		Connection con = null;
		try {
			con = getConnection();
			createContract(con, contract);
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_CREATE_CONTRACT, ex);
		} finally {
			close(con);
		}
		return true;
	}

	/**
	 * Find contract by id.
	 * 
	 * @param contractId contracts id.
	 * @return Contract contract
	 * @throws DBException
	 */
	public Contract findContract(int contractId) throws DBException {
		Contract contract = new Contract();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_CONTRACT_BY_CONTRACT_ID);
			pstmt.setInt(1, contractId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contract = extractContract(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CONTRACTS, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONTRACTS, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return contract;
	}

	/**
	 * Find all contracts.
	 * 
	 * @return list contracts
	 * @throws DBException
	 */
	public List<Contract> getAllContracts() throws DBException {
		List<Contract> contractsList = new ArrayList<Contract>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_ALL_CONTRACTS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				contractsList.add(extractContract(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CONTRACTS, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONTRACTS, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return contractsList;
	}

	/**
	 * Update contracts status.
	 * 
	 * @return true if update.
	 * @throws DBException
	 */
	public boolean updateContractStatus(Status status, int contractId) throws DBException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_UPDATE_CONTRACT_STATUS_BY_CONTRACT_ID);
			pstmt.setInt(1, status.ordinal() + 1);
			pstmt.setInt(2, contractId);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			throw new DBException(Messages.ERR_CANNOT_UPDATE_CONTRACT, e);
		} finally {
			close(con, pstmt, rs);
		}
		return true;
	}

	public List<Contract> findUserContract(User user) throws DBException {
		List<Contract> contracts = new ArrayList<Contract>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_CONTRACT_BY_USER);
			pstmt.setInt(1, user.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				contracts.add(extractContract(rs));
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CONTRACT, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONTRACT, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return contracts;
	}

	public Contract findUserContract(int contractId) throws DBException {
		Contract contract = new Contract();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL_FIND_CONTRACT_BY_CONTRACT_ID);
			pstmt.setInt(1, contractId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contract = extractContract(rs);
			}
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			LOG.error(Messages.ERR_CANNOT_OBTAIN_CONTRACT, ex);
			throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONTRACT, ex);
		} finally {
			close(con, pstmt, rs);
		}
		return contract;
	}

	// //////////////////////////////////////////////////////////
	// Bill
	// //////////////////////////////////////////////////////////

	/**
	 * Create bill.
	 * 
	 * @param bill bill to create.
	 * @return true if create.
	 * @throws DBException
	 */
	public boolean addBill(Bill bill) throws DBException {
		Connection con = null;
		try {
			con = getConnection();
			addBill(con, bill);
			con.commit();
		} catch (SQLException ex) {
			rollback(con);
			throw new DBException(Messages.ERR_CANNOT_CREATE_BILL, ex);
		} finally {
			close(con);
		}
		return true;
	}

	// //////////////////////////////////////////////////////////
	// Entity access methods (for transactions)
	// //////////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////
	// Car
	// //////////////////////////////////////////////////////////

	private void addNewCar(Connection con, Car car) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL_CREATE_CAR);
			int k = 1;
			pstmt.setString(k++, car.getBrand());
			pstmt.setString(k++, car.getModel());
			pstmt.setString(k++, car.getType());
			pstmt.setString(k++, car.getImage());
			pstmt.setInt(k++, car.getEarOfIssue());
			pstmt.setString(k++, car.getQualityClass());
			pstmt.setDouble(k++, car.getPrice());
			pstmt.setBoolean(k++, car.isRentered());
			pstmt.setInt(k, car.getDamage());

			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	// //////////////////////////////////////////////////////////
	// User
	// //////////////////////////////////////////////////////////

	/**
	 * Update user.
	 * 
	 * @param user user to update.
	 * @throws SQLException
	 */
	private void updateUser(Connection con, User user) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL_UPDATE_USER);
			int k = 1;
			pstmt.setString(k++, user.getFirstname());
			pstmt.setString(k++, user.getName());
			pstmt.setString(k++, user.getLastname());
			pstmt.setString(k++, user.getAdress());
			pstmt.setString(k++, user.getPasport());
			pstmt.setInt(k++, user.getTel());
			pstmt.setBoolean(k++, user.isBlocked());
			pstmt.setInt(k, user.getId());

			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	private void createUser(Connection con, User user) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL_CREATE_USER);
			int k = 1;
			pstmt.setString(k++, user.getLogin());
			pstmt.setString(k++, user.getPassword());
			pstmt.setString(k++, user.getAdress());
			pstmt.setString(k++, user.getName());
			pstmt.setString(k++, user.getFirstname());
			pstmt.setString(k++, user.getLastname());
			pstmt.setString(k++, user.getPasport());
			pstmt.setInt(k++, user.getTel());
			pstmt.setInt(k, user.getRoleId());

			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	// //////////////////////////////////////////////////////////
	// Contract
	// //////////////////////////////////////////////////////////

	/**
	 * Create contract.
	 * 
	 * @param con  connection
	 * @param car  car from order
	 * @param user user who make order
	 * @throws SQLException
	 */
	private void createContract(Connection con, Contract contract) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL_CREATE_CONTRACT);
			int k = 1;
			pstmt.setInt(k++, contract.getRentalTerm());
			pstmt.setInt(k++, contract.getCarId());
			pstmt.setBoolean(k++, contract.isWithDriver());
			pstmt.setInt(k++, contract.getUserId());
			pstmt.setInt(k, contract.getStatus().ordinal() + 1);
			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	// //////////////////////////////////////////////////////////
	// Bill
	// //////////////////////////////////////////////////////////

	private void addBill(Connection con, Bill bill) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL_CREATE_BILL);
			int k = 1;
			pstmt.setDouble(k++, bill.getTotalPrice());
			pstmt.setInt(k, bill.getContractId());
			LOG.trace(pstmt);

			pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
	}

	// //////////////////////////////////////////////////////////
	// DB util methods
	// //////////////////////////////////////////////////////////

	/**
	 * Closes a connection.
	 * 
	 * @param con Connection to be closed.
	 */
	private void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				LOG.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
			}
		}
	}

	/**
	 * Closes a statement object.
	 */
	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				LOG.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
			}
		}
	}

	/**
	 * Closes a result set object.
	 */
	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
				LOG.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
			}
		}
	}

	/**
	 * Closes resources.
	 */
	private void close(Connection con, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(con);
	}

	/**
	 * Rollbacks a connection.
	 * 
	 * @param con Connection to be rollbacked.
	 */
	private void rollback(Connection con) {
		if (con != null) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				LOG.error("Cannot rollback transaction", ex);
			}
		}
	}

	// //////////////////////////////////////////////////////////
	// Other methods
	// //////////////////////////////////////////////////////////

	/**
	 * Extracts a contract from the result set.
	 * 
	 * @param rs Result set from which a contract entity will be extracted.
	 * @return Contract object
	 */
	private Contract extractContract(ResultSet rs) throws SQLException {
		Contract contract = new Contract();
		contract.setId(rs.getInt(Fields.ENTITY_ID));
		contract.setRentalTerm(rs.getInt(Fields.CONTRACT_RENTAL_TERM));
		contract.setCarId(rs.getInt(Fields.CONTRACT_CAR_ID));
		contract.setWithDriver(rs.getBoolean(Fields.CONTRACT_WITH_DRIVER));
		contract.setUserId(rs.getInt(Fields.CONTRACT_USER_ID));
		contract.setStatus(Status.values()[rs.getInt(Fields.CONTRACT_STATUS_ID) - 1]);
		return contract;
	}

	/**
	 * Extracts a user entity from the result set.
	 * 
	 * @param rs Result set from which a user entity will be extracted.
	 * @return User entity
	 */
	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(Fields.ENTITY_ID));
		user.setLogin(rs.getString(Fields.USER_LOGIN));
		user.setPassword(rs.getString(Fields.USER_PASSWORD));
		user.setAdress(rs.getString(Fields.USER_ADRESS));
		user.setName(rs.getString(Fields.USER_NAME));
		user.setFirstname(rs.getString(Fields.USER_FIRST_NAME));
		user.setLastname(rs.getString(Fields.USER_LAST_NAME));
		user.setPasport(rs.getString(Fields.USER_PASPORT));
		user.setTel(rs.getInt(Fields.USER_TELEPHONE));
		user.setBlocked(rs.getBoolean(Fields.USER_BLOCKED));
		user.setRoleId(rs.getInt(Fields.USER_ROLE_ID));
		return user;
	}

	/**
	 * Extracts a car from the result set.
	 * 
	 * @param rs Result set from which a car entity will be extracted.
	 * @return Car entity.
	 */
	private Car extractCar(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId(rs.getInt(Fields.ENTITY_ID));
		car.setBrand(rs.getString(Fields.CAR_BRAND));
		car.setModel(rs.getString(Fields.CAR_MODEL));
		car.setType(rs.getString(Fields.CAR_TYPE));
		car.setImage(rs.getString(Fields.CAR_IMAGE));
		car.setEarOfIssue(rs.getInt(Fields.CAR_EAR_OF_ISSUE));
		car.setQualityClass(rs.getString(Fields.CAR_QUALITY_CLASS));
		car.setPrice(rs.getDouble(Fields.CAR_PRICE));
		car.setRentered(rs.getBoolean(Fields.CAR_RENTERED));
		car.setDamage(rs.getInt(Fields.CAR_DAMAGE));
		return car;
	}

}