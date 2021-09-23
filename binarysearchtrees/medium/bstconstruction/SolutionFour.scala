class BST(var value: Int, var left: BST = null, var right: BST = null) {
  //average O(log(n)) time, O(log(n)) space
  // worst O(n) time, O(n) space
  def insert(value: Int): BST = {
    var pointer: BST = this
    if(value < pointer.value) {
      if(pointer.left == null) {
        pointer.left = new BST(value)
      } 
      else {
        pointer = pointer.left
        pointer.insert(value)
      }
    }
    else {
      if(pointer.right == null) {
        pointer.right = new BST(value)
      }
      else {
        pointer = pointer.right
        pointer.insert(value)
      }
    }
    return this
  }
  //average O(log(n)) time, O(log(n)) space
  //worst O(n) time, O(n) space
  def contains(value: Int): Boolean = {
    if(value < this.value) {
      if(this.left == null) return false
      else this.left.contains(value)  
    }
    else if(value > this.value) {
      if(this.right == null) return false
      else this.right.contains(value)
    } 
    else return true
  }
  //average O(log(n)) time, O(log(n)) space
  //worst O(n) time, O(n) space
  def remove(value: Int, _parentNode: BST = null): BST = {
    var parentNode: BST = _parentNode 
    var pointer: BST = this
    if(value < pointer.value) {
      if(pointer.left == null) {} 
      else pointer.left.remove(value, pointer)
    }
    else if(value > pointer.value) {
      if(pointer.right == null) {} 
      else pointer.right.remove(value, pointer)
    }
    else {
      if(pointer.left != null && pointer.right != null) {
        pointer.value = pointer.right.getMinValue()
        pointer.right.remove(pointer.value, pointer)
      }
      else if(parentNode == null) {
        if(pointer.left != null) {
          pointer.value = pointer.left.value
          pointer.right = pointer.left.right
          pointer.left = pointer.left.left
        }
        else if(pointer.right != null) {
          pointer.value = pointer.right.value
          pointer.left = pointer.right.left
          pointer.right = pointer.right.right
        }
        else {}
      }
      else {
        if(parentNode.left == pointer) {
          if(pointer.left != null) {
            parentNode.left = pointer.left
          }
          else if(pointer.right != null) {
            parentNode.left = pointer.right
          }
          else {
            parentNode.left = null
          }
        }
        else {
          if(pointer.left != null) parentNode.right = pointer.left 
          else if(pointer.right != null) parentNode.right = pointer.right
          else parentNode.right = null
        }
      }   
    }
    return pointer
  }
  def getMinValue(): Int = {
    var pointer: BST = this
    if(pointer.left == null) return pointer.value
    else pointer.left.getMinValue()
  }
}
object Solution {
  def main(args: Array[String]): Unit = {
    testCase1()
  }
  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14)
    println(root.left.right.value == 5)
    println(root.right.left.right.value == 14)
    println(root.contains(1))
    root.remove(1).remove(2)
    println(root.contains(1) == false)
    println(root.contains(2) == false)
  }
  
}
