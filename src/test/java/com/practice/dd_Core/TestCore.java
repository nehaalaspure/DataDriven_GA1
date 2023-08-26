package com.practice.dd_Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.practice.dd_Util.ExcelReader;
import com.practice.dd_Util.TestConfig;
import com.practice.dd_Util.monitoringMail;
import com.practice.dd_Util.testUtil;


public class TestCore {
	
	
	public static Properties config =new Properties();
	public static Properties object =new Properties();
	public static FileInputStream fis;
	public static WebDriver driver=null;
	public static ExcelReader excel=null;
	public static Logger app_logs=Logger.getLogger("devpinoyLogger");

	
	@BeforeSuite
	public void init() throws IOException, InterruptedException
	{
		if (driver==null)
		{
		   //loading config prpoerty file                            
		   fis=new	FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\practice\\dd_properties\\configuration.properties");
		   config.load(fis);
		   app_logs.debug("loading config property file");
			 
		   
		   //loading object prpoerty file
		   fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\practice\\dd_properties\\objects.properties");
		   object.load(fis);
		   app_logs.debug("loading object property file");
		   
		   
           //Loading Excel file
		   excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\java\\com\\practice\\dd_properties\\Data_Assig1.xlsx");
		   app_logs.debug("Loading Excel file");
		
		   Thread.sleep(3000);
		 if(config.getProperty("browser").equals("chrome"))
	     {
		  	System.getProperty("webdriver.chrome.driver", "D:\\Selenium_Drivers\\chromedriver.exe");	
			driver=new ChromeDriver();
			ChromeOptions options=new ChromeOptions();
			
			options.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(options);
				
	     }else 
	    if(config.getProperty("browser").equals("firefox"))
	      {
	       System.getProperty("webdriver.gecko.driver", "F:\\GeckoDriver\\geckodriver.exe");	
	       driver=new FirefoxDriver();	
	        	
	       
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
		 driver.get(config.getProperty("testsite"));
		 driver.manage().window().maximize();
		 
	       }
	    }
	}	
	
	@AfterSuite
	 public void QuitDriver() throws InterruptedException, AddressException, MessagingException{
	 Thread.sleep(3000);
	 if (driver!=null)
	 driver.close();
	app_logs.debug("Zipping screenshot folder");
	testUtil.zip(System.getProperty("user.dir")+"\\screenshot");
	
	app_logs.debug("zip report sucessfully");
	monitoringMail mail=new monitoringMail();
	mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	app_logs.debug("mail send sucessfully");

	
	
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

