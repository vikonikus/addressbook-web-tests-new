package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String lastname;
  private String firstname;
//  private String company;
//  private String address;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
//  private String email;
//  private String group;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFirstname() {
    return firstname;
  }

//  public String getCompany() {
//    return company;
//  }
//
//  public String getAddress() {
//    return address;
//  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

//  public String getEmail() {
//    return email;
//  }

//  public String getGroup() {
//    return group;
//  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(lastname, that.lastname)
            && Objects.equals(firstname, that.firstname)
            && Objects.equals(homePhone, that.homePhone)
            && Objects.equals(mobilePhone, that.mobilePhone)
            && Objects.equals(workPhone, that.workPhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastname, firstname, homePhone, mobilePhone, workPhone);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", home='" + homePhone + '\'' +
            ", mobile='" + mobilePhone + '\'' +
            ", work='" + workPhone + '\'' +
            '}';
  }
}
