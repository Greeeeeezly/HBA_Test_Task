package info;

import java.math.BigDecimal;

public class CreditCardInfo {
    protected final BigDecimal balance;
    protected final BigDecimal creditLimit;
    protected final BigDecimal creditFunds;
    protected final BigDecimal ownFunds;

    public CreditCardInfo(BigDecimal balance, BigDecimal creditLimit, BigDecimal creditFunds, BigDecimal ownFunds) {
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.creditFunds = creditFunds;
        this.ownFunds = ownFunds;
    }

    @Override
    public String toString() {
        return  "Balance=" + balance +
                ", CreditLimit=" + creditLimit +
                ", CreditFunds=" + creditFunds +
                ", OwnFunds=" + ownFunds;
    }

}
