class JavaSolutionOne {
  public static void main(String[] args) {
    int[] result = twoSum(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
    for (int num : result) {
      System.out.println(num);
    }
  }
  public static int[] twoSum(int[] inputArr, int targetSum) {
    for (int i = 0; i < inputArr.length - 1; i++) {
      int numOne = inputArr[i];
      for (int j = i + 1; j < inputArr.length; j++) {
        int numTwo = inputArr[j]; 
        if (numOne + numTwo == targetSum) {
          return new int[] {numOne, numTwo};
        }
      }
    }
    return new int[0];
  }
}
