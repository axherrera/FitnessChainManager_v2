package FitnessManager;

/**
 * This is the main class to check the results
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class Main {
    public static void main(String[] args) {
//        FitnessManager.Member a1 = new FitnessManager.Member("hu", "aa", "12-21-2020","12-21-2023", "SOMERVILLE, 08876, SOMERSET);
        Date date1 = new Date("01/02/2026");
        Date date2 = new Date("01/02/2022");
        Date date3 = new Date("01/02/2023");

        Location location3 = Location.BRIDGEWATER;
        Location location2 = Location.EDISON;
        Location location1 = Location.FRANKLIN;
        Location location4 = Location.PISCATAWAY;
        Location location5 = Location.SOMERVILLE;

        FitnessManager.Member m = new FitnessManager.Member("Alex", "Jhon ", date1, date2, location1);
        FitnessManager.Member m2 = new FitnessManager.Member("Yon", "Lukas ", date1, date2, location2);

        System.out.println(m.toString());
        System.out.println(m.equals(m2));
        System.out.println(date1.toString());
    }
}
