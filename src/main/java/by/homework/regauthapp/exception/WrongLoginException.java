package by.homework.regauthapp.exception;

/**
 * Created by Сергей Зубов on 11.04.2019.
 */
public class WrongLoginException extends Exception{
    public WrongLoginException(String message) {
        super(message);
    }
}
