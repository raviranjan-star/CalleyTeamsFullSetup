package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pompages.LoginPage;
import pompages.RegistrationPage;
import testBase.BaseClass;

public class RegistrationTest extends BaseClass {
	
	@Test(groups= {"Sanity","Masters"})
	public void Registration()
	{
		logger.info("***** Registration Test Started *****");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.clickSignUp();
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		try{
			rp.enterName(properties.getProperty("name"));
			logger.info("Name Entered");
			
			rp.enterEmail(properties.getProperty("usr1Email"));
			logger.info("Email Entered");
			
			rp.enterPassword(properties.getProperty("usr1Password"));
			logger.info("Password Entered");
			
			rp.enterNumber(properties.getProperty("phnNumber"));
			logger.info("Phone Number Entered");
			
			rp.clickCaptchaBox();
			logger.info("Captcha Clicked");
			
			rp.clickCheckbox(driver);
			logger.info("Checked Box Clicked");
			
			rp.clickSignUp(driver);
			logger.info("SignUp Button Clicked");
			
			Thread.sleep(2000);
			
			if(driver.getCurrentUrl().contains("dashboard")) {
			logger.info("***** Registration Completed *****");
			}
			else if(rp.errMsgDisplayed())
			{
				logger.info("Registartion failled due to Captcha");
				
			}
			else if(rp.errCaptchaDisplayed()){
				logger.info("Registartion failled due to Captcha");
			}
			else
			{
				Assert.fail();
			}
				
        } catch (Exception e) {
        	
        			logger.error("Test Failed: ");
                    Assert.fail("Exception occurred during Registration test");
        		}
		logger.info("***** Registration Test Completed *****");
		}
}
