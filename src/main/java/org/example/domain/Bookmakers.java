package org.example.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bookmakers {

    private List<Bookmaker> bookmakers = initializeBookmakers();

    private List<Bookmaker> initializeBookmakers() {
        List<Bookmaker> bookmakers = new ArrayList<>();
        bookmakers.add(new Bookmaker("Bookmaker A", 115, 120));
        bookmakers.add(new Bookmaker("Bookmaker B", 110, 101));
        return bookmakers;
    }

    private Bookmakers() {
    }

    public List<Bookmaker> getBookmakers() {
        return bookmakers;
    }
}
