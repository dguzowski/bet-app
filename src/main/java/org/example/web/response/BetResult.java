package org.example.web.response;

import org.springframework.util.comparator.Comparators;

import java.math.BigDecimal;
import java.util.Objects;

public class BetResult implements Comparable<BetResult> {
    private String bookmaker;
    private BigDecimal profitability;

    public BetResult(String bookmaker, BigDecimal profitability) {
        this.bookmaker = bookmaker;
        this.profitability = profitability;
    }

    public String getBookmaker() {
        return bookmaker;
    }

    public BigDecimal getProfitability() {
        return profitability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetResult betResult = (BetResult) o;
        return Objects.equals(bookmaker, betResult.bookmaker) && Objects.equals(profitability, betResult.profitability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookmaker, profitability);
    }

    @Override
    public int compareTo(BetResult o) {
        return profitability.compareTo(o.profitability);
    }

    @Override
    public String toString() {
        return "BetResult{" +
                "bookmaker='" + bookmaker + '\'' +
                ", profitability=" + profitability +
                '}';
    }
}
