package com.example.franck.fintechhomework.ThirdPoint;

import java.math.BigDecimal;

/**
 * Created by Franck on 05.11.2017.
 */

public class MoneyAmount {
    private BigDecimal money_amount;

    public BigDecimal getMoney_amount() {
        return money_amount;
    }

    public void setMoney_amount(BigDecimal money_amount) {
        this.money_amount = money_amount;
    }

    @Override
    public String toString() {
        return "MoneyAmount [money" + money_amount + "]";
    }
}
