package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletionTests() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName4", "LastName4",
              "Company4", "Address4", "phoneNumber4", "eMail4", "test1"));
    }
    int before = app.getContactHelper().getContactCounter();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().submitDeletionContact();
    int after = app.getContactHelper().getContactCounter();
    Assert.assertEquals(after, before); // есть чекбокс для всех контактов, поэтому умвеличиваем после на 1
  }


}
