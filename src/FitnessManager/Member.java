package FitnessManager;

;

public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

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

    public Member(
            String fname,
            String lname,
            Date dob
    ) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getExpire() {
        return this.expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return (
                this.fname + ", " +
                this.lname +
                "DOB: " + this.dob.toString() +
                ", Membership expires: " + this.expire.toString() + ", " +
                "FitnessManager.Location: " + this.location.toString()
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Member mem = (Member) obj;
        return (fname.equals(mem.fname) && lname.equals(mem.lname) && dob.equals(mem.dob));
    }

    @Override
    public int compareTo(Member o) {
        int comp = this.fname.compareTo(o.fname);
        if(comp == 0){
            return this.lname.compareTo(o.lname);
        } else{
            return comp;
        }
    }

    public static void main(String[] args) {

        Date date1 = new Date("01/02/2026");
        Date date2 = new Date("01/02/2000");
        Date date3 = new Date("01/02/2023");


        Location location3 = Location.BRIDGEWATER;
        Location location2 = Location.EDISON;
        Location location1 = Location.FRANKLIN;
        Location location4 = Location.PISCATAWAY;
        Location location5 = Location.SOMERVILLE;

        Member member1 = new Member("Gibre", "Lukas ", date1, date2, location1);
        Member member2 = new Member("Tomas", "Mike ", date1, date2, location2);
        Member member3 = new Member("Micheal", "Tomas ", date2, date1, location3);
        Member member4 = new Member("Mike", "Tato ", date1, date2, location4);
        Member member5 = new Member("Gebre", "Lakas ", date1, date2, location5);
        Member member6 = new Member("n", "k ", date3, date2, location5);
//        System.out.println(member1);
//        System.out.println(member4.toString());
//        System.out.println(date1.compareTo(date2));
//        System.out.println(member1.compareTo(member2));

        MemberDatabase md = new MemberDatabase();
        md.add(member1);
        md.add(member2);
        md.add(member3);
        md.add(member4);
        md.add(member5);
        md.add(member6);

//        md.print();
//        md.printByName();
        md.printByCounty();
//        md.printByExpirationDate();
    }
}

