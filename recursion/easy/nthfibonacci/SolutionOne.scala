/*
f0 = 0, f1= 1
getNthFib(1) = f0
getNthFib(0) = 0
fib(n) = fib(n-1) + fib(n-2)
if n = 3
fib(3) = fib(3-1) + fib(3-2)
2 + 1 = 3
fib(4) = fib(4-1) + fib(4-2)
3 + 2 = 5
fib(5) = fib(5-1) + fib(5-2)
4 + 3 = 7

Solution.getNthFib(5)
Solution.getNthFib(6)
Solution.getNthFib(7)
Solution.getNthFib(8)
Solution.getNthFib(9)

naive recursion
O(2^n) time, O(n) space - call stack
naive: because time complexity not great
*/


object Solution {
  def getNthFib(n: Int): Int = {
    if(n <= 1) return 0
    if(n == 2) return 1
    else {
      return getNthFib(n - 1) + getNthFib(n - 2)
    }
  }
}

/* caching / memoization
   call stack is a fibonacci tree
f(5)
f(4) + f(3)
f(3) + f(2) + f(2) + f(1)
f(2) + f(1)


Solution.getNthFib(5)
Solution.getNthFib(6)
Solution.getNthFib(7)
Solution.getNthFib(8)
Solution.getNthFib(9)

O(n) time, O(n) space
*/

import scala.collection.mutable.Map

object Solution {
  def getNthFib(n: Int): Int = {
    var memo: collection.mutable.Map[Int, Int] = Map()
    var fibResult: Int = 0
    if(memo.get(n) != None) return memo(n)
    if(n <= 1) return 0
    if(n == 2) return 1
    else { 
      fibResult = getNthFib(n - 1) + getNthFib(n - 2)
       memo += ((n, fibResult))
      return fibResult
        }
  }
}

/*
iterative

O(n) time, O(1) space
*/

import scala.collection.mutable.ArrayBuffer

object Solution {
  def getNthFib(n: Int): Int = {
    var numContainer: collection.mutable.ArrayBuffer[Int] = ArrayBuffer(0, 1)
    var tracker: Int = 3
    if(n <= 1) return 0
    if(n == 2) return 1
    else {
      while(tracker <= n) {
        numContainer(1) = numContainer(0) + numContainer(1)
        numContainer(0) = numContainer(1) - numContainer(0)
        tracker += 1
      }
      return numContainer(1)
    }
  }
}

