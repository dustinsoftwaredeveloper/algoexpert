/*
sample input: val inputStr: String = "xyz"; val num: Int = 2
sample output: "zab"

Solution.caesarCipherEncryptor(inputStr, num)

brute force, 2 for loops
O(n) time, O(n) space

*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, _num: Int): String = {
    var num: Int = _num
    var inputStrArray: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    var newStrArray: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    var newCode: Int = 0
    num = num % 26
    for(inputChar <- inputStr) inputStrArray += inputChar.toInt
    for(uniCode <- inputStrArray) {
      newCode = uniCode + num
      if(newCode <= 122) {
        inputStrArray(inputStrArray.indexOf(uniCode)) = newCode
        newStrArray += newCode.toChar
      }
      
      else {
        inputStrArray(inputStrArray.indexOf(uniCode)) = 96 + newCode % 122
        newStrArray += (96 + newCode % 122).toChar
      }
    }
    return newStrArray.mkString
  }
}

// brute force 2 functions

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, _num: Int): String = {
    var num: Int = _num
    var newLetters: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    var newNum: Int = num % 26
    for(letter <- inputStr) {
      newLetters += getNewLetter(letter, newNum) 
    }
    return newLetters.mkString
  }

  def getNewLetter(letter: Char, num: Int): Char = {
    var newLetterCode: Int = letter.toInt + num
    if(newLetterCode <= 122) return newLetterCode.toChar
    else return (96 + newLetterCode % 122).toChar
  }
}

// no unicode, O(n) time, O(n) space

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, num: Int): String = {
    val alphabets: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
    'x', 'y', 'z')
    var newLetters: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    var newNum: Int = num % 26
    for(letter <- inputStr) {
      newLetters += getNewLetter(letter, newNum, alphabets)
    }
    return newLetters.mkString
  }

  def getNewLetter(letter: Char, num: Int, alphabets: Array[Char]): Char = {
    var newLetterCode: Int = alphabets.indexOf(letter) + num
    if(newLetterCode <= 25) return alphabets(newLetterCode)
    else return alphabets(-1 + newLetterCode % 25)
  }
}