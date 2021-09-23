/*
return boolean
constraint: frequency of unique characters in the character string is
greater than or equal to the frequency of unique chars in the document string

if characters = "abcabc" and document = "aabbccc" return false
missing one c

char can be anything including capital letters, numbers, spaces and symbols
you can always generate the empty string ("")
sample input
var characters: String = "Bste!hetsi ogEAxpelrt x ";
var document: String = "AlgoExpert is the best!";
Solution.generateDocument(characters, document)

use a hash table (a -> 2), (b -> 2), (c -> 2)

a container ds storing chars in character string
a container ds storing chars in document string
convert them to string and compare those 2 

sort the 2 string and compare

"aabbcc" "abcabcc" false
sort -> one tracker
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    if(characters == "") {
      if(document == "") return true
      else return false
    }
    if(document == "") {
      if(characters == "") return true
      else return false
    }
    if(characters.length == 1) return characters == document
    if(document.length == 1) return characters.contains(document)
    
    var itemCounter: Int = 1
    val charactersSorted: String = characters.sortWith(_ < _)
    val documentSorted: String = document.sortWith(_ < _)
    var charactersArr: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    var documentArr: collection.mutable.ArrayBuffer[String] = ArrayBuffer()
    for(i <- 1 to charactersSorted.length - 1) {
      if(charactersSorted(i) != charactersSorted(i - 1) || itemCounter == 9) {
        charactersArr += itemCounter.toString + charactersSorted(i - 1).toString
        itemCounter = 0
      }
      itemCounter += 1
    }
    charactersArr += itemCounter.toString + charactersSorted(charactersSorted.length - 1)
    
    itemCounter = 1
    for(j <- 1 to documentSorted.length - 1) {
      if(documentSorted(j) != documentSorted(j - 1) || itemCounter == 9) {
        documentArr += itemCounter.toString + documentSorted(j - 1).toString
        itemCounter = 0
      }
      itemCounter += 1
    }
    documentArr += itemCounter.toString + documentSorted(documentSorted.length - 1)
    
    for(k <- 0 to documentArr.length - 1) {
      if(documentArr(k) > charactersArr(k)) return false
    }
    return true
  }
}
/*
val characters: String = "";
val document: String = "a";
Solution.generateDocument(characters, document)

hash table
2 for loops
takes O(n + m) time, O(c) space
*/

import scala.collection.mutable.Map

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    var charactersMap: collection.mutable.Map[String, Int] = Map()
    for(c <- characters) {
      if(charactersMap.get(c.toString) == None) charactersMap += ((c.toString, 1))
      else charactersMap(c.toString) += 1
    }
    for(d <- document) {
      if(charactersMap.get(d.toString) == None) return false
      else charactersMap(d.toString) -= 1
      if(charactersMap(d.toString) < 0) return false
    }
    return true
  }
}


