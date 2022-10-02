package FitnessManager;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created a GymManager class represents the fitness manager
 * @author ALEJANDRO HERRERA-PINEDA, Huruy Belay
 */
public class GymManager {
    MemberDatabase database;
    FitnessClass classes[];
    private final int numClasses = 3;
    private final Date NA = new Date("00/00/0000");

    /**
     * The constructor for the class GymManager
     */
    public GymManager() {
        this.database = new MemberDatabase();
        this.classes = new FitnessClass[numClasses];
        classes[0] = new FitnessClass(ClassType.PILATES);
        classes[1] = new FitnessClass(ClassType.SPINNING);
        classes[2] = new FitnessClass(ClassType.CARDIO);
    }

    /**
     * It validates member data
     * @param fname first name
     * @param lname last name
     * @param birth birthdate
     * @param expire expire date
     * @param location location
     * @return firstname, last name, birthdate, expire date and location
     */
    private Member validateMemberData(
            String fname,
            String lname,
            String birth,
            String expire,
            String location
    ){
        Date bday = new Date(birth);
        Date eDate = new Date(expire);
        Location loc = Location.idLocation(location);

        if(!dateValidation(fname, lname, bday, Operation.DOB))
            return null;
        if(!dateValidation(fname, lname, eDate, Operation.AEXP))
            return null;
        if(loc == Location.NA){
            System.out.printf("%s: invalid location!\n", location);
            return null;
        }
        Member tempMem = new Member(fname, lname, bday, eDate, loc);
        if(database.getMember(tempMem)!=null){
            System.out.printf("%s %s is already in the database.\n", tempMem.getFname(), tempMem.getLname());
            return null;
        }
        return tempMem;
    }

    /**
     * Date validation
     * It checks if date is future date, invalid date, or date birth is less than 18 years
     * @param fname first name
     * @param lname last name
     * @param date date
     * @param op operation
     * @return boolean
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
        else if(op == Operation.AEXP){
            if(!date.isValid()){
                System.out.printf("Expiration date %s: invalid calendar date!\n", date.toString());
                return false;
            }
            else return true;
        }
        return false;
    }

    /**
     * check that the there is no conflict with other classes, member is not already checked in
     * @param tempMem temporary member
     * @param classType class type
     * @return boolean
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
     * Adding member to gym database
     * And prints the first name and last name to add
     * @param sc the member to add
     */
    private void addMember(Scanner sc){
        StringTokenizer tk = new StringTokenizer(sc.nextLine(), " ");
        Member tempMem = validateMemberData(tk.nextToken(), tk.nextToken(), tk.nextToken(), tk.nextToken(), tk.nextToken());
        if(tempMem == null)
            return;
        database.add(tempMem);
        System.out.printf("%s %s added.\n", tempMem.getFname(), tempMem.getLname());
    }

    /**
     * Remove the member from the gym database
     * And prints the first name and last name to remove
     * If the members is not the database, it prints the member is not in database
     * @param sc the member to remove
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
     * It displays the schedule for the gym fitness
     */
    private void displayClassSchedule(){
        System.out.println("\n-Fitness Classes-");
        for(FitnessClass fitnessClass:classes){
            fitnessClass.classInfo();
        }
        System.out.println();
    }

    /**
     * The members check to the gym fitness class
     * @param sc the gym fitness member
     */
    private void checkinToClass(Scanner sc){
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

        //validate dob, then validate member, then validate member's expiration date
        if(!dateValidation(fname, lname, bday, Operation.DOB))
            return;
        Member tempMem = classes[classtype.getIndex()].find(new Member(fname, lname, bday, NA, Location.NA));
        if(!checkInValidate(tempMem, classtype))
            return;
        if(!dateValidation(fname, lname, tempMem.getExpire(), Operation.EXP))
            return;

        classes[classtype.getIndex()].checkIn(tempMem);
        System.out.printf("%s %s checked into cardio\n",fname, lname);
    }

    /**
     * It drops the member from the gym fitness database
     * @param sc member
     */
    private void dropClass(Scanner sc){
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

        classes[classtype.getIndex()].dropClass(new Member(fname, lname, bday, NA, Location.NA));
    }

    /**
     * Add or Drop
     * @param sc member
     * @param op operation
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
            classes[classtype.getIndex()].dropClass(new Member(fname, lname, bday, NA, Location.NA));
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

        classes[classtype.getIndex()].checkIn(tempMem);
    }

    /**
     * checking operations, to add, to remove, to print and to display
     * @param op operations
     * @param sc member
     */
    private void checkOP(String op, Scanner sc){
        switch (op) {
            case "A":
                addMember(sc);
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
            default:
                System.out.println(op + " is an invalid command!\n");
        }
    }

    /**
     * Run the GymManager class
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
