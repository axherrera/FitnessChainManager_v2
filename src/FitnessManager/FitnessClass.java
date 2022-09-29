package FitnessManager;

public class FitnessClass {

    private MemberDatabase checkedIn = new MemberDatabase();
    private String instructor;
    private Time time;
    private ClassType classType;

    public enum Time {
        MORNING("09:00"),
        AFTERNOON("14:00");

        private String time;

        Time(String s) {
            this.time = s;
        }

        public String toString(){
            return this.time;
        }
    }
    public enum ClassType {
        PILATES("Pilates"),
        SPINNING("Spinning"),
        CARDIO("Cardio");

        private String classtype;

        ClassType(String classtype) {
            this.classtype = classtype;
        }

        public String toString(){
            return this.classtype;
        }
    }

    public FitnessClass(String instructor, Time time, ClassType classType){
        this.instructor = instructor;
        this.time = time;
        this.classType = classType;
    }

//    public boolean checkIn(FitnessManager.Member member){
//
//    }
//
//    public boolean dropClass(FitnessManager.Member member){
//
//    }
//
//    public void classInfo() {
//
//    }
}
