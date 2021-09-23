import scala.collection.mutable.Map

class BST(var value: Int, var left: BST = null, var right: BST = null) {
  def insert(value: Int): BST = {
    if(value < this.value) {
      if(this.left != null) this.left.insert(value)
      else this.left = new BST(value) 
    }
    else {
      if(this.right != null) this.right.insert(value)
      else this.right = new BST(value)
    }
    return this
  }
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
}

object SolutionFour extends App {
  // O(log(n)) time, O(log(n))space average
  // O(n) time, O(n) space worst
  def findClosestValueInBst(root: BST, target: Int): Int = {
    var closest: Int = Int.MaxValue 
    return findClosestHelper(root, target, closest)
  }
  def findClosestHelper(node: BST, target: Int, _closest: Int): Int = {
    var closest: Int = _closest
    if((node.value - target).abs < (closest - target).abs) closest = node.value
    if(target < node.value) {
      if(node.left == null) return closest
      else findClosestHelper(node.left, target, closest) 
    }
    else if(target > node.value) {
      if(node.right == null) return closest
      else findClosestHelper(node.right, target, closest)
    }
    else return closest
  }
  
  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14)
    println(root.contains(1) == true)
    println(findClosestValueInBst(root, 12) == 13) 
  }
  testCase1()
}
