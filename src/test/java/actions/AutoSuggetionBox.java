package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggetionBox 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hadoop Tutorial");
		String val = driver.findElement(By.name("q")).getAttribute("value");
		
		//(//ul[@jsname='bw4e9b'])[1]/li/div/div[2]/div/div[1]/span
		//(//ul[@jsname='bw4e9b'])[1]/li//following::div[2]/div[@class='wM6W7d']/span
		
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@jsname='bw4e9b'])[1]/li/div/div[2]/div/div[1]/span"));
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getText().equalsIgnoreCase(val))
			{
				list.get(i).click();
				return;
			}
		}
	}

}
