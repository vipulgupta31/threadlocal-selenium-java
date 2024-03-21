package WithThreadLocal.advanced-scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import WithThreadLocal.BaseTest;

public class TestOrderFlowEcommercePlayground extends BaseTest
{
	@Test
	public void testOrderFlow() 
	{
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Navigating to LambdaTest Ecommerce website");
		getDriver().get("https://ecommerce-playground.lambdatest.io/");
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Entering search data");
		getDriver().findElement(By.name("search")).sendKeys("iphone");
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Clicking search button");
		getDriver().findElement(By.xpath("//*[text()='Search']")).click();
		
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Fetch the price of first item and print it");
		String price = getDriver().findElement(By.xpath("(//*[@class='price-new'])[1]")).getText();
		System.out.println("Thread id " + Thread.currentThread().getId() + " : Final message = " + price);

		status = "passed";
	}	
}
