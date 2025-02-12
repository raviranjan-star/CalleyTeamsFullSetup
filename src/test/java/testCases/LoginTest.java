package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pompages.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Masters","Regression"})
	public void login()
	{
		logger.info("***** Login Test Started *****");

        LoginPage lp = new LoginPage(driver);
        
        try {
            lp.enterEmail(properties.getProperty("usr1Email"));
            logger.info("Username Entered");
            
            lp.enterPassword(properties.getProperty("usr1Password"));
            logger.info("Password Entered");

            lp.clickLoginBtn();
            logger.info("Login Button clicked");

            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed");
        } catch (Exception e) {
            logger.error("Test Failed: ", e);
            Assert.fail("Exception occurred during login test");
        }
        
        logger.info("***** Login Test Completed *****");
    }
}
