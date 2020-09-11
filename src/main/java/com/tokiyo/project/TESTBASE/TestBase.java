//PACKAGE
package com.tokiyo.project.TESTBASE; 
//*****************************************************************

//IMPORTED PACKAGES
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tokiyo.project.UTIL.TestUtil;

//*****************************************************************


//TESTBASE CLASS to define commonly used methods()

public class TestBase {
	public static WebDriver driver;//driver global object reference variable
	public static Properties prop;//prop global object reference variable
	public static EventFiringWebDriver eventFiringWebDriver;//eventFiringWebDriver global object reference variable
	public static ExtentTest test;
	public static ExtentReports report;
	public static Robot robot;
	
	public TestBase()//constructor
	{
		

			try {
				prop = new Properties();//create object of Properties Class & assign it prop global object reference variable
		
				//create object of FileInputStream Class to read data from configuration File
			
		
				//FileInputStream fis = new FileInputStream("E:\\SVN-V3-automation\\Automation\\src\\main\\java\\com\\qa\\vidalhealth\\Configuration\\config.properties");
				FileInputStream fis = new FileInputStream("E:\\TokyoProject\\TokiyoProject\\src\\main\\java\\com\\tokiyo\\project\\CONFIGURATION\\config.properties");
				
				System.out.println(fis);

				prop.load(fis);//load(read) data using FileInputStream object reference into 
							   //Properties object reference using load() method
		
				}catch(FileNotFoundException e) {
					e.printStackTrace();
						}
					catch(IOException  e) {
							e.printStackTrace();
						}
			
	}
		
	@BeforeMethod
	public static void initialization() {

		String browserName = prop.getProperty("browser");//get browser from configuration File
		
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver","E:\\SVN-V3-automation\\Automation\\Driverserver\\chromedriver.exe");
	    driver = new ChromeDriver();	
		}
	    
	    else if(browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver","E:\\SVN-V3-automation\\Automation\\Driverserver"
				+ "\\geckodriver.exe");
	    driver = new FirefoxDriver();  
	    }
		
	    else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver","E:\\SVN-V3-automation\\Automation\\Driverserver\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		    
		    }
	 
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    String url=prop.getProperty("url");
	    driver.get(url);   

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

	}
	
	


