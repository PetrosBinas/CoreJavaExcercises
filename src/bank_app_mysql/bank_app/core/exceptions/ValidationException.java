package bank_app_mysql.bank_app.core.exceptions;

public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }
}