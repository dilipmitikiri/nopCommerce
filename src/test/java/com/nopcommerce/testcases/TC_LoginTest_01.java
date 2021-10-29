package com.nopcommerce.testcases;

import com.nopcommerce.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Logger;

public class TC_LoginTest_01 extends BaseClass {
    @Test
    public void loginTest() throws IOException {
        driver.get(baseURL);
        log.info("Opened URL");
        LoginPage lp = new LoginPage(driver);
        lp.clickLoginLink();
        lp.setEmailId(username);
        log.info("Entered Email");
        lp.setPassword(password);
        log.info("Entered password");
        lp.clickLoginButton();
        log.info("Clicked on Login button");


        if(driver.getTitle().equals("nopCommerce demo store. Login")){
            Assert.assertTrue(true);
            log.info("Login test passed");
        }
        else{
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            log.info("Login test failed");
        }
    }
}
