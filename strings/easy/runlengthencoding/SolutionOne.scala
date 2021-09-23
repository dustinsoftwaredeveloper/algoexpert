/*
input 
val string: String = "AAAAAAAAAAAAABBCCCCDD";
Solution.runLengthEncoding(string)

output
"9A4A2B4C2D"

O(n) time, O(n) space
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def runLengthEncoding(inputStr: String): String = {
    var encodedStringCharacters: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    var currentRunLength: Int = 1
    for(i <- 1 to inputStr.length - 1) {
      var currentCharacter: String = inputStr(i).toString
      var previousCharacter: String = inputStr(i - 1).toString
      if(currentCharacter != previousCharacter || currentRunLength == 9) {
        encodedStringCharacters += currentRunLength.toString
        encodedStringCharacters += previousCharacter
        currentRunLength = 0
      }
      currentRunLength += 1
    }
    encodedStringCharacters += currentRunLength.toString
    encodedStringCharacters += inputStr(inputStr.length - 1).toString
    return encodedStringCharacters.mkString
  }  
}