import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 {
	static WebDriver wb = null;

	@BeforeMethod
	public void beforeMethod() {
		wb = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		wb.manage().window().maximize();
		wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void fbNegativeTwo() {
		wb.get("https://www.facebook.com/");
		wb.findElement(By.id("u_0_m")).sendKeys("firstName");
		wb.findElement(By.id("u_0_r")).sendKeys("userName@gmail.com");
		wb.findElement(By.id("u_0_u")).sendKeys("userName@gmail.com");
		wb.findElement(By.id("u_0_w")).sendKeys("password123@1");
		wb.findElement(By.xpath("//*[text()='Female']")).click();
		wb.findElement(By.id("u_0_13")).click();
		WebElement elem = wb
				.findElement(By.xpath("//*[@id=\"u_0_n\"]//*[@class=\"_5dbc img sp_UQETc8Y6QpO sx_ad93cf\"]"));
		wb.findElement(By.id("u_0_m")).click();
		waitForElem(elem);
		Assert.assertTrue(elem.isDisplayed());
	}

	@Test
	public void fbNegativeOne() {
		wb.get("https://www.facebook.com/");
		wb.findElement(By.id("u_0_o")).sendKeys("lastName");
		wb.findElement(By.id("u_0_r")).sendKeys("userName@gmail.com");
		wb.findElement(By.id("u_0_u")).sendKeys("userName@gmail.com");
		wb.findElement(By.id("u_0_w")).sendKeys("password123@1");
		wb.findElement(By.xpath("//*[text()='Female']")).click();
		wb.findElement(By.id("u_0_13")).click();
		WebElement elem = wb
				.findElement(By.xpath("//*[@id=\"u_0_m\"]/../../*[@class=\"_5dbc img sp_UQETc8Y6QpO sx_ad93cf\"]"));
		wb.findElement(By.id("u_0_o")).click();
		waitForElem(elem);
		Assert.assertTrue(elem.isDisplayed());
	}

	@Test
	public void linkedInOne() {
		wb.get("https://www.linkedin.com/");
		wb.findElement(By.cssSelector("a[class=\"nav__button-secondary\"]")).click();
		waitForElem(wb.findElement(By.xpath("//*[text()='Welcome Back']")));
		wb.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		Assert.assertTrue(
				wb.findElement(By.xpath("//*[text()='Please enter an email address or phone number']")).isDisplayed());
	}

	@Test
	public void linkedInTwo() {
		wb.get("https://www.linkedin.com/");
		wb.findElement(By.cssSelector("a[class=\"nav__button-secondary\"]")).click();
		waitForElem(wb.findElement(By.xpath("//*[text()='Welcome Back']")));
		wb.findElement(By.id("username")).sendKeys("username@gmail.com");
		wb.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		Assert.assertTrue(wb.findElement(By.xpath("//*[text()='Please enter a password.']")).isDisplayed());
	}
	
	@Test
	public void newToursOne() {
		wb.get("http://newtours.demoaut.com/");
		wb.findElement(By.cssSelector("input[name=\"userName\"]")).sendKeys("123132!!@@");
		wb.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("021@12213");
		wb.findElement(By.cssSelector("input[name=\"login\"]")).click();
		try {
			wb.findElement(By.xpath("//*[text()='PROFILE']")).isDisplayed();
		} catch (Exception e) {
			System.out.println("element not displayed");
			// TODO: handle exception
		}
	}

	@Test
	public void newToursTwo() {
		wb.get("http://newtours.demoaut.com/");
		wb.findElement(By.cssSelector("input[name=\"userName\"]")).sendKeys("");
		wb.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("");
		wb.findElement(By.cssSelector("input[name=\"login\"]")).click();
		try {
			wb.findElement(By.xpath("//*[text()='PROFILE']")).isDisplayed();
		} catch (Exception e) {
			 System.out.println("element not displayed");
		}
	}
	
	public static void waitForElem(WebElement element) {
		WebDriverWait wait = new WebDriverWait(wb, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElemInteraction(WebElement element) {
		WebDriverWait wait = new WebDriverWait(wb, 30);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	@AfterMethod
	public void afterMethod() {
		wb.quit();
	}

}
