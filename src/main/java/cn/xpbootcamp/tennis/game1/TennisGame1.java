package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1.getPlayerName()))
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (player1.getPlayerScore() == player2.getPlayerScore()) {
            return getScoreResultOfEqualScores(player1);
        }
        if (player1.getPlayerScore() >= 4 || player2.getPlayerScore() >= 4) {
            return getScoreResultOfAnyScoreGreaterThanFour(player1, player2);
        }
        return getScoreResultOfCommon(player1, player2);
    }

    private static String getScoreResultOfCommon(Player player1, Player player2) {
        StringBuilder score = new StringBuilder();

        score.append(player1.getScore());
        score.append("-");
        score.append(player2.getScore());

        return score.toString();
    }

    private static String getScoreResultOfAnyScoreGreaterThanFour(Player player1, Player player2) {
        int scoreDifference = player1.getPlayerScore() - player2.getPlayerScore();
        if (scoreDifference == 1) {
            return "Advantage " + player1.getPlayerName();
        }
        if (scoreDifference == -1) {
            return "Advantage " + player2.getPlayerName();
        }
        if (scoreDifference >= 2) {
            return "Win for " + player1.getPlayerName();
        }
        return "Win for " + player2.getPlayerName();
    }

    private static String getScoreResultOfEqualScores(Player player) {
        if (player.getPlayerScore() >= 3) {
            return "Deuce";
        }
        return player.getScore() + "-All";
    }
}