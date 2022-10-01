package FitnessManager;

public enum ClassType {
    PILATES("Pilates", "Jennifer", "morning", "0"),
    SPINNING("Spinning", "Denise", "afternoon", "1"),
    CARDIO("Cardio", "Kim", "afternoon", "2"),
    NA("NA", "NA", "NA", "-1");

    private String name;
    private String instructor;
    private Time time;
    private int index;

    ClassType(String classtype, String instructor, String time, String index ) {
        this.name = classtype;
        this.instructor = instructor;
        this.time = Time.getTime(time);
        this.index = Integer.parseInt(index);
    }

    @Override
    public String toString(){
        return (String.format("%s - %s %s", name, instructor, time.toString()));
    }

    public String getName(){
        return name;
    }

    public String getInstructor(){
        return instructor;
    }

    public Time getTime(){
        return time;
    }

    public int getIndex(){ return index;}

    public static ClassType idClassType(String classtype){
        switch (classtype.toLowerCase()){
            case "pilates":
                return ClassType.PILATES;
            case "spinning":
                return ClassType.SPINNING;
            case "cardio":
                return ClassType.CARDIO;
            default:
                System.out.println(classtype + " class does not exist.");
                return ClassType.NA;
        }
    }
}
