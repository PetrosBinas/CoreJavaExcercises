package bank_app_mysql.bank_app.core.mapper;

import bank_app_mysql.bank_app.dto.AccountInsertDTO;
import bank_app_mysql.bank_app.dto.AccountReadOnlyDTO;
import bank_app_mysql.bank_app.model.Account;

public class Mapper {

    /**
     * No instances of this class should be available.
     */
    private Mapper() {}

    public static Account mapToModelEntity(AccountInsertDTO insertDTO) {
        return new Account(insertDTO.iban(), insertDTO.balance());
    }

    public static AccountReadOnlyDTO mapToReadOnlyDTO(Account account) {
        return new AccountReadOnlyDTO(account.getIban(), account.getBalance());
    }
}