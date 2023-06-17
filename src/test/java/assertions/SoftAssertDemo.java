package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertDemo 
{

	public static void main(String[] args) 
	{
		ChromeOptions option  = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		String expectedlink = "Customer Serv";
		String actuallink =driver.findElement(By.linkText("Customer Service")).getText();
		
		SoftAssert soft = new SoftAssert();
		//soft.assertEquals(actuallink, expectedlink);
		soft.assertTrue(actuallink.equals(expectedlink), "Both links are not equal..");
		
		soft.assertTrue(false, "err1");
		
		soft.assertTrue(false, "err2");
		
		soft.assertTrue(true, "err3");
		
		soft.assertTrue(false, "err4");
		
		driver.findElement(By.linkText("Customer Service")).click();
		
		soft.assertAll();
	}

}
