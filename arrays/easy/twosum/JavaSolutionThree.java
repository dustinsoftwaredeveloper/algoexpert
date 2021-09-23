import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class JavaSolutionThree {
  public static void main(String[] args) {
    int[] result = twoSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    for (int ele : result) System.out.println(ele); 
  }
  public static int[] twoSum(int[] inputArr, int targetSum) {
    List<Integer> inputList = Arrays.asList(inputArr);
    for (int num : inputArr) {
      if (inputList.contains(targetSum - num)) {
        return new int[] {num, targetSum - num}; 
      } else {
        inputList.add(num);
      }
    }
    return new int[0];
  }
}
