package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertNotNull;

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
    WebElement frame = getDriver().findElement(By.xpath("//iframe[@id='aisera-webchat']"));
    assertNotNull(frame);

    long timeout_sec = 20;
    WebDriverWait wait = new WebDriverWait(driver, (long)timeout_sec);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));

    threadSleep(500);

    WebElement chatOpenerButton = getDriver().findElement(By.xpath("//div[@class='chat-opener']//child::img[@class='chat-opener-img']"));
    assertNotNull(chatOpenerButton);

    threadSleep(500);

    chatOpenerButton.click();

    return new WebchatPage(getDriver());
  }
}
