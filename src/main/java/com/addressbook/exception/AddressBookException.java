package com.addressbook.exception;

public class AddressBookException extends Exception {

    ExceptionType type;
    private String message;

    public AddressBookException(String message) {
        super(message);

    }
    enum ExceptionType {
        NO_SUCH_FILE, WRONG_DATA_FORMAT, WRONG_FILE_TYPE
    }
}
