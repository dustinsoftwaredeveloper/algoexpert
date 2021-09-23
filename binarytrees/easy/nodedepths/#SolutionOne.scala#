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
object SolutionOne {
  def main(args: Array[String]): Unit = {
    testCase1()
  }
  def nodeDepths(node: BinaryTree, depth: Int = 0): Int = {
    if(node == null) return 0
    else if(node.left == null && node.right == null) {
      return depth
    }
    return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1)
  }
  def testCase1(): Unit = {
    var root: BinaryTree = new BinaryTree(1)
    root.addChild(2).addChild(3)
    root.left.addChild(4).addChild(5)
    root.right.addChild(6).addChild(7)
    root.left.left.addChild(8).addChild(9)
    println(nodeDepths(root))
  }
}
