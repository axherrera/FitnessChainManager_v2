package cs213;

public enum Location{
    PISCATAWAY("pistcataway", "08845", "middlesex county"),
    BRIDGEWATER("bridgewater", "08837", "somerset county"),
    EDISON("edison", "08837", "middlesex county"),
    FRANKLIN("franklin", "08873", "somerset county"),
    SOMERVILLE("somerville", "08876", "somerset county"),
    NA("NA", "NA", "NA");

    private String town;
    private int zip;
    private String county;

    Location(String town, String zip, String county){
        this.town = town;
        this.zip = Integer.parseInt(zip);
        this.county = county;
    }

    public String toString(){
        return this.town;
    }

}

