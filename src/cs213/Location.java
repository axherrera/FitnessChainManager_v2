package edu.rutges.cs213;

public class Location implements javax.xml.stream.Location {
    private String township;
    private String zipcode;
    private String country;

    /***
     * Constructor
     * @param township
     * @param zipcode
     * @param country
     */
    public Location(String township, String zipcode, String country) {
        this.township = township;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return this.getTownship() + ", " + this.getZipcode() + ", " + this.getCountry();
    }

    @Override
    public int getLineNumber() {
        return 0;
    }

    @Override
    public int getColumnNumber() {
        return 0;
    }

    @Override
    public int getCharacterOffset() {
        return 0;
    }

    @Override
    public String getPublicId() {
        return null;
    }

    @Override
    public String getSystemId() {
        return null;
    }

    public static void main(String[] args) {
        Location l = new Location("Edison", "08619", "Middlesex");
        System.out.println(l.toString());
    }
}
