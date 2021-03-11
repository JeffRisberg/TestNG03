package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class AdminUILoginPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://login.demo9.aws-001-us-west-2.aisera.cloud/?system";

  @FindBy(how = How.XPATH, using = "//form[@class='fields-container']//input[@name='email']")
  private WebElement emailText;

  @FindBy(how = How.XPATH, using = "//form[@class='fields-container']//input[@name='password']")
  private WebElement passwordText;

  @FindBy(how = How.XPATH, using = "//div[@class='login-btn-container']/button")
  private WebElement loginButton;

  public AdminUILoginPage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    threadSleep(1000);

    PageFactory.initElements(driver, this);

    assertNotNull(emailText);
    assertNotNull(passwordText);
    assertNotNull(loginButton);
  }

  public void typeEmail(String email) {
    highlightElement(getDriver(), emailText, HIGHLIGHT_DURATION);

    emailText.sendKeys(email);
  }

  public void typePassword(String password) {
    highlightElement(getDriver(), passwordText, HIGHLIGHT_DURATION);

    passwordText.sendKeys(password);
  }

  public AdminUIHomePage clickLogin() {
    highlightElement(getDriver(), loginButton, HIGHLIGHT_DURATION);

    loginButton.click();

    int timeoutSec = 10;
    waitForLoad(driver, timeoutSec);

    try {
      WebElement agreeButton =
              getElement(getDriver(),
                  By.xpath("//div[@class='button-container']//button[contains(text(),'I Agree')]"),
                  timeoutSec);

      if (agreeButton != null) {
        highlightElement(getDriver(), agreeButton, HIGHLIGHT_DURATION);

        agreeButton.click();
        waitForLoad(driver, timeoutSec);
      }
    } catch (Exception e) {
    }

    return new AdminUIHomePage(getDriver());
  }

  public AdminUIHomePage login(String email, String password) {
    typeEmail(email);
    typePassword(password);

    return clickLogin();
  }
}
