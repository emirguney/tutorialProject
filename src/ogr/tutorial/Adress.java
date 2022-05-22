package ogr.tutorial;

public class Adress {
    private int id;
    private String city;
    private String country;
    private String Street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    @Override
    public String toString() {
        return "id:" + getId() + ", city: " + getCity() + ",country: " + getCountry() + ",street: " + getStreet();
    }
}
