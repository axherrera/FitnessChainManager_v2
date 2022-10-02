package FitnessManager;

/**
 * created enum classType
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public enum ClassType {
    PILATES("Pilates", "Jennifer", "morning", "0"),
    SPINNING("Spinning", "Denise", "afternoon", "1"),
    CARDIO("Cardio", "Kim", "afternoon", "2"),
    NA("NA", "NA", "NA", "-1");

    private String name;
    private String instructor;
    private Time time;
    private int index;

    /**
     * This is a constructor for the enum ClassType
     * @param classtype the class type
     * @param instructor the instructor of the gym fitness
     * @param time the time for the gym fitness
     * @param index
     */
    ClassType(String classtype, String instructor, String time, String index ) {
        this.name = classtype;
        this.instructor = instructor;
        this.time = Time.getTime(time);
        this.index = Integer.parseInt(index);
    }

    /**
     * It overrides the toString class
     * @return the name, instructor and time of the gym fitness
     */
    @Override
    public String toString(){
        return (String.format("%s - %s %s", name, instructor, time.toString()));
    }

    /**
     * It gets the name
     * @return the name
     */
    public String getName(){
        return name;
    }

    /**
     * It gets the instructor
     * @return the instructor
     */
    public String getInstructor(){
        return instructor;
    }

    /**
     * gets the time of the fitness class
     * @return the time
     */
    public Time getTime(){
        return time;
    }

    /**
     * gets the index
     * @return the index
     */
    public int getIndex(){
        return index;
    }

    /**
     * it accepts a string and returns the classType
     * @param classtype it is the class type
     * @return the class type of the gym fitness
     */
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
