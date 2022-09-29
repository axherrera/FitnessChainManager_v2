package FitnessManager;

public enum Location {
    BRIDGEWATER ("Bridgewater", "08807", "Somerset County"),
    EDISON("Edison", "08837", "Middlesex County"),

    FRANKLIN("Franklin", "08873", "Somerset County"),
    PISCATAWAY("Piscataway", "08854", "Middlesex County"),
    SOMERVILLE("Somerville", "08876", "Somerset County"),
    NA("NA", "NA", "NA");
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
        Location edison = Location.EDISON;
        Location Bridge = Location.BRIDGEWATER;
        Location Frank = Location.FRANKLIN;
        Location Somer = Location.SOMERVILLE;
        Location Piscat = Location.PISCATAWAY;
        System.out.println(edison);

    }
}
