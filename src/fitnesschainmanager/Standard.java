package fitnesschainmanager;

public class Standard extends Member{
    public final double ONE_TIME_FEE = 29.99;
    private final double    MEMBER_SCHEDULE_PER_MONTH = 39.99;
    /**
     * The constructor of the Member class
     *
     * @param fname    first name
     * @param lname    last name
     * @param dob      date of birth
     * @param expire   expiration date
     * @param location location
     */
    public Standard(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
    }

    public double MemberShipFee(){
        return ONE_TIME_FEE + MEMBER_SCHEDULE_PER_MONTH * 4;
    }


}
