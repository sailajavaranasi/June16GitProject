package selenium;

import org.apache.log4j.Logger;

public class TC_002 extends BaseTest
{
	
	private static final Logger log = Logger.getLogger(TC_002.class);
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("init the properties files...");
		
		launch("chromebrowser");
		log.info("Opened the Browser : " +  p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url : " + childProp.getProperty("amazonurl"));
		
		selectOption("amazondropbox_id","Books");
		log.info("Selected the option Books By using Locator : " +orProp.getProperty("amazondropbox_id") );
		
		typeText("amazonsearchtext_name","Harry Potter");
		log.info("Entered the text Harry Potter By using the Locator : " + orProp.getProperty("amazonsearchtext_name"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on Element By Using Locator : " + orProp.getProperty("amazonsearchbutton_xpath"));
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
	}

	

}
