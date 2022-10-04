package org.example.service;

import org.example.domain.BetType;
import org.example.domain.Bookmaker;
import org.example.domain.Bookmakers;
import org.example.web.request.BetData;
import org.example.web.response.BetResult;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BetServiceTest {

    private Bookmakers bookmakers = Mockito.mock(Bookmakers.class);

    private BetService betService = new BetService(bookmakers);

    @Test
    void shouldReturnOrderedBookMakersByProfitability(){
        //given
        List<Bookmaker> bookmakerList = List.of(
                new Bookmaker("Bookmaker A", 115, 120),
                new Bookmaker("Bookmaker B", 110, 101));
        Mockito.when(bookmakers.getBookmakers()).thenReturn(bookmakerList);
         List<BetData> betData = List.of( new BetData(BetType.WIN, new BigDecimal("1.00")), new BetData(BetType.PLACE, new BigDecimal("2.10")));

         //when
        List<BetResult> result = betService.calculateProfitability(betData);

        //then
        assertEquals(expected(), result);
    }

    private List<BetResult> expected() {
     return List.of( new BetResult("Bookmaker B", BigDecimal.valueOf(7.463)), new BetResult("Bookmaker A", BigDecimal.valueOf(8.71)));
    }


}