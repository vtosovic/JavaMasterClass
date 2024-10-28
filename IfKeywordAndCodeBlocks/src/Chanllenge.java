public class Chanllenge {
    public static void main(String[] args) {

        int playerPosition = calculateHighScorePosition(1500);
        System.out.println(displayHighScorePosition("Tim",playerPosition));

        playerPosition = calculateHighScorePosition(1000);
        System.out.println(displayHighScorePosition("Tod",playerPosition));

        playerPosition = calculateHighScorePosition(500);
        System.out.println(displayHighScorePosition("Triss",playerPosition));

        playerPosition = calculateHighScorePosition(100);
        System.out.println(displayHighScorePosition("Theodor",playerPosition));


    }

    public static String displayHighScorePosition(String playerName, int playerPosition) {

        String returnString = playerName + " managed to get into position " + playerPosition + " on the highs score list";
        return(returnString);
    }

    public static int calculateHighScorePosition(int playerScore) {
        int returnScore = 0;
        if (playerScore >= 1000) {
            returnScore = 1;
        }
        else if (playerScore >= 500) {
            returnScore = 2;
        }
        else if (playerScore < 500) {
            returnScore = 3;
        }
        else {
            returnScore = 4;
        }
        return(returnScore);
    }

}
