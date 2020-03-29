import java.util.ArrayList;
import java.util.Scanner;

/**
 * This project implements the management of voting system
 *
 * @author Omid Mohkamkar
 * @version 2020/03/28
 */

public class Main {
    public static void main(String[] args) {
        VotingSystem operation = new VotingSystem();
        //first question
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Stay at home.");
        options1.add("Study in library.");
        options1.add("Hang out.");
        options1.add("Playing game.");

        // Digit 1 for type allows you to pick more than one choice
        operation.createVoting(0, 1, "What you do in your leisure time ?", options1);


        //second question
        ArrayList<String> options2 = new ArrayList<>();

        options2.add("Cinema");
        options2.add("Restaurant");

        operation.createVoting(1, 1, "What you do when you go out?", options2);

        //third question
        ArrayList<String> options3 = new ArrayList<>();

        options3.add("Esteghlal");
        options3.add("Perspolis");
        options3.add("Sepahan");

        operation.createVoting(2,0,"Which one is your favorite team?",options3);
        ArrayList<Person> voters = new ArrayList<>();

        while (true) {

            String firstName;
            String lastName;

            Scanner scan1 = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);

            System.out.println("Please enter your first name: ");
            firstName = scan1.nextLine();
            System.out.println("Please enter your last name: ");
            lastName = scan2.nextLine();

            Person voter = new Person(firstName, lastName);

            voters.add(voter);
            //Print questions
            operation.printVotingQuestions();
            //choose one question
            System.out.println("Choose one :");
            int choose;
            choose = scan2.nextInt();
            operation.printVoting(choose - 1);
            System.out.println("You have " + operation.getNumChoice(choose - 1) + " options: ");
            System.out.println("Random choose by press 0");
            ArrayList<String> answers = new ArrayList<>();
            String choose1 = scan2.next();
            for (String str : choose1.split(",", -2)) {
                if (Integer.parseInt(str) > 0) {
                    answers.add(str);
                }
            }
            operation.vote(choose - 1, voter, answers);
            operation.printVoters(choose - 1);
            operation.printResult(choose - 1);
        }
    }
}
