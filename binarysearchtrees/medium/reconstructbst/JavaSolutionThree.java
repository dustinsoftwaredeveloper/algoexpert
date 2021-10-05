import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JavaSolutionThree {
  public static void main(String[] args) {
    List<Integer> inputArr = new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
    BST root = reconstructBst(inputArr);
    System.out.println(root.value == 10);
    System.out.println(root.left.value == 4);
    System.out.println(root.left.left.value == 2);
    System.out.println(root.left.left.left.value == 1);
    // nullpointer exception, from this line onwards something went wrong
    // it has sth to do with right nodes
    System.out.println(root.left.right.value == 5);
    System.out.println(root.right.value == 17);
    System.out.println(root.right.right.value == 19);
    System.out.println(root.right.right.left.value == 18);
  }
  static class BST {
    int value;
    BST left;
    BST right;
    public BST(int value) {
      this.value = value;
    }
  }

  public static BST reconstructBst(List<Integer> inputArr) {
    // this is a recursive function
    // stopping conditions first
    if (inputArr.size() < 1) return null; 
    BST root = new BST(inputArr.get(0));
    int rightSubtreeRootIdx = inputArr.size();
    for (int i=1; i < inputArr.size(); i++) {
      if (inputArr.get(i) >= root.value) {
        rightSubtreeRootIdx = i;
        break; // pay attention, if i need the first value match my requirement, must break the loop
        // else it will keep changing the value of the variable if there's other matches
      }
    }
    List<Integer> leftSubtreeValues = inputArr.subList(1, rightSubtreeRootIdx);
    List<Integer> rightSubtreeValues = inputArr.subList(rightSubtreeRootIdx, inputArr.size());
    root.left = reconstructBst(leftSubtreeValues);
    root.right = reconstructBst(rightSubtreeValues);
    return root;
  }
}
