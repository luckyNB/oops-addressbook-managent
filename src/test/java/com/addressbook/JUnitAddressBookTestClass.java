package com.addressbook;

import com.addressbook.model.Address;
import com.addressbook.model.Person;
import com.addressbook.service.AddressBookManager;
import com.addressbook.service.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class JUnitAddressBookTestClass {
    Manager manager = new AddressBookManager();

    @Test
    public void givenPersonInFo_When_WrittenToJson_Should_ReturnTrue() throws FileNotFoundException {
        Address address = new Address("Satara  ", "758586", "Maharashtra");
        Person person = new Person("Rohit", "Ghorpade", address, "888881646535");
        boolean result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonInfo_When_EdittedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        Address address = new Address("A'Bad", "098765434", "RJ");
        Person person = new Person("Vijay", "Salaskar", address, "784544551258");
        boolean result = manager.editPerson(person, "784544551258");
        Assert.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenPresent_Should_RemoveFromAddressBook() throws FileNotFoundException {
        boolean result = manager.deletePerson("795465621645");
        Assert.assertTrue(result);
    }
}
