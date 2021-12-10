package com.framework.core;

import java.time.Clock;
import java.time.Duration;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;

class SearchContextWait extends FluentWait<SearchContext> {
  public final static long DEFAULT_SLEEP_TIMEOUT = 500;

  /**
   * Just implementing one constructor for this sample
   * @param input
   * @param timeOutInSeconds
   */
  public SearchContextWait(SearchContext input, long timeOutInSeconds) {
    this(input, Clock.systemDefaultZone(), Sleeper.SYSTEM_SLEEPER,
        timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
  }

  protected SearchContextWait(SearchContext sc, Clock clock, Sleeper sleeper,
      long timeOutInSeconds, long sleepTimeOut) {
    super(sc, clock, sleeper);
    withTimeout(Duration.ofSeconds(timeOutInSeconds));
    pollingEvery(Duration.ofMillis(sleepTimeOut));
    ignoring(NotFoundException.class);
  }
}
