package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCounter();
    app.getContactHelper().createContact(new ContactData("firstName4", "LastName4",
            "Company4", "Address4", "phoneNumber4", "eMail4", "test1"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCounter();
    Assert.assertEquals(after, before + 1);
  }

}
