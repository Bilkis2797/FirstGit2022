package VariousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException{
		
		launchBrowser();
		LoginTest();
		tearDown();
		
		launchBrowser();
		negLoginTest();
		tearDown();
		
		
	}
	
	  public static void launchBrowser() {
			
//			System.setProperty("webdriver.chrome.driver", "C:\\Users\\chumk\\eclipse-Selenium\\crm\\driver\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			
			driver = new ChromeDriver();
			
			//clear cashe
			driver.manage().deleteAllCookies();
			//go to website
			driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
			//maximize
			driver.manage().window().maximize();
	  }
	
	  public static void LoginTest() {
		   
		   driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc123");
			driver.findElement(By.name("login")).click();
	}
	  
	  public static void negLoginTest() {
		   
		   driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			driver.findElement(By.id("password")).sendKeys("abc1234");
			driver.findElement(By.name("login")).click();
	}
	  
	  public static void tearDown() throws InterruptedException{
		 Thread.sleep(7000);
		  driver.close();
			driver.quit();
	  }
}
