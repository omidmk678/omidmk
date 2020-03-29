public class Person {

    /**
     * This class holds information of every voters
     */
    private String firstName;
    private String lastName;

    /**
     * Constructor for Person
     * @param firstName refers to person's first name
     * @param lastName refers to person's last name
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * getter for firstName
     * @return first name of person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getter for lastName
     * @return last name of person
     */
    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString(){
        return "Full Name : " + firstName + " " + lastName;
    }
}
