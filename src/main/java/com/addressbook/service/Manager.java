package com.addressbook.service;

import com.addressbook.exception.AddressBookException;
import com.addressbook.model.Person;

public interface Manager {

    boolean addPerson(Person person, String filePath) throws AddressBookException;

    boolean editPerson(Person person, String mobileNumber) throws AddressBookException;

    boolean deletePerson(String mobileNumber) throws AddressBookException;

    boolean sortingAddressBook(String sortingFieldName) throws AddressBookException;

    boolean printingAddressBook() throws AddressBookException;

    boolean createEmptyFile(String fileName) throws AddressBookException;

    boolean openingExistingFile(String fileName);

    boolean saveAddressBook(String fileName);

    boolean saveAsAddressBook(String oldName, String newName);


}
