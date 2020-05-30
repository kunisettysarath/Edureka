import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Assignment2 {
    static WebDriver wb = null;


    @BeforeMethod
    public void beforeMethod(){
        wb = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        wb.manage().window().maximize();
        wb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wb.get("http://newtours.demoaut.com/");
        
    }
    
    @Test
    public void testcaseOne() {
    	wb.findElement(By.cssSelector("input[name=\"userName\"]")).sendKeys("mercury");
    	wb.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("mercury");
    	wb.findElement(By.cssSelector("input[name=\"login\"]")).click();
    	WebElement elem = wb.findElement(By.xpath("//*[@name=\"fromPort\"]"));
    	waitForElem(elem);
    	wb.findElement(By.xpath("//*[@name=\"findFlights\"]")).click();
    	elem = wb.findElement(By.xpath("(//*[contains(@value,\"Unified Airlines\")])[1]"));
    	waitForElem(elem);
    	elem.click();
    	wb.findElement(By.xpath("(//*[contains(@value,\"Unified Airlines\")])[1]")).click();
    	wb.findElement(By.xpath("//*[@name=\"reserveFlights\"]")).click();
    	waitForElem(wb.findElement(By.xpath("//*[text()='FLIGHT']")));
    	wb.findElement(By.cssSelector("input[name=\"passFirst0\"]")).sendKeys("firstName");
    	wb.findElement(By.cssSelector("input[name=\"passLast0\"]")).sendKeys("lastName");
    	wb.findElement(By.cssSelector("input[name=\"creditnumber\"]")).sendKeys("12345678910036");
    	Select s = new Select(wb.findElement(By.cssSelector("[name=\"cc_exp_dt_mn\"]")));
    	s.selectByIndex(5);
    	s = new Select(wb.findElement(By.cssSelector("[name=\"cc_exp_dt_yr\"]")));
    	s.selectByIndex(8);
     	wb.findElement(By.cssSelector("input[name=\"cc_frst_name\"]")).sendKeys("firstName");
     	wb.findElement(By.cssSelector("input[name=\"cc_last_name\"]")).sendKeys("lastName");
    	wb.findElement(By.cssSelector("input[name=\"buyFlights\"]")).click();
    	elem = wb.findElement(By.xpath("//*[contains(text(),\"Confirmation #\")]"));
    	waitForElem(elem);
    	Assert.assertTrue(elem.isDisplayed());
    }
    
    @Test
    public void testcaseTwo() {
    	wb.findElement(By.cssSelector("input[name=\"userName\"]")).sendKeys("mercury");
    	wb.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys("mercury");
    	wb.findElement(By.cssSelector("input[name=\"login\"]")).click();
    	WebElement elem = wb.findElement(By.xpath("//*[text()='PROFILE']"));
    	waitForElem(elem);
    	Assert.assertTrue(elem.isDisplayed());
    }
    
    public static void waitForElem(WebElement element){
        WebDriverWait wait = new WebDriverWait(wb,30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    @AfterMethod
    public void afterMethod(){
        wb.quit();
    }

}
