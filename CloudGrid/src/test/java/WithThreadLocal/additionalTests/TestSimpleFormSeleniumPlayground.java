package WithThreadLocal.additionalTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import WithThreadLocal.BaseTest;

public class TestSimpleFormSeleniumPlayground extends BaseTest
{	
	@Test
	public void testSimpleDemoForm() 
	{
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Navigating to TestSimpleDemoForm website");
		getDriver().get("https://www.lambdatest.com/selenium-playground/");
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Clicking on SimpleDemoForm link");
		getDriver().findElement(By.xpath("//*[text()='Simple Form Demo']")).click();
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Entering message");
		getDriver().findElement(By.id("user-message")).sendKeys("LambdaTest");
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Clicking on Get value button");
		getDriver().findElement(By.id("showInput")).click();
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Fetch the message and print it");
		String message = getDriver().findElement(By.id("message")).getText();
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Final message = " + message);
	}	

}
