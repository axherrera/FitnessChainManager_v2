package FitnessManager;

import java.util.Calendar;

/**
 * created a date class, it compares the Comparable interface
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class Date implements Comparable<Date>{
    public static final int MAX_YEAR = 9999;
    public static final int MIN_YEAR = 1800;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    private int year;
    private int month;
    private int day;

    /**
     * Initializes a new date from year, month and day
     * @param year year
     * @param month month between 1 and 12
     * @param day day between 1 and 28-31/ it depends on the month
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Returns the year
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * It sets the year
     * @param year year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the month
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month
     * @param month month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gets the day
     * @return
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day
     * @param day day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Creates an object with today’s date
     */
    public Date() {
        setDate(01,02,2000);
    }

    /**
     * Sets the year, month and day
     * @param mm month
     * @param dd day
     * @param yyyy year
     */
    public void setDate( int mm, int dd, int yyyy ) {
        setYear(yyyy);
        setMonth(mm);
        setDay(dd);
    }

    /**
     * Creates Date object
     * @param date date
     */
    public Date(String date) {
        String[] string = date.split("/");
        if(string.length != 3){
            throw new IllegalArgumentException("Invalide date");
        }
        month = Integer.parseInt(string[0]);
        day = Integer.parseInt(string[1]);
        year = Integer.parseInt(string[2]);
    }

    /**
     * It overrides the CompareTo class
     * @param date the object to be compared.
     * @return date
     */
    @Override
    public int compareTo(Date date) {
        int yearDiff = this.year - date.year;
        if(yearDiff != 0){
            return yearDiff;
        }
        int monthDiff = this.month - date.month;
        if(monthDiff != 0){
            return monthDiff;
        }
        return this.day - date.day;
    }

    /**
     * Checks if a date is year or not
     * @return boolean
     */
    //check if a date is a valid calendar date
    boolean isLeapYear(){
        return (year % QUADRENNIAL == 0) && (year % CENTENNIAL != 0) || (year % QUATERCENTENNIAL == 0);
    }

    /**
     * Checks if a date is a valid calendar date or not
     * @return boolean
     */
    public boolean isValid() {
        if(year > MAX_YEAR || year < MIN_YEAR){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        if(day < 1 || day > 31){
            return false;
        }
        if(month == 2){
            if(isLeapYear()){
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        if( month == 4 || month == 6 || month == 9 || month == 11){
            return day <= 30;
        }
        return true;
    }

    /**
     * checks if the age is over 18
     * @return boolean
     */
    public boolean ofAge(){
        Calendar cd = Calendar.getInstance();
        int yrs = cd.get(Calendar.YEAR) - this.year;
        int mon = cd.get(Calendar.MONTH) + 1 - this.month;
        int day = cd.get(Calendar.DAY_OF_MONTH) - this.day;
        return (yrs > 18) ^ (yrs == 18 && ((mon == 0 && day >= 0) ^ (mon > 0)));
    }

    /**
     * Checks if age is future or not
     * if age for future, birthday is invalid
     * @return boolean
     */
    public boolean isFuture(){
        Calendar cd = Calendar.getInstance();
        int yrs = cd.get(Calendar.YEAR) - this.year;
        int mon = cd.get(Calendar.MONTH) + 1 - this.month;
        int day = cd.get(Calendar.DAY_OF_MONTH) - this.day;
        return (yrs < 0 ^ (yrs == 0 && (mon == 0 && day <= 0) ^ (mon < 0)));
    }

    /**
     * It overrides the toString clas
     * @return rear, month and day
     */
    @Override
    public String toString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }

    /**
     * It overrides the equals method
     * @param obj object of the class
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Date d = (Date) obj;
        return (this.month == d.month) && (this.day == d.day) && (this.year == d.year);
    }

    /**
     * This is the main class to check if the methods are working
     * @param args
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IllegalAccessException {
        Date date = new Date("01/02/1990");
        Date date1 = new Date("01/02/2022");

        System.out.println(date.toString());
        System.out.println(date.isValid());
        System.out.println(date.equals(date1));
        System.out.println(date.getYear());
        System.out.println(date.isFuture());
    }
}


