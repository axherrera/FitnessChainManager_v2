package fitnesschainmanager;

public class Premium extends Family{
//    public final double PREMIU_SCHEDULE_PER_MONTH = 59.99;
    /**
     * The constructor of the Member class
     *
     * @param fname    first name
     * @param lname    last name
     * @param dob      date of birth
     * @param expire   expiration date
     * @param location location
     */
    public Premium(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
    }

    @Override
    public double MemberShipFee(){
        return FAMILY_SCHEDULE_PER_MONTH * 11;
    }
}
