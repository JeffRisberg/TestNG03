package com.pageobjects.toptal;

import com.framework.core.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://www.toptal.com";

  // Locators

  @FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")
  private WebElement developerApplyButton;

  public HomePage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    PageFactory.initElements(driver, this);
  }

  public ApplyPage clickOnDeveloperApplyButton() {
    try {
      ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollIntoView(true);", developerApplyButton);
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    developerApplyButton.click();

    return new ApplyPage(getDriver());
  }
}
