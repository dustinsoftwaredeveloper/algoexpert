import scala.util.control.Breaks._

class BST(var value: Int, var left: BST = null, var right: BST = null) {
  def insert(value: Int): BST = {
    var currentNode: BST = this
    breakable {
      while(true) {
        if(value < currentNode.value) {
          if(currentNode.left == null) {
            currentNode.left = new BST(value)
            break()
          } 
          else {
            currentNode = currentNode.left 
          }
        }
        else {
          if(currentNode.right == null) {
            currentNode.right = new BST(value)
            break() 
          }
          else {
            currentNode = currentNode.right
          } 
        }
      }
    }
    return this
  }
  def contains(value: Int): Boolean = {
    var currentNode: BST = this
    while(currentNode != null) {
      if(value < currentNode.value) {
        currentNode = currentNode.left
      }
      else if(value > currentNode.value) {
        currentNode = currentNode.right
      }
      else return true
    }
    return false
  }
  def remove(value: Int, _parentNode: BST = null): BST = {
    var parentNode: BST = _parentNode 
    var currentNode: BST = this
    breakable {
      while(currentNode != null) {
        if(value < currentNode.value) {
          parentNode = currentNode
          currentNode = currentNode.left
        }
        else if(value > currentNode.value) {
          parentNode = currentNode
          currentNode = currentNode.right 
        }
        else {
          if(currentNode.left != null && currentNode.right != null) {
            currentNode.value = currentNode.right.getMinValue()
            currentNode.right.remove(currentNode.value, currentNode) 
            break()
          }
          else if(parentNode == null) {
            if(currentNode.left != null) {
              currentNode.value = currentNode.left.value
              currentNode.right = currentNode.left.right  
              currentNode.left = currentNode.left.left
              break()
            }
            else if(currentNode.right != null) {
              currentNode.value = currentNode.right.value
              currentNode.left = currentNode.right.left
              currentNode.right = currentNode.right.right
              break()
            }
            else {
              currentNode.value = 0
              break()
            }
          }
          else if(parentNode.left == currentNode) {
            if(currentNode.left != null) {
              parentNode.left = currentNode.left
              break()  
            }
            else {
              parentNode.left = currentNode.right
              break() 
            }
          }
          else if(parentNode.right == currentNode) {
            if(currentNode.left != null) {
              parentNode.right = currentNode.left
              break()
            }
            else {
              parentNode.right = currentNode.right
              break() 
            }
          }
        }
      }
    } 
    return this
  }
  def getMinValue(): Int = {
    var currentNode: BST = this 
    while(currentNode.left != null) {
      currentNode = this.left  
    }
    return currentNode.value
  }
}

object SolutionOne {
  def main(args: Array[String]): Unit = {
    var root: BST = new BST(10)
    root.insert(1).insert(11)
    println(s"left: ${root.left.value} , right: ${root.right.value}")
    println(s"contains 11 -> ${root.contains(11)}")
    println(root.contains(12))
    root.remove(11)
    println(s"called remove, contains 11 -> ${root.contains(11)}")
  }
}
