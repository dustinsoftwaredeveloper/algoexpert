/*
input
val string: String = "AAAAAAAAAAAAABBCCCCDD";
Solution.runLengthEncoding(string)
output
"9A4A2B4C2D"

take in string
count amount of char
seperate >= 10 chars
output combination

numtracker = 0

for(num <- string) {
  while(string.indexOf(num) <= string.length - 1)
  if(num == string(string.indexOf(num) + 1))
  numTracker += 1
  if(num != string(string.indexOf(num) + 1)) {
  if(numtracker == 0) {
  newArray += (numtracker + 1).toString
  newArray += (num)
  numTracker = 0
  }
  else {
  newArray += (numtracker).toString
  newArray += (num)
  numTracker = 0
  }
  }
}
newArray += (numtracker).toString
newArray += (string(string.length - 1)).toString

newArray.mkString
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def runLengthEncoding(inputStr: String): String = {
    var itemContainer: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    var itemCounter: Int = 0
    if(inputStr.length == 1) return "1" + inputStr
    for(i <- 0 to inputStr.length - 2) {
      if(itemCounter == 9) {
        itemContainer += itemCounter.toString
        itemContainer += inputStr(i - 1).toString
        itemCounter = 0
      }
      if(inputStr(i) == inputStr(i + 1)) itemCounter += 1
      else {
        itemContainer += (itemCounter + 1).toString
        itemContainer += inputStr(i).toString
        itemCounter = 0
      }
    }
    if(inputStr(inputStr.length - 1) == inputStr(inputStr.length - 2)) {
      if(itemCounter == 9) {
        itemContainer += itemCounter.toString
        itemContainer += inputStr(inputStr.length - 2).toString
        itemCounter = 0
      }
      itemCounter += 1 
      }
    else {
      itemContainer += itemCounter.toString
      itemContainer += inputStr(inputStr.length - 2).toString
      itemCounter = 1
    }
    itemContainer += itemCounter.toString
    itemContainer += inputStr(inputStr.length - 1).toString
    return itemContainer.mkString
  }
}

/*
input
val string: String = "AAAAAAAAAAAAABBCCCCDD";
Solution.runLengthEncoding(string)
output
"9A4A2B4C2D"


run = value count pair

one tracker
one array
constraint: counter <= 9
non empty input. 1 <= input.length

"AAABC" for i in "AAABC"
if(i == inputStr(inputStr.indexOf(i) + 1))
(3A1B1C)

input
val string: String = "AAAAAAAAAAAAABBCCCCDD";
Solution.runLengthEncoding(string)
output
"9A4A2B4C2D"

two stopping condition in one if or
one tracker
one container
one indexed comparison: starting at index 1, responding to non empty input
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def runLengthEncoding(inputStr: String): String = {
    var itemCounter: Int = 1
    var outputContainer: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    if(inputStr.length == 1) return itemCounter + inputStr
    for(i <- 1 to inputStr.length - 1) {
      if(itemCounter == 9 || inputStr(i) != inputStr(i - 1)) {
          outputContainer += itemCounter.toString
          outputContainer += inputStr(i - 1).toString
          itemCounter = 0
      }   
      itemCounter += 1 //AAAA C BBB AAAAA
    }
    outputContainer += itemCounter.toString
    outputContainer += inputStr(inputStr.length - 1).toString
    return outputContainer.mkString
  }
}
