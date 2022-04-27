package model;

public class TravelAgency extends Travel{
    public String name;

    public TravelAgency(String name) {
        super();
        this.name=name;
    }

    public TravelAgency(Country country, int duration_in_days, TravelType type, boolean in_stock, int price_in_uah) {
        super(country, duration_in_days, type, in_stock, price_in_uah);
    }

}
