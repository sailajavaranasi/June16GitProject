package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import selenium.BaseTest;

public class TestNG_003 extends BaseTest
{
	@Parameters("browser")
  @BeforeMethod(groups = {"regression"})
  public void startProcess(String bType) throws Exception 
  {
	  System.out.println("BeforeMethod");
	    init();
		test = report.createTest("TestNG_003");
		test.log(Status.INFO, "init the properties files...");
		
		launch(bType);
		test.log(Status.PASS, "Opened the Browser : " +  bType);
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigated to url : " + childProp.getProperty("amazonurl"));
  }
  
  @Test(groups = {"regression"})
  public void amazonText() 
  {
	  System.out.println("amazonText");
	    selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selected the option Books By using Locator : " +orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry Potter By using the Locator : " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
  }

  @AfterMethod(groups = {"regression"})
  public void endProcess() 
  {
	  System.out.println("AfterMethod");
	  report.flush();
	  driver.quit();
  }

}
