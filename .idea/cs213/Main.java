package cs213;

public class Main {
    public static void main(String[] args) {
//        FitnessManager.Member a1 = new FitnessManager.Member("hu", "aa", "12-21-2020","12-21-2023", "SOMERVILLE, 08876, SOMERSET);
        Date d1 = new Date(2022,2,02);
        Date d2 = new Date(2022,2,02);

        edu.rutges.cs213.Location l = new edu.rutges.cs213.Location("Ed","08619", "Md");
        java.util.Date d11 = new java.util.Date(2022, 02,01);
        java.util.Date d22 = new java.util.Date(2000, 02,01);

        java.util.Date d3=new java.util.Date(2022,02,01 );

        Member m = new Member("aa", "bb ", d11, d22, l);
        Member m2 = new Member("aa", "bb ", d11, d22, l);

        MemberDatabase mm = new MemberDatabase();
        mm.add(m);
        mm.add(m2);

        System.out.println(mm.toString());

//        System.out.println(m.toString());
//        System.out.println(m.equals(m2));

//        System.out.println(d1.toString());
//        System.out.println(l.toString());

    }
}
