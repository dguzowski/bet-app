package org.example.web;

import org.example.service.BetService;
import org.example.web.request.BetData;
import org.example.web.response.BetResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BetController {

    private final BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @GetMapping("/bet/results")
    public List<BetResult> getResults(@RequestBody List<BetData> betData){
        return betService.calculateProfitability(betData);
    }
}
