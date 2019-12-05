package com.addressbook;

import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.service.AddressBookManager;
import com.addressbook.service.Manager;
import com.google.gson.stream.MalformedJsonException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JUnitAddressBookTestClass {
    Manager manager = new AddressBookManager();

    @Test
    public void givenPersonInFo_When_WrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Address address = new Address("pune  ", "100030", "MB");
        Person person = new Person("dta", "sao", address, "795465621645");
        Manager manager = new AddressBookManager();
        boolean result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }


}
