package FitnessManager;

public enum Location {
    BRIDGEWATER ("Bridgewater", "08807", "Somerset County", "3"),
    EDISON("Edison", "08837", "Middlesex County", "1"),

    FRANKLIN("Franklin", "08873", "Somerset County", "4"),
    PISCATAWAY("Piscataway", "08854", "Middlesex County", "2"),
    SOMERVILLE("Somerville", "08876", "Somerset County", "5"),
    NA("NA", "NA", "NA", "6");
    private final String township;
    private final String zipcode;
    private final String county;
    private final int rank;

    public String getTownship() {
        return township;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCounty() {
        return county;
    }
    public int getRank() {return rank; }

    Location(String township, String zipcode, String county, String rank){
        this.township = township;
        this.zipcode = zipcode;
        this.county = county;
        this.rank = Integer.parseInt(rank);
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
