package com.addressbook.service;

import com.addressbook.model.Person;
import com.addressbook.util.Utility;
import com.google.gson.stream.MalformedJsonException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookManager implements Manager {
    Utility utility;
    {
        try {
            utility = new Utility();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addPerson(Person person, String path) {

        try {
            utility.writingPersonDetailsIntoJsonFile(person
            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void readAllPersons() throws FileNotFoundException, MalformedJsonException {
        utility.readList();

    }

}
