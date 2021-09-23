/*
1 bike 2 ppl, speed = fast person, 
2 lists of positive ints, red and blue, same length
pair every red with blue to ride 1 bike
return maximum total if fastest = true, else minimum

val redShirtSpeeds: Array[Int] = Array(5, 5, 3, 9, 2)
val blueShirtSpeeds: Array[Int] = Array(3, 6, 7, 2, 1)
val fastest: Boolean = false
Solution.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest)


val redShirtSpeeds: Array[Int] = Array(5, 5, 3, 9, 2)
val blueShirtSpeeds: Array[Int] = Array(3, 6, 7, 2, 1)
val fastest: Boolean = false
Solution.tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest)

sort both arr
take the largest in one, pair with the smallest in another
have to track color
(2, 3, 5, 5, 9)
(1, 2, 3, 6, 7)
pointers
if arr1(length - 1) > arr2(length -1)
pair += arr1(length -1), pair += arr2(0), length - 1, 0 + 1
else pair += arr2(length - 1), pair += arr1(0),length - 1, 0+1

O(n + p) time, O(2n + p) space
*/
import scala.collection.mutable.ArrayBuffer

object Solution {
  def tandemBicycle(red: Array[Int], blue: Array[Int],
  fastest: Boolean): Int = {
    var redL: Int = 0
    var redR: Int = red.length - 1
    var blueL: Int = 0
    var blueR: Int = blue.length - 1
    val redSorted: Array[Int] = red.sortWith(_ < _)
    val blueSorted: Array[Int] = blue.sortWith(_ < _)
    var pairs: collection.mutable.ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer()
    var result: Int = 0
    if(fastest == true) {
      for(i <- redSorted.length - 1 to 0 by -1) {
        if(redSorted(redR) > blueSorted(blueR)) {
          pairs += ArrayBuffer(redSorted(redR), blueSorted(blueL))
          redR -= 1
          blueL += 1
        }
        else {
          pairs += ArrayBuffer(blueSorted(blueR), redSorted(redL))
          blueR -= 1
          redL += 1
        }
      }
      for(pair <- pairs) {
        result += pair(0)
      }
      println(pairs)
      return result
    }
    else {
      for(i <- redSorted.length - 1 to 0 by -1) {
        if(redSorted(redR) > blueSorted(blueR)) {
          pairs += ArrayBuffer(redSorted(redR), blueSorted(blueR))
          redR -= 1
          blueR -= 1
        }
        else {
          pairs += ArrayBuffer(blueSorted(blueR), redSorted(redR))
          blueR -= 1
          redR -= 1
        }
      }
      for(pair <- pairs) {
        result += pair(0)
      }
      println(pairs)
      return result
    }
  }
}