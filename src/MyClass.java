import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

	@Test(enabled = false)
	public void Login() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test(enabled = false)
	public void AddAllItems() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> Buttons = driver.findElements(By.className("btn"));
		for (int i = 0; i < Buttons.size(); i++) {
			Buttons.get(i).click();
		}
	}

	@Test(enabled = false)
	public void AddThreeItems() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		List<WebElement> Buttons = driver.findElements(By.className("btn"));
		for (int i = 0; i < Buttons.size(); i = i + 2) {
			Buttons.get(i).click();
		}
	}

	@Test()
	public void Checkout() throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Lana");
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Osama");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("6875856");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//button[@id='finish']")).click();

	}

	@AfterTest
	public void myPost() {
	}

}
