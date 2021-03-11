package com.tests.aisera;

import com.domain.Candidate;
import com.domain.CandidateFixture;
import com.framework.core.BaseTest;
import com.pageobjects.aisera.HomePage;
import com.pageobjects.aisera.WebchatPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class WebchatTests extends BaseTest {

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
  }

  //@Test(groups = {"aisera"})
  public void webchatTest1() {
    HomePage homePage = new HomePage(getDriver());

    WebchatPage webchatPage = homePage.clickChatOpenerButton();

    assertNotNull(webchatPage);

    webchatPage.changeUserName("mark.smith.at.acme@aisera.com");

    webchatPage.clickCloseButton();
  }

  //@Test(groups = {"aisera"})
  public void webchatTest2() throws Exception {
    HomePage homePage = new HomePage(getDriver());

    WebchatPage webchatPage = homePage.clickChatOpenerButton();

    assertNotNull(webchatPage);

    webchatPage.sendUtterance("hello");

    webchatPage.waitForResponse("//div[text() = 'Hi Mark, how can I help you?']");

    webchatPage.sendUtterance("work from home guide");

    webchatPage.waitForResponse("//a[text() = 'Guide - Work From Home (WFH)']");

    webchatPage.sendUtterance("how much is 1password for me");

    webchatPage.waitForResponse("//div[@class='answer-content-item']//p[text() = '$36']");

    webchatPage.clickCloseButton();
  }
}