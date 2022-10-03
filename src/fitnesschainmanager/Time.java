package fitnesschainmanager;

/**
 * An enumeration to be used by the ClassType enumeration
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public enum Time {
    MORNING("09:30"),
    AFTERNOON("14:00");

    private final String time;

    Time(String time){
        this.time = time;
    }

    /**
     * Overrides the toString method to print time as a string
     * @return
     */
    @Override
    public String toString(){
        return time;
    }

    /**
     * Identifies the Time object corresponding to the provided string argument
     * @param time time
     * @return returns the Time object corresponding to the argument
     */
    public static Time getTime(String time){
        if(time.equals("afternoon"))
            return Time.AFTERNOON;
        else
            return Time.MORNING;
    }
}
