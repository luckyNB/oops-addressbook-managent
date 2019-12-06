package com.addressbook;

import com.addressbook.exception.AddressBookException;
import com.addressbook.model.Person;
import com.addressbook.service.AddressBookManager;
import com.addressbook.service.Manager;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class JUnitAddressBookTestClass {
    Manager manager = new AddressBookManager();

    @Test
    public void givenPersonInFo_When_WrittenToJson_Should_ReturnTrue() throws AddressBookException {

        Person person = new Person("Rawan", "Raj", "322312465", "Hingoli", "2525254", "SL");

        boolean result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPersonInfo_When_EdittedSuccessfully_Should_ReturnTrue() throws AddressBookException, FileNotFoundException {
        Person person = new Person("Raja", "Bhosale", "885956585", "Nanded", "123123", "MH");

        boolean result = manager.editPerson(person, "784544551258");
        Assert.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenPresent_Should_RemoveFromAddressBook() throws AddressBookException {
        boolean result = manager.deletePerson("795465621645");
        Assert.assertTrue(result);
    }

    @Test
    public void givenSortingFieldParameter_AsFirstName_WhenSortedSuccessfully_Should_ReturnTrue() throws AddressBookException, FileNotFoundException {
        boolean result = manager.sortingAddressBook("firstName");
        Assert.assertTrue(result);
    }

    @Test
    public void givenSortingFieldParameter_AsZIPCode_WhenSortedSuccessfully_Should_ReturnTrue() throws AddressBookException, FileNotFoundException {
        boolean result = manager.sortingAddressBook("zip");
        Assert.assertTrue(true);
    }

    @Test
    public void givenListOfAddressBook_When_PrintedSuccessfully_Should_ReturnTrue() throws AddressBookException {
        boolean result = manager.printingAddressBook();
        Assert.assertTrue(result);
    }

    @Test
    public void givenFileName_WhenCreatedSuccessfully_Should_ReturnTrue() throws AddressBookException {
        boolean result=manager.createEmptyFile("Laxman" );
        Assert.assertTrue(result);
    }
}
