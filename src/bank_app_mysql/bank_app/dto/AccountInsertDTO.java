package bank_app_mysql.bank_app.dto;

import java.math.BigDecimal;

public record AccountInsertDTO(String iban, BigDecimal balance) {

    //    public static AccountInsertDTO empty() {
//        return new AccountInsertDTO("", BigDecimal.ZERO);
//    }
    public AccountInsertDTO() {
        this("", BigDecimal.ZERO);
    }
}