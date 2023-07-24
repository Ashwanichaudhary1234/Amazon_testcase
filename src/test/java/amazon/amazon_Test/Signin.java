package amazon.amazon_Test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import amazon.amazon_Pages.Loginpage;
import amazon.amazon_testbase.testbase;


	@Test
	public class Signin extends testbase
	{
		Loginpage LP;
		String actual_title;
		static ExtentTest test;
		static ExtentReports report;
		
		@AfterSuite
		public void stop() throws IOException 
		{
			terminate();
		}
		@BeforeTest
		public static void startTest(){
			report = new ExtentReports("C:\\Users\\achaudhary\\.jenkins\\workspace\\Amazon\\report.html",true);
			test = report.startTest("amazon");
		}
		@AfterTest
		public static void endTest() {
			report.endTest(test);
			report.flush();
		}
		@BeforeSuite
		public void Launch() throws Exception 
		{
			initialization();
			LP = new Loginpage();
		}
		@Test(priority = 1)
        public void Signin1() throws InterruptedException 
		{
	    test=report.startTest("User able to sign in or not");
	    test.log(LogStatus.INFO, "User able to sign");
		LP.signin_element().click();
		LP.Email_element().sendKeys("6397372561");;
		LP.Continue_element().click();
		LP.password_element().sendKeys("Ashwani@123");
		LP.Continue_element().click();
		Thread.sleep(20000);
		String actual= driver.getCurrentUrl();
		String expected="https://www.amazon.in/?ref_=nav_ya_signin";
		
		if(actual.equals(expected))
		{
			test.log(LogStatus.PASS, "user able to successfully sign in");
		}
		else
		{
			test.log(LogStatus.PASS, "user is not able to successfully sign in");

		}
		//Assert.assertEquals(actual, expected);
		}
		
	@Test(priority = 2)
     public void deliver() throws InterruptedException 
	{
	   test=report.startTest("functionality of delivery and address button");
	    test.log(LogStatus.INFO, "User able to click on dlivery and address button");

       LP.deliver_element().click();
       LP.Address_element().click();
	   Assert.assertEquals(LP.deliver_element().isDisplayed(), true);
	   Thread.sleep(1000);
	   driver.navigate().refresh();
	   String actual= driver.getCurrentUrl();
		String expected="https://www.amazon.in/?ref_=nav_ya_signin&";
		
		if(actual.equals(expected))
		{
			test.log(LogStatus.PASS, " delivery and address button is clickable ");
		}
		else
		{
			test.log(LogStatus.PASS, " delivery and address button is not clickable");

		}
		Assert.assertEquals(actual, expected);
		}
	
		
		@Test(priority = 3,dependsOnMethods="Signin1")
        public void Orders() 
		{
		test=report.startTest("Verify the functionality of orders and history");
	    test.log(LogStatus.INFO, "User able to click on orders and history");
		LP.Orders_element().click();
		LP.history_element().click();
		LP.past_element().click();
		   String actual= driver.getCurrentUrl();
		   String expected = "https://www.amazon.in/gp/your-account/order-history?orderFilter=year-2023&ref_=ppx_yo2ov_dt_b_filter_all_y2023";
		   if(actual.equals(expected))
			{
				test.log(LogStatus.PASS, " Order history is visible to user");
			}
			else
			{
				test.log(LogStatus.PASS, " Order history is not visible to user");

			}
			Assert.assertEquals(actual, expected);
			driver.navigate().back();
			}
		
	
		
		 }
	
//		
//		@Test(priority = 4)
//        public void Order1() throws InterruptedException 
//		{
//	    LP.all_element().click();
//	    Thread.sleep(2000);
//		LP.youraccount_element().click();
//	    Thread.sleep(2000);
//		Actions a = new Actions(driver);
//		a.sendKeys(Keys.PAGE_DOWN).build().perform();
//		a.sendKeys(Keys.PAGE_UP).build().perform();	
//	    Thread.sleep(2000);
//        driver.navigate().back();
//		 }
//		
//		
//		@Test(priority = 5)
//        public void Order2() throws InterruptedException 
//		{
//		Thread.sleep(2000);
//	    LP.all_element().click();
//	    Thread.sleep(2000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", LP.services_element());
//	    Thread.sleep(2000);
//        driver.navigate().back();
//		 }
//		@Test(priority = 6)
//        public void Order3() throws InterruptedException 
//		{
//		LP.all_element().click();
//	    Thread.sleep(2000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", LP.signout_element());
//		Thread.sleep(2000);	
//		}
//		
//	
//		
	
 //}

