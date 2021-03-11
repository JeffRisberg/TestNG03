package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

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
    highlightElement(getDriver(), inputTextArea, 2);

    closeButton.click();
  }

  public void clickMenuButton() {
    //highlightElement(getDriver(), menuButton, 2);

    //menuButton.click();
  }

  public void clickRefreshButton() {
    clickMenuButton();

    WebElement refreshButton = getDriver().findElement(By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"));
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void clickProfileButton() {
    clickMenuButton();

    WebElement refreshButton = getDriver().findElement(By.xpath("//div[@class='commands-container']//span[@data-tooltip='Refresh']"));
    assertNotNull(refreshButton);

    refreshButton.click();
  }

  public void changeUserName(String userName) {
    //clickProfileButton();

    WebElement userNameText = getDriver().findElement(By.xpath("//div[@class='field-editor']//input"));
    assertNotNull(userNameText);

    highlightElement(getDriver(), userNameText, 2);

    userNameText.sendKeys(userName);

    WebElement continueButton = getDriver().findElement(By.xpath("//button[contains(@class,'continue-btn')]"));
    assertNotNull(continueButton);

    continueButton.click();
  }

  public void sendUtterance(String text) {
    highlightElement(getDriver(), inputTextArea, 2);

    inputTextArea.sendKeys(text);

    inputTextArea.sendKeys("\n");
    threadSleep(500);
  }

  public void waitForResponse(String xpathLocator) throws Exception {
    int timeoutSec = 30;

    highlightElement(driver, By.xpath(xpathLocator), timeoutSec);
    waitUntilElementIsVisible(driver, By.xpath(xpathLocator), timeoutSec);
  }
}

