package info;


import java.math.BigDecimal;

public class DebitCardCashbackInfo extends DebitCardInfo {
    private final BigDecimal cashback;

    public DebitCardCashbackInfo(BigDecimal balance, BigDecimal cashback) {
        super(balance);
        this.cashback = cashback;
    }

    @Override
    public String toString() {
        return  "Cashback=" + cashback +
                ", Balance=" + balance +
                '}';
    }
}
