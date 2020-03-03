package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int player1Score = 0;
    public int player2Score = 0;

    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score && player1Score < 4) {
            if (player1Score == 0)
                score = "Love";
            if (player1Score == 1)
                score = "Fifteen";
            if (player1Score == 2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Score == player2Score && player1Score >= 3)
            score = "Deuce";

        if (player1Score > 0 && player2Score == 0) {
            if (player1Score == 1)
                player1Result = "Fifteen";
            if (player1Score == 2)
                player1Result = "Thirty";
            if (player1Score == 3)
                player1Result = "Forty";

            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (player2Score > 0 && player1Score == 0) {
            if (player2Score == 1)
                player2Result = "Fifteen";
            if (player2Score == 2)
                player2Result = "Thirty";
            if (player2Score == 3)
                player2Result = "Forty";

            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }

        if (player1Score > player2Score && player1Score < 4) {
            if (player1Score == 2)
                player1Result = "Thirty";
            if (player1Score == 3)
                player1Result = "Forty";
            if (player2Score == 1)
                player2Result = "Fifteen";
            if (player2Score == 2)
                player2Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }
        if (player2Score > player1Score && player2Score < 4) {
            if (player2Score == 2)
                player2Result = "Thirty";
            if (player2Score == 3)
                player2Result = "Forty";
            if (player1Score == 1)
                player1Result = "Fifteen";
            if (player1Score == 2)
                player1Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }

        if (player1Score > player2Score && player2Score >= 3) {
            score = "Advantage player1";
        }

        if (player2Score > player1Score && player1Score >= 3) {
            score = "Advantage player2";
        }

        if (player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2) {
            score = "Win for player1";
        }
        if (player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    public void increasePlayer1Score() {
        player1Score++;
    }

    public void increasePlayer2Score() {
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player.equals(this.player1Name))
            increasePlayer1Score();
        else
            increasePlayer2Score();
    }
}