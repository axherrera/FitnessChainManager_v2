package fitnesschainmanager;

import java.text.DecimalFormat;

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
    public String MemberShipFee(){
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(FAMILY_SCHEDULE_PER_MONTH * 12 - FAMILY_SCHEDULE_PER_MONTH);
    }

    public static void main(String[] args) {
        Date date1 = new Date("01/02/2026");
        Date date2 = new Date("01/02/2022");
        Date date3 = new Date("01/02/2023");

        Location location3 = Location.BRIDGEWATER;
        Location location2 = Location.EDISON;
        Location location1 = Location.FRANKLIN;
        Location location4 = Location.PISCATAWAY;
        Location location5 = Location.SOMERVILLE;

        Member guest1 = new Member("Kaleb", "Yonas", date1, location1);
        Member guest2 = new Member("John", "Mat", date2, location5);
        Member guest3 = new Member("John", "Mat", date3, location3);
//        System.out.println(guest2.getLocation());

        Member member1 = new Member("Gibre", "Lukas ", date1, date2, location1);
        Member member2 = new Member("Tomas", "Mike ", date1, date2, location2);
        Member member3 = new Member("Micheal", "Tomas ", date2, date1, location3);
        Member member4 = new Member("Mike", "Tato ", date1, date2, location4);
        Member member5 = new Member("Gebre", "Lakas ", date1, date2, location5);
        Member member6 = new Member("nani", "kibret", date3, date2, location5);
        System.out.println(member6.MemberShipFee());

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

//        md.printByName();
//        md.printByCounty();
//        md.printByExpirationDate();
    }
}
