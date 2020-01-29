package nl.cge.jakartaee8.transakties.control;

import javax.ejb.ApplicationException;

@ApplicationException
public class InvalidTransaktiebestandException extends RuntimeException {

    public InvalidTransaktiebestandException(String msg) {
        super(msg);
    }
}
