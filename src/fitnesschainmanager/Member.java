package fitnesschainmanager;

/**
 * Member used to represent the members of the gym
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    /**
     * The constructor of the Member class
     * @param fname first name
     * @param lname last name
     * @param dob date of birth
     * @param expire expiration date
     * @param location location
     */
    public Member(
            String fname,
            String lname,
            Date dob,
            Date expire,
            Location location
    ) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }

    /**
     * To get the first name
     * @return first name
     */
    public String getFname() {
        return this.fname;
    }

    /**
     * To set the first name
     * @param fname first name
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * To get the last name
     * @return last name
     */
    public String getLname() {
        return this.lname;
    }

    /**
     * To set the last name
     * @param lname last name
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * To get the date of birth
     * @return date of birth
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * To set the date of birth
     * @param dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * To get the expiration date
     * @return expiration date
     */
    public Date getExpire() {
        return this.expire;
    }

    /**
     * To set the expiration date
     * @param expire expiration
     */
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    /**
     * To get the location
     * @return location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * To set the location
     * @param location location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * It overrides the toString method
     * @return first name, last name, date of birth and expiration date
     */
    @Override
    public String toString() {
        return (
                this.fname + ", " +
                        this.lname +
                        " DOB: " + this.dob.toString() +
                        ", Membership expires: " + this.expire.toString() + ", " +
                        "Location: " + this.location.toString()
        );
    }

    /**
     * It overrides the equals method for object comparison
     * @param obj object
     * @return if compared object are the same return true, otherwise return false
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Member mem = (Member) obj;
        return (fname.toLowerCase().equals(mem.fname.toLowerCase()) && lname.toLowerCase().equals(mem.lname.toLowerCase()) && dob.equals(mem.dob));
    }

    /**
     * It overrides the compareTo method to compare 2 names
     * @param o the object to be compared.
     * @return returns 0 if names are the same, -x is name is less than, x is more than
     */
    @Override
    public int compareTo(Member o) {
        int comp = this.fname.compareTo(o.fname);
        if(comp == 0){
            return this.lname.compareTo(o.lname);
        } else{
            return comp;
        }
    }
}

