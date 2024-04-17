package cards;
import info.CreditCardInfo;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditCard extends BankCard{
    protected final BigDecimal creditLimit;
    protected BigDecimal creditFunds;
    protected BigDecimal ownFunds;

    @Override
    public void topUp(BigDecimal amount) {
        //Хотел добавить scale Rounding mode к amount, чтобы ограничить пополнение 2 знаками после запятой, но он не импортируется из-за версии старой Intellij Idea.
        if(Objects.equals(creditFunds, creditLimit)){
            ownFunds=ownFunds.add(amount);
            balance=balance.add(amount);
        }
        else if(creditFunds.add(amount).compareTo(creditLimit)<=0){
                creditFunds=creditFunds.add(amount);
            }
        else {
            BigDecimal debt=creditLimit.subtract(creditFunds);
            BigDecimal remainingFunds=debt.add(amount);
            creditFunds=creditFunds.add(debt);
            ownFunds=ownFunds.add(remainingFunds);
            balance=balance.add(remainingFunds);
        }
    }

    @Override
    public boolean pay(BigDecimal payment) {
        if (payment.compareTo(balance) > 0) {
            System.out.println("Insufficient funds");
            return false;
        } else if (ownFunds.compareTo(payment) >= 0) {
            balance = balance.subtract(payment);
            ownFunds = ownFunds.subtract(payment);
            return true;
        } else {
            BigDecimal remainingPayment = payment.subtract(ownFunds);
            ownFunds = BigDecimal.ZERO;
            creditFunds = creditFunds.subtract(remainingPayment);
            return true;
        }
    }


    @Override
    public Object getInfo() {
        return new CreditCardInfo(balance, creditLimit, creditFunds, ownFunds);
    }


    public CreditCard(BigDecimal credit_limit) {
        this.creditLimit = credit_limit;
        creditFunds = credit_limit;
        balance = getBalance().add(credit_limit);
        ownFunds = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return  "CreditLimit=" + creditLimit +
                ", CreditFunds=" + creditFunds +
                ", OwnFunds=" + ownFunds +
                ", Balance=" + balance;
    }
}
