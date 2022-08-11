package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
      this.driver = driver;
    }

    public LoginPage setNABID(String value) {
        driver.findElement(By.id("userid")).sendKeys(value);
        return this;
      }

    public LoginPage submitLogin() {
        //loginBtn
        driver.findElement(By.id("loginBtn")).click();

        return this;
    }

    public String getNABIDError() {
        return driver.findElement(By.id("userid-error")).findElement(By.tagName("p")).getText();
    }

    public String getPasswordError() {
        //password-error
        return driver.findElement(By.id("password-error")).findElement(By.tagName("p")).getText();
    }
}
