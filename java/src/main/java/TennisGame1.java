
public class TennisGame1 implements TennisGame {

    public static final int SCORE_THREE = 4;
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        if (playerName == player2Name)
            m_score2 += 1;
    }

    public String getScore() {
        if (sameScore()) {
            return scoreForEqual(m_score1);
        }

        return compareScore();
    }

    private String compareScore() {
        if (greaterThanScoreThree()) {
            return scoreForAdvantage();
        }

        return scoreForCompare();
    }

    private boolean greaterThanScoreThree() {
        return m_score1 >= SCORE_THREE || m_score2 >= SCORE_THREE;
    }

    private boolean sameScore() {
        return m_score1 == m_score2;
    }

    private String scoreForCompare() {
        return getStringByScore(m_score1) + "-" + getStringByScore(m_score2);
    }

    private String getStringByScore(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String scoreForAdvantage() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String scoreForEqual(int score) {
        switch (score) {
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
