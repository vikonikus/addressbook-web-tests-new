package ru.stqa.pft.addressbook.tests;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import static java.lang.System.out;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
                    .build();
    try {
      sessionFactory =
              new MetadataSources(registry)
                      .addAnnotatedClass(ContactData.class)
                      .buildMetadata()
                      .buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we
      // had trouble building the SessionFactory so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test
  public void testHbConnection() {
//    sessionFactory.inTransaction(session -> {
//      session.createSelectionQuery("from GroupData", GroupData.class)
//              .getResultList()
//              .forEach(group -> out.println("Group id (" + group.getId()
//                      + ") : Name (" + group.getName() + ") : Header (" + group.getHeader() + ") : Footer (" + group.getFooter()  + ")"));
//    });
    sessionFactory.inTransaction(session -> {
      session.createSelectionQuery("from ContactData where deprecated is null", ContactData.class)
              .getResultList()
              .forEach(contact -> out.println("Contact id (" + contact.getId()
                      + ") : LastName (" + contact.getLastname() + ") : Firstname (" + contact.getFirstname()
                      + ") : HomePhone (" + contact.getHomePhone() + ") : MobilePhone (" + contact.getMobilePhone()
                      + ") : WorkPhone (" + contact.getWorkPhone()
                      + ") : Photo (" + contact.getPhoto()
                      + ")"));
    });
  }

}

