import java.util.ArrayList;

class JavaSolutionFour {
  public static void main(String[] args) {
    int[] result = twoSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    for (int ele : result) {
      System.out.println(ele);
    }
  }
  // O(n) time, O(n) space
  public static int[] twoSum(int[] inputArr, int targetSum) {
    ArrayList<Integer> inputList = new ArrayList<>();
    for (int num : inputArr) {
      if (inputList.contains(targetSum - num)) {
        return new int[] {targetSum - num, num};	
      } else {
        inputList.add(num);
      } 
    }
    return new int[0];
  }
}
