package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("firstName", "LastName",
              "Company", "Address", "phoneNumber", "eMail", "test1"));
    }
    int before = app.getContactHelper().getContactCounter();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("firstName_mod3", "LastName_mod3",
            "Company_mod3", "Address_mod3", "phoneNumber_mod3", "eMail_mod3",
            null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCounter();
    Assert.assertEquals(after, before + 1); // есть чекбокс для всех контактов, поэтому умвеличиваем после на 1
  }
}
