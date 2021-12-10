package com.framework.core;

import java.util.function.Function;
import org.openqa.selenium.*;

public class SearchContextExpectedConditions {

  public static SearchContextExpectedCondition visibilityOfElementLocated(final By by) {
    return new SearchContextExpectedCondition<WebElement>() {
      public WebElement apply(SearchContext sc) {
        try {
          return elementIfVisible(findElement(by, sc));
        } catch (StaleElementReferenceException e) {
          return null;
        }
      }

      @Override
      public String toString() {
        return "visibility of element located by " + by;
      }
    };
  }

  public static SearchContextExpectedCondition existanceOfElementLocated(final By by) {
    return new SearchContextExpectedCondition<Boolean>() {
      public Boolean apply(SearchContext sc) {
        try {
          return findElement(by, sc) != null;
        } catch (StaleElementReferenceException e) {
          return false;
        }
      }

      @Override
      public String toString() {
        return "existance of element located by " + by;
      }
    };
  }

  /**
   * Looks up an element. Logs and re-throws WebDriverException if thrown.
   * <p/>
   * Method exists to gather data for
   * http://code.google.com/p/selenium/issues/detail?id=1800
   */
  private static WebElement findElement(By by, SearchContext sc) {
    try {
      return sc.findElement(by);
    } catch (NoSuchElementException e) {
      throw e;
    } catch (WebDriverException e) {
      // log.log(Level.WARNING,
      // String.format("WebDriverException thrown by findElement(%s)", by), e);
      throw e;
    }
  }

  /**
   * @return the given element if it is visible and has non-zero size,
   *         otherwise null.
   */
  private static WebElement elementIfVisible(WebElement element) {
    return element.isDisplayed() ? element : null;
  }
}

interface SearchContextExpectedCondition<T> extends Function<SearchContext, T> {
}
