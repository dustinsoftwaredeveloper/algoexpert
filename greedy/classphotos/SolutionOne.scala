/*
even number of students, red or blue half half
two rows, each row same number, red in the same row, 
blue same, back row taller

val redShirtHeights: Array[Int] = Array(5, 8, 1, 3, 4)
val blueShirtHeights: Array[Int] = Array(6, 9, 2, 4, 5)
Solution.classPhotos(redShirtHeights, blueShirtHeights)

val redShirtHeights: Array[Int] = Array(4, 7)
val blueShirtHeights: Array[Int] = Array(5, 6)
Solution.classPhotos(redShirtHeights, blueShirtHeights)

sort compare enumerate
O(n^2) time, O(n) space, n = total data in both arrays
*/
object Solution {
  def classPhotos(red: Array[Int], blue: Array[Int]): Boolean = {
    val redSorted: Array[Int] = red.sortWith(_ < _)
    val blueSorted: Array[Int] = blue.sortWith(_ < _)
	
	for(i <- 0 to redSorted.length - 1) {
	  if(redSorted(i) > blueSorted(i)) {
	    for(i <- 1 to redSorted.length - 1) {
		  if(redSorted(i) < blueSorted(i)) return false
		}
		return true
	  }
	  
	  if(redSorted(i) < blueSorted(i)) {
	    for(i <- 1 to redSorted.length - 1) {
		  if(redSorted(i) > blueSorted(i)) return false
		}
		return true
	  }
	  
	}
	return false
	
  }
}

/* greedy solution

val redShirtHeights: Array[Int] = Array(5, 8, 1, 3, 4)
val blueShirtHeights: Array[Int] = Array(6, 9, 2, 4, 5)
Solution.classPhotos(redShirtHeights, blueShirtHeights)

val redShirtHeights: Array[Int] = Array(4, 7)
val blueShirtHeights: Array[Int] = Array(5, 6)
Solution.classPhotos(redShirtHeights, blueShirtHeights)


val redShirtHeights: Array[Int] = Array(4, 7)
val blueShirtHeights: Array[Int] = Array(4, 7)
Solution.classPhotos(redShirtHeights, blueShirtHeights)

O(2nlog(n) + n) time, O(2n) space, n = amount of ints in each row
*/

object Solution {
  def classPhotos(red: Array[Int], blue: Array[Int]): Boolean = {
    val redSorted: Array[Int] = red.sortWith(_ < _)
	val blueSorted: Array[Int] = blue.sortWith(_ < _)
	val lastIndex: Int = redSorted.length - 1
	var backRow: String = ""
	if(redSorted(lastIndex) == blueSorted(lastIndex)) return false
	
	if(redSorted(lastIndex) > blueSorted(lastIndex)) {
	  backRow = "red"
      for(i <- lastIndex - 1 to 0 by -1) if(redSorted(i) <= blueSorted(i)) return false
	}
	return true
	  
	if(redSorted(lastIndex) < blueSorted(lastIndex)) {
	  backRow = "blue"
      for(i <- lastIndex - 1 to 0 by -1) if(redSorted(i) >= blueSorted(i)) return false
	}
	return true
	
  }
}


// alt greedy


object Solution {
  def classPhotos(red: Array[Int], blue: Array[Int]): Boolean = {
    val redSorted: Array[Int] = red.sortWith(_ < _)
	val blueSorted: Array[Int] = blue.sortWith(_ < _)
	var backRow: String = ""
	var redHeight: Int = 0
	var blueHeight: Int = 0
	
	if(redSorted(0) > blueSorted(0)) {
	  backRow = "red"
	}
	else backRow = "blue"
	
	for(i <- 0 to redSorted.length - 1) {
	  var redHeight: Int = redSorted(i)
	  var blueHeight: Int = blueSorted(i)
	  if(backRow == "red") {if(redHeight <= blueHeight) return false}
	  else {if(redHeight >= blueHeight) return false}
	}
	return true
  }
}
/*
val redShirtHeights: Array[Int] = Array(5, 8, 1, 3, 4)
val blueShirtHeights: Array[Int] = Array(6, 9, 2, 4, 5)
Solution.classPhotos(redShirtHeights, blueShirtHeights)

val redShirtHeights: Array[Int] = Array(4, 7)
val blueShirtHeights: Array[Int] = Array(5, 6)
Solution.classPhotos(redShirtHeights, blueShirtHeights)


val redShirtHeights: Array[Int] = Array(4, 7)
val blueShirtHeights: Array[Int] = Array(4, 7)
Solution.classPhotos(redShirtHeights, blueShirtHeights)
*/
object Solution {
  def classPhotos(red: Array[Int], blue: Array[Int]): Boolean = {
    val redSorted: Array[Int] = red.sortWith(_ < _)
	val blueSorted: Array[Int] = blue.sortWith(_ < _)
	var frontRow: String = ""
	if(redSorted(0) < blueSorted(0)) {frontRow = "red"}
	else {frontRow = "blue"}
	for(i <- 0 to redSorted.length - 1) {
	if(frontRow == "red") {if(redSorted(i) >= blueSorted(i)) {return false}}
	else {if(redSorted(i) <= blueSorted(i)) {return false}}
	}
    return true
  }
}