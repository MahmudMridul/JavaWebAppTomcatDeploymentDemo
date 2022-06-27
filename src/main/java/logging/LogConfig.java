package logging;

import java.io.InputStream;
import java.io.File;
import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.util.logging.Level;
//import org.apache.juli.ClassLoaderLogManager;

public class LogConfig 
{
	private static final String CONF_FILE = "logging.properties";
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
			instance = new LogConfig();
			String directory = System.getProperty("user.home");
			
			try
			{
				File logDirectory = new File(directory+"\\DemoWebAppLogs");
				logDirectory.mkdir();
			}
			catch(Exception e)
			{
				LogConfig.getInstance().log(LogConfig.class, e.getMessage());
			}
			
			return instance;
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
