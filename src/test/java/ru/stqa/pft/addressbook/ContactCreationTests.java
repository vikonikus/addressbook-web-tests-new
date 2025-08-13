package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    initContactCreation();
    fillContactForm(new ContactData("firstName3", "LastName3",
            "Company3", "Address3", "phoneNumber3", "eMail3"));
    submitContactCreation();
    returnToHomePage();
  }

}
