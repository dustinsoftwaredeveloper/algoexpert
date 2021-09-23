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

object SolutionTwo extends App {
  def nodeDepths(root: BinaryTree): Int = {
    var sumOfDepths: Int = 0
    var stack: ListBuffer[Map[String, Any]] = ListBuffer(Map(("node", root), ("depth", 0)))
    while(stack.length > 0) {
      var nodeInfo: Map[String, Any] = stack(0)
      stack.remove(0)
      var node: BinaryTree = nodeInfo("node").asInstanceOf[BinaryTree]
      var depth: Int = nodeInfo("depth").asInstanceOf[Int] 
      breakable {
        if(node == null) { break() }
        else {
          sumOfDepths += depth.asInstanceOf[Int]
          stack.prepend(Map(("node", node.left), ("depth", depth + 1)))
          stack.prepend(Map(("node", node.right), ("depth", depth + 1)))
        }
      }
    }
    return sumOfDepths
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
