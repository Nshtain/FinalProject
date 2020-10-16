package kolesnick.SummaryTask.web.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;

/**
 * Context listener.
 */
public class ContextListener implements ServletContextListener {

	private static final Logger LOG = LogManager.getLogger(ContextListener.class);

	public void contextDestroyed(ServletContextEvent event) {
		log("Servlet context destruction starts");
		// no op
		log("Servlet context destruction finished");
	}

	public void contextInitialized(ServletContextEvent event) {
		log("Servlet context initialization starts");

		initLog4J(event.getServletContext());
		initCommandContainer();
	
		log("Servlet context initialization finished");
	}

	/**
	 * Initializes log4j framework.
	 */
	
	private void initLog4J(ServletContext servletContext) {
		log("Log4J initialization started");
		try {
			LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
			File file = new File(servletContext.getRealPath("/WEB-INF/log4.xml"));
			loggerContext.setConfigLocation(file.toURI());
			System.out.print(file.toURI());
			
			LOG.debug("Log4j has been initialized");
		} catch (Exception ex) {
			log("Cannot configure Log4j");
			ex.printStackTrace();
		}		
		log("Log4J initialization finished");
	}
	
	/**
	 * Initializes CommandContainer.
	 */
	private void initCommandContainer() {
		
		// initialize commands container
		// just load class to JVM
		try {
			Class.forName("kolesnick.SummaryTask.web.command.CommandContainer");
		} catch (ClassNotFoundException ex) {
			throw new IllegalStateException("Cannot initialize Command Container");
		}
	}
	
	private void log(String msg) {
		System.out.println("[ContextListener] " + msg);
	}
}