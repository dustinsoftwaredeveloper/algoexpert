/*
*/
import scala.collection.mutable.ArrayBuffer

class BinaryTree(var value: Int, var left: BinaryTree = null, var right: BinaryTree = null) {
  def addChild(value: Int): BinaryTree = {
    if(this.left == null && this.right == null) {this.left = new BinaryTree(value)}
    else if(this.left != null && this.right == null) {this.right = new BinaryTree(value)}
    return this
  }
  
}

object SolutionTwo extends App{
  def branchSums(root: BinaryTree): Array[Int] = {
    var sums: ArrayBuffer[Int] = ArrayBuffer()
    calculateBranchSums(root, 0, sums)
    return sums.toArray
  } 
  def calculateBranchSums(node: BinaryTree, runningSum: Int, sums: ArrayBuffer[Int]): Unit = {
    if(node == null) return
    var newRunningSum: Int = runningSum + node.value
    if(node.left == null && node.right == null) {
      sums += newRunningSum
      return
    }
    calculateBranchSums(node.left, newRunningSum, sums)
    calculateBranchSums(node.right, newRunningSum, sums)
  }
  def testCase1(): Unit = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.left.left.addChild(8).addChild(9)
    root.left.right.addChild(10)
    root.right.addChild(6).addChild(7)
    println(branchSums(root).mkString(" "))
  }
  testCase1()
}
