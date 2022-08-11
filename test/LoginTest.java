package com.planittesting.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.planittesting.model.pages.HomePage;
public class LoginTest extends BaseTest{
    @Test
    void verifyLoginResirect()  {
      var loginPage = new HomePage(driver) //go into homepage
          .clickLoginButton(); //click login button
    }

    @Test
    void verifyNabID()  {
      var loginPage = new HomePage(driver) //go into homepage
          .clickLoginButton()
          .setNABID("abc")
          .submitLogin();

        assertEquals("Your NAB ID is incorrect.\nIt is a 8-10 digit number, found on the back of your NAB Credit or Debit card.", loginPage.getNABIDError());
    }

    @Test
    void verifyMissingFieldErrors()  {
      var loginPage = new HomePage(driver) //go into homepage
          .clickLoginButton()
            .submitLogin();

        assertEquals("Please enter your NAB ID.", loginPage.getNABIDError());
        assertEquals("Please enter your Internet Banking password.", loginPage.getPasswordError());
    }
}
