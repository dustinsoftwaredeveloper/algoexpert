/*
val characters: String = "abeabcabc";
val document: String = "abc";
Solution.generateDocument(characters, document)

2 functions, 2 trackers
O(n (n + m)) time, O(1) space
*/

object Solution {
  def generateDocument(characters: String, document: String): Boolean  = {
    var dTracker: Int = 0
    var cTracker: Int = 0
    for(d <- document) {
      dTracker = counter(d, document)
      cTracker = counter(d, characters)
      if(dTracker > cTracker) return false
    }
    return true
  }

  def counter(char: Char, inputStr: String): Int = {
    var tracker: Int = 0
    for(i <- inputStr) {
      if(i == char) tracker += 1
    }
    return tracker
  }
}

/*
val characters: String = "a ad11!";
val document: String = "a !1";
Solution.generateDocument(characters, document)
O(c (n + m)) time, O(c) space
*/

import scala.collection.mutable.Set
import util.control.Breaks._

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    var dContainer: collection.mutable.Set[Char] = Set()
    var dTracker: Int = 0
    var cTracker: Int = 0
    for(d <- document) {
      breakable {
        if(dContainer.contains(d)) break
        dTracker = counter(d, document)
        cTracker = counter(d, characters)
        if(dTracker > cTracker) return false
        dContainer += d
      }   
    }
    return true
  }

  def counter(char: Char, inputStr: String): Int = {
    var result: Int = 0
    for(letter <- inputStr) {
      if(letter == char) result += 1
    }
    return result
  }
}

/*
val characters: String = "a ad11!";
val document: String = "a !21a";
Solution.generateDocument(characters, document)
O(n (n + m)) time, O(1) space
*/

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    for(d <- document) {
      if(counter(d, document) > counter(d, characters)) return false
    }
    return true
  }
  def counter(char: Char, inputStr: String): Int = {
    var result: Int = 0
    for(letter <- inputStr) if(letter == char) result += 1
    return result
  }
}

/*
val characters: String = "a ad11!";
val document: String = "a !1a";
Solution.generateDocument(characters, document)
O(c (n + m)) time, O(c) space
*/

import scala.collection.mutable.Set
import scala.util.control._

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    var dContainer: collection.mutable.Set[Char] = Set()
    for(d <- document) {
      breakable {
        if(dContainer.contains(d)) break
        if(counter(d, document) > counter(d, characters)) return false
        dContainer += d
      }
    }
    return true
  }
  def counter(char: Char, inputStr: String): Int = {
    var result: Int = 0
    for(i <- inputStr) if(i == char) result += 1
    return result
  }
}

/*
val characters: String = "a ad11!";
val document: String = "a !1a";
Solution.generateDocument(characters, document)
O(m + n) time O(c) space
*/

import scala.collection.mutable.Map

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    var cMap: collection.mutable.Map[Char, Int] = Map()
    for(c <- characters) {
      if(cMap.get(c) == None) cMap += ((c, 1))
      else cMap(c) += 1
    }
    println(cMap)
    for(d <- document) {
      if(cMap.get(d) == None) return false
      else {
        cMap(d) -= 1
        println(cMap(d))
        if(cMap(d) < 0) return false
      }
    }
    return true
  }
}


/*
val characters: String = "a ad11!";
val document: String = "a2 !1a";
Solution.generateDocument(characters, document)
O(m + n) time O(c) space
*/

import scala.collection.mutable.Map

object Solution {
  def generateDocument(characters: String, document: String): Boolean = {
    var cRecord: collection.mutable.Map[Char, Int] = Map()
    for(c <- characters) {
      if(cRecord.get(c) == None) cRecord += ((c, 1))
      else cRecord(c) += 1
    }
    for(d <- document) {
      if(cRecord.get(d) == None) return false
      else {
        cRecord(d) -= 1
        if(cRecord(d) < 0) return false
      }
    }    
    return true
  }
}