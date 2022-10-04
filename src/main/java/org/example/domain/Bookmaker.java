package org.example.domain;

public class Bookmaker {

    private final String name;
    private final int winPercentage;
    private final int placePercentage;

    public Bookmaker(String name,int winPercentage, int placePercentage) {
        this.winPercentage = winPercentage;
        this.placePercentage = placePercentage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getWinPercentage() {
        return winPercentage;
    }

    public int getPlacePercentage() {
        return placePercentage;
    }

}
