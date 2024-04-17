package info;

import java.math.BigDecimal;

public class DebitCardInfo {
    protected final BigDecimal balance;

    public DebitCardInfo(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance=" + balance;
    }
}
