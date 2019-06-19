
public class TennisGame3 implements TennisGame {

    public static final String[] SCORE_NAME = {"Love", "Fifteen", "Thirty", "Forty"};
    public static final String DEUCE = "Deuce";
    public static final String ALL = "All";
    private int point2;
    private int point1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String p1N, String p2N) {
        this.player1Name = p1N;
        this.player2Name = p2N;
    }

    public String getScore() {
        return isSameScore() ? (isDeuce() ? deuce() : sameScore())
                : isNormalScore() ? normalScore()
                : isAdvantageScore() ? advantage() : win();
    }

    private String sameScore() {
        return SCORE_NAME[point1] + "-" + ALL;
    }

    private String deuce() {
        return DEUCE;
    }

    private String win() {
        return "Win for " + (point1 - point2 > 0 ? player1Name : player2Name);
    }

    private String advantage() {
        return "Advantage " + (point1 - point2 > 0 ? player1Name : player2Name);
    }

    private boolean isAdvantageScore() {
        return Math.abs(point1 - point2) == 1;
    }

    private boolean isDeuce() {
        return isSameScore() && point1 >= 3;
    }

    private String normalScore() {
        return SCORE_NAME[point1] + "-" + SCORE_NAME[point2];
    }

    private boolean isNormalScore() {
        return point1 < 4 && point2 < 4;
    }

    private boolean isSameScore() {
        return point1 == point2;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            this.point1 += 1;
        else
            this.point2 += 1;

    }

}
