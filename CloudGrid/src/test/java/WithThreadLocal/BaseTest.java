package WithThreadLocal;

import java.net.*;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {

	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	String username = System.getenv("LT_USERNAME") == null ? "<lambdatest_username>" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "<lambdatest_accesskey>" : System.getenv("LT_ACCESS");

	@BeforeClass
	public void setDriver() 
	{
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("121.0");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("build", "RemoteWebDriver with ThreadLocal");
			ltOptions.put("project", "RemoteWebDriver with ThreadLocal");
			chromeOptions.setCapability("LT:Options", ltOptions);

			driver.set(new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("Browser setup by Thread : " + Thread.currentThread().getId() + " and Driver reference is : "
				+ getDriver());
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
				+ " and Closing driver reference is :" + getDriver());
		driver.get().close();
		driver.remove();
	}
}
