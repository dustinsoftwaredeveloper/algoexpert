/* 
Sample Input
competitions: Array[Array[String]] = Array(
Array("HTML", "C#"), 
Array("C#", "Python"), 
Array("Python", "HTML")
)

results: Array[Int] = Array(0, 0, 1)

Sample Output
"Python"
*/

import scala.collection.mutable.Map

object Solution {
  def tournamentWinner(competitions: Array[Array[String]], results: Array[Int]): String = {
    var scores: collection.mutable.Map[String, Int] = Map()
    var currentBestTeam: String = ""
    scores += ((currentBestTeam, 0))
    for((competition, idx) <- competitions.zipWithIndex) {
      val Array(homeTeam, awayTeam): Array[String] = competition
      var winner: String = ""
      if(results(idx) == 1) winner = homeTeam
      else winner = awayTeam
      updateScores(winner, 3, scores)
      if(scores(winner) > scores(currentBestTeam)) currentBestTeam = winner
    }
    return currentBestTeam
  }
  
  def updateScores(winner: String, points: Int, scores: collection.mutable.Map[String, Int]): Unit = {
    if(scores.get(winner) == None) scores += ((winner, 0))
    scores += ((winner, scores(winner) + 3))
  }
}