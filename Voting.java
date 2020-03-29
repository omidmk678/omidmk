import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class implements the vote.
 * if type field equals 0 it means that there is
 * a single vote and if type field equals 1 then
 * we will have a multi vote.
 * */
public class Voting {

    public int type;
    private String question;
    private ArrayList<Person> voters;
    public HashMap<String, HashSet<Vote>> listOfVotesToChoice;

    /**
     * Constructor for Voting
     * @param type refers to type of vote
     * @param question question of vote
     */
    public Voting(int type,String question){
        this.type = type;
        this.question = question;
        voters = new ArrayList<>();
        listOfVotesToChoice = new HashMap<>();
    }

    /**
     * getter for question
     * @return question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * add an option to vote
     * @param option option to add
     */
    public void createChoice(String option){
        HashSet<Vote> votes = new HashSet<>();
        listOfVotesToChoice.put(option,votes);
    }
    public void vote(Person voter,ArrayList<String> voteOptions){
        JalaliCalendar date = new JalaliCalendar(new GregorianCalendar());
        Vote vote = new Vote(voter,date.toString());
        voters.add(voter);
        for (String voteOption : voteOptions) {
            if (voteOptions.size() <= listOfVotesToChoice.keySet().size()) {
                if (type == 0) {
                    listOfVotesToChoice.get(listOfVotesToChoice.keySet().toArray()[Integer.parseInt(voteOptions.get(0)) - 1]).add(vote);
                } else {
                    listOfVotesToChoice.get(listOfVotesToChoice.keySet().toArray()[Integer.parseInt(voteOption) - 1]).add(vote);
                }
            }
        }
    }

    /**
     * getter for voters
     * @return voters
     */
    public void getVoters(){
        JalaliCalendar jalaliCalendar = new JalaliCalendar(new GregorianCalendar());
        for (int i=0 ; i<voters.size() ; i++)
            System.out.println("voter " + (i+1) + " : " + voters.get(i).getFirstName() + " " + voters.get(i).getLastName() +  "      voting at: " + jalaliCalendar );
    }

    /**
     * print the result of vote
     */
    public void printVoters(){
        for (String option : listOfVotesToChoice.keySet()){
            System.out.println("option : " + option + " has " + listOfVotesToChoice.get(option).size() + " votes.");
        }
    }

    /**
     * returns options of a voting
     * @return list of options
     */
    public ArrayList<String> getChoices(){
        return new ArrayList<>(listOfVotesToChoice.keySet());
    }

}
