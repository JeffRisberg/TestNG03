package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;

import com.framework.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://static.aisera.com/demo9/acme-itsm/index.html";

  public HomePage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    threadSleep(500);

    PageFactory.initElements(driver, this);
  }

  public WebchatPage clickChatOpenerButton() {
    WebElement frame = getElement(getDriver(), By.xpath("//iframe[@id='aisera-webchat']"), 10);
    assertNotNull(frame);

    long timeout_sec = 20;
    WebDriverWait wait = new WebDriverWait(driver, (long)timeout_sec);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

    threadSleep(500);

    WebElement chatOpenerButton =
        getElement(getDriver(), By.xpath("//div[@class='chat-opener']//child::img[@class='chat-opener-img']"), 10);
    assertNotNull(chatOpenerButton);

    threadSleep(500);

    chatOpenerButton.click();

    return new WebchatPage(getDriver());
  }
}
