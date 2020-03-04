package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return getScoreResultOfEqualScores(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            return getScoreResultOfAnyScoreGreaterThanFour(player1Score - player2Score);
        } else {
            return getScoreResultOfCommon(player1Score, player2Score);
        }
    }

    private static String getScoreResultOfCommon(int player1Score, int player2Score) {
        StringBuilder score = new StringBuilder();

        score.append(getScoreStringByScore(player1Score));
        score.append("-");
        score.append(getScoreStringByScore(player2Score));

        return score.toString();
    }

    private static String getScoreStringByScore(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private static String getScoreResultOfAnyScoreGreaterThanFour(int scoreDifference) {
        if (scoreDifference == 1) {
            return "Advantage player1";
        }
        if (scoreDifference == -1) {
            return "Advantage player2";
        }
        if (scoreDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private static String getScoreResultOfEqualScores(int player1Score) {
        switch (player1Score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";

        }
    }
}