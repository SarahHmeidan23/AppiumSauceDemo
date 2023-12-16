import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;

public class MyClass {

	DesiredCapabilities caps = new DesiredCapabilities();
	AndroidDriver driver;

	@BeforeTest
	public void mySetup() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Sara");

		// Browser Testing Type (1)
		caps.setCapability("chromedriverExecutable", "C:\\Users\\sarah\\Downloads\\New folder\\chromedriver.exe");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");

	}

	@Test()
	public void myTest() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@AfterTest
	public void myPost() {
	}

}
