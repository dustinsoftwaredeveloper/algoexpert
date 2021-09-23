/*
val string: String = "xyz"; val key: Int = 2
Solution.caesarCipherEncryptor(string, key)
O(n) time, O(n) space
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, key: Int): String = {
    var actualKey: Int = key % 26
    var newLetters: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    for(letter <- inputStr) {
      newLetters += changeLetters(letter, actualKey)
    }
    return newLetters.mkString
  }
  
  def changeLetters(letter: Char, key: Int): Char = {
    if(letter.toInt + key <= 122) return (letter.toInt + key).toChar
    else return (96 + (letter.toInt + key) % 122).toChar
  }
}

// one function

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, key: Int): String = {
    var actualKey: Int = key % 26
    var newLetters: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    for(letter <- inputStr) {
      if(letter.toInt + actualKey <= 122) newLetters += (letter.toInt + actualKey).toChar
      else newLetters += (96 + (letter.toInt + actualKey) % 122).toChar
    }
    return newLetters.mkString
  }
}

// no unicode
// O(n) time, O(n) space

import scala.collection.mutable.ArrayBuffer

object Solution {
  def caesarCipherEncryptor(inputStr: String, key: Int): String = {
    val alphabets: Array[Char] = Array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
    'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')
    val actualKey: Int = key % 26
    var newLetters: collection.mutable.ArrayBuffer[Char] = ArrayBuffer()
    for(letter <- inputStr) {
      newLetters += changeLetter(letter, actualKey, alphabets)
    }
    return newLetters.mkString
  }

  def changeLetter(letter: Char, key: Int, alphabets: Array[Char]): Char = {
    if(alphabets.indexOf(letter) + key <= 25) return alphabets(alphabets.indexOf(letter) + key)
    else return alphabets(-1 + (alphabets.indexOf(letter) + key) % 25)
  }
}
