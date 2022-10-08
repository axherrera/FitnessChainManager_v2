package fitnesschainmanager;

public class Family extends Member{

//    private final double ONE_TIME_FEE = 29.99;
    static final double FAMILY_SCHEDULE_PER_MONTH = 59.99;

    /**
     * The constructor of the Member class
     *
     * @param fname    first name
     * @param lname    last name
     * @param dob      date of birth
     * @param expire   expiration date
     * @param location location
     */
    public Family(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
    }

    @Override
    public double MemberShipFee(){
        return MEMBER_ONE_TIME_FEE + FAMILY_SCHEDULE_PER_MONTH * 4;
    }
}
