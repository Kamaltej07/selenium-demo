package com.selenium.examples.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public abstract class Page {

  protected WebDriver webDriver;

  public Page(WebDriver webDriver) {
    initDriver(webDriver);
  }

  public Page(WebDriver webDriver, String url) {
    webDriver.get(url);
    initDriver(webDriver);
  }


  public String getTitle() {
    return webDriver.getTitle();
  }

  private void initDriver(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(this.webDriver, this);
  }
}
