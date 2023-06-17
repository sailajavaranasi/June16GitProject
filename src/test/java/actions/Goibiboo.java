package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibiboo 
{
	public static void main(String[] args) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.goibibo.com/flights/");

	
	
	driver.manage().window().maximize();
	driver.navigate().refresh();

	//driver.findElement(By.cssSelector("body[class='desktop']>div>div>div>div>div>div>div>p>span")).click();
	driver.findElement(By.cssSelector("body[class='desktop'] span[class='sc-iwjdpV jUsACy fswDownArrow']")).click();

	for(int i=1;i<=4;i++)
	{
	driver.findElement(By.cssSelector("div[class='DayPicker-NavBar']>span[class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	}
	//driver.findElement(By.cssSelector("body[class='desktop'] div[class='DayPicker-Month']:last-child div[class='DayPicker-Body'] div[class='DayPicker-Week']:nth-child(3)>div:nth-child(3)")).click();
	driver.findElement(By.cssSelector("body[class='desktop'] div[class='DayPicker-Month']:last-child div[class='DayPicker-Week']:nth-child(3) div[class='DayPicker-Day']:nth-child(3)")).click();
	//driver.close();
	}
	
	
	
	
	/*String month1 = driver.findElements(By.cssSelector("div[class=\"DayPicker-Months\"]>div>div[class=\"DayPicker-Caption\"]>div")).get(0).getText();
	System.out.println(month1);

	String month2 = driver.findElements(By.cssSelector("div[class=\"DayPicker-Months\"]>div>div[class=\"DayPicker-Caption\"]>div")).get(1).getText();

	System.out.println(month1 + " " + month2);

	if(!(month1.contains("August") || month2.contains("August")))
	{
	//driver.findElement(By.cssSelector("span.DayPicker-NavButton.DayPicker-NavButton--next")).click();
	driver.findElement(By.cssSelector("span[aria-label=\"Next Month\"]")).click();

	}*/


}
