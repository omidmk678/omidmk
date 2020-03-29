import java.util.ArrayList;

/**
 * This class manages the whole project.
 * Votes are define here.
 */
public class VotingSystem {
    ArrayList<Voting> votingList;

    /**
     * Constructor for VotingSystem
     */
    public VotingSystem(){
        votingList = new ArrayList<>();
    }

    /**
     * Vote creates in this method with question
     * and options and its vote type.
     * @param voteQuestion question of vote
     * @param voteType type of vote
     * @param voteOptions options for vote
     */
    public void createVoting(int index, int voteType,String voteQuestion,ArrayList<String>  voteOptions){
        Voting voting = new Voting(voteType,voteQuestion);
        votingList.add(voting);
        voteOptions.forEach((a) -> votingList.get(index).createChoice(a));
    }

    /**
     * print questions of vote
     */
    public void printVotingQuestions(){
//        for (int i=0 ; i< votingList.size() ; i++)
//            System.out.println("Question " + (i+1) + " : " + votingList.get(i).getQuestion());
        int index = 1;
        for(Voting voting : votingList){
            System.out.println("Question " + index + " : " + voting.getQuestion());
            index++;
        }
    }

    /**
     * print a voting question with all choices
     * @param printVote index of vote to print
     */
    public void printVoting(int printVote){
        System.out.println(votingList.get(printVote).getQuestion());
        for (int i=0 ; i<votingList.get(printVote).getChoices().size() ; i++)
            System.out.println((i+1) + " : " + votingList.get(printVote).getChoices().get(i));
    }

    /**
     * create a vote
     * @param voteID index of voting
     * @param voter  voter
     * @param Selected selected option
     */
    public void vote(int voteID,Person voter,ArrayList<String> Selected){
        if (votingList.get(voteID).type == 1)
            votingList.get(voteID).vote(voter,Selected);
        else {
            System.out.println("You can only pick one choice");
            votingList.get(voteID).vote(voter, Selected);
        }
    }

    /**
     * prints the result of vote
     */
    public void printResult(int index){
        votingList.get(index).printVoters();
    }
    public void printVoters(int index){votingList.get(index).getVoters(); }
    public int getNumChoice(int index){return votingList.get(index).getChoices().size(); }

}
