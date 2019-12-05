package com.addressbook;

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

        Person person = new Person("Tushar", "Raj", "1030493048", "Osmnanabad", "8552", "MH");

        boolean result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonInfo_When_EdittedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        Person person = new Person("Raja", "Bhosale", "885956585", "Nanded", "123123", "MH");

        boolean result = manager.editPerson(person, "784544551258");
        Assert.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenPresent_Should_RemoveFromAddressBook() throws FileNotFoundException {
        boolean result = manager.deletePerson("795465621645");
        Assert.assertTrue(result);
    }

    @Test
    public void givenSortingFieldParameter_AsFirstName_WhenSortedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        boolean result = manager.sortingAddressBook("firstName");
        Assert.assertTrue(result);
    }

    @Test
    public void givenSortingFieldParameter_AsZIPCode_WhenSortedSuccessfully_Should_ReturnTrue() throws FileNotFoundException {
        boolean result = manager.sortingAddressBook("zip");
        Assert.assertTrue(true);
    }
}
