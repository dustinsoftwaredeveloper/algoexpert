import java.util.Arrays;

class JavaSolutionTwo {
  public static void main(String[] args) {
    int[] result = twoSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    for (int num : result) {
      System.out.println(num);
    }
  }
  // O(n) time, O(1) space
  public static int[] twoSum(int[] inputArr, int targetSum) {
    Arrays.sort(inputArr); 
    int left = 0, right = inputArr.length - 1;
    while (left != right) {
      if (inputArr[left] + inputArr[right] < targetSum) {
        left += 1; 
      } else if (inputArr[left] + inputArr[right] > targetSum) {
        right -= 1;
      } else {
        return new int[] {inputArr[left], inputArr[right]};
      } 
    }   
    return new int[0]; 
  }
}
