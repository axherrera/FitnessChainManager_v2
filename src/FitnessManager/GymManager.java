package FitnessManager;

import java.util.Scanner;
import java.util.StringTokenizer;

public class GymManager {
    MemberDatabase database;

    public GymManager() {
        this.database = new MemberDatabase();
    }

    /*private boolean validateData(
            FitnessManager.Date dob,
            FitnessManager.Date eDate,
            FitnessManager.Location location
    ){
        //if(eDate.isValid() && )
    }*/

    public Location idLocation(String location) {
        location.toLowerCase();
        switch (location) {
            case "piscataway":
                return Location.PISCATAWAY;
            case "bridgewater":
                return Location.BRIDGEWATER;
            case "edison":
                return Location.EDISON;
            case "franklin":
                return Location.FRANKLIN;
            case "somerville":
                return Location.SOMERVILLE;
            default:
                return Location.NA;
        }
    }

    private void addMember(Scanner sc){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        if(tk.countTokens()!= 5) System.out.println("Invalid number of tokens");
        String fName = tk.nextToken();
        String lName = tk.nextToken();
        Date dob = new Date(tk.nextToken());
        Date eDate = new Date(tk.nextToken());
        Location loc = idLocation(tk.nextToken());
        //if(!validateData(dob, eDate, loc)) return;
        database.add(new Member(fName,lName, dob, eDate, loc));
        System.out.println(fName + " " + lName + " added.");
    }
    private void displayMemebers(){
        this.database.print();
    }
    private void removeMember(Scanner sc){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        if(tk.countTokens()!= 3) System.out.println("Invalid number of tokens");
        String fName = tk.nextToken();
        String lName = tk.nextToken();
        Date dob = new Date(tk.nextToken());
        if(!this.database.remove(new Member(fName, lName, dob))) System.out.println("Non-existent FitnessManager.Member");
        System.out.println("FitnessManager.Member Removed");

    }
    private void diplayByCounty(){
        this.database.printByCounty();
    }
    private void displayByEDate(){
        this.database.printByExpirationDate();
    }
    private void displayByName(){
        this.database.printByName();
    }
    private void displayClassSchedule(String token){

    }
    private void checkinToClass(String token){

    }
    private void dropClass(String token){

    }

    private void checkOP(String op, Scanner sc){
        switch (op) {
            case "A":
                addMember(sc);
                break;
            case "R":
                removeMember(sc);
                break;
            case "P":
                displayMemebers();
                break;
            case "PC":
                diplayByCounty();
                break;
            case "PN":
                displayByName();
                break;
            case "PD":
                displayByEDate();
                break;
            case "S":

                break;
            case "C":

                break;
            case "D":

                break;
            default:
                System.out.println(op + "is an invalid command!");
        }
    }

    public void run(){
        System.out.println("Gym Manager running...");
        Scanner scan = new Scanner(System.in);
        String op = scan.next();
        while(op != "Q"){
            checkOP(op, scan);
            op = scan.next();
        }
        System.out.println("Gym Manager terminated.");
    }
}
