package FitnessManager;

public class MemberDatabase {
    private Member [] mlist;
    private int size;
    public MemberDatabase() {
        mlist = new Member[4];
        size = 4;
    }

    // grow the size of the array
    private void grow() {
        Member temp[] = new Member[size+4];
        for(int i = 0; i<size; i++){
            temp[i]=mlist[i];
        }
        mlist = temp;
        size+=4;

    }

    //method to check if database is full
    private boolean isFull(){
        for(int i=0; i<size; i++){
            if(mlist[i]==null)
                return false;
        }
        return true;
    }

    //add member to the array
    public boolean add (Member member) {
//        if(!validateNewMember(member))
//            return false;
        if(isFull())
            grow();
        for(int i = 0; i<size; i++){
            if(mlist[i]==null){
                mlist[i]=member;
                return true;
            }
        }
        return false;
    }
    // find a member from the array
    private int find(Member member) {
        for(int i = 0; i < size; i++){
            if(member.equals(mlist[i])){
                return i;
            }
        }
        return -1;
    }
    // remove the member from the array
    public boolean remove( Member member) {
        if (find(member) == -1)
            return false;
        mlist[find(member)] = null;
        return true;
    }



    //print the array contents as is
    public void print() {
        for(int i = 0; i < size; i++){
            if(this.mlist[i] != null)
                System.out.println(mlist[i]);
        }
    }

    //sort by county and then zipcode
    //this is giving a null pointer exception
    public void printByCounty() {
        for(int i = 0; i < mlist.length; i++){
            for(int j = i+1; j< mlist.length; j++){
                if(mlist[i].getLocation().getCounty().compareTo(mlist[j].getLocation().getZipcode()) > 0){
                    System.out.println(mlist[j]);
                }
            }

        }

    }
    //sort by the expiration date
    public void printByExpirationDate() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(mlist[i].getExpire().compareTo(mlist[j].getExpire()) > 1){
                    System.out.println(mlist[i]);
                }
            }
        }
    }
    //sort by last name and then first name
    public void printByName() {
        for(int i = 0; i < size; i++){
            if((mlist[i].getLname().compareTo(mlist[i].getFname()) > 0) ){
                System.out.println(mlist[i]);
            }
        }
    }

    public static void main(String[] args) {
        Date date1 = new Date("01/02/2026");
        Date date2 = new Date("01/02/2022");
        Date date3 = new Date("01/02/2023");

        Location location3 = Location.BRIDGEWATER;
        Location location2 = Location.EDISON;
        Location location1 = Location.FRANKLIN;
        Location location4 = Location.PISCATAWAY;
        Location location5 = Location.SOMERVILLE;

        Member member1 = new Member("John", "Lukas ", date1, date2, location1);
        Member member2 = new Member("Tomas", "Mike ", date1, date2, location2);
        Member member3 = new Member("Micheal", "Tomas ", date2, date1, location3);
        Member member4 = new Member("Mike", "Tato ", date1, date2, location4);
        Member member5 = new Member("Gebre", "Bajo ", date1, date2, location5);
        Member member6 = new Member("m6", "dskjfl ", date1, date2, location4);
        Member member7 = new Member("m7", "skdlflkdsf ", date1, date2, location5);

        MemberDatabase md = new MemberDatabase();
        md.add(member1);
        md.add(member2);
        md.add(member3);
        md.add(member4);
        md.add(member5);
        md.add(member6);
        md.add(member7);

        md.remove(member3);

        md.print();
        //md.printByName();
        //System.out.println(md.find(member1));
        //md.printByExpirationDate();
        //md.printByCounty();

    }
}


