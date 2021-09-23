/*
Sample Input
coins = [5, 7, 1, 1, 2, 3, 22]
Sample Output
20
Sample Input
coins = []
Sample Output
1
Sample Input
coins = [1, 2, 5]
Sample Output
4
*/

/*
for the nums in the array to be constructible,
the numbers must not be larger than the sum.
so + 1 will make the difference
the sum is in fact a number inside the array, + 1 is the way to get 
a number that's out of range
[5, 7, 1, 1, 2, 3, 22]
[1, 1, 2, 3, 5, 7, 22] 20 ->answer
what is the difference between 20 and all the other sums
20 is the sum + 1
does this apply to the smaller array?
yes. so if the next number in the input array is greater than the sum of
all numbers before + 1, it will create some numbers it can't make up
so the qualifying condition should be the sum + 1
for loop:
0+1(1), 1+1(2), 2+2(4), 4+3(7), 7+5(12), 12+7(19), 19+22(41)
output: smallest sum it can't create
[1, 2, 4]
for loop:
0 + 1 = 1
1 + 2 = 3
3 + 5 = 8
what is the difference between 4 and 5 in relation to [1, 2]?
5 is greater than (1+2)
4 is greater than (1+2)
5 is greater than (1+2 + 1) -> difference
*/
//O(n) / O(n log n time), O(1) space


object Solution {
  def nonConstructibleChange(coins: Array[Int]): Int = {
    if(coins.length < 1) return 1
    var sum: Int = 0
    for(coin <- coins.sortWith(_ < _)) {
      if(coin > sum + 1) return sum + 1
      else sum += coin
    }
    return sum + 1
  }
}


