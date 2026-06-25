package bank_app_mysql.bank_app.core.exceptions;

public class NegativeAmountException extends Exception {

  public NegativeAmountException(String message) {
    super(message);
  }
}