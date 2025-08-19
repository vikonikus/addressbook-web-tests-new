package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("firstName4", "LastName4",
            "Company4", "Address4", "phoneNumber4", "eMail4", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
