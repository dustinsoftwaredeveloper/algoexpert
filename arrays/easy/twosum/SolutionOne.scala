/*
Write a function that takes in a non-empty array of distinct integers
representing a target sum. If any two numbers in the input array sum up
to the target sum, the function should return them in an array, in any
order. if no two numbers sum up to the target sum, the function should
return an empty array.

Note that the target sum has to be obtained by summing two different
integers in the array; you can't add a single integer to itself in 
order to obtain the target sum.

You can assume that there will be at most one pair of numbers summing
up to the target sum.

sample imput:
array = [3, 5, -4, 8, 11, 1, -1, 6]
targetSum = 10

sample output:
[-1, 11] // the numbers could be in reverse order
*/

object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = scala.collection.mutable.Map[Int, Int] ()
        var count = 0;
        for(num <- nums){
            val comp = target-num
            map.get(comp) match {
                case None => {map.put(num,count)}
                case Some(index) => return Array(index,count) 
                
            }
            count = count+1
        }
        Array(0,0)
    }
    val arrayOne = Array(3, 5, -4, 8, 11, 1, -1, 6)
    println(twoSum(arrayOne, 10))
    println("fuck")
}


    