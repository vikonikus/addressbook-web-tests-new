package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoHomePage();
    if (app.contact().all().isEmpty()) {
      app.contact().create(new ContactData()
              .withFirstname("firstName")
              .withLastname("LastName")
              .withHomePhone("home")
              .withMobilePhone("mobile")
              .withWorkPhone("work")
              .withAddress("address")
              .withFirstEmail("email")
              .withSecondEmail("email1")
              .withFirstEmail("email2"));
    }
  }

  @Test
  public void testContactDeletionTests() throws Exception {
    Contacts before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    app.contact().delete(deleteContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deleteContact)));
  }

}
