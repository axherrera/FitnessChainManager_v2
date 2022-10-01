package edu.rutges.cs213;

import java.util.Arrays;
import java.util.Date;

public class MemberDatabase {
    private Member [] mlist;
    private int size;

    // grow the size of the array
    private void grow() {
        Member[] temp = new Member[mlist.length + 4];
        for(int i = 0; i < size; i++){
            temp[i] = mlist[i];
        }
        size+=4;
        mlist = temp;
    }

    //add member to the array
    public boolean add(Member member) {
        if (this.mlist == null) {
            mlist = new Member[4];
        }
        if (size == mlist.length) {
            return false;
        }
        if (member instanceof Member) {
            this.mlist[size++] = member;
            return true;
        }
        grow();
        return false;
    }

    // find a member from the array
    private int find(Member member) {
        for(int i = 0; i < mlist.length; i++){
            if(mlist[i].equals(member)){
                return i;
            }
        }
        return -1;
    }
    // remove the member from the array
    public boolean remove( Member member) {
        for (int i = 0; i < size; i++){
            if(member.equals(mlist[i])){
                mlist[i] = null;
                return true;
            }
        }
        return false;
    }

    //print the array contents as is
    public void print() {
        for(int i = 0; i < mlist.length; i++){
            System.out.println(mlist[i]);
        }
    }

    //sort by county and then zipcode
    public void printByCounty() {
        for(int i = 0; i < size; i++){
            Member k = mlist[i];
            int j = i - 1;

            while(j >= 0 && (mlist[j].getLocation().getCounty().compareTo(k.getLocation().getCounty())==1)){
                mlist[j + 1] = mlist[j];
            }
        }
    }
    //sort by the expiration date
    public void printByExpirationDate() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(mlist[i].getExpire().compareTo(mlist[j].getExpire()) > 0){
                    System.out.println(mlist[i]);
                }
            }
        }
    }
    //sort by last name and then first name
    public void printByName() {
//        Arrays.sort(mlist, new Member());
//        for(int i = 0; i < size; i++){
//                if((mlist[i].getFname().compareTo(mlist[i].getLname()) > 0) ){
//                    System.out.println(mlist[i]);
//                }
//        }
    }

    private Date getBirthDate() {
        return null;
    }

    public static void main(String[] args) {
//        Date date1 = new Date("01/02/2026");
//        Date date2 = new Date("01/02/2022");
//        Date date3 = new Date("01/02/2023");
//
//        Location location3 = Location.Bridgewater;
//        Location location2 = Location.Edison;
//        Location location1 = Location.Franklin;
//        Location location4 = Location.Piscataway;
//        Location location5 = Location.Somerville;
//
//        Member member1 = new Member("john", "lukas ", date1, date2, location1);
//        Member member2 = new Member("tomas", "mike ", date1, date2, location2);
//        Member member3 = new Member("micheal", "tomas ", date2, date1, location3);
//        Member member4 = new Member("mike", "tato ", date1, date2, location4);
//        Member member5 = new Member("mebre", "bajo ", date1, date2, location5);
//
//        MemberDatabase md = new MemberDatabase();
//        md.add(member1);
//        md.add(member2);
//        md.add(member3);
//        md.add(member4);
//        md.add(member5);

//        md.remove(member3);

//        md.print();
//        md.printByName();
//        System.out.println(md.find(member1));
//        md.printByExpirationDate();
//        md.printByCounty();

    }
}


