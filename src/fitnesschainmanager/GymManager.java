package fitnesschainmanager;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;

/**
 * Created a GymManager class represents the fitness manager
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class GymManager {
    MemberDatabase database;
    FitnessClass classes[];
    private final int NUM_CLASSES = 3;
    private final Date NA = new Date("00/00/0000");

    private final String MEMBER_LIST = "memberList.txt";

    private final String CLASS_SCHEDULE = "classSchedule.txt";

    /**
     * Creates new instance of GymManager class
     */
    public GymManager() {
        this.database = new MemberDatabase();
        this.classes = new FitnessClass[NUM_CLASSES];
        classes[0] = new FitnessClass(ClassType.PILATES);
        classes[1] = new FitnessClass(ClassType.SPINNING);
        classes[2] = new FitnessClass(ClassType.CARDIO);
    }

    /**
     * It validates input data before creating member object
     * Does date validation on date of birth and location
     * @param fname first name
     * @param lname last name
     * @param birth birthdate
     * @param location location
     * @return Will return member if input is valid. Otherwise, it will return null
     */
    private Member validateMemberData(
            String fname,
            String lname,
            String birth,
            String location,
            Operation memType
    ){
        Date bday = new Date(birth);
        Location loc = Location.idLocation(location);

        if(!dateValidation(fname, lname, bday, Operation.DOB))
            return null;
        if(loc == Location.NA){
            System.out.printf("%s: invalid location!\n", location);
            return null;
        }
        Member tempMem;
        switch (memType){
            case F:
                tempMem = new Family(fname, lname, bday, loc);
                break;
            case P:
                tempMem = new Premium(fname, lname, bday, loc);
                break;
            default:
                tempMem = new Member(fname, lname, bday, loc);
        }
        if(database.getMember(tempMem)!=null){
            System.out.printf("%s %s is already in the database.\n", tempMem.getFname(), tempMem.getLname());
            return null;
        }
        return tempMem;
    }

    /**
     * Does date validation on dob and expiration date
     * Will print out error message if there is invalid date input
     * @param fname first name
     * @param lname last name
     * @param date date
     * @param op operation
     * @return if date is valid return true, otherwise return false
     */
    private boolean dateValidation(String fname, String lname, Date date, Operation op){
        if(op == Operation.DOB){
            if(!date.isValid()){
                System.out.printf("DOB %s: invalid calendar date!\n", date.toString());
                return false;
            }
            else if(date.isFuture()){
                System.out.printf("DOB %s: cannot be today or a future date!\n", date.toString());
                return false;
            }
            else if(!date.ofAge()){
                System.out.printf("DOB %s: must be 18 or older to join!\n", date.toString());
                return false;
            }
            else return true;
        }
        else if (op == Operation.EXP){
            if(!date.isValid()){
                System.out.printf("Expiration date %s: invalid calendar date!\n", date.toString());
                return false;
            }
            else if(!date.isFuture()){
                System.out.printf("%s %s %s membership expired\n", fname, lname, date.toString());
                return false;
            }
            else return true;
        }
        return false;
    }

    /**
     * check that the there is no conflict with other classes, member is not already checked in
     * @param tempMem member object
     * @param classType class type
     * @return boolean that shows whether member can check into class or not
     */
    private boolean checkInValidate(Member tempMem, ClassType classType) {
        for(FitnessClass fitnessClass: classes){
            if(fitnessClass.find(tempMem)==null)
                continue;
            if(fitnessClass.getClassType()!=classType && fitnessClass.getClassType().getTime()==classType.getTime()){
                System.out.printf(
                        "%s time conflict -- %s %s has already checked in %s.\n",
                        classType.getName(),
                        tempMem.getFname(),
                        tempMem.getLname(),
                        fitnessClass.getClassType().getName()
                );
                return false;
            }
            else if(fitnessClass.getClassType()==classType){
                System.out.printf(
                        "%s %s has already checked in %s\n",
                        tempMem.getFname(),
                        tempMem.getLname(),
                        classType.getName()
                );
                return false;
            }
        }
        return true;
    }

    /**
     * Adds member to gym database
     * If adding is successful, prints out string notifying addition.
     * @param sc scanner object that will read user inputs
     */
    private void addMember(Scanner sc, Operation memType){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        Member tempMem = validateMemberData(tk.nextToken(), tk.nextToken(), tk.nextToken(), tk.nextToken(), memType);
        if(tempMem == null)
            return;
        database.add(tempMem);
        System.out.printf("%s %s added.\n", tempMem.getFname(), tempMem.getLname());
    }

    /**
     * Remove the member from the gym database
     * And prints the first name and last name to remove
     * If the members is not the database, it prints the member is not in database
     * @param sc scanner object that will read user inputs
     */
    private void removeMember(Scanner sc){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        Member tempMem = new Member(tk.nextToken(), tk.nextToken(), new Date(tk.nextToken()), NA, Location.NA);
        if(!this.database.remove(tempMem)) {
            System.out.println(tempMem.getFname() + " " + tempMem.getLname() + " "+ " is not in the database");
            return;
        }
        System.out.println(tempMem.getFname() + " " + tempMem.getLname() + " removed");

    }

    /**
     * It displays the schedule for the gym fitness classes
     */
    private void displayClassSchedule(){
        System.out.println("\n-Fitness Classes-");
        for(FitnessClass fitnessClass:classes){
            System.out.println(fitnessClass.toString());
            if(fitnessClass.checkedIn.isEmpty())
                continue;
            System.out.println("   ** participants **");
            fitnessClass.classInfo();
        }
        System.out.println();
    }

    /**
     * Adds or Drops class
     * @param sc scanner object that will read user inputs
     * @param op operation, either add or drop
     */
    private void addOrDropClass(Scanner sc, Operation op){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        String isClass = tk.nextToken();
        ClassType classtype = ClassType.idClassType(isClass);

        if(classtype == ClassType.NA) {
            System.out.printf("%s class does not exist\n", isClass);
            return;
        }

        String fname = tk.nextToken();
        String lname = tk.nextToken();
        Date bday = new Date(tk.nextToken());

        if(!dateValidation(fname, lname, bday, Operation.DOB))
            return;

        if(op == Operation.DROP){
            System.out.println(classes[classtype.getIndex()].dropClass(new Member(fname, lname, bday, NA, Location.NA)));
            return;
        }

        if(database.getMember(new Member(fname, lname, bday, NA, Location.NA)) == null){
            System.out.printf("%s %s %s is not in the database.\n", fname, lname, bday);
            return;
        }
        Member tempMem = database.getMember(new Member(fname, lname, bday, NA, Location.NA));
        if(!checkInValidate(tempMem, classtype))
            return;
        if(!dateValidation(fname, lname, tempMem.getExpire(), Operation.EXP))
            return;

        System.out.println(classes[classtype.getIndex()].checkIn(tempMem));
    }

    /**
     * Imports historical member information from a memberList.txt file
     * This method assumes that all historical members hav valid member information, therefore
     * forgoing new member information validation.
     */
    private void importMembers(){
        File file = new File(MEMBER_LIST);
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
                database.add(
                        new Member(
                                tk.nextToken(), tk.nextToken(), new Date(tk.nextToken()), new Date(tk.nextToken()), Location.idLocation(tk.nextToken())
                        )
                );
            }
        }
        catch(FileNotFoundException e) {
            System.out.printf("%S not found in project directory", MEMBER_LIST);
        }
    }

    private void loadSchedule(){
        File file = new File(CLASS_SCHEDULE);

    }
    /**
     * Checks operation and calls corresponding method
     * @param op operation to be used
     * @param sc scanner object to be passed into corresponding method
     */
    private void checkOP(String op, Scanner sc) {
        switch (op) {
            case "A":
                addMember(sc, Operation.S);
                break;
            case "AF":
                addMember(sc, Operation.F);
                break;
            case "AP":
                addMember(sc, Operation.P);
                break;
            case "R":
                removeMember(sc);
                break;
            case "P":
                this.database.printDatabase();
                break;
            case "PC":
                this.database.printByCounty();
                break;
            case "PN":
                this.database.printByName();;
                break;
            case "PD":
                this.database.printByExpirationDate();
                break;
            case "S":
                displayClassSchedule();
                break;
            case "C":
                addOrDropClass(sc, Operation.CHK);
                break;
            case "D":
                addOrDropClass(sc, Operation.DROP);
                break;
            case "LS":
                loadSchedule();
                break;
            case "LM":
                importMembers();
                break;
            default:
                System.out.println(op + " is an invalid command!\n");
        }
    }

    /**
     * Runs an instance of the GymManager class. Will terminate with the input 'Q'
     */
    public void run(){
        System.out.println("Gym Manager running...");
        Scanner scan = new Scanner(System.in);
        String op = scan.next();
        while(!op.equals("Q")){
            checkOP(op, scan);
            op = scan.next();
        }
        System.out.println("Gym Manager terminated.");
    }
}
