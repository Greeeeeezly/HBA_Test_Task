import cards.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Debit card, topUp 1000 and pay 500");
        BankCard debitCard = new DebitCard();
        debitCard.topUp(new BigDecimal("1000"));
        System.out.println("Debit card balance:"+debitCard.getBalance());
        debitCard.pay(new BigDecimal("500"));
        System.out.println("Debit card info:"+debitCard.getInfo());

        System.out.println("\nCredit card  credit limit 10000, pay 11000,5000 and top up 14000");
        BankCard creditCard = new CreditCard(new BigDecimal("10000"));
        creditCard.pay(new BigDecimal("11000"));
        creditCard.pay(new BigDecimal("5000"));
        System.out.println("Credit card info: "+creditCard.getInfo());
        creditCard.topUp(new BigDecimal("14000"));
        System.out.println("Credit card balance: "+ creditCard.getBalance());
        System.out.println("Credit card info: "+creditCard.getInfo());

        System.out.println("\nCredit card with accumulation topUp 20000");
        cards.BankCard creditCardAccumulation = new cards.CreditCardAccumulation(new BigDecimal("10000"));
        creditCardAccumulation.topUp(new BigDecimal("20000"));
        System.out.println("CreditCardAccumulation getInfo: "+creditCardAccumulation.getInfo());

        System.out.println("\nCredit card with cashback topUp 50000, pay 50000 and topUp 500000");
        BankCard creditCardCashback = new CreditCardCashback(new BigDecimal("10000"));
        creditCardCashback.topUp(new BigDecimal("50000"));
        System.out.println("CreditCardCashback getBalance:" +creditCardCashback.getBalance());
        creditCardCashback.pay(new BigDecimal("50000"));
        System.out.println("CreditCardCashback getInfo:" +creditCardCashback.getInfo());
        creditCardCashback.topUp(new BigDecimal("500000"));
        System.out.println("CreditCardCashback getInfo:" +creditCardCashback.getInfo());

        System.out.println("\nDebitCardWithCashback top up 11000, pay 9000 and pay 1500");
        BankCard debitCardCashback = new DebitCardCashback();
        debitCardCashback.topUp(new BigDecimal("11000"));
        System.out.println("DebitCardWithCashback balance:" + debitCardCashback.getBalance());
        debitCardCashback.pay(new BigDecimal("9000"));
        System.out.println("DebitCardWithCashback balance:" + debitCardCashback.getInfo());
        debitCardCashback.pay(new BigDecimal("1500"));
        System.out.println("DebitCardWithCashback balance:" + debitCardCashback.getInfo());
    }
}
