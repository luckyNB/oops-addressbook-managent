package com.addressbook.service;

import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.util.Utility;

public class AddressBookManager implements Manager {
    @Override
    public void addPerson() {
        String firstName = Utility.getStringValue("Enter FirstName:");
        String lastName = Utility.getStringValue("Enter LastName:");
        String phoneNumber = Utility.getStringValue("Enter phoneNumber:");
        String zip = Utility.getStringValue("Enter ZIP Code:");
        String city = Utility.getStringValue("Enter City:");
        String state = Utility.getStringValue("Enter state:");
        Address address = new Address(city, zip, state);
        Person newPerson = new Person(firstName, lastName, address, phoneNumber);
        Utility.writingStateCensusDataIntoJsonFile(newPerson,
                "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");

    }
}
