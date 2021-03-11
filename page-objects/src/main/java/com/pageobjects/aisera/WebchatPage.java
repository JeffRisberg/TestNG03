package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class WebchatPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://static.aisera.com/demo9/acme-itsm/index.html";

  @FindBy(how = How.XPATH, using = "//div[@class='webchat-header']//div[contains(@class,'chat-close')]")
  private WebElement closeButton;

  //@FindBy(how = How.XPATH, using = "//div[@class='commands-container']//span[contains(@class,'flaticon-menu-dots')]")
  //private WebElement menuButton;

  @FindBy(how = How.XPATH, using = "//div[@class='chat-input-container']//textarea[contains(@class,'chat-input')]")
  private WebElement inputTextArea;

  public WebchatPage(WebDriver driver) {
    super(driver);

    threadSleep(1000);

    PageFactory.initElements(driver, this);

    assertNotNull(closeButton);
    //assertNotNull(menuButton);
    assertNotNull(inputTextArea);
  }

  public void clickCloseButton() {
    highlightElement(getDriver(), inputTextArea, HIGHLIGHT_DURATION);

    closeButton.click();
  }

  public void clickMenuButton() {
    //highlightElement(getDriver(), menuButton, HIGHLIGHT_DURATION);

    //menuButton.click();
  }

  public void clickRefreshButton() {
    clickMenuButton();

    WebElement refreshButton =
        getElement(getDriver(), By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"), 10);
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void clickProfileButton() {
    clickMenuButton();

    WebElement refreshButton =
        getElement(getDriver(), By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"), 10);
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void changeUserName(String userName) {
    WebElement userNameText =
        getElement(getDriver(), By.xpath("//div[@class='field-editor']//input"), 10);
    assertNotNull(userNameText);

    highlightElement(getDriver(), userNameText, HIGHLIGHT_DURATION);

    userNameText.sendKeys(userName);

    WebElement continueButton =
        getElement(getDriver(), By.xpath("//button[contains(@class,'continue-btn')]"), 10);
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

