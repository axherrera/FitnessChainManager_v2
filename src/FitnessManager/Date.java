package FitnessManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    //create an object with today’s date (see Calendar class)
    public Date() {
        setDate(01,02,2000);
    }

    public void setDate( int mm, int dd, int yyyy ) {
        setYear(yyyy);
        setMonth( mm );
        setDay( dd );
    }

    //take “mm/dd/yyyy” and create a FitnessManager.Date object
    public Date(String date) {
        String[] string = date.split("/");
        if(string.length != 3){
            throw new IllegalArgumentException("Invalide date");
        }
        month = Integer.parseInt(string[0]);
        day = Integer.parseInt(string[1]);
        year = Integer.parseInt(string[2]);
    }

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

    //check if a date is a valid calendar date
    boolean isLeapYear(){
        return (year % QUADRENNIAL == 0) && (year % CENTENNIAL != 0) || (year % QUATERCENTENNIAL == 0);
    }
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
    public boolean hasAgeGreaterthanEighteen(){
        Calendar cd = new GregorianCalendar();
        int age = cd.get(Calendar.YEAR) - year;
        if(age < 18){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }
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

    public static void main(String[] args) throws IllegalAccessException {
        Date date = new Date("01/02/1990");
        Date date1 = new Date("01/02/2022");

//        System.out.println(date.toString());
//        System.out.println(date.isValid());
//        System.out.println(date.equals(date1));
//        System.out.println(date.getYear());
        System.out.println(date.hasAgeGreaterthanEighteen());
    }
}


