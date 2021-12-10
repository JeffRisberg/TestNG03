package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class AdminUILoginPage extends BasePage {

  private final WebElement emailText;
  private final WebElement passwordText;
  private final WebElement loginButton;

  public AdminUILoginPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/uiLoginPage"), "cannot load properties");

    String pageUrl = properties.getProperty("UILOGIN_URL");

    driver.get(pageUrl);
    threadSleep(1000);

    String emailTextLocator = properties.getProperty("UILOGIN_EMAIL_TEXT_XPATH");
    emailText = getElement(driver, By.xpath(emailTextLocator), 30);
    assertNotNull(emailText, "cannot find EMail text");

    String passwordTextLocator = properties.getProperty("UILOGIN_PASSWORD_TEXT_XPATH");
    passwordText = getElement(driver, By.xpath(passwordTextLocator), 30);
    assertNotNull(passwordText, "cannot find Password text");

    String loginButtonLocator = properties.getProperty("UILOGIN_LOGIN_BUTTON_XPATH");
    loginButton = getElement(driver, By.xpath(loginButtonLocator), 30);
    assertNotNull(loginButton, "cannot find Login button");
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
      String agreeButtonLocator = properties.getProperty("UILOGIN_AGREE_BUTTON_XPATH");
      WebElement agreeButton = getElement(getDriver(), By.xpath(agreeButtonLocator), timeoutSec);

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
