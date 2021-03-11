package com.pageobjects.toptal;

import com.domain.CandidateType;
import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplyPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://www.toptal.com/talent/apply";

  // Locators
  @FindBy(how = How.CLASS_NAME, using = "cookie_banner-btn_allow")
  private WebElement cookieBannerAllowButton;

  @FindBy(how = How.XPATH, using = "//input[@id='talent_create_applicant_talent_kind']/..")
  private WebElement talentSelector;

  @FindBy(how = How.ID_OR_NAME, using = "talent_create_applicant_full_name")
  private WebElement fullNameText;

  @FindBy(how = How.ID_OR_NAME, using = "talent_create_applicant_email")
  private WebElement emailText;

  @FindBy(how = How.ID_OR_NAME, using = "talent_create_applicant_password")
  private WebElement passwordText;

  @FindBy(how = How.ID_OR_NAME, using = "talent_create_applicant_password_confirmation")
  private WebElement passwordConfirmText;

  @FindBy(how = How.ID_OR_NAME, using = "save_new_talent_create_applicant")
  private WebElement commitButton;

  public ApplyPage(WebDriver driver) {
    super(driver);

    assertCurrentUrl(PAGE_URL);

    PageFactory.initElements(driver, this);

    if (cookieBannerAllowButton != null) {
      cookieBannerAllowButton.click();
    }
  }

  public void selectType(CandidateType candidateType) {
    WebElement defaultValue =
        talentSelector.findElement(By.xpath("//div[@class='input has-default_value']"));

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    defaultValue.click(); // open it

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    String xPathStr = String.format("//div[@data-value='%s']", candidateType.getSelectionValue());
    System.out.println(xPathStr);

    WebElement typeChild = talentSelector.findElement(By.xpath(xPathStr));

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }

    typeChild.click(); // close with a selection
  }

  public void typeFullName(String fullName) {
    try {
      ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollIntoView(true);", fullNameText);
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    fullNameText.sendKeys(fullName);
  }

  public void typeEmail(String email) {
    try {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailText);
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    emailText.sendKeys(email);
  }

  public void typePassword(String password) {
    try {
      ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollIntoView(true);", passwordText);
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    passwordText.sendKeys(password);
  }

  public void clickCommit() {
    try {
      ((JavascriptExecutor) driver)
          .executeScript("arguments[0].scrollIntoView(true);", commitButton);
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    commitButton.click();
  }
}
