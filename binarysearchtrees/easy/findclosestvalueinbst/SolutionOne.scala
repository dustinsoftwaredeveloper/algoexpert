/*
Definition for a binary tree node
*/

import scala.collection.mutable.Array

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {

  def findClosestValueInBst(root: TreeNode, val: Int): Int = {
    var closeValues: collection.mutable.Array[Int] = Array()
    var allValues: collection.mutable.Array[Int] = extractInOrder(root) += val
    val allValuesSorted: collection.mutable.Array[Int] =  allValues.sortWith(_ < _)
    val valIndex: Int = allValuesSorted.indexOf(val)
    var beforeVal: Int = 0
    var afterval: Int = 0
    if(valIndex == 0) return allValuesSorted(valIndex + 1)
    if(valIndex == allValuesSorted.length - 1) return allValuesSorted(allValuesSorted.length - 2)
    else {
      beforeVal = allValuesSorted(valIndex - 1)
      afterVal = allValuesSorted(valIndex + 1)
        if((val - beforeVal).abs < (val - afterVal)) return beforeVal
        else return afterVal
    }
  }

  def extractInOrder(root: TreeNode): collection.mutable.Array[Int] {
    var allValues: collection.mutable.Array[Int] = Array()
    if(root.left != null) {extractInOrder(root.left)}
    allValues += root.value
    if(root.right != null) {extractInOrder(root.right)}
  }
}