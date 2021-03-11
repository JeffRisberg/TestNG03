package com.pageobjects.aisera;

import com.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertNotNull;

public class AdminUILoginPage extends BasePage {

  // Page URL
  private static String PAGE_URL = "https://login.demo9.aws-001-us-west-2.aisera.cloud/?system";

  @FindBy(how = How.XPATH, using = "//form[@class='fields-container']//input[@name='email']")
  private WebElement emailText;

  @FindBy(how = How.XPATH, using = "//form[@class='fields-container']//input[@name='password']")
  private WebElement passwordText;

  @FindBy(how = How.XPATH, using = "//div[@class='login-btn-container']/button")
  private WebElement loginButton;

  public AdminUILoginPage(WebDriver driver) {
    super(driver);

    driver.get(PAGE_URL);
    threadSleep(1000);

    PageFactory.initElements(driver, this);

    assertNotNull(emailText);
    assertNotNull(passwordText);
    assertNotNull(loginButton);
  }

  public void typeEmail(String email) {
    highlightElement(getDriver(), emailText, 2);

    emailText.sendKeys(email);
  }

  public void typePassword(String password) {
    highlightElement(getDriver(), passwordText, 2);

    passwordText.sendKeys(password);
  }

  public AdminUIHomePage clickLogin() {
    highlightElement(getDriver(), loginButton, 2);

    loginButton.click();

    int timeoutSec = 10;
    waitForLoad(driver, timeoutSec);

    try {
      WebElement agreeButton = getDriver().findElement
              (By.xpath("//div[@class='modal-body']//div[@class='button-container']//button[contains(text(),'I Agree')]"));

      if (agreeButton != null) {
        System.out.println("found eula screen");

        highlightElement(getDriver(), agreeButton, 2);

        agreeButton.click();
        waitForLoad(driver, timeoutSec);
      }
    } catch (NoSuchElementException e) {
      System.out.println("no eula screen");
    }

    return new AdminUIHomePage(getDriver());
  }

  public AdminUIHomePage login(String email, String password) {
    typeEmail(email);
    typePassword(password);

    return clickLogin();
  }
}
