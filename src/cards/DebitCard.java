package cards;

import info.DebitCardInfo;

import java.math.BigDecimal;

public class DebitCard extends BankCard{

    @Override
    public void topUp(BigDecimal amount) {
        //Хотел добавить scale Rounding mode к amount, чтобы ограничить пополнение 2 знаками после запятой, но он не импортируется из-за версии старой Intellij Idea.
        balance=balance.add(amount);
    }

    @Override
    public boolean pay(BigDecimal payment) {
        if(payment.compareTo(balance)>0){
            System.out.println("Insufficient funds");
            return false;
        }
        else
            balance=balance.subtract(payment);
            return true;
    }

    @Override
    public Object getInfo() {
        return new DebitCardInfo(balance);
    }
}
