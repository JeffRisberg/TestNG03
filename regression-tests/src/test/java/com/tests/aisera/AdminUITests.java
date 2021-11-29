package com.tests.aisera;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BaseTest;
import com.pageobjects.aisera.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminUITests extends BaseTest {

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @Test(groups = {"aisera"}, priority = 1)
  public void homePageTest1() {
    AdminUILoginPage loginPage = new AdminUILoginPage(getDriver());

    assertNotNull(loginPage);

    AdminUIHomePage homePage = loginPage.login("admin@aisera.com", "Aisera123");

    assertNotNull(homePage);

    homePage.toggleConfigMenu();
    homePage.toggleUserMenu();
  }

  @Test(groups = {"aisera"}, priority = 2)
  public void homePageTest2() {
    AdminUIHomePage homePage = new AdminUIHomePage(getDriver());

    assertNotNull(homePage);

    AdminUIDataSourcesPage dataSourcesPage = homePage.navToDataSourcesPage();
  }
}
