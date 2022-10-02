package FitnessManager;

/**
 * Created a MemberDatabase class
 * @author ALEJANDRO HERRERA-PINEDA, HURUY BELAY
 */
public class MemberDatabase {
    private Member [] mlist;
    private int size;
    private final int NOT_FOUND = -1;

    /**
     * It initializes the array size
     */
    public MemberDatabase() {
        mlist = new Member[4];
        size = 4;
    }

    /**
     * grow the size of the array
     */
    private void grow() {
        Member[] temp = new Member[size+4];
        for(int i = 0; i<size; i++){
            temp[i] = mlist[i];
        }
        mlist = temp;
        size+=4;
    }

    /**
     * A method to check if database is full
     * @return boolean
     */
    private boolean isFull(){
        for(int i = 0; i < size; i++){
            if(mlist[i] == null)
                return false;
        }
        return true;
    }

    /**
     * To check is the array is empty
     * @return boolean
     */
    public boolean isEmpty(){
        for(int i = 0; i < size; i++){
            if(mlist[i] != null)
                return false;
        }
        return true;
    }

    /**
     * Add member to the array
     * If the array empty apply the grow method
     * @param member member
     * @return boolean
     */
    public boolean add (Member member) {
        if(isFull())
            grow();
        else if(find(member) != NOT_FOUND)
            return false;
        else
            for(int i = 0; i < size; i++){
            if(mlist[i] == null){
                mlist[i] = member;
                return true;
            }
        }
        return false;
    }

    /**
     * Find a member from the array
     * @param member
     * @return
     */
    private int find(Member member) {
        for(int i = 0; i < size; i++){
            if(member.equals(mlist[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * To get the member from the array
     * @param m member
     * @return array list
     */
    public Member getMember(Member m){
         if(find(m) == NOT_FOUND)
             return null;
         return mlist[find(m)];
    }

    /**
     * Remove the member from the array
     * @param member member
     * @return boolean
     */
    public boolean remove( Member member) {
        int index = find(member);
        if (index == NOT_FOUND)
            return false;
        mlist[find(member)] = null;
        for(int i = index+1; i <size; i++){
            Member temp = mlist[i-1];
            mlist[i-1] = mlist[i];
            mlist[i] = temp;
        }
        return true;
    }

    /**
     * Printing the array contents as is
     */
    private void print() {
        for(int i = 0; i < size; i++){
            if(this.mlist[i] != null)
                System.out.println(mlist[i]);
        }
        System.out.println("-end of list-\n");
    }

    /**
     * prints after sorted by county and then zipcode
     * this is giving a null pointer exception
     */
    public void printDatabase(){
        if(isEmpty()){
            System.out.println("Member database is empty!");
            return;
        }
        System.out.println("-list of members-");
        print();
    }

    /**
     * Prints by county
     * it sorts by county
     */
    public void printByCounty() {
        if(isEmpty()){
            System.out.println("Member database is empty!");
            return;
        }
        for(int i = 1; i < size; ++i){
            Member k = mlist[i];
            int j = i - 1;
            while( j >= 0 && (mlist[j] != null && mlist[i] != null) && (mlist[j].getLocation().getRank() > k.getLocation().getRank())){
                mlist[j + 1] = mlist[j];
                j = j - 1;
            }
            mlist[j + 1] = k;
        }
        System.out.println("-list of members sorted by county and zipcode-");
        print();
    }

    /**
     * Sort by the expiration date
     */
    public void printByExpirationDate() {
        if(isEmpty()){
            System.out.println("Member database is empty!");
            return;
        }
        for(int i = 1; i < size; ++i) {
            Member k = mlist[i];
            int j = i - 1;
            while(j >= 0 && (mlist[j] != null && mlist[i] != null) &&(mlist[j].getExpire().compareTo(k.getExpire())) > 0){
                mlist[j + 1] = mlist[j];
                j = j - 1;
            }
            mlist[j + 1] = k;
        }
        System.out.println("-list of members sorted by membership expiration date-");
        print();
    }

    /**
     * After sorting by last name and then first name and then printing
     */
    public void printByName() {
        if(isEmpty()){
            System.out.println("Member database is empty!");
            return;
        }
        for(int i = 0; i < size; i++){
            Member k = mlist[i];
            int j = i - 1;
            while(j >= 0 && (mlist[j] != null && mlist[i] != null) && (mlist[j].getLname().compareTo(k.getLname())) > 0){
                mlist[j + 1] = mlist[j];
                j = j - 1;
            }
            mlist[j + 1] = k;
        }
        System.out.println("-list of members sorted by last name, and first name-");
        print();
    }

    /**
     * The main class to check if the methods are working properly
     * @param args parameters
     */
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
        md.printByName();
        System.out.println(md.find(member1));
        md.printByExpirationDate();
        md.printByCounty();

    }
}