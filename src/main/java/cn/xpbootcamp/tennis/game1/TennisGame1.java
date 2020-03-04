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
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            score = getScoreResultOfEqualScores(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            score = getScoreResultOfAnyScoreGreaterThanFour(player1Score, player2Score);
        } else {
            getScoreResultOfCommon(score, player1Score, player2Score);
        }
        return score.toString();
    }

    private static void getScoreResultOfCommon(StringBuilder score, int player1Score, int player2Score) {
        int tempScore;
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
    }

    private static StringBuilder getScoreResultOfAnyScoreGreaterThanFour(int player1Score, int player2Score) {
        StringBuilder score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private static StringBuilder getScoreResultOfEqualScores(int player1Score) {
        StringBuilder score;
        switch (player1Score) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}