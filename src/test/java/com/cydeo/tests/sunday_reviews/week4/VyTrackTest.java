package com.cydeo.tests.sunday_reviews.week4;

import com.cydeo.pages.DashboardsPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.tests.Utilities.BrowserUtils;
import com.cydeo.tests.Utilities.ConfigurationReader;
import com.cydeo.tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class VyTrackTest {

    @Test
    public void vytrack_driver_login_test(){

        //// TC: Vytrack app login test as Driver
        //  // 1- Open a Chrome browser
        //  // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
        //  // 3. Enter username User1
        //vyTrackLoginPage.username.sendKeys(ConfigurationReader.getProperty("usernameDriver"));

        //  // 4. Enter password UserUser123
        //vyTrackLoginPage.password.sendKeys(ConfigurationReader.getProperty("passwordDriver"));

        //  // 5. Click to Login button
        //vyTrackLoginPage.loginButton.click();

        vyTrackLoginPage.loginAsDriver();

        Driver.closeDriver();
    }

    @Test
    public void vytrack_salesManager_login_test(){

        //// TC: Vytrack app login test as Driver
        //  // 1- Open a Chrome browser
        //  // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
        // 3. Enter username salesmanager120
        //  // 4. Enter password UserUser123
        //  // 5. Click to Login button

        vyTrackLoginPage.loginAsSalesManager();

        Driver.closeDriver();
    }

    @Test
    public void vytrack_storeManager_login_test(){

        //// TC: Vytrack app login test as Driver
        //  // 1- Open a Chrome browser
        //  // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
        // 3. Enter username storemanager85
        //  // 4. Enter password UserUser123
        //  // 5. Click to Login button

        vyTrackLoginPage.loginAsStoreManager();

        Driver.closeDriver();
    }

    @Test
    public void vytrack_salesManager_hover_test(){

        //// TC: Vytrack app login test as Driver
        //  // 1- Open a Chrome browser
        //  // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackURL"));

        VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
        // 3. Enter username salesmanager120
        // 4. Enter password UserUser123
        // 5. Click to Log in button
        vyTrackLoginPage.loginAsSalesManager();

        BrowserUtils.sleep(2);

        // 6. Hover over each main menu
        DashboardsPage dashboardsPage = new DashboardsPage();
        Actions actions = new Actions(Driver.getDriver());

/*        actions.moveToElement(dashboardsPage.dashboards)
                .moveToElement(dashboardsPage.fleet)
                .moveToElement(dashboardsPage.customers)
                .moveToElement(dashboardsPage.sales)
                .moveToElement(dashboardsPage.activities)
                .moveToElement(dashboardsPage.marketing)
                .moveToElement(dashboardsPage.reportsAndSegments)
                .moveToElement(dashboardsPage.system)
                .perform();

 */

        List<WebElement> mainMenu = dashboardsPage.mainMenu;
        for (WebElement eachMenu : mainMenu) {
            actions.moveToElement(eachMenu).perform();
            BrowserUtils.sleep(3);
        }

       // Driver.closeDriver();
    }
}
