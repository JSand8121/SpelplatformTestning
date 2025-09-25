package platform;

public class HighScoreHandler {
    public HighScoreHandler(){
    }

    public String[] getHighScores(){
        //TODO Skriva metoden
        throw new RuntimeException("Den här metoden måste vara implementerade");
    }

    public boolean addNewScore(String newScore, String newName) {
        //Todo Skriva metoden
        return false;
    }
    
    public String showHighScores(){
        StringBuilder results = new StringBuilder();
        String[] scoreResults = getHighScores();
        if(scoreResults.length < 1) {
            results = new StringBuilder("Ingen höga poäng");
        } else {
            results = new StringBuilder("---Högsta poäng----\n");

            for (int i = 0; i < scoreResults.length; i++) {
                String[] score = scoreResults[0].split("-");
                results.append(score[0]).append("---").append(score[1]);
            }
        }

        return results.toString();
    }
}
