package com.tests.aisera;

import com.domain.Candidate;
import com.domain.CandidateFixture;
import com.framework.core.BaseTest;
import com.pageobjects.aisera.AdminUIHomePage;
import com.pageobjects.aisera.AdminUILoginPage;
import com.pageobjects.aisera.HomePage;
import com.pageobjects.aisera.WebchatPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class AdminUITests extends BaseTest {

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @Test(groups = {"aisera"})
  public void homePageTest1() {
    AdminUILoginPage loginPage = new AdminUILoginPage(getDriver());

    assertNotNull(loginPage);

    AdminUIHomePage homePage = loginPage.login("admin@aisera.com", "Aisera123");

    assertNotNull(homePage);

    homePage.logout();
  }
}