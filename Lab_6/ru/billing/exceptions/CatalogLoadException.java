package ru.billing.exceptions;

public class CatalogLoadException extends Exception {
    public CatalogLoadException(String message) {
        super(message);
    }

    public CatalogLoadException(ItemAlreadyExistsException message) {
        super(message);
    }
}
