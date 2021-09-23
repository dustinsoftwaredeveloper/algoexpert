//One function
//O(n) time, O(k) space

import scala.collection.mutable.Map

object Solution {
  def tournamentWinner(competitions: Array[Array[String]], results: Array[Int]): String = {
    var currentBestTeam: String = ""
    var scores: collection.mutable.Map[String, Int] = Map()
    scores += ((currentBestTeam, 0))
    for((competition, idx) <- competitions.zipWithIndex) {
      val Array(homeTeam, awayTeam): Array[String] = competition
      var winner: String = ""
      if(results(idx) == 1) winner = homeTeam
      else winner = awayTeam
      if(scores.get(winner) == None) scores += ((winner, 0))
      scores += ((winner, scores(winner) + 3))
      if(scores(winner) > scores(currentBestTeam)) currentBestTeam = winner
    }
    return currentBestTeam
  }
}