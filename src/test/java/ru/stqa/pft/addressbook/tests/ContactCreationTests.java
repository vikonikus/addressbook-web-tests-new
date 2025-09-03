package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    // Разрешаем только необходимые классы
    xStream.allowTypes(new Class[]{
            ru.stqa.pft.addressbook.model.ContactData.class
            // другие классы вашей модели
    });
    xStream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
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
