/*
head of singly linked list, sorted
a function return a ll with no duplicate, modify input ll in place, still sorted
each node has value and next
1 - 1 - 3 - 4 - 4 - 4 - 5 - 6 - 6 => 1 - 3 - 4 - 5 - 6
*/

import scala.collection.mutable.ArrayBuffer

object Solution extends App{
  class Node(var value: Int, var next: Node = null) {
    
    def linkedList(head: Node, values: Array[Int]): Node = {
      var current: Node = head
      for(value <- values) {
        var nextNode: Node = new Node(value)
        current.next = nextNode
        current = nextNode
      }
      return head
    }

    def removeDuplicates(head: Node): Node = {
      var current: Node = head
      var holder: Node = null
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

    def valuesToString(head: Node): String = {
      var values: collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
      var current: Node = head
      while(current.next != null) {
        values += current.value
        current = current.next
      }
      values += current.value
      return values.mkString(" ")
    }
  }

  def testCase1(): Boolean = {
    var head1: Node = new Node(1)
    var head2: Node = new Node(1)
    head1.linkedList(head1, Array(1, 3, 4, 4, 4, 5, 6, 6))
    head2.linkedList(head2, Array(3, 4, 5, 6))
    head1.removeDuplicates(head1)
    return head1.valuesToString(head1) == head2.valuesToString(head2)
  }

  println(testCase1())
}

