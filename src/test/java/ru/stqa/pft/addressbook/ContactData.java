package ru.stqa.pft.addressbook;

public record ContactData(String firstName, String lastName, String company, String address, String phoneNumber,
                          String eMail) {
}