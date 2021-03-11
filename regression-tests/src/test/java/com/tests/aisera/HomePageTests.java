package com.tests.aisera;

import com.domain.Candidate;
import com.domain.CandidateFixture;
import com.framework.core.BaseTest;
import com.pageobjects.aisera.HomePage;
import com.pageobjects.aisera.WebchatPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class HomePageTests extends BaseTest {
  protected Candidate candidate;

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    candidate = CandidateFixture.getCandidate();
  }

  @Test(groups = {"aisera"})
  public void homePageTest1() {
    HomePage homePage = new HomePage(getDriver());

    WebchatPage webchatPage = homePage.clickChatOpenerButton();

    assertNotNull(webchatPage);

    webchatPage.clickCloseButton();
  }

  /*
  @Test(groups = {"aisera"})
  public void homePageTest2() {
    HomePage homePage = new HomePage(getDriver());

    WebchatPage webchatPage = homePage.clickChatOpenerButton();

    assertNotNull(webchatPage);

    webchatPage.changeUserName("mark.smith.at.acme@aisera.com");

    webchatPage.clickCloseButton();
  }
  */
}
