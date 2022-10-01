package edu.rutges.cs213;

import java.util.Date;

public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    public Member(String fname, String lname, Date dob, Date expire, edu.rutges.cs213.Location location) {
        this.fname = fname.toLowerCase();
        this.lname = lname.toLowerCase();
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public edu.rutges.cs213.Location getLocation() {
        return location;
    }

    public void setLocation(edu.rutges.cs213.Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.getFname() + ", " + this.getLname() + "DOB: " + this.getDob() + ", Membership expires: " + this.getExpire() + ", " + "Location:" + this.getLocation();
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

        Member mem = (Member) o;
        int fn = fname.compareTo(mem.getFname());
        if(fn == 0){
            return lname.compareTo(mem.getLname());
        }
        int zip = location.getCounty().compareTo(mem.location.getCounty());
        if(zip == 0){
            return location.getZipcode().compareTo(mem.location.getZipcode());
        }
        return 0;
    }

    public static void main(String[] args) {

        Date date1 = new Date("01/02/2026");
        Date date2 = new Date("01/02/2022");
        Date date3 = new Date("01/02/1999");
        Date date4 = new Date("01/02/2000");
        Date date5 = new Date("01/02/2003");

        Location location3 = Location.Bridgewater;
        Location location2 = Location.Edison;
        Location location1 = Location.Franklin;
        Location location4 = Location.Piscataway;
        Location location5 = Location.Somerville;

        Member member1 = new Member("John", "Lukas ", date1, date2, location1);
        Member member2 = new Member("Tomas", "Mike ", date1, date4, location2);
        Member member3 = new Member("Micheal", "Tomas ", date2, date1, location3);
        Member member4 = new Member("Mike", "Tato ", date1, date2, location4);
        Member member5 = new Member("Gebre", "Bajo ", date3, date3, location5);
        Member member6 = new Member("nebro", "kiros", date2, date5, location5);
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

