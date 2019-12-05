package com.addressbook.main;

import com.addressbook.service.AddressBookManager;
import com.addressbook.service.Manager;

public class AddressBookManagement {


    public static void main(String[] args) {
        Manager manager = new AddressBookManager();
        manager.addPerson();
    }
}
