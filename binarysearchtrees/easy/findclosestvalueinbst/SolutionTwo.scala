class BST(var value: Int, var left: BST = null, var right: BST = null) {
  def addChild(value: Int): BST = {
    if(this.left == null && this.right == null) {
      if(value < this.value) {
        this.left = new BST(value)
        return this 
      }
      else {
        this.right = new BST(value)
        return this 
      }
    }
    else if(this.left != null && this.right == null) {
      if(value < this.value) {
        this.left.addChild(value)
        return this
      }
      else {
        this.right = new BST(value)
        return this
      }
    }
    else if(this.left == null && this.right != null) {
      if(value < this.value) {
        this.left = new BST(value)
        return this
      }
      else {
        this.right.addChild(value)
        return this
      }
    }
    else {
      if(value < this.value) {
        this.left.addChild(value)
        return this
      }
      else {
        this.right.addChild(value)
        return this
      }
    }
  }
}

object SolutionTwo extends App {
  def testCase1(): Unit = {
    var root: BST = new BST(10)
    root.addChild(5).addChild(15)
    root.left.addChild(2).addChild(5)
    root.right.addChild(13).addChild(22)
    root.left.left.addChild(1)
    root.right.left.addChild(14)
  }
  testCase1()
}
