import scala.collection.mutable.ListBuffer
import util.control.Breaks._

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

object SolutionTwo extends App {
  def nodeDepths(root: BinaryTree): Int = {
    var result: Int = 0
    var depth: Int = 0
    var nodeStack: ListBuffer[Map[BinaryTree, Int]] = ListBuffer(Map((root, depth)))
    while(nodeStack.length > 0) {
      var nodeInfo: Map[BinaryTree, Int] = nodeStack(0)
      nodeStack.remove(0)
      var n: BinaryTree = null
      var d: Int = 0
      for((k, v) <- nodeInfo) {
        n = k 
        d = v 
      }
      breakable {
      if (n == null) {break}
      else {result += d}
      }
      nodeStack.prepend(Map((root.right, depth + 1)))
      nodeStack.prepend(Map((root.left, depth + 1)))
    }   
    return result
  }
  def testCase1(): Boolean = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.right.addChild(6).addChild(7)
    root.left.left.addChild(8).addChild(9)
    println(nodeDepths(root))
    return nodeDepths(root) == 16
  }
  testCase1()
}
