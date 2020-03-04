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
            return getScoreResultOfAnyScoreGreaterThanFour(player1Score, player2Score);
        } else {
            return getScoreResultOfCommon(player1Score, player2Score);
        }
    }

    private static String getScoreResultOfCommon(int player1Score, int player2Score) {
        int tempScore;
        StringBuilder score = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score.append("-");
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    private static String getScoreResultOfAnyScoreGreaterThanFour(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
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