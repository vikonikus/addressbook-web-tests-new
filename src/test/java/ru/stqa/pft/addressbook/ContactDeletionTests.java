package ru.stqa.pft.addressbook;

import org.testng.annotations.*;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletionTests() throws Exception {
    gotoMainPage();
    selectContact();
    deleteSelectedContact();
    submitDeletionContact();
  }


}
