package com.practice.Rough;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment__1 {

/*	
	1.  To verify that the Google web page is launched successfully

*/
   public static void main(String[] args) throws InterruptedException {
	   
	//Launch the browser
    System.getProperty("webdriver.chrome.driver", "D:\\Selenium_Drivers\\.chromedriver.exe");	
    WebDriver driver=new ChromeDriver();
		  		  
    //navigate google webpage
    driver.get("https://www.google.com/");
	driver.manage().window().maximize();
		   
	//Click on the Sign in button
	driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a/span")).click();
	
	//Enter the user name
	driver.findElement(By.xpath("//*[@autocomplete='username']")).sendKeys("nehaalaspure3@gmail.com");
	Thread.sleep(4000);
			   	   
	//Click on the next button
	driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
	Thread.sleep(6000);
	
	//Enter the user password
	WebElement Password=driver.findElement(By.xpath("//*[@name='Passwd']"));
	Password.sendKeys("Neha_135");
			
	//Back to Home page
	Thread.sleep(2000);
    driver.navigate().to("https://www.google.com/");
			   	     	     
	//Google search box text field xpath
    Thread.sleep(2000);
	WebElement Search1 = driver.findElement(By.xpath("//*[@id='APjFqb']"));
    Search1.sendKeys("Best Movie");
		          
    //Google search button xpath 
    WebElement Search2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
    Search2.click();
		
    //Back to Home page
	driver.navigate().back();
    Thread.sleep(2000);
		   		
    //I am feeeling lucky Xpath
    WebElement Search3 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]"));
    Search3.click();
   
   //feeeling lucky page down
   Thread.sleep(2000);
   driver.findElement(By.xpath("//*[@id='about-link']")).sendKeys(Keys.PAGE_DOWN);
		   	  
   //feeeling lucky page up
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='about-link']")).sendKeys(Keys.PAGE_UP);
    
   //Back to Home page
    Thread.sleep(2000);
	driver.navigate().back();
		  
	//It terminates the program
    driver.close();
		   	    
		   	     
		
		  
		  
	
		  
	}

}
