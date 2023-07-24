package amazon.amazon_Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import amazon.amazon_Pages.Loginpage;
import amazon.amazon_testbase.testbase;
public class digitalcontent extends testbase {
	
		Loginpage LP;
		@BeforeSuite
		public void Launch() throws Exception  
		{
			initialization();
			LP = new Loginpage();
		}
	       @AfterSuite
	        public void stop() throws IOException 
	       {
		      terminate();
	          }
	 
	
         @Test(priority = 1)
        public void digitalcontent_element() throws InterruptedException
        {
        	LP.all_element().click();
        	Thread.sleep(2000);
        	LP.alexa_element().click();
        	Thread.sleep(2000);
        	LP.newecho_element().click();
        	Thread.sleep(3000);
        	JavascriptExecutor js =(JavascriptExecutor) driver;
    	    js.executeScript("window.scrollBy(500,50000); ");
    	    Thread.sleep(3000);
    	    LP.backtotop_element().click();
    	    Thread.sleep(3000);

        }
         @Test(priority = 2)
         public void share_element() throws InterruptedException
         {   Thread.sleep(3000);
        	 LP.share_element().click();
        	 Thread.sleep(3000);
        	 LP.copylink_element().click();
        	 Thread.sleep(3000);

        	 LP.Iconsearchbox_element().sendKeys("https://amzn.eu/d/ebCJdkN");
        	 Thread.sleep(3000);
             LP.searchIcon_element().click();
        	 Thread.sleep(3000);

         }
         @Test(priority = 3)
         public void result_element() throws InterruptedException
         {   Thread.sleep(3000);
        	 LP.result_element().click();
        	 Thread.sleep(3000);
        	 LP.seemore_element().click();
        	 Thread.sleep(3000);
        	 LP.seeless_element().click();
         }
}

