package com.addressbook.service;

import com.addressbook.model.Person;
import com.addressbook.util.Utility;

import java.io.IOException;

public class AddressBookManager implements Manager {
    @Override
    public boolean addPerson(Person person, String path) {

        Utility.writingPersonDetailsIntoJsonFile(person,
                path);
        return true;
    }

    @Override
    public boolean editPerson() throws IOException {
        Utility.readingJsonFile();
        return true;
    }

}
