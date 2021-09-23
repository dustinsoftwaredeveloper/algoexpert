import scala.collection.mutable.ArrayBuffer

class BinaryTree(var value: Int, var left: BinaryTree = null, var right: BinaryTree = null) {
  def addChild(value: Int): BinaryTree = {
    if(this.left == null && this.right == null) {
      this.left = new BinaryTree(value)
      return this
    }
    else if(this.left != null && this.right == null) {
      this.right = new BinaryTree(value)
      return this
    }
    else return this 
  }
}

object SolutionThree extends App {
  def branchSums(root: BinaryTree): Array[Int] = {
    var results: ArrayBuffer[Int] = ArrayBuffer()
    branchSumsHelper(root, results)
    return results.toArray
  }
  def branchSumsHelper(node: BinaryTree, results: ArrayBuffer[Int], currentSum: Int = 0): Unit = {
    if(node == null) return
    var newCurrentSum = currentSum + node.value
    if(node.left == null && node.right == null) {
      results += newCurrentSum
      return
    }
    branchSumsHelper(node.left, results, newCurrentSum)
    branchSumsHelper(node.right, results, newCurrentSum)
  }
  def testCase1(): Unit = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.right.addChild(6).addChild(7)
    root.left.left.addChild(8).addChild(9)
    root.left.right.addChild(10)
    println(branchSums(root).mkString(" "))
  }
  testCase1()
}
