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

object SolutionFour extends App {
  def nodeDepths(root: BinaryTree, depth: Int = 0): Int = {
    var result: Int = 0
    if(root == null) return 0 
    result = depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1)
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
