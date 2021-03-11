package com.tests.google;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import com.framework.core.BaseTest;
import com.pageobjects.google.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  @Test(groups = {"google"})
  public void homePageTests() {
    try {
      HomePage homePage = new HomePage(getDriver());

      AboutPage aboutPage = homePage.clickAboutButton();
      assertNotNull(aboutPage);

      homePage = new HomePage(getDriver());

      StorePage storePage = homePage.clickStoreButton();
      assertNotNull(storePage);
    } catch (Exception e) {
      fail();
    }
  }
}
