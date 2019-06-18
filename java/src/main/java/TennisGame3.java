
public class TennisGame3 implements TennisGame {

    public static final String[] SCORE_NAME = {"Love", "Fifteen", "Thirty", "Forty"};
    private int point2;
    private int point1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String p1N, String p2N) {
        this.player1Name = p1N;
        this.player2Name = p2N;
    }

    public String getScore() {
        if (point1 < 4 && point2 < 4) {
            if (point1 + point2 == 6) return "Deuce";
            return (point1 == point2) ? SCORE_NAME[point1] + "-All" : SCORE_NAME[point1] + "-" + SCORE_NAME[point2];
        } else {
            if (point1 == point2) {
                return "Deuce";
            }
            String s = point1 > point2 ? player1Name : player2Name;
            return ((point1 - point2) * (point1 - point2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            this.point1 += 1;
        else
            this.point2 += 1;

    }

}
