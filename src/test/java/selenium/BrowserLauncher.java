package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ravi\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		
		//webdriver.chrome.driver
		//webdriver.gecko.driver
		//webdriver.iedriver.driver
		//webdriver.edge.driver
		
	}
}
