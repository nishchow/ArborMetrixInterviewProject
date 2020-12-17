/*
 * @author Nishat Chowdhury
 * 
 */
package arbormetrix.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import arbormetrix.util.TestUtil;

public class TestBase {

	public static WebDriver driver;

	public static void initialization() throws Exception {
		
		String browserName = "chrome";
		
		String url = "https://www.jotform.com/form-templates/class-registration-3";

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "Resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(url);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='formPreviewArea']")));

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
}