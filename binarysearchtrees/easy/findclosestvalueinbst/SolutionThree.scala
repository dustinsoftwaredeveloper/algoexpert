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

object SolutionThree extends App {
  // O(n) time, O(n) space 
  def findClosestValueInBst(root: BST, target: Int): Int = {
    var allValues: collection.mutable.Map[Int, Int] = collection.mutable.Map()
    findClosestHelper(root, target, allValues)
    var allValuesSorted = allValues.toSeq.sortBy(_._1)
    var closestPair = allValuesSorted(0)
    return closestPair._2.toInt
  }
  def findClosestHelper(node: BST, target: Int, allValues: collection.mutable.Map[Int, Int]): Unit = {
    allValues.put((target - node.value).abs, node.value)
    if(node.left != null && node.right != null) {
      findClosestHelper(node.left, target, allValues)
      findClosestHelper(node.right, target, allValues)
    }
    else if(node.left != null) {
      findClosestHelper(node.left, target, allValues)
    }
    else if(node.right != null) {
      findClosestHelper(node.right, target, allValues)
    }
    else {}
  }

  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14)
    println(root.contains(1) == true)
    println(findClosestValueInBst(root, 12) == 13) 
  }
  testCase1()
}
