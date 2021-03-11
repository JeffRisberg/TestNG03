package com.tests.google;

import com.framework.core.BaseTest;
import com.pageobjects.google.AboutPage;
import com.pageobjects.google.HomePage;
import com.pageobjects.google.StorePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class HomePageTests extends BaseTest {

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @Test(groups = {"google"})
  public void homePageTests() {
    HomePage homePage = new HomePage(getDriver());

    AboutPage aboutPage = homePage.clickAboutButton();
    assertNotNull(aboutPage);

    homePage = new HomePage(getDriver());

    StorePage storePage = homePage.clickStoreButton();
    assertNotNull(storePage);
  }
}
