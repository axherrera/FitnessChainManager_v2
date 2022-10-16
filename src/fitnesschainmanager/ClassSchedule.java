package fitnesschainmanager;

public class ClassSchedule {
    private FitnessClass[] classes;
    private int numClasses;
    private final int NOT_FOUND = -1;

    public ClassSchedule(){
        classes = new FitnessClass[4];
        numClasses = 4;
    }

    public FitnessClass[] getClasses() {
        return classes;
    }

    /**
     * Used to grow the size of the array by increments of 4 when full
     */
    private void grow() {
        FitnessClass[] temp = new FitnessClass[numClasses+4];
        for(int i = 0; i<numClasses; i++){
            temp[i] = classes[i];
        }
        classes = temp;
        numClasses+=4;
    }

    /**
     * A method to check if class schedule is full
     * @return If class schedule is full return true, otherwise return false
     */
    private boolean isFull(){
        for(int i = 0; i < numClasses; i++){
            if(classes[i] == null)
                return false;
        }
        return true;
    }

    /**
     * Adds a class to the first empty spot in the class schedule
     * If the schedule is full, grow() is called to expand capacity
     * @param fitnessClass class to be added into class schedule
     * @return if class is successfully added return true, otherwise return false
     */
    public boolean add (FitnessClass fitnessClass) {
        if(isFull())
            grow();
        for(int i = 0; i < numClasses; i++){
            if(classes[i] == null){
                classes[i] = fitnessClass;
                return true;
            }
        }
        return false;
    }

    /**
     * Find a fitness class in the class schedule
     * @param fitnessClass
     * @return index found if successful, -1 if class not found
     */
    public int find(FitnessClass fitnessClass) {
        for(int i = 0; i < numClasses; i++){
            if(fitnessClass.equals(classes[i])){
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * To get the class from the schedule
     * @param fitnessClass fitness class
     * @return return class if found, null if class not found in database
     */
    public FitnessClass getFitnessClass(FitnessClass fitnessClass){
        if(find(fitnessClass) == NOT_FOUND)
            return null;
        return classes[find(fitnessClass)];
    }
}
