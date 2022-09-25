package edu.rutges.cs213;
public class MemberDatabase {
    private Member [] mlist;
    private int size;

    private int find(Member member) {
        int NOT_FOUND = -1;
        for(int i = 0; i < mlist.length; i++){
            if(member.equals(mlist[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }
    private void grow() {

    }
    public boolean add(Member member) {
        for(int i = 0; i < mlist.length; i++){
            if(member != null){
                mlist[i] = member;
            }
        }
        return true;
    }

    public boolean remove(Member member) {
        for (int i = 0; i < mlist.length; i++){
            if(member.equals(mlist[i])){
                mlist[i] = null;
            }
        }
        return false;
    }

    //print the array contents as is
    public void print() {
        for(int i = 0; i < mlist.length; i++){
            System.out.println(mlist[i].toString());
        }
    }
    //sort by county and then zipcode
//    Bridgewater, 08807, Somerset County
    public void printByCounty() {

    }
    //sort by the expiration date
    public void printByExpirationDate() {

    }
    //sort by last name and then first name
    public void printByName() {
//        Member temp;
//        for(int i = 0; i < mlist.length; i++){
//            for(int j = 0; j < mlist.length; j++){
//                if(mlist[i].compareTo(mlist[j]) > 0){
//                    temp = mlist[i];
//                    mlist[i] = mlist[j];
//                    mlist[j] = temp;
//                }
//            }
//        }
    }

    public static void main(String[] args) {
//        Member m=new Member("hu", "kk", "")
    }
}
