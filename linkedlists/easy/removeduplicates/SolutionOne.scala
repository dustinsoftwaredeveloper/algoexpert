/*
head of singly linked list, a function returns a ll has no duplicates
modify it in place, should still be sorted.
each node has value and next node pointer
input = 1 - 1 - 3 - 4 - 4- 4 - 5- 6 - 6
output = 1 - 3 - 4 - 5 - 6
for all nodes
valholder = thisnode.data

var thisnode
if node.next.data = valholder
thisnode.nextnode = nextnode.next
nextnode.next = null
nextnode.previous = null
return linkedlist

*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  class LinkedList(var value: Int, var next: LinkedList = null) {
    def addMany(values: Array[Int]): LinkedList = {
      var current: LinkedList = this
      while(current.next != null) {
        current = current.next
      }
      for(value <- values) {
        current.next = new LinkedList(value)
        current = current.next
      }
      return this
    }
    def getNodesInString(): String = {
      var nodes: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
      var current: LinkedList = this
      while(current != null) {
        nodes += current.value
        current = current.next
      }
      return nodes.mkString(" ")
    }
  }

  def removeDuplicatesFromLinkedList(ll: LinkedList): LinkedList = {
    var current: LinkedList = ll
    var holder: LinkedList = null
    while(current.next != null) {
      if(current.value == current.next.value) {
        holder = current.next
        current.next = current.next.next
        holder.next = null
      }
      else {current = current.next}
      
    }
    return ll
  }
    
  def testCase1(): Unit = {
    val ll1: LinkedList = new LinkedList(1)
    val ll2: LinkedList = new LinkedList(1)
    val test: LinkedList = ll1.addMany(Array(3, 4, 4, 4, 5, 5, 6))
    val expected: LinkedList = ll2.addMany(Array(3, 4, 5, 6))
    val actual: LinkedList = removeDuplicatesFromLinkedList(test)
    println(actual.getNodesInString())
    println(expected.getNodesInString())
    println(actual.getNodesInString() == expected.getNodesInString())
  } 
}
