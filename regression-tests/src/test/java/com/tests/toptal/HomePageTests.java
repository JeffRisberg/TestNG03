package com.tests.toptal;

import com.domain.Candidate;
import com.domain.CandidateFixture;
import com.framework.core.BaseTest;
import com.pageobjects.toptal.ApplyPage;
import com.pageobjects.toptal.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
  protected Candidate candidate;

  @BeforeClass(alwaysRun = true)
  private void setup() {
    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

    candidate = CandidateFixture.getCandidate();
  }

  @Test(groups = {"toptal"})
  public void homePageTests() {
    HomePage homePage = new HomePage(getDriver());

    ApplyPage applyPage = homePage.clickOnDeveloperApplyButton();

    applyPage.selectType(candidate.type);
    applyPage.typeFullName(candidate.getFullName());
    applyPage.typeEmail(candidate.email);
    applyPage.typePassword(candidate.password);

    applyPage.clickCommit();
  }
}
