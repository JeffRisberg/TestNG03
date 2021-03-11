package com.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class BasePage {
  private static final int TIMEOUT = 5; // seconds
  private static final int POLLING = 100; // milliseconds

  protected WebDriver driver;
  private WebDriverWait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
  }

  public WebDriver getDriver() {
    return driver;
  }

  protected void assertCurrentUrl(String url) {
    String currentUrl = driver.getCurrentUrl();
    int questionIndex = currentUrl.indexOf("?");
    if (questionIndex > 0) {
      currentUrl = currentUrl.substring(0, questionIndex);
    }
    if (currentUrl.endsWith("/")) {
      currentUrl = currentUrl.substring(0, currentUrl.length()-1);
    }

    assertEquals(currentUrl, url);
  }

  protected void waitForElementToAppear(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  protected void waitForTextToDisappear(By locator, String text) {
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
  }
}
