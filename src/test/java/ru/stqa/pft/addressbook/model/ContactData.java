package ru.stqa.pft.addressbook.model;

public record ContactData(String firstName, String lastName, String company, String address, String phoneNumber,
                          String eMail, String group) {
}