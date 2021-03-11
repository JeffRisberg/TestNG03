package com.framework.core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  private static WebDriver driver;

  @BeforeSuite(alwaysRun = true)
  protected void beforeClass() {
    System.setProperty("headless", "false"); // You can set this property elsewhere
    String headless = System.getProperty("headless");

    ChromeDriverManager.chromedriver();
    if ("true".equals(headless)) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
    } else {
      driver = new ChromeDriver();
    }
  }

  @AfterSuite(alwaysRun = true)
  protected void afterClass() {
    if (null != driver) {
      driver.close();
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
