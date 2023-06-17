package webdriverScreenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy3 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		String link = driver.findElement(By.linkText("Customer Service")).getText();
		System.out.println(link);
		
		/*List<WebElement> link1 = driver.findElements(By.tagName("a"));
		for(int i=0;i<link1.size();i++)
		{
			if(!link1.get(i).getText().isEmpty())
			 System.out.println(link1.get(i).getText());
		}*/
		
		List<WebElement> link2 = driver.findElements(By.xpath("//div[@id='nav-xshop']//child::a"));
		for(int i=0;i<link2.size();i++)
		{
			System.out.println(link2.get(i).getText());
		}
		
	}

}
