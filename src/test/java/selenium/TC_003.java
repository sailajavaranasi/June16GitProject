package selenium;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.Status;

public class TC_003 extends BaseTest
{
	
		
	public static void main(String[] args) throws Exception 
	{
		init();
		test = report.createTest("TC_003");
		test.log(Status.INFO, "init the properties files...");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Opened the Browser : " +  p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigated to url : " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		test.log(Status.FAIL, "Selected the option Books By using Locator : " +orProp.getProperty("amazondropbox_id"));
		
		typeText("amazonsearchtext_name","Harry Potter");
		test.log(Status.INFO, "Entered the text Harry Potter By using the Locator : " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(Status.INFO, "Clicked on Element By Using Locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
		
		report.flush();
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
	}

	

}
