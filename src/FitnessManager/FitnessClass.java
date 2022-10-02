package FitnessManager;

/**
 * a fitnessclass
 * @author ALEJANDRO HERRERA-PINEDA, Huruy Belay
 */
public class FitnessClass {
    private MemberDatabase checkedIn = new MemberDatabase();
    private ClassType classType;

    /**
     * The consyructor for the class FitnessClass
     * @param classType classType
     */
    public FitnessClass(ClassType classType){
        this.classType = classType;
    }

    /**
     * The check in the member of the gym fitness
     * @param member member of the gym fitness
     */
    public void checkIn(Member member){
        checkedIn.add(member);
        System.out.printf("%s %s checked into %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    /**
     * It drops the member of the gym fitness
     * @param member member of the gym fitness
     */
    public void dropClass(Member member){
        if(!checkedIn.remove(member)){
            System.out.printf("%s %s is not a participant in %s\n", member.getFname(), member.getLname(), classType.getName());
            return;
        }
        System.out.printf("%s %s dropped %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    /**
     * If finds the member of the gym fitness
     * @param m member of the gym fitness
     * @return the member
     */
    public Member find(Member m){
        return this.checkedIn.getMember(m);
    }

    /**
     * It prints the participant members
     */
    public void classInfo() {
        System.out.println(classType.toString());
        if(checkedIn.isEmpty())
            return;
        System.out.println("   ** participants **");
        checkedIn.printDatabase();
    }

    /**
     * This is to get the class type
     * @return
     */
    public ClassType getClassType(){
        return this.classType;
    }
}
