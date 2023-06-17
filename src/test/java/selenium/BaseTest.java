package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String ProjectRootPath = System.getProperty("user.dir")+"/src/test/resources";
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainProp;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String filePath;
	
	static
	{
		Date dt = new Date();
		filePath = dt.toString().replace(':', '_').replace(' ','_');
	}
	
	public static void init() throws Exception
	{
		System.out.println(System.getProperty("user.dir"));
		//FileInputStream fis = new FileInputStream("D:\\April2022WD\\March2023_6AM_SeleniumBatch\\src\\test\\resources\\data.properties");
		fis = new FileInputStream(ProjectRootPath+"/data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(ProjectRootPath+"/environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(ProjectRootPath+"/"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		System.out.println(childProp.getProperty("amazonurl"));
		
		fis = new FileInputStream(ProjectRootPath+"/or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(ProjectRootPath+"/log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
	}
	
	public static void launch(String browser)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		//driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	public static void clickElement(String locatorKey) 
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.name(orProp.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		getElement(locatorKey).sendKeys(option);
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for Element Present
		if(!isElementPresent(locatorKey))
			//report as failure
			System.out.println("Element is not present : " + locatorKey);
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}*/
		
		return element;
	}
	
	public static boolean isElementPresent(String locatorKey)
	{
		System.out.println("Checking for Eelemnt Presence : " + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		/*if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_classname")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_linktext")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(orProp.getProperty(locatorKey))));
		}*/
		
		
		return true;
	}
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
	
	// Verifications 
	public static boolean isLinksEqual(String expectedLink) 
	{
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		if(actualLink.equals(expectedLink))
			return true;
		else
			return false;
	}
	
	//Reportings
	public static void reportSuccess(String successMessage) 
	{
		test.log(Status.PASS, successMessage);
	}

	public static void reportFailure(String failureMessage) throws Exception 
	{
		test.log(Status.FAIL, failureMessage);
		takesScreenshot();
	}

	public static void takesScreenshot() throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO,"Screenshot --->" +test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
	}
}
