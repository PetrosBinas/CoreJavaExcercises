package bank_app_mysql.bank_app.service;

import bank_app_mysql.bank_app.core.exceptions.AccountNotFoundException;
import bank_app_mysql.bank_app.core.exceptions.InsufficientBalanceException;
import bank_app_mysql.bank_app.core.exceptions.NegativeAmountException;
import bank_app_mysql.bank_app.dto.AccountDepositDTO;
import bank_app_mysql.bank_app.dto.AccountInsertDTO;
import bank_app_mysql.bank_app.dto.AccountReadOnlyDTO;
import bank_app_mysql.bank_app.dto.AccountWithdrawDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {

    AccountReadOnlyDTO createNewAccount(AccountInsertDTO accountInsertDTO)
            throws NegativeAmountException;

    void deposit(AccountDepositDTO accountDepositDTO)
            throws AccountNotFoundException, NegativeAmountException;

    void withdraw(AccountWithdrawDTO accountWithdrawDTO)
            throws AccountNotFoundException, InsufficientBalanceException;

    BigDecimal getBalance(String iban) throws AccountNotFoundException;

    List<AccountReadOnlyDTO> getAllAccounts();
}


