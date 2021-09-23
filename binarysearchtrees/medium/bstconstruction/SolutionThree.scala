import scala.util.control.Breaks._

class BST(var value: Int, var left: BST = null, var right: BST = null) {
  def insert(value: Int): BST = {
    var pointer: BST = this
    val root: BST = this
    breakable {
      while(pointer != null) {
        if(value < pointer.value) {
          if(pointer.left != null) {
            pointer = pointer.left
          }
          else {
          pointer.left = new BST(value)
          break()
          }
        }
        else {
          if(pointer.right != null) {
            pointer = pointer.right
          }
          else {
          pointer.right = new BST(value)
          break()
          }
        }
      }
    }
    return root 
  }
  def contains(value: Int): Boolean = {
    var pointer: BST = this
    while(pointer != null) {
      if(value < pointer.value) {
        pointer = pointer.left
      }
      else if(value > pointer.value) {
        pointer = pointer.right
      }
      else {
        return true
      }
    }
    return false
  }
  def remove(value: Int, _parentNode: BST = null): BST = {
    var parentNode: BST = _parentNode
    var pointer: BST = this
    val root: BST = this
    breakable {    
      while(pointer != null) {
        if(value < pointer.value) {
          parentNode = pointer
          pointer = pointer.left
        }
        else if(value > pointer.value) {
          parentNode = pointer
          pointer = pointer.right
        }
        else {
          if(pointer.left != null && pointer.right != null) {
            pointer.value = findMin(pointer.right)
            pointer.right.remove(pointer.value)
            break()
          }
          else if(parentNode != null) {
            if(parentNode.left == pointer) {
              if(pointer.left != null) {
                parentNode.left = pointer.left
                pointer.right = pointer.left.right 
                pointer.left = pointer.left.left
                break()
              }
              else if(pointer.right != null) {
                parentNode.left = pointer.right
                pointer.left = pointer.right.left
                pointer.right = pointer.right.right
                break()
              }
              else { 
                parentNode.left = null
                break()
              }
            }
            else {
              if(pointer.left != null) {
                parentNode.right = pointer.left
                pointer.right = pointer.left.right 
                pointer.left = pointer.left.left
                break()
              }
              else if(pointer.right != null) {
                parentNode.right = pointer.right
                pointer.left = pointer.right.left
                pointer.right = pointer.right.right
                break()
              }
              else { 
                parentNode.right = null
                break()
              }
            } 
          }
          else {
            if(pointer.left != null) {
              pointer.value = pointer.left.value
              pointer.right = pointer.left.right
              pointer.left = pointer.left.left
              break() 
            }
            else if(pointer.right != null) {
              pointer.value = pointer.right.value
              pointer.left = pointer.right.left
              pointer.right = pointer.right.right
              break()
            }
            else {}
          }
        }
      }
    }
    return root
  }
  def findMin(subTreeRoot: BST): Int = {
    var currentNode: BST = subTreeRoot
    var currentMin: Int = subTreeRoot.value
    while(currentNode.left != null) {
      currentNode = currentNode.left
      currentMin = currentNode.value
    }
    return currentMin
  }
}

object SolutionThree extends App {
  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14)
    println(root.right.left.right.value == 14)
    root.insert(12)
    println(root.right.left.left.value == 12)
    println(root.contains(13))
    root.remove(14)
    println(root.contains(14) == false)
    root.remove(10)
    println(root.value == 12)
  }
  testCase1()
}
