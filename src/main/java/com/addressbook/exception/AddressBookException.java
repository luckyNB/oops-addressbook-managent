package com.addressbook.exception;

public class AddressBookException extends Exception {

    ExceptionType type;
    private String message;

    public AddressBookException(String message) {
        super(message);

    }

    public AddressBookException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

    public AddressBookException(String message, String message1, ExceptionType type) {
        super(message);
        this.message = message1;
        this.type = type;
    }

    public AddressBookException(String message, Throwable cause, String message1, ExceptionType type) {
        super(message, cause);
        this.message = message1;
        this.type = type;
    }

    public AddressBookException(Throwable cause, String message, ExceptionType type) {
        super(cause);
        this.message = message;
        this.type = type;
    }

    public AddressBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, ExceptionType type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.type = type;
    }

    enum ExceptionType {
        NO_SUCH_FILE, WRONG_DATA_FORMAT, WRONG_FILE_TYPE
    }
}
