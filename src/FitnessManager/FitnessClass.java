package FitnessManager;

public class FitnessClass {

    private MemberDatabase checkedIn = new MemberDatabase();
    private ClassType classType;



    public FitnessClass(ClassType classType){
        this.classType = classType;
    }

    public void checkIn(Member member){
        checkedIn.add(member);
        System.out.printf("%s %s checked into %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    public void dropClass(Member member){
        if(!checkedIn.remove(member)){
            System.out.printf("%s %s is not a participant in %s\n", member.getFname(), member.getLname(), classType.getName());
            return;
        }
        System.out.printf("%s %s dropped %s\n", member.getFname(), member.getLname(), classType.getName());
    }

    public Member find(Member m){
        return this.checkedIn.getMember(m);
    }

    public void classInfo() {
        System.out.println(classType.toString());
        if(checkedIn.isEmpty())
            return;
        System.out.println("   ** participants **");
        checkedIn.printDatabase();
    }

    public ClassType getClassType(){
        return this.classType;
    }

}
