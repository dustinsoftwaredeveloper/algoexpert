/*
input
var string: String = "AAAAAAAAAAAAABBCCCCDD"
Solution.runLengthEncoding(string)
output
"9A4A2B4C2D"

non empty string "A" to"AAAAA..."
tracker
Array container for processing
stopping conditions :
constraint: tracker <= 9
if item != previous letter
for

O(n) time, O(n) space
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def runLengthEncoding(inputStr: String): String = {
    var itemTracker: Int = 1
    var outputContainer: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    if(inputStr.length == 1) return itemTracker.toString + inputStr
    for(i <- 1 to inputStr.length - 1) {
      if(inputStr(i) != inputStr(i - 1) || itemTracker == 9) {
        outputContainer += itemTracker.toString
        outputContainer += inputStr(i - 1).toString
        itemTracker = 0
      }
      itemTracker += 1
    }
    outputContainer += itemTracker.toString
    outputContainer += inputStr(inputStr.length - 1).toString
    return outputContainer.mkString("")
  }
}


/*
input
non empty string => min input length is 1
run is count of item + item
all kind of chars including nums
count must <= 9

one var to track count
one data structure to store count and chars
for each ele in the input
add count and char into the ds
should apply the constraints
add data to the ds when counter == 9 || next ele is different from this one
turn the ds into str
output

var string: String = "AAAAAAAAAAAAABBCCCCDD"
output "9A4A2B4C2D"

O(3n) time, O(2n) space
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def runLengthEncoding(inputStr: String): String = {
    var itemContainer: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    var itemCounter: Int = 1
    if(inputStr.length == 1) return itemCounter + inputStr
    for(i <- 0 to inputStr.length - 2) {
      if(itemCounter == 9 || inputStr(i) != inputStr(i + 1)) {
        itemContainer += itemCounter.toString
        itemContainer += inputStr(i).toString
        itemCounter = 0
      }
      itemCounter += 1
    }
    itemContainer += itemCounter.toString
    itemContainer += inputStr(inputStr.length - 1).toString
    return itemContainer.mkString("")
  }
}
