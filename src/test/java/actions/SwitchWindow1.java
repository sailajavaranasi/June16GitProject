package actions;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow1 
{

	public static void main(String[] args) 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        option.addArguments("--remote-allow-origins=*");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		String singleWind = driver.getWindowHandle();
		System.out.println(singleWind);
		
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
		
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> nwinds = new ArrayList<String>(windows);
		for(String i:nwinds)
		{
			System.out.println(i);
		}
		
		driver.switchTo().window(nwinds.get(0));
		System.out.println(driver.getTitle());
		
	}

}
