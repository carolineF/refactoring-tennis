package cn.xpbootcamp.tennis.game1;

public class Player {
    private String playerName;
    private int playerScore = 0;

    public Player(String playerName) {
        this.setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void wonPoint() {
        setPlayerScore(getPlayerScore() + 1);
    }

    public String getScore() {
        String[] playerScores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return playerScores[getPlayerScore()];
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
