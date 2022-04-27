package model;

public class Travel {
    public Country country;
    public int duration_in_days;
    public TravelType type;
    public boolean in_stock;
    public int price_in_uah;

    public Travel(Country country, int duration_in_days, TravelType type, boolean in_stock, int price_in_uah) {
        this.country=country;
        this.duration_in_days=duration_in_days;
        this.type=type;
        this.in_stock=in_stock;
        this.price_in_uah=price_in_uah;
    }

    public Travel() {

    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getDuration_in_days() {
        return duration_in_days;
    }

    public void setDuration_in_days(int duration_in_days) {
        this.duration_in_days = duration_in_days;
    }

    public TravelType getType() {
        return type;
    }

    public void setType(TravelType type) {
        this.type = type;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public int getPrice_in_uah() {
        return price_in_uah;
    }

    public void setPrice_in_uah(int price_in_uah) {
        this.price_in_uah = price_in_uah;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "country=" + country +
                ", duration_in_days=" + duration_in_days +
                ", type=" + type +
                ", in_stock=" + in_stock +
                ", price_in_uah=" + price_in_uah +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Travel travel = (Travel) o;

        if (duration_in_days != travel.duration_in_days) return false;
        if (in_stock != travel.in_stock) return false;
        if (price_in_uah != travel.price_in_uah) return false;
        if (country != travel.country) return false;
        return type == travel.type;
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + duration_in_days;
        result = 31 * result + type.hashCode();
        result = 31 * result + (in_stock ? 1 : 0);
        result = 31 * result + price_in_uah;
        return result;
    }

    public String getHeaders(){
        return "Country" + "," + "duration" + "," + "type" + "," + "inStock" + "," + "price";
    }

    public String toCSV(){
        return country + "," + duration_in_days+ "," + type+ "," + in_stock+ "," + price_in_uah;
    }



}
