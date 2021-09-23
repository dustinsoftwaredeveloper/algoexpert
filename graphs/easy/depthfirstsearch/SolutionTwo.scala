import scala.collection.mutable.ArrayBuffer

class Vertex(var name: Char, var children: ArrayBuffer[Vertex] = ArrayBuffer()) {
  def addChild(name: Char): Vertex = {
    this.children += new Vertex(name)
    return this 
  }

  def depthFirstSearch(names: ArrayBuffer[Char]): ArrayBuffer[Char] = {
    names += this.name
    for(c <- this.children) {
      c.depthFirstSearch(names)
    }
    return names 
  } 
}

object MainClass extends App {
  def testCase1(): Unit = {
    var names: ArrayBuffer[Char] = ArrayBuffer()
    var graph: Vertex = new Vertex('A')
    graph.addChild('B').addChild('C').addChild('D')
    graph.children(0).addChild('E').addChild('F')
    graph.children(2).addChild('G').addChild('H')
    graph.children(0).children(1).addChild('I').addChild('J')
    graph.children(2).children(0).addChild('K')
    println(graph.depthFirstSearch(names).mkString(", ") == "A, B, E, F, I, J, C, D, G, K, H")
    println(graph.depthFirstSearch(names).mkString(" -> "))
  }
  testCase1() 
}
