package fitnesschainmanager;

import java.text.DecimalFormat;

public class Family extends Member{

//    private final double ONE_TIME_FEE = 29.99;
    protected final double FAMILY_FEE_PER_MONTH = 59.99;

    public double getFAMILY_FEE_PER_MONTH() {
        return FAMILY_FEE_PER_MONTH;
    }

    public Family(String fname, String lname, Date dob, Location location) {
        super(fname, lname, dob, location);
    }

    public Family(String fname, String lname, Date dob, Date expire, Location location) {
        super(fname, lname, dob, expire, location);
    }


    @Override
    public String MemberShipFee(){
        DecimalFormat df = new DecimalFormat("0.##");
        return df.format(this.MEMBER_ONE_TIME_FEE + FAMILY_FEE_PER_MONTH * 3);
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
        Family guest1 = new Family("Kaleb", "Yonas", date1, location1);
        Family guest2 = new Family("John", "Mat", date2, location5);
//        System.out.println(guest2.getFname());

        Member family1 = new Family("Gibre", "Lukas ", date1, date2, location1);
        Member family2 = new Family("Tomas", "Mike ", date1, date2, location2);
        Member family3 = new Family("Micheal", "Tomas ", date2, date1, location3);
        Member family4 = new Family("Mike", "Tato ", date1, date2, location4);
        Member family5 = new Family("Gebre", "Lakas ", date1, date2, location5);
        Member family6 = new Family("nani", "kibret", date3, date2, location5);
        System.out.println(family6.MemberShipFee());

//        System.out.println(family1);
//        System.out.println(family4.toString());
//        System.out.println(date1.compareTo(date2));
//        System.out.println(family1.compareTo(family2));

        MemberDatabase md = new MemberDatabase();

        md.add(family1);
        md.add(family2);
        md.add(family3);
        md.add(family4);
        md.add(family5);
        md.add(family6);
      
        md.print();
//        md.printByName();
//        md.printByCounty();
//        md.printByExpirationDate();
    }
}
