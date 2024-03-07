package WithoutThreadLocal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {
	
	public static RemoteWebDriver driver = null;
	String username = System.getenv("LT_USERNAME") == null ? "vipul31gupta" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "gsHDwl7aj0bXNoLrvirbfOEehHSp1a9yvCECGEcc3YPm8aRhQg" : System.getenv("LT_ACCESS");

	@BeforeClass
	public void setDriver() 
	{
		try {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName("Windows 10");
			chromeOptions.setBrowserVersion("121.0");

			HashMap<String, Object> ltOptions = new HashMap<String, Object>();
			ltOptions.put("build", "RemoteWebDriver without ThreadLocal");
			ltOptions.put("project", "RemoteWebDriver without ThreadLocal");
			chromeOptions.setCapability("LT:Options", ltOptions);

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		System.out.println(
				"Browser setup by Thread : " + Thread.currentThread().getId() + " and Driver reference is : " + driver);
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
				+ " and Closing driver reference is :" + driver);
		driver.quit();

	}
}
