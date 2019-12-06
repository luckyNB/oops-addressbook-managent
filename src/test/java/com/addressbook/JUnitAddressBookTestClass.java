package com.addressbook;

import com.addressbook.exception.AddressBookException;
import com.addressbook.model.Person;
import com.addressbook.service.AddressBookManager;
import com.addressbook.util.Utility;
import org.junit.Assert;
import org.junit.Test;

public class JUnitAddressBookTestClass {
    AddressBookManager manager = new AddressBookManager();

    @Test
    public void givenPersonInFo_When_WrittenToJson_Should_ReturnTrue() {
        try {
            Person person = new Person("Ravy", "DADADDAD", "5345345", "New York", "2525254", "SL");
            boolean result = false;

            result = manager.addPerson(person, "/home/admin1/IdeaProjects/oops-addressbook-mgmt/src/main/resources/Person.json");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            Assert.assertEquals("Person validation error", e.getMessage());
        }
    }

    @Test
    public void givenPersonInfo_When_EdittedSuccessfullyBasedUponMobileNumber_Should_ReturnTrue() {
        try {
            Person person = new Person("", "Bhosale", "885956585", "Nanded", "123123", "MH");
            boolean result = manager.editPerson(person, "5345345");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            Assert.assertEquals("Person validation error", e.getMessage());
        }
    }

    @Test
    public void givenMobileNumberAndPersonInfo_If_MobileNumberDoesNotExistsForEdit_Should_ThrowAddressBookException() {
        try {
            Person person = new Person("Laxman", "Raaj", "7030493048", "Tokyo", "462752", "Japan");
            boolean result = manager.editPerson(person, "8855844149");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            Assert.assertEquals("Persons Details unavailable", e.getMessage());
        }

    }

    @Test
    public void givenMobileNumber_WhenPresent_Should_RemoveFromAddressBook() {
        try {
            boolean result = manager.deletePerson("7030493048");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMobileNumer_IfDoesNotPresentInAddressBook_Should_ThrowAddressBookException() {
        try {
            boolean result = manager.deletePerson("1234567893");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            Assert.assertEquals("Person does not exists to delete", e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void givenSortingFieldParameter_AsFirstName_WhenSortedSuccessfully_Should_ReturnTrue() {
        try {
            boolean result = manager.sortingAddressBook("firstName");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSortingFieldParameter_AsZIPCode_WhenSortedSuccessfully_Should_ReturnTrue() {
        try {
            boolean result = manager.sortingAddressBook("zip");
            Assert.assertTrue(true);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfAddressBook_When_PrintedSuccessfully_Should_ReturnTrue() {

        boolean result = manager.printingAddressBook();
        Assert.assertTrue(result);

    }

    @Test
    public void givenFileName_WhenCreatedSuccessfully_Should_ReturnTrue() {
        try {
            boolean result = manager.createEmptyFile("Raja");
            Assert.assertTrue(result);
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileName_WhenExist_Should_Open_And_ReturnTrue() {
        boolean result = manager.openingExistingFile("Person.json");
        Assert.assertTrue(result);
    }

    @Test
    public void givenFileName_When_OpenedAndEditedBeAbleToSave_Should_ReturnTrue() {
        boolean result = manager.saveAddressBook(Utility.resourcePath + "Laxman.json");
        Assert.assertTrue(true);
    }

    @Test
    public void givenFileName_When_OpenedAndEdited_Should_BeAble_SaveAsWithNewName_Return_True() {
        boolean result = manager.saveAsAddressBook("Lucky.json", "Avi");
        Assert.assertTrue(result);
    }
}
