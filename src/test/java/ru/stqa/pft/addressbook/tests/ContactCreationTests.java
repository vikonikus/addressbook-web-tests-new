package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("firstName3", "LastName3",
            "Company3", "Address3", "phoneNumber3", "eMail3"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
