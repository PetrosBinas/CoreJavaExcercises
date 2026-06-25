package bank_app_mysql.bank_app.core.exceptions;

public class AccountNotFoundException extends Exception {

    public AccountNotFoundException(String message) {
        super(message);
    }
}