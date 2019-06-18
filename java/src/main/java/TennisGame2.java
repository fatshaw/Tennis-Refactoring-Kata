
public class TennisGame2 implements TennisGame {
    public static final int SCORE_THREE = 4;
    public int P1point = 0;
    public int P2point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (equalScore(P1point, P2point)) {
            return equalScoreResult();
        }

        if (combatScore(P1point, P2point)) {
            return combatScoreResult();
        }

        return winScoreResult();

    }

    private String combatScoreResult() {
        return getNameForScore(P1point) + "-" + getNameForScore(P2point);
    }

    private String equalScoreResult() {
        if (P1point == 0)
            return "Love-All";
        if (P1point == 1)
            return "Fifteen-All";
        if (P1point == 2)
            return "Thirty-All";

        return "Deuce";
    }

    private String winScoreResult() {
        int diff = P1point - P2point;
        if (diff == 1) {
            return "Advantage player1";
        }

        if (diff == -1) {
            return "Advantage player2";
        }

        if (diff >= 2) {
            return "Win for player1";
        }
        if (diff <= -2) {
            return "Win for player2";
        }
        return "";
    }

    private boolean combatScore(int p1point, int p2point) {
        return p1point < SCORE_THREE && p2point < SCORE_THREE;
    }

    private boolean equalScore(int p1point, int p2point) {
        return p1point == p2point;
    }

    private String getNameForScore(int score) {
        if (score == 0)
            return "Love";
        if (score == 1)
            return "Fifteen";
        if (score == 2)
            return "Thirty";
        if (score == 3)
            return "Forty";
        return "";
    }


    public void wonPoint(String player) {
        if (player == player1Name)
            P1point++;
        if (player == player2Name)
            P2point++;
    }
}