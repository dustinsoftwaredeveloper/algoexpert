class BST(var value: Int, var left: BST = null, var right: BST = null) {
  def insert(value: Int): BST = {
    var currentNode: BST = this
    while(currentNode != null) { 
      if(value < currentNode.value) {
        if(currentNode.left == null) {
          currentNode.left = new BST(value)
          return this
        }
        else currentNode = currentNode.left
      }
      else {
        if(currentNode.right == null) {
          currentNode.right = new BST(value)
          return this
        } 
        else currentNode = currentNode.right
      }
    } 
    return this
  }
  def contains(value: Int): Boolean = {
    var currentNode: BST = this
    while(currentNode != null) {
      if(value == currentNode.value) return true 
      else if(value < currentNode.value) {
        currentNode = currentNode.left
      }
      else currentNode = currentNode.right
    }
    return false
  }
  def remove(value: Int, _parentNode: BST = null): BST = {
    var parentNode: BST = _parentNode 
    var currentNode: BST = this
    val root: BST = this
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
          currentNode.value = findMin(currentNode.right) 
          currentNode.right.remove(currentNode.value)
          return root 
        }
        else if(parentNode == null) {
          if(currentNode.left != null) {
            currentNode.value = currentNode.left.value
            currentNode.right = currentNode.left.right
            currentNode.left = currentNode.left.left
            return root
          }
          else if(currentNode.right != null) {
            currentNode.value = currentNode.right.value
            currentNode.left = currentNode.right.left
            currentNode.right = currentNode.right.right
            return root
          }
          else return root
        }
        // >> one to zero child node
        else {
          if(currentNode == parentNode.left) {
            if(currentNode.left != null) {
              parentNode.left = currentNode.left
              return root
            }
            // >> one right node or no children node
            else {
              parentNode.left = currentNode.right
              return root
            }
          }
          else if(currentNode == parentNode.right) {
            if(currentNode.left != null) {
              parentNode.right = currentNode.left
              return root
            }
            else {
              parentNode.right = currentNode.right
              return root
            }
          }
        }
      }
    }
    println(s"There's no node holding $value value in this BST")
    return this 
  }
  def findMin(subTreeRoot: BST): Int = {
    var currentNode: BST = subTreeRoot
    var currentMin: Int = subTreeRoot.value
    while(currentNode.left != null) {
      currentMin = currentNode.left.value
      currentNode = currentNode.left
    }
    return currentMin
  }
}
object SolutionTwo extends App {
  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.insert(5).insert(2).insert(1).insert(5).insert(15).insert(13).insert(14).insert(22)
    println(root.right.left.left == null)
    println(root.right.left.right.value == 14)
    root.insert(12)
    println(root.right.left.left.value == 12)
    println(root.contains(12))
    root.remove(10)
    println(root.contains(10) == false)
    println(root.value == 12)
    println(root.contains(15))
  }
  testCase1()
}
