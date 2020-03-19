/**
 * @author erfan omid seyed
 * this class have 4 field and it's about student of a school
 * @since 2020-01-24
 *
 */

public class Lab {

    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * Create a new Lab with a given capacity and day.
     *
     * @param cap capacity of Lab
     * @param d day of Lab
     */
    public Lab(int cap,String d){
        capacity = cap;
        students = new Student[cap];
        day = d;
        currentSize = 0;
    }

    /**
     * this is method adds a student
     * @param std this is the student
     */
    public void enrollStudent(Student std){
        if(currentSize < capacity){
            students[currentSize] = std;
            currentSize++;
        }else System.out.println("Lab is full!!!");
    }
    public void print(){
        for (int i = 0; i < students.length; i++) {
            System.out.println("fName: " + students[i].getFirstName()
                    + " id:" + students[i].getId()  +
                    " grade:"+ students[i].getGrade());
        }
        System.out.println("Lab AVG:" + avg);
    }
    /**
     * get the first name of student
     * @return firstName field
     */
    public Student[] getStudents(){
        return students;
    }
    /**
     * get the average of lab
     * @return avg field
     */
    public int getAvg() {
        return avg;
    }
    /**
     * get the capacity of lab
     * @return capacity field
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * get the current Size of lab
     * @return currentSize field
     */
    public int getCurrentSize() {
        return currentSize;
    }
    /**
     * get the day
     * @return day field
     */
    public String getDay() {
        return day;
    }
    /**
     *  @param avg set average of a lab
     */
    public void setAvg(int avg) {
        this.avg = avg;
    }
    /**
     *  @param day set day
     */
    public void setDay(String day) {
        this.day = day;
    }
    /**
     *  @param capacity set capacity of a lab
     */
    public void setCapt(int capacity) {
        this.capacity = capacity;
    }
    /**
     *  @param currentSize set current Size of a lab
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
    /**
     *  @param students set students of a lab
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }
}
