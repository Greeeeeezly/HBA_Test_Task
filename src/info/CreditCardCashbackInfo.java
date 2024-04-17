package info;

import java.math.BigDecimal;

public class CreditCardCashbackInfo extends CreditCardInfo{
    private final BigDecimal cashback;

    public CreditCardCashbackInfo(BigDecimal balance, BigDecimal creditLimit, BigDecimal creditFunds, BigDecimal ownFunds, BigDecimal cashback) {
        super(balance, creditLimit, creditFunds, ownFunds);
        this.cashback = cashback;

    }

    @Override
    public String toString() {
        return "Cashback=" + cashback +
                ", Balance=" + balance +
                ", CreditLimit=" + creditLimit +
                ", CreditFunds=" + creditFunds +
                ", OwnFunds=" + ownFunds +
                '}';
    }
}
