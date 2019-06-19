class TennisGame3(private val p1N: String, private val p2N: String) : TennisGame {

    private var p2: Int = 0
    private var p1: Int = 0

    override fun getScore(): String {
        return when {
            isSameScore() -> return if (isDeuce()) deuce() else sameScore()
            isNormalScore() -> normalScore()
            isAdvantage() -> advantageScore()
            else -> winScore()
        }
    }

    private fun deuce() = "Deuce"

    private fun isNormalScore() = p1 < 4 && p2 < 4

    private fun isAdvantage() = Math.abs(p1 - p2) == 1

    private fun isDeuce() = p1 >= 3 && isSameScore()

    private fun sameScore() = "${SCORE_NAME[p1]}-All"

    private fun normalScore() = "${SCORE_NAME[p1]}-${SCORE_NAME[p2]}"

    private fun winScore() = "Win for ${advPlayer()}"

    private fun advantageScore() = "Advantage ${advPlayer()}"

    private fun advPlayer(): String {
        return if (p1 > p2) p1N else p2N
    }

    private fun isSameScore() = p1 == p2

    override fun wonPoint(playerName: String) {
        if (playerName === p1N)
            this.p1 += 1
        else
            this.p2 += 1

    }

    companion object {
        private val SCORE_NAME = arrayOf("Love", "Fifteen", "Thirty", "Forty")
    }

}
