import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JavaSolutionTwo {
  public static void main(String[] args) {
    List<Integer> inputArr = new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
    BST root = reconstructBst(inputArr);
    System.out.println(root.value == 10);
    System.out.println(root.left.value == 4);
    System.out.println(root.left.left.value == 2);
    System.out.println(root.left.left.left.value == 1);
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
    public BST insert(int value) {
      if (value < this.value) {
        if (this.left != null) {
          this.left.insert(value);
        } else {
          this.left = new BST(value);
        }
      } else {
        if (this.right != null) {
          this.right.insert(value);
        } else {
          this.right = new BST(value);
        }
      }
      return this;
    }
  }
  // O(n * log(n)) time, O(n) space
  /*
  public static BST reconstructBst(ArrayList<Integer> inputArr) {
    BST root = null;
    for (int idx = 0;idx < inputArr.size(); idx++) {
      if (idx == 0) {
        root = new BST(inputArr.get(idx));
      } else {
        root.insert(inputArr.get(idx));
      }
    } 
    return root;  
  }
  */

  /*
  // O(n^2) time, O(n)space
  public static BST reconstructBst(List<Integer> inputArr) {
    // stopping condition
    if (inputArr.size() == 0) return null;
    int currentValue = inputArr.get(0);
    int rightSubtreeRootIdx = inputArr.size();
    for (int idx = 1; idx < inputArr.size(); idx++) {
      int value = inputArr.get(idx);
      if (value >= currentValue) {
        rightSubtreeRootIdx = idx;
        break;
      }
    } 
    // slice the left sub tree 
    BST leftSubtree = reconstructBst(inputArr.subList(1, rightSubtreeRootIdx));
    BST rightSubtree = reconstructBst(inputArr.subList(rightSubtreeRootIdx, inputArr.size()));
    BST root = new BST(currentValue);
    root.left = leftSubtree;
    root.right = rightSubtree; 
    return root;
  }
  */
  // recursive function, 1 for loop, worst case n^2 ===>>> O(n^2) time, O(n) space
  public static BST reconstructBst(List<Integer> inputArr) {
    // stopping condition
    if (inputArr.size() == 0) return null;
    int currentValue = inputArr.get(0);
    int rightSubtreeIdx = inputArr.size();
    for (int idx = 1; idx < inputArr.size(); idx++) {
      if (inputArr.get(idx) >= currentValue) {
        rightSubtreeIdx = idx;
        break;
      }
    }
    BST root = new BST(currentValue);
    BST leftSubtree = reconstructBst(inputArr.subList(1, rightSubtreeIdx));
    BST rightSubtree = reconstructBst(inputArr.subList(rightSubtreeIdx, inputArr.size()));
    root.left = leftSubtree;
    root.right = rightSubtree;
    return root;
  }
}
