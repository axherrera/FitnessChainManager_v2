package fitnesschainmanager;

/**
 * Instance of a fitness class which consists of a class type and database of all checked in members
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class FitnessClass {
    private MemberDatabase checkedIn = new MemberDatabase();
    private ClassType classType;

    /**
     * Initializes a newly created FitnessClass object
     *
     * @param classType classType
     */
    public FitnessClass(ClassType classType){
        this.classType = classType;
    }

    /**
     * This is to get the fitness class type
     * @return class type
     */
    public ClassType getClassType(){
        return this.classType;
    }

    /**
     * Checks in a member into the fitness class object
     * Prints out string to console detailing which member got added to which class
     * @param member member of the gym fitness
     */
    public void checkIn(Member member){
        checkedIn.add(member);
        System.out.printf("%s %s checked into %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    /**
     * Drops a member from fitness class object
     * Prints warning message if member is not a participant of the class
     * Otherwise prints notification that member dropped the class
     * @param member member of the fitness chain
     */
    public void dropClass(Member member){
        if(!checkedIn.remove(member)){
            System.out.printf("%s %s is not a participant in %s\n", member.getFname(), member.getLname(), classType.getName());
            return;
        }
        System.out.printf("%s %s dropped %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    /**
     * Finds out whether a member checked into the class or not
     *
     * @param m member of the gym fitness
     * @return if member is found return member, return null if no such member exists
     */
    public Member find(Member m){
        return this.checkedIn.getMember(m);
    }

    /**
     * It prints class information as well as all members attending
     * If class is empty, does not attempt to print out the participant list
     */
    public void classInfo() {
        System.out.println(classType.toString());
        if(checkedIn.isEmpty())
            return;
        System.out.println("   ** participants **");
        checkedIn.printDatabase();
    }
}
