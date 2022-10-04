package org.example.web.request;

import org.example.domain.BetType;

import java.math.BigDecimal;

public class BetData {

    private BetType type;

    private BigDecimal amount;

    public BetData(BetType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    public BetType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
