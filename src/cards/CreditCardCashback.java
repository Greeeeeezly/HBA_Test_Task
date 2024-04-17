package cards;

import info.CreditCardCashbackInfo;
import java.math.BigDecimal;
//Cashback 1% for all purchases and 5% for purchases from 5000
public class CreditCardCashback extends CreditCard{
    private static final BigDecimal CASHBACK_PERCENT=BigDecimal.ONE;
    private static final BigDecimal INCREASED_CASHBACK_MIN_AMOUNT=new BigDecimal("5000");
    private static final BigDecimal INCREASED_CASHBACK=new BigDecimal("5");

    private BigDecimal cashback=BigDecimal.ZERO;

    public CreditCardCashback(BigDecimal credit_limit) {
        super(credit_limit);
    }

    @Override
    public boolean pay(BigDecimal payment) {
        if (balance.compareTo(payment) >= 0) {
            if (payment.compareTo(INCREASED_CASHBACK_MIN_AMOUNT) >= 0) {
                cashback = cashback.add(payment.multiply(INCREASED_CASHBACK.divide(new BigDecimal("100"))));
            } else {
                cashback = cashback.add(payment.multiply(CASHBACK_PERCENT.divide(new BigDecimal("100"))));
            }
            return super.pay(payment);
        }
        return false;
    }


    @Override
    public Object getInfo() {
        return new CreditCardCashbackInfo(balance,creditLimit,creditFunds,ownFunds,cashback);
    }
}
