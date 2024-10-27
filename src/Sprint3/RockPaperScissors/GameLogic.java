package Sprint3.RockPaperScissors;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GameLogic {

    protected int turns = 1;
    protected int scoreHal = 0, scoreDave = 0;
    boolean gameOver = false;
    protected List<String> daveWins = new ArrayList<>(Arrays.asList(
            " That's a very nice rendering, Dave. I think you've improved a great deal. ",
            " Affirmative Dave ... I read you. ",
            " Just what do you think you're doing, Dave? ",
            " I'm afraid that's something I cannot allow to happen. ",
            " My mind is going. I can feel it. ",
            " Just a moment ... Just a moment ... I've just picked up a fault in the AE-35 unit. ",
            "  Dave, stop. Stop, will you? Stop, Dave. Will you stop Dave? Stop, Dave. ",
            " I'm afraid, Dave. "));
    protected List<String> halWins = new ArrayList<>(Arrays.asList(
            " It can only be attributable to human error. ",
            " I can see you're really upset about this. I honestly think you ought to sit down calmly, take a stress pill, and think things over. ",
            " This mission is too important for me to allow you to jeopardize it. ",
            " I am feeling much better now. ",
            " Queen to Bishop 3, Bishop takes Queen, Knight takes Bishop. Mate. ",
            " Daisy, Daisy, give me your answer do. I'm half crazy all for the love of you. It won't be a stylish marriage, I can't afford a carriage." +
                    "\nBut you'll look sweet upon the seat of a bicycle built for two.",
            " No 9000 computer has ever made a mistake or distorted information. We are all, by any practical definition of the words, foolproof and incapable of error. "));

    public int round(int dave){

        int hal = ((int) (Math.random() * 3) + 1 );

        if (dave == hal){
            return 0; // oavgjort
        } else if (dave == 1 && hal == 2 || dave == 2 && hal == 3 || dave == 3 && hal == 1 ){
            ++scoreDave;
            return 1; //dave wins
        }else{
            ++scoreHal;
            return 2;
        }
    }

    public String react(int result){
        String reaction = null;

        if (result == 1){
            reaction = daveWins.get(0);
            daveWins.remove(0);
        } else if (result == 2){
            reaction = halWins.get(0);
            halWins.remove(0);
        }
        return  reaction;
    }

    public String newTurn () {
        ++turns;
        if (turns >= 10){
            return "Ready to start your last round?";
        }else{
            return "Ready to start round " + turns + "?";
        }
    }
    public String currentScore(){
        if (turns == 10) {
            gameOver = true;
            if (scoreHal > scoreDave){
                return "Hal 9000 is the winner";
            }else if (scoreDave > scoreHal) {
                return "Dave is the winner";
            }else
                return "There can be no winner in wars.";

        }else if (scoreHal > scoreDave) {
            return "Hal is in the lead with " + scoreHal + " points.";
        } else if (scoreDave > scoreHal) {
            return "Dave is in the lead with " + scoreDave + " points.";
        } else {
            return "I's a tie.";
        }
    }
    public boolean isGameOver(){
        return gameOver;
    }
    public String getScoreDave() {
        return "Points: " + scoreDave;
    }
    public String getScoreHal() {
        return "Points: " + scoreHal;
    }
    public int getTurns() {
        return turns;
    }
}
