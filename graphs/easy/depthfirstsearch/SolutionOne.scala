/*
tdd
*/
import collection.mutable.ArrayBuffer

object SolutionOne extends App {
  class Node(var name: Char, var children: ArrayBuffer[Node] = ArrayBuffer()) {
    def addChild(name: Char): Node = {
      children += new Node(name)
      return this 
    }
    def depthFirstSearch(arr: ArrayBuffer[Char]): ArrayBuffer[Char] = {
      arr += this.name 
      for(child <- children) {
        child.depthFirstSearch(arr)
      }
      return arr
    }
  }

  def testCase1(): Unit= {
    var names: ArrayBuffer[Char] = ArrayBuffer()
    val graph = new Node('A')
    graph.addChild('B').addChild('C').addChild('D')
    graph.children(0).addChild('E').addChild('F')
    graph.children(2).addChild('G').addChild('H')
    graph.children(0).children(1).addChild('I').addChild('J')
    graph.children(2).children(0).addChild('K')
    println(graph.depthFirstSearch(names).mkString(", ") == "A, B, E, F, I, J, C, D, G, K, H")
    println(graph.depthFirstSearch(names).mkString("->"))
  }

  testCase1()
}
