package model;

public class Travel {
    public Country country;
    public int durationInDays;
    public TravelType type;
    public boolean inStock;
    public int priceInUah;

    public Travel(Country country, int durationInDays, TravelType type, boolean inStock, int priceInUah) {
        this.country=country;
        this.durationInDays = durationInDays;
        this.type=type;
        this.inStock = inStock;
        this.priceInUah = priceInUah;
    }

    public Travel() {

    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public TravelType getType() {
        return type;
    }

    public int getPriceInUah() {
        return priceInUah;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "country=" + country +
                ", duration_in_days=" + durationInDays +
                ", type=" + type +
                ", in_stock=" + inStock +
                ", price_in_uah=" + priceInUah +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Travel travel = (Travel) o;

        if (durationInDays != travel.durationInDays) return false;
        if (inStock != travel.inStock) return false;
        if (priceInUah != travel.priceInUah) return false;
        if (country != travel.country) return false;
        return type == travel.type;
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + durationInDays;
        result = 31 * result + type.hashCode();
        result = 31 * result + (inStock ? 1 : 0);
        result = 31 * result + priceInUah;
        return result;
    }

    public String getHeaders(){
        return "Country" + "," + "duration" + "," + "type" + "," + "inStock" + "," + "price";
    }

    public String toCSV(){
        return country + "," + durationInDays + "," + type+ "," + inStock + "," + priceInUah;
    }
}
