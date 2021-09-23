/*
given head of sorted singly linked list, each node nas an int value and next pointer
write a function that remove duplicate values, modify the ll in place not create new
output should still be sorted
1 - 1 - 3 - 4 - 4 - 5 - 5 - 5 - 6 -> 1 - 3 - 4 - 5 -6
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  class LinkedList(_value: Int, _next: LinkedList = null) {
    var value: Int = _value
    var next: LinkedList = _next
  }

  def addMany(head: LinkedList, values: Array[Int]): LinkedList = {
    var current: LinkedList = head
    for(i <- 0 to values.length - 1) {
      var newNode: LinkedList = new LinkedList(values(i))
      current.next = newNode
      current = newNode
    }
    return head
  }

  def removeDuplicates(head: LinkedList): LinkedList = {
    var current: LinkedList = head
    var holder: LinkedList = null
    while(current.next != null) {
      if(current.value == current.next.value) {
        holder = current.next
        current.next = current.next.next
        holder.next = null
      }
      else {current = current.next}
    }
    return head
  }
  
  def valuesToString(head: LinkedList): String = {
    var valuesArr: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
    var current: LinkedList = head
    while(current.next != null) {
      valuesArr += current.value
      current = current.next
    }
    valuesArr += current.value
    return valuesArr.mkString(" ")
  }
  
  def testCase1(): Boolean = {
    var headOne: LinkedList = new LinkedList(1)
    var headTwo: LinkedList = new LinkedList(1)
    addMany(headOne, Array(1, 1, 2, 3, 3, 4, 4, 5, 5, 6))
    addMany(headTwo, Array(2, 3, 4, 5, 6))
    removeDuplicates(headOne)
    return valuesToString(headOne) == valuesToString(headTwo)
  }
}
