package logging;

import java.io.InputStream;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;

public class LogConfig 
{
	private static final String CONF_FILE = "logging.properties";
	//private static Logger logger = null;
	private static LogConfig instance = null;
	
	
	private LogConfig()
	{
		try
		{
			InputStream inputStream = LogConfig.class.getClassLoader().getResourceAsStream(CONF_FILE);
			LogManager.getLogManager().readConfiguration(inputStream);
		}
		catch(Exception e) 
		{
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
		}
	}
	
	public static LogConfig getInstance()
	{
		if(instance == null)
		{
			return new LogConfig();
		}
		else
		{
			return instance;
		}
	}
	
	public void log(Class<?> clazz, String message)
	{
		Logger logger = Logger.getLogger(clazz.getName());
		logger.log(Level.INFO, message);
	}
}
