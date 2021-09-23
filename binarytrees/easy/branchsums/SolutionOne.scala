/*
*/
import scala.collection.mutable.ArrayBuffer

class BinaryTree(var value: Int, var left: BinaryTree = null, var right: BinaryTree = null) {
  def addChild(value: Int): BinaryTree = {
    if(this.left == null && this.right == null) {this.left = new BinaryTree(value)}
    else if(this.left != null && this.right == null) {this.right = new BinaryTree(value)}
    return this
  }
  def branchSums(): Array[Int] = {
    var results: ArrayBuffer[Int] = ArrayBuffer()
    branchSumsHelper(this, 0, results)
    return results.toArray
  }
  def branchSumsHelper(root: BinaryTree, currentSum: Int, results: ArrayBuffer[Int]): Unit = {
    if(this == null) return 
    var newCurrentSum: Int = currentSum + this.value
    if(this.left == null && this.right == null) {
      results += newCurrentSum
      return 
    }
    branchSumsHelper(this.left, newCurrentSum, results)
    branchSumsHelper(this.right, newCurrentSum, results)
  }
}

object Solution extends App{
  def testCase1(): Unit = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.left.left.addChild(8).addChild(9)
    root.left.right.addChild(10)
    root.right.addChild(6).addChild(7)
    println(root.branchSums())
  }
  testCase1()
}
