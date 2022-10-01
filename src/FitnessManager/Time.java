package FitnessManager;

public enum Time {
    MORNING("09:00"),
    AFTERNOON("14:00");

    private final String time;

    Time(String time){
        this.time = time;
    }

    @Override
    public String toString(){
        return time;
    }

    public static Time getTime(String time){
        if(time.equals("afternoon"))
            return Time.AFTERNOON;
        else
            return Time.MORNING;
    }


}
