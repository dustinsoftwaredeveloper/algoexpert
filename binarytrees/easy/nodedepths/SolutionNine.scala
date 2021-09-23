import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._

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

object SolutionNine extends App {
  def nodeDepths(root: BinaryTree): Int = {
    var stack = ListBuffer(Map(("node", root), ("depth", 0)))
    var result: Int = 0
    while(stack.length > 0) {
      var nodeInfo = stack(0)
      stack.remove(0)
      var currentNode = nodeInfo("node").asInstanceOf[BinaryTree]
      var currentDepth = nodeInfo("depth").asInstanceOf[Int]
      breakable {
        if(currentNode == null) break()
        else {
          result += currentDepth
          stack.prepend(Map(("node", currentNode.right), ("depth", currentDepth + 1)))   
          stack.prepend(Map(("node", currentNode.left), ("depth", currentDepth + 1)))   
        }
      } 
    } 
    return result 
  }
 
  def testCase1(): Unit = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.right.addChild(6).addChild(7)
    root.left.left.addChild(8).addChild(9)
    println(nodeDepths(root) == 16)
  } 
  testCase1() 
}
