package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.File;
import java.util.Date;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(firstEmail, that.firstEmail);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", firstEmail='" + firstEmail + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastname, firstname, address, homePhone, firstEmail);
  }

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Expose
  @Column(name = "deprecated")
  private Date deprecated;

  public Date getDeprecated() {
    return deprecated;
  }

  @Expose
  @Column(name = "firstname")
  private String firstname;
  //  private String company;

  @Expose
  @Column(name = "address")
  private String address;

  @Expose
  @Column(name = "home")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  private String mobilePhone;

  @Expose
  @Column(name = "work")
  private String workPhone;

  @Expose
  @Column(name = "email")
  private String firstEmail;

  @Expose
  @Column(name = "email2")
  private String secondEmail;

  @Expose
  @Column(name = "email3")
  private String thirdEmail;

  @Transient
  private String group;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Transient
  private String allEmails;

  @Expose
  @Transient
//  @Column(name = "photo")
  private String photo; // не работает для перевода в json поэтому коменчены все поля с photo

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getFirstEmail() {
    return firstEmail;
  }

  public String getSecondEmail() {
    return secondEmail;
  }

  public String getThirdEmail() {
    return thirdEmail;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

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

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withFirstEmail(String firstEmail) {
    this.firstEmail = firstEmail;
    return this;
  }

  public ContactData withSecondEmail(String secondEmail) {
    this.secondEmail = secondEmail;
    return this;
  }

  public ContactData withThirdEmail(String thirdEmail) {
    this.thirdEmail = thirdEmail;
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
  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getGroup() {
    return group;
  }

}
