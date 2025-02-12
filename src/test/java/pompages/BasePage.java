package pompages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected static WebDriver driver;
	protected static JavascriptExecutor js;
	protected WebDriverWait wait;
	protected Actions actions;
	
	public BasePage(WebDriver driver)
	{
		BasePage.driver=driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
		
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	
}
