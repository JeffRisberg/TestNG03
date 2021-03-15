package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class WebchatPage extends BasePage {

  private WebElement closeButton;
  private WebElement menuButton;

  public WebchatPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/webchatPage"), "cannot load properties");

    String pageUrl = properties.getProperty("WEBCHAT_URL");

    assertCurrentUrl(pageUrl);

    threadSleep(1000);

    String closeButtonLocator = properties.getProperty("WEBCHAT_CLOSE_BUTTON_XPATH");
    closeButton = getElement(driver, By.xpath(closeButtonLocator), 30);
    assertNotNull(closeButton, "cannot find Close button");

    String menuButtonLocator = properties.getProperty("WEBCHAT_MENU_BUTTON_XPATH");
    // menuButton = getElement(driver, By.xpath(menuButtonLocator), 30);
    // assertNotNull(menuButton, "cannot find Menu button");
  }

  public void clickCloseButton() {
    highlightElement(getDriver(), closeButton, HIGHLIGHT_DURATION);

    closeButton.click();
  }

  public void clickMenuButton() {
    highlightElement(getDriver(), menuButton, HIGHLIGHT_DURATION);

    menuButton.click();
  }

  public void clickRefreshButton() {
    clickMenuButton();

    String refreshButtonLocator = properties.getProperty("WEBCHAT_REFRESH_BUTTON_XPATH");
    WebElement refreshButton = getElement(getDriver(), By.xpath(refreshButtonLocator), 10);
    assertNotNull(refreshButton);

    highlightElement(getDriver(), refreshButton, HIGHLIGHT_DURATION);

    refreshButton.click();
  }

  public void clickProfileButton() {
    clickMenuButton();

    String profileButtonLocator = properties.getProperty("WEBCHAT_PROFILE_BUTTON_XPATH");
    WebElement profileButton = getElement(getDriver(), By.xpath(profileButtonLocator), 10);
    assertNotNull(profileButton);

    highlightElement(getDriver(), profileButton, HIGHLIGHT_DURATION);

    profileButton.click();
  }

  public void changeUserName(String userName) {
    String userNameLocator = properties.getProperty("WEBCHAT_USERNAME_XPATH");
    WebElement userNameText = getElement(getDriver(), By.xpath(userNameLocator), 10);
    assertNotNull(userNameText);

    highlightElement(getDriver(), userNameText, HIGHLIGHT_DURATION);

    userNameText.sendKeys(userName);

    String continueButtonLocator = properties.getProperty("WEBCHAT_CONTINUE_BUTTON_XPATH");
    WebElement continueButton = getElement(getDriver(), By.xpath(continueButtonLocator), 10);
    assertNotNull(continueButton);

    highlightElement(getDriver(), userNameText, HIGHLIGHT_DURATION);

    continueButton.click();
  }

  public void sendUtterance(String text) {
    String inputTextAreaLocator = properties.getProperty("WEBCHAT_INPUT_TEXTAREA_XPATH");
    WebElement inputTextArea = getElement(driver, By.xpath(inputTextAreaLocator), 30);
    assertNotNull(inputTextArea, "cannot find Input TextArea");

    highlightElement(getDriver(), inputTextArea, HIGHLIGHT_DURATION);

    inputTextArea.sendKeys(text);

    inputTextArea.sendKeys("\n");
    threadSleep(500);
  }

  public void waitForResponse(String xpathLocator) throws Exception {
    int timeoutSec = 10;

    highlightElement(driver, By.xpath(xpathLocator), HIGHLIGHT_DURATION, timeoutSec);
    waitUntilElementIsVisible(driver, By.xpath(xpathLocator), timeoutSec);
  }
}
