package com.framework.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

  public void threadSleep(int mills) {
    try {
      Thread.sleep(mills);
    } catch (Exception e) {
    }
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

  public void setTimeOutForElements(int timeout) {
    try {
      if (!Boolean.parseBoolean(System.getProperties().getProperty("headless")))
        Thread.sleep(timeout);
    } catch (Exception e) {
    }
  }

  private WebElement getElement(WebDriver driver, By locator, int timeoutSec) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

    wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    return driver.findElement(locator);
  }

  private List<WebElement> getElements(WebDriver driver, By locator, int timeoutSec) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);

    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    return driver.findElements(locator);
  }

  public void waitUntilElementIsVisible(WebDriver driver, By locator, int timeoutSec) throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public boolean highlightElement(WebDriver driver, WebElement element, int timeoutSec) {
    if (Boolean.parseBoolean(System.getProperties().getProperty("headless"))) {
      return true;
    }

    WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
    wait.until(ExpectedConditions.visibilityOf(element));

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].setAttribute('style', 'background: yellow');", element);

    setTimeOutForElements(700);

    jse.executeScript("arguments[0].setAttribute('style', 'background: solid white');", element);

    return true;
  }

  public boolean highlightElement(WebDriver driver, By locator, int timeoutSec) {
    try {
      WebElement webElement = getElement(driver, locator, timeoutSec);

      return highlightElement(driver, webElement, timeoutSec);
    } catch (Exception e) {
      return false;
    }
  }

  public void scrollToView(WebDriver driver, WebElement webElement) {
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
  }

  public void scrollToView(WebDriver driver, By locator, int timeoutSec) {
    try {
      WebElement webElement = getElement(driver, locator, timeoutSec);

      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    } catch (Exception e) {
    }
  }
}
