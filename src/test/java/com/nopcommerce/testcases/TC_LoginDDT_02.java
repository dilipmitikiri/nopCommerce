package com.nopcommerce.testcases;

import com.nopcommerce.pageobjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_02 extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        driver.get(baseURL);
        LoginPage lp = new LoginPage(driver);
        lp.clickLoginLink();
        lp.setEmailId(user);
        log.info("user name provided");
        lp.setPassword(pwd);
        log.info("password provided");
        lp.clickLoginButton();

    }

    @DataProvider(name = "LoginData")
    Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "./TestData/LoginData.xlsx";

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String logindata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);//1 0
            }

        }
        return logindata;
    }

}
