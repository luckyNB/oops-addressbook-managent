package com.addressbook.service;

import com.addressbook.model.Person;
import com.google.gson.stream.MalformedJsonException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Manager {

    boolean addPerson(Person person,String filePath) throws FileNotFoundException;
    boolean editPerson() throws IOException;
    void readAllPersons() throws FileNotFoundException, MalformedJsonException;


}
