package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;

public class WebchatPage extends BasePage {

  // @FindBy(how = How.XPATH, using =
  // "//div[@class='webchat-header']//div[contains(@class,'chat-close')]")
  private WebElement closeButton;

  // @FindBy(how = How.XPATH, using =
  // "//div[@class='commands-container']//span[contains(@class,'flaticon-menu-dots')]")
  private WebElement menuButton;

  // @FindBy(how = How.XPATH, using =
  // "//div[@class='chat-input-container']//textarea[contains(@class,'chat-input')]")
  private WebElement inputTextArea;

  public WebchatPage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/webchatPage"), "cannot load properties");

    String pageUrl = properties.getProperty("WEBCHAT_URL");

    threadSleep(1000);

    String closeButtonLocator = properties.getProperty("WEBCHAT_CLOSE_BUTTON_XPATH");
    closeButton = getElement(driver, By.xpath(closeButtonLocator), 30);
    assertNotNull(closeButton, "cannot find Close button");

    String menuButtonLocator = properties.getProperty("WEBCHAT_MENU_BUTTON_XPATH");
    //menuButton = getElement(driver, By.xpath(menuButtonLocator), 30);
    // assertNotNull(menuButton, "cannot find Menu button");

    String inputTextAreaLocator = properties.getProperty("WEBCHAT_INPUT_TEXTAREA_XPATH");
    inputTextArea = getElement(driver, By.xpath(inputTextAreaLocator), 30);
    assertNotNull(inputTextArea, "cannot find Input TextArea");
  }

  public void clickCloseButton() {
    highlightElement(getDriver(), inputTextArea, HIGHLIGHT_DURATION);

    closeButton.click();
  }

  public void clickMenuButton() {
    // highlightElement(getDriver(), menuButton, HIGHLIGHT_DURATION);

    // menuButton.click();
  }

  public void clickRefreshButton() {
    clickMenuButton();

    String refreshButtonLocator = properties.getProperty("WEBCHAT_REFRESH_BUTTON_XPATH");
    WebElement refreshButton = getElement(getDriver(), By.xpath(refreshButtonLocator), 10);
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void clickProfileButton() {
    clickMenuButton();

    String profileButtonLocator = properties.getProperty("WEBCHAT_PROFILE_BUTTON_XPATH");
    WebElement profileButton = getElement(getDriver(), By.xpath(profileButtonLocator), 10);
    assertNotNull(profileButton);

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

    continueButton.click();
  }

  public void sendUtterance(String text) {
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
