package manager;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;
import utils.JSWaiter;
import utils.LogUtils;

public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		System.out.println(driverType);
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
		System.out.println(environmentType);
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		 try {  switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		   return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
		try {
			
			switch (driverType) {

			case FIREFOX:
				if (System.getProperty("os.name").contains("Windows")) {
					System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\resources\\drivers-mac\\geckodriver");
						} else {
								System.setProperty(FIREFOX_DRIVER_PROPERTY,  System.getProperty("user.dir")+"/resources/drivers-windows/geckodriver.exe");
						}
				driver = new FirefoxDriver();
				break;

			case CHROME:

				String os[] = System.getProperty("os.name").split(" ");
				String folder_appender=os[0].toLowerCase();
				System.out.println("OS NAME:"+folder_appender);
				String driverpath=System.getProperty("user.dir")+File.separator+"resources"+File.separator+"drivers-"+folder_appender+File.separator+"chromedriver";
				System.out.println("DRIVER PATH: "+ driverpath);
				System.setProperty(CHROME_DRIVER_PROPERTY, driverpath);

				 ChromeOptions options = new ChromeOptions();
			       // options.addArguments("--headless");
			        options.addArguments("--no-sandbox");
			        options.addArguments("window-size=1300x1000");

				driver = new ChromeDriver(options);

				break;

			case INTERNETEXPLORER:
				driver = new InternetExplorerDriver();
				break;

			case EDGE:
				driver = new EdgeDriver();
				break;

			default:
				throw new IllegalAccessException();

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		JSWaiter.setDriver(driver);
		if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		LogUtils.info("Closing and Quitting the driver");
		driver.close();
		driver.quit();
	}

}
