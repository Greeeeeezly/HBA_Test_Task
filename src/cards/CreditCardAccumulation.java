package cards;

import java.math.BigDecimal;
//Accumulation with topUp 5%
public class CreditCardAccumulation extends CreditCard{
    final static BigDecimal ACCUMULATION_PERCENT = new BigDecimal("0.5");
    public CreditCardAccumulation(BigDecimal credit_limit) {
        super(credit_limit);
    }

    @Override
    public void topUp(BigDecimal amount) {
        super.topUp(amount);
        BigDecimal accumulation = amount.multiply(ACCUMULATION_PERCENT.divide(new BigDecimal("100")));
        balance=balance.add(accumulation);
        ownFunds=ownFunds.add(accumulation);
    }

}
