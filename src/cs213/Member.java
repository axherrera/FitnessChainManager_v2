package edu.rutges.cs213;

import javax.xml.stream.Location;
import java.util.Collections;
import java.util.Date;

public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    public Member(String fname, String lname, Date dob, Date expire, Location location){
        this.fname = fname;
        this.lname = lname;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.getFname() + ", " + this.getLname() + "DOB: " + this.getDob() + " " + this.getExpire() + " " + "Location:" + this.getLocation();
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
        int fdiff = this.fname.compareTo(o.fname);
        if(fdiff != 0){
            return fdiff;
        }
        int ldiff = this.lname.compareTo(o.lname);
        if(ldiff != 0){
            return ldiff;
        }
        int dobdiff = this.dob.compareTo(o.dob);
        if(dobdiff != 0){
            return dobdiff;
        }
        int expdiff = this.expire.compareTo(o.expire);
        if(expdiff != 0){
            return expdiff;
        }
        return 0;
    }

    public static void main(String[] args) {
        edu.rutges.cs213.Location l = new edu.rutges.cs213.Location("Ed","08619", "Md");

        Date d1 = new Date("01/02/2026");
        Date d2 = new Date("01/02/2022");
        Date d3 = new Date("01/02/2023");
//        System.out.println(d1.compareTo(d3));

        Member m1 = new Member("hu", "jj ", d1, d2, l);
        Member m2 = new Member("hu", "jj ", d1, d2, l);
//        System.out.println(m1.toString());
//        System.out.println(d1.compareTo(d2));
        System.out.println(m1.compareTo(m2));

    }
}

