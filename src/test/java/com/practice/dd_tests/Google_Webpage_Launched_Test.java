package com.practice.dd_tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.dd_Core.TestCore;
import com.practice.dd_Util.testUtil;

public class Google_Webpage_Launched_Test  extends TestCore {
	
	
	@BeforeTest
	   public void isSkip()
	  {
		 if(!testUtil.isExecutable("Google_Webpage_Launched_Test"))
		    {
			   throw new SkipException("Skipping testcase as runmode is set to No");
		    }
		}
	
	
	
	@Test(dataProvider="getData")
	public void doLogin(String email,String pass) throws IOException 
	{
		try {
		//Click on the Sign in button
		app_logs.debug("Click on the Sign in button");
		driver.findElement(By.xpath(object.getProperty("Sign_in_button"))).click();
		
		
		//Enter the user name
		Thread.sleep(2000);
		app_logs.debug("Enter the user name");
		driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(email);
		Thread.sleep(2000);
				   	   
		//Click on the next button
		app_logs.debug("Click on the next button");
		driver.findElement(By.xpath(object.getProperty("next_button"))).click();
		Thread.sleep(40000);
		
		//Enter the user password
		app_logs.debug("Enter the user password");
		driver.findElement(By.xpath(object.getProperty("userpassword"))).sendKeys(pass);
				
		//Back to Home page
		Thread.sleep(2000);
		app_logs.debug("Back to Home page");
	    driver.navigate().to(config.getProperty("testsite"));
				   	     	     
		//Google search box text field xpath
	    Thread.sleep(2000);
	    app_logs.debug("Google search box text field xpath");
		driver.findElement(By.xpath(object.getProperty("search_box_text_field"))).sendKeys("Best Movie");
			          
	    //Google search button xpath 
		app_logs.debug("Google search button xpath");
	    driver.findElement(By.xpath(object.getProperty("search_button"))).click();
			
	    //Back to Home page
	    app_logs.debug("Back to Home page");
		driver.navigate().back();
	    Thread.sleep(2000);
			   		
	    //I am feeeling lucky Xpath
	    app_logs.debug("I am feeeling lucky Xpath");
	    driver.findElement(By.xpath(object.getProperty("I_am_feeeling_lucky_button"))).click();
	   
	   //feeeling lucky page down
	   Thread.sleep(2000);
	   app_logs.debug("feeeling lucky page down");
	   driver.findElement(By.xpath(object.getProperty("feeling_lucky_page_down"))).sendKeys(Keys.PAGE_DOWN);
			   	  
	   //feeeling lucky page up
	    Thread.sleep(2000);
	    app_logs.debug("feeeling lucky page up");
	    driver.findElement(By.xpath(object.getProperty("feeling_lucky_page_Up"))).sendKeys(Keys.PAGE_UP);
	    
	   //Back to Home page
	    Thread.sleep(2000);
	    app_logs.debug("Back to Home page");
		driver.navigate().back();
		
	}catch(Throwable t)
		{
		 testUtil.captureScreenshot("Google_Webpage_Launched_Test");
		  Assert.assertTrue(false, t.getMessage());
		}
	}
	
	
	@DataProvider
	public static Object[][] getData()
	{
		 return testUtil.getData("Google_Webpage_Launched_Test");
	}
		
	
	

}
