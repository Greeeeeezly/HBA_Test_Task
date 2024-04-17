package cards;

import java.math.BigDecimal;

public abstract class BankCard {
    protected BigDecimal balance=new BigDecimal("0.00");

    public abstract void topUp(BigDecimal amount);

    public abstract boolean pay(BigDecimal payment);
    public BigDecimal getBalance() {
        return balance;
    }
    public abstract Object getInfo();
}
