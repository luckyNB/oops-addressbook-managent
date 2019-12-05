package com.addressbook.service;

import com.addressbook.model.Person;

import java.io.IOException;

public interface Manager {

    boolean addPerson(Person person,String filePath);
    boolean editPerson() throws IOException;


}
