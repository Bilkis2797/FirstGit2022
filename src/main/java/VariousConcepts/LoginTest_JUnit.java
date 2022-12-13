package VariousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest_JUnit {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}

	@Before
	public void launchBrowser() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		// clear cashe
		driver.manage().deleteAllCookies();
		// go to website
		driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
		//implicitly waits
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize
		driver.manage().window().maximize();
	}

	@Test
	public void LoginTest() {
		System.out.println("Login Test");
		// driver.findElement(By.id("username1")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}

	@Test
	public void negLoginTest() {
		System.out.println("Neg Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();
	}

	@After
	public void tearDown() throws InterruptedException {
		System.out.println("After");
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
