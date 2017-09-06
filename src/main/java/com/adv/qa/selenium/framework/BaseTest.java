package com.adv.qa.selenium.framework; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;

import com.adv.qa.selenium.framework.pageObjects.PageObjects;
import com.adv.qa.selenium.helpers.MainXMLStructure;
import com.adv.qa.selenium.helpers.ReportListeners;
import com.adv.qa.selenium.helpers.TestResultXmlUtility;
import com.adv.qa.selenium.helpers.WaitHelper;
import com.adv.qa.selenium.helpers.WebDriverEventListenerTest;



/**
 * @version:0.1
 * Used as a parent class in test scripts Loads data which are common for all test scripts from 
 * environment.properties
 *
 */
@Listeners({ReportListeners.class})
public class BaseTest {

	public static String LOG_LINE_SEPARATOR = "   ===================================== ";
	public static final Logger log = LoggerFactory.getLogger(BaseTest.class);
	private  String className = this.getClass().getName();
	private  String testCaseName = this.getClass().getSimpleName();
	protected WebDriver browserDriver = null;
	protected  EventFiringWebDriver driver = null;
	private static Properties properties = new Properties();
	public static boolean useRemoteWebDriver;
	protected String remoteWebDriverUrl= null;
	public static String  adve5URL;
	public static String  browser;
	public static String  database;
	public String companyId="IM";
	static Object startupSync = new Object();
	public static long implicitlyWaitTimeout;
	public static String appendURL = "/app/map.do";
	private static String runTime=null;
	private static String filePath = null;
	
	private PageObjects pObject = new PageObjects();
	
	public List<String> testcases = new ArrayList<String>();
	
	static {
		
		try {
			initializeStaticFields();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize all static fields (except driver) using
	 * environment.properties
	 * @throws IOException 
	 */
	private static void initializeStaticFields() throws IOException {
	
		runTime = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		
		try {
			filePath =MainXMLStructure.getMainXML(runTime);
			
			
		} catch (ParserConfigurationException e) {			
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		
		loadProperties("environment.properties");
		
		useRemoteWebDriver = Boolean.parseBoolean(properties.getProperty("useRemoteWebDriver"));
	
		/*Initiate database*/
		
		database = System.getProperty("database");
		
		if (database == null){
			database = properties.getProperty("database");
		}
		
		log.info("Database : " + database);
	
		/*Initiate e5h5 URL*/
		
		adve5URL = System.getProperty("adve5URL");
		
		if (adve5URL == null){
			
			adve5URL = properties.getProperty("adve5URL");
		}
		log.info("Environment : " + adve5URL);
		
		/*Initiate browser*/
		
		browser = System.getProperty("browser");
		if (browser == null){
			browser = properties.getProperty("browser");
		}
		log.info("browser : " + browser);
		
		
		String timeoutString = properties.getProperty("seleniumImplicityWaitTimeout");
		implicitlyWaitTimeout = Integer.parseInt(timeoutString);
		
	}
	
	
	/**
	 * Load properties from a file and append them to 'properties' field
	 * @param propFileName name of the file with properties
	 */
	private static void loadProperties(String propFileName) {
		try
		{
			InputStream is = BaseTest.class.getClassLoader().getResourceAsStream(propFileName);
			properties.load(is);
			is.close();
		} catch (Exception e)
		{
			log.info("#### Error: Unable to load the \"" + propFileName + "\" file.");
			System.exit(1);
		}
	}
	
	/**
	 * Used in Before methods
	 * Initializes driver
	 * @throws Exception
	 */
	public  void setUp() throws Exception {
		//start logging to test specific log file
	    TestLogHelper.startTestLogging(testCaseName);		
		log.info( "\n =============== SETUP START "+className +LOG_LINE_SEPARATOR);
		
		initialiseWebDriver();	
//		driver.manage().window().maximize();
	
	}
	
	/**
	 * Used in classes that do not inherit from BaseTest
	 * Initialize driver and open e5h5 home page using e5h5URL from data file
	 * @return driver
	 * @throws Exception
	 */
	public WebDriver getDriverInstance() throws Exception {
		initialiseWebDriver();
		return driver;
	}
	
	/**
	 * Initialize driver and open e5h5 home page using e5h5URL from data file
	 * @throws Exception
	 */
	public void initialiseWebDriver() throws Exception{
		initialiseWebDriverWithoutLoadingPage();
		log.info(  "adve5URL  "+adve5URL);
		driver.get(adve5URL+appendURL);
		
		driver.manage().window().maximize();
		Thread.sleep(2500);
	}
	

//	protected void initialiseWebDriver() throws Exception{
//		initialiseWebDriverWithoutLoadingPage();
//		log.info(  "adve5URL  "+adve5URL);
//		driver.get(adve5URL+appendURL);
//		
//		driver.manage().window().maximize();
//		Thread.sleep(2500);
//	}
	
	protected void initialiseWebDriverWithoutLoadingPage() throws Exception {		
			synchronized (startupSync) {
			if (useRemoteWebDriver) {
				remoteWebDriverUrl = properties.getProperty("remoteWebDriverUrl");

				DesiredCapabilities capability = null;
				
				if(browser.equalsIgnoreCase("firefox")){
					capability = DesiredCapabilities.firefox();
			
				}
				
				else if(browser.equalsIgnoreCase("chrome")){
					capability = DesiredCapabilities.chrome();
				}
				
				browserDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), capability);
				driver = new EventFiringWebDriver(browserDriver);
			}
			
			
			/*This is for the normal Machine and Browsers*/
			
			else if(browser.equalsIgnoreCase("firefox".trim())) {			

				System.setProperty("webdriver.gecko.driver","jars/geckodriver.exe");
				
				browserDriver = new FirefoxDriver();
				driver = new EventFiringWebDriver(browserDriver);
	
			}
			
			else if(browser.equalsIgnoreCase("chrome".trim())){
				
				System.setProperty("webdriver.chrome.driver","jars/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("chrome.switches","disable-extensions");
				options.addArguments("--disable-notifications");
				
				/*To disable yellow strip info bar which prompts info messages*/
				options.addArguments("disable-infobars");
				
				browserDriver = new ChromeDriver(options);
				driver = new EventFiringWebDriver(browserDriver);
		
			}
			
			else if (browser.equalsIgnoreCase("internetexplorer".trim()))
			{	

				System.setProperty("webdriver.ie.driver","jars/IEDriverServer.exe");
				browserDriver = new InternetExplorerDriver();
				driver = new EventFiringWebDriver(browserDriver);
		
			}
			
			else if(browser.equalsIgnoreCase("Edge".trim())){
				
				System.setProperty("webdriver.edge.driver","jars/MicrosoftWebDriver.exe");
							
				browserDriver = new EdgeDriver();
				driver = new EventFiringWebDriver(browserDriver);
			
			}
			
			
		}


		driver.register(new WebDriverEventListenerTest(testCaseName));
	
		/* Set timeout for implicit wait */
		driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeout,TimeUnit.SECONDS);
		
		log.info( "\n =============== SETUP FINISH "+className +LOG_LINE_SEPARATOR);

	}
	
	public boolean isAlertPresent(){
		 boolean presentFlag = false;

	      try {
	       Alert alert = driver.switchTo().alert();
	       log.info("--------------------->>>>>>>>>>>>>>>"+alert.getText());
	       presentFlag = true;
	       alert.accept();
	      } catch (NoAlertPresentException ex) {
	       ex.printStackTrace();
	      }

	      return presentFlag;
	}
	
	/**
	 * Close driver instance
	 */
	public void tearDown() {
		synchronized (startupSync) {
			log.info(" \n =============== TEARDOWN START "+className +LOG_LINE_SEPARATOR);			
			
			try {
				TestResultXmlUtility.createXMLFile(testcases,runTime,filePath,testCaseName);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}			
			
			if (driver != null) {
				driver.manage().deleteAllCookies();
				
				try {
					driver.quit();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			driver = null;

			log.info(" \n =============== TEARDOWN FINISH "+className +LOG_LINE_SEPARATOR);
			
		}
		
		
		
	}
	
	/**
	 * Takes a screen shot and writes it to the project root folder
	 * @param prefix the name of screen shot will be started with this prefix
	 * @return File
	 * @throws IOException
	 */
	public File takeScreenshot(String prefix,String key) throws IOException {
		
		File screenshot = File.createTempFile(prefix, ".png", new File("."));
				
		TakesScreenshot screenshoter = null;
		
		BaseTest t = WebDriverManager.retrieveInstance(key);
	
		try {
			if (useRemoteWebDriver) {
				WebDriver augmentedDriver = new Augmenter().augment(t.browserDriver);
				 screenshoter = (TakesScreenshot) augmentedDriver;
			} else {
				 screenshoter = (TakesScreenshot) t.browserDriver;
			};
			
				
			FileUtils.copyFile(screenshoter.getScreenshotAs(OutputType.FILE), screenshot);
			} 
		catch (Exception e)	{
			driver.register(new WebDriverEventListenerTest(testCaseName));
			
			/* Cannot take a screen shot */
			String errorMessage = e.getMessage();
			if(errorMessage != null){
				
				log.info("Cannot take a screenshot: " + errorMessage);	
			}
		}
		return screenshot;
	}
	
	
		/**
	 * Click on Cancel button
	 */
	
	public void clickOnCancel(){
		WaitHelper.waitAdditional(2);
		driver.findElement(By.xpath(pObject.AllPG_CANCEL)).click();
		WaitHelper.waitAdditional(1);
	}

	
	/**
	 * Logout from the application
	 * @throws InterruptedException
	 */
	public void logOut() throws InterruptedException{
		clickOnCancel();
		clickOnCancel();	
		driver.findElement(By.id(pObject.TWO+pObject._ZERO)).click();
		WaitHelper.waitAdditional(4);
	}
	
	public static String getCurreentDate(){
		return new SimpleDateFormat("dd/MM/YYYY hh:mm:ss").format(new Date());
	}
	


	
}

