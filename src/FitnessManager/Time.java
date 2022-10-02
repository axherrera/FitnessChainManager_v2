package FitnessManager;

/**
 * An enum Time created
 * @author ALEJANDRO HERRERA-PINEDA, Huruy Belay
 */
public enum Time {
    MORNING("09:30"),
    AFTERNOON("14:00");

    private final String time;

    Time(String time){
        this.time = time;
    }

    /**
     * Overrides the toString method
     * @return
     */
    @Override
    public String toString(){
        return time;
    }

    /**
     * It gets the time
     * @param time time
     * @return time
     */
    public static Time getTime(String time){
        if(time.equals("afternoon"))
            return Time.AFTERNOON;
        else
            return Time.MORNING;
    }
}
