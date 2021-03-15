package com.pageobjects.aisera;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import com.framework.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);

    assertTrue(loadProperties("aisera/homePage"), "cannot load properties");

    String pageUrl = properties.getProperty("HOME_URL");

    driver.get(pageUrl);
    threadSleep(500);
  }

  public WebchatPage clickChatOpenerButton() {
    String chatFrameLocator = properties.getProperty("HOME_CHAT_FRAME_XPATH");
    WebElement frame = getElement(getDriver(), By.xpath(chatFrameLocator), 10);
    assertNotNull(frame);

    long timeout_sec = 20;
    WebDriverWait wait = new WebDriverWait(driver, (long) timeout_sec);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

    threadSleep(500);

    String chatOpenerButtonLocator = properties.getProperty("HOME_CHAT_OPENER_BUTTON_XPATH");
    WebElement chatOpenerButton = getElement(getDriver(), By.xpath(chatOpenerButtonLocator), 10);
    assertNotNull(chatOpenerButton);

    threadSleep(500);

    chatOpenerButton.click();

    return new WebchatPage(getDriver());
  }
}
