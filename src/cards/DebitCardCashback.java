package cards;

import info.DebitCardCashbackInfo;
import info.DebitCardInfo;
import java.math.BigDecimal;
//Cashback 1000 for total expenses from 10000
public class DebitCardCashback extends DebitCard {
    private static final BigDecimal CASHBACK_THRESHOLD = new BigDecimal("10000");
    private static final BigDecimal CASHBACK_AMOUNT = new BigDecimal("1000");

    private BigDecimal cashback=BigDecimal.ZERO;

    private BigDecimal totalSpent = BigDecimal.ZERO;

    @Override
    public void topUp(BigDecimal amount) {
        balance = balance.add(amount);
    }

    @Override
    public boolean pay(BigDecimal payment) {
        if (payment.compareTo(balance) >= 0) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            balance = balance.subtract(payment);
            totalSpent = totalSpent.add(payment);
            if (totalSpent.compareTo(CASHBACK_THRESHOLD) >= 0) {
                cashback = cashback.add(CASHBACK_AMOUNT);
                totalSpent = BigDecimal.ZERO;
            }
            return true;
        }
    }

    @Override
    public Object getInfo() {
        return new DebitCardCashbackInfo(balance, cashback);
    }
}
