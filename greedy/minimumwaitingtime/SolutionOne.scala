/*
non empty arr of positive ints
one query can be executed at a time but can be in any order
(1, 4, 5) = 0 + 1 + 1 + 4 = 6
(5, 1, 4) = 0 + 5 + 5 + 1 = 11
(5, 4, 1) = 0 + 5 + 4 + 5 = 14

return the minimum amount of total waiting time for all of the queries
sample input
queries = (3, 2, 1, 2, 6)
sample output
17

sort (1, 2, 2, 3, 6)
result += 1 + 0 = 1
queriesBefore = 1
result += 2 + 1 = 4
queriesbefore = 2 + 1 = 3
result += 2 + 2 + 1
queriesbefore = 2 + 2 + 1
result = 3 + 2 + 2 + 1

0 + 1 + 1 +2 + 1+2 +2 + 1+2+2 +3 = 17

val queries: Array[Int] = Array(3, 2, 1, 2, 6)
Solution.minimumWaitingTime(queries)
*/

object Solution {
  def minimumWaitingTime(queries: Array[Int]): Int = {
    if(queries.length <= 1) return 0
    val queriesSorted: Array[Int] = queries.sortWith(_ < _)
    var result: Int = 0
    var queriesBefore = 0
    for(i <- 1 to queriesSorted.length - 1) {
      result += queriesSorted(i - 1) + queriesBefore
      queriesBefore = result
    }
    return result
  }
}

/*
(1, 2, 2, 3, 6)
0, 1, 2, 3, 4
each valid waiting time times the amount waited
1*1  1*1 + 2*1  1*1+ 2*1 + 2*1  1*1+2*1+2*1+3*1
val queries: Array[Int] = Array(3, 2, 1, 2, 6)
Solution.minimumWaitingTime(queries)

O(nlogn + n) time, O(1) space
*/

object Solution {
  def minimumWaitingTime(queries: Array[Int]): Int = {
    var sum: Int = 0
    for((time, i) <- queries.sortWith(_ < _).zipWithIndex) {
      sum += time * (queries.length - 1 - i)
    }
    return sum
  }
}

object Solution {
  def minimumWaitingTime(queries: Array[Int]): Int = {
    var sum: Int = 0
    queries.sortWith(_ < _).zipWithIndex.foreach {
      case(time, i) => sum += time * (queries.length - 1 - i)
    }
    return sum
  }
}