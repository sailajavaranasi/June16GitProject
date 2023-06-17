package excelOperation;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class FaceBookFinalProgram 
{
  @Test(dataProvider = "getData")
  public void facebook(Hashtable<String, String> obj) 
  {
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("--remote-allow-origins=*");
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver(option);
	  driver.manage().window().maximize();
	  driver.get("https://www.facebook.com");
	  
	  if(obj.get("RunMode").equals("N"))
		  throw new  SkipException("testcase is skipped due to Runmode set as N");
	  driver.findElement(By.id("email")).sendKeys(obj.get("UserName"));
	  driver.findElement(By.id("pass")).sendKeys(obj.get("UserPassword"));
		  
  }

  @DataProvider
  public Object[][] getData() throws Exception 
  {
	  	ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\suitex.xlsx");
		String sheetName = "data";
		String testName = "LoginTest";
		return DataUtil.getTestData(e, sheetName, testName);
  }
}
