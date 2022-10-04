package org.example.service;

import org.example.domain.BetType;
import org.example.domain.Bookmaker;
import org.example.domain.Bookmakers;
import org.example.web.request.BetData;
import org.example.web.response.BetResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetService {

    private final Bookmakers bookmakers;

    public BetService(Bookmakers bookmakers) {
        this.bookmakers = bookmakers;
    }

    public List<BetResult> calculateProfitability(List<BetData> betData) {
        return bookmakers.getBookmakers()
                .stream()
                .map(b -> {
                    if (betData.size() == 1) {
                        return calculateByBetType(betData.get(0), b);
                    }
                    BetData first = betData.get(0);
                    BetData second = betData.get(1);
                    BetResult firstResult = calculateByBetType(first, b);
                    BetResult secondResult = calculateByBetType(second, b);
                    return calculateCompound(first.getType(), firstResult, secondResult);
                })
                .collect(Collectors.toList());
    }

    private BetResult calculateByBetType(BetData betData, Bookmaker bookmaker) {
        if (betData.getType() == BetType.WIN) {
            return new BetResult(bookmaker.getName(), betData.getAmount().multiply(BigDecimal.valueOf(bookmaker.getWinPercentage())).divide(BigDecimal.valueOf(100)));
        }
        return new BetResult(bookmaker.getName(), betData.getAmount().multiply(BigDecimal.valueOf(bookmaker.getPlacePercentage())).divide(BigDecimal.valueOf(100)));
    }

    private BetResult calculateCompound(BetType type, BetResult firstResult, BetResult secondResult) {
        if (type == BetType.WIN) {
            return new BetResult(firstResult.getBookmaker(), firstResult.getProfitability().add(secondResult.getProfitability().multiply(BigDecimal.valueOf(3))));
        }
        return new BetResult(firstResult.getBookmaker(), secondResult.getProfitability().add(firstResult.getProfitability().multiply(BigDecimal.valueOf(3))));
    }
}
