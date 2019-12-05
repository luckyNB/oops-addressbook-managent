package com.addressbook;

import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.service.AddressBookManager;
import com.addressbook.service.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JUnitAddressBookTestClass {
    Manager manager = new AddressBookManager();

    @Test
    public void givenPersonInFo_When_WrittenToJson_Should_ReturnTrue() {
        Address address = new Address("Nanded", "431513", "MH");
        Person person = new Person("Sapna", "ABC", address, "7030493048");
        Manager manager = new AddressBookManager();
        boolean result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
        Assert.assertEquals(true, result);

    }

    @Test
    public void givenPersonInFoFile_When_ReadToJson_Should_ReturnTrue() throws IOException {
        boolean result=manager.editPerson();

    }
}
