package fitnesschainmanager;

/**
 * Enum class for ClassType which holds information about each fitness class
 * Includes class name, instructor, time, and index
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
     *
     * @param classtype the class type
     * @param instructor the instructor for the class
     * @param time time which class is being held
     * @param index index which class will occupy in the fitness class array in gym manager
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
     * It gets the fitness class name
     * @return returns name of fitness class
     */
    public String getName(){
        return name;
    }

    /**
     * gets the time of the fitness class
     * @return returns time of fitness class
     */
    public Time getTime(){
        return time;
    }

    /**
     * gets the index which this class will be held in
     * @return returns class's index
     */
    public int getIndex(){
        return index;
    }

    /**
     * it accepts a string and returns the fitness class type corresponding to that string
     * @param classtype it is the class type
     * @return the class type of the gym fitness, if string is not valid location, returns NA
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
