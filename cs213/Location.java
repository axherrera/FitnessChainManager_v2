package edu.rutges.cs213;

public enum Location {
    Bridgewater ("Bridgewater", "08807", "Somerset County"),
    Edison("Edison", "08837", "Middlesex County"),

    Franklin("Franklin", "08873", "Somerset County"),
    Piscataway("Piscataway", "08854", "Middlesex County"),
    Somerville("Somerville", "08876", "Somerset County");
    private final String township;
    private final String zipcode;
    private final String county;

    public String getTownship() {
        return township;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCounty() {
        return county;
    }

    Location(String township, String zipcode, String county){
        this.township = township;
        this.zipcode = zipcode;
        this.county = county;
    }

    @Override
    public String toString() {
        return township + ", " + zipcode + ", "+ county;
    }

    public static void main(String[] args) {
        Location edison = Location.Edison;
        Location Bridge = Location.Bridgewater;
        Location Frank = Location.Franklin;
        Location Somer = Location.Somerville;
        Location Piscat = Location.Piscataway;
        System.out.println(edison);

    }
}
