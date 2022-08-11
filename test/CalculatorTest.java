package com.planittesting.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;


public class CalculatorTest extends BaseTest {

  @Test
  void verifyMissingFieldErrors() {
    var calculatorPage = new HomePage(driver) //go into homepage
        .clickCalculButton() //click Calculate borrowing power button
        .clickNextButton(); //click Next button

    assertEquals("Selection is required", calculatorPage.getPeopleError());
    assertEquals("Selection is required", calculatorPage.getDependantsError());
  }

 
  @Test
  void verifyPercentageComplete() {
    var message = new HomePage(driver)
        .clickCalculButton()
        .setPersonalData()
        .clickNextButton()
        .getPercentageComplete();


        var message2 = new HomePage(driver)
        .setPersonalData2()
        .clickNextButton()
        .getPercentageComplete();

    //     if (message[0:2] < message2[0:2]){
    //         boolean flag = true;
    //     }
    // assertEquals(true, flag);
  }
 
}
