// two for loops
// O(n) time, O(k) space

import scala.collection.mutable.Map

object Solution {
  def tournamentWinner(competitions: Array[Array[String]], results: Array[Int]): String = {
    var scores: collection.mutable.Map[String, Int] = Map()
    for((competition, idx) <- competitions.zipWithIndex) {
      val result: Int = results(idx)
      val Array(homeTeam, awayTeam) = competition
      var winningTeam: String = ""
      if(result == 1) {
        winningTeam = homeTeam
      }
      else {
        winningTeam = awayTeam
      }
      updateScores(winningTeam, 3, scores)
    }
    val scoresSorted = scores.toSeq.sortWith(_._2 < _._2):_*
    val finalWinner = scoresSorted.toMap
    return finalWinner.keys
  }

  def updateScores(team: String, points: Int, scores: Map[String, Int]): Unit = {
    if(scores.get(team) == None) {
      scores += ((team, 0))
    }
    scores += ((team, scores(team) + 3))
  }
}