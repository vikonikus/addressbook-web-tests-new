package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"Firstname1", "Lastname1", "Address 1", "1@1.ru", "111"});
    list.add(new Object[]{"Firstname2", "Lastname2", "Address 2", "2@2.ru", "222"});
    list.add(new Object[]{"Firstname3", "Lastname3", "Address 3", "3@3.ru", "333"});
    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(String firstname, String lastname, String address, String email, String homephone) throws Exception {
    //    File photo = new File("src/test/resources/floor.png");
    ContactData contact = new ContactData()
            .withFirstname(firstname)
            .withLastname(lastname)
            .withAddress(address)
            .withFirstEmail(email)
            .withHomePhone(homephone);
//            .withPhoto(photo);
    app.goTo().gotoHomePage();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
  }


}
