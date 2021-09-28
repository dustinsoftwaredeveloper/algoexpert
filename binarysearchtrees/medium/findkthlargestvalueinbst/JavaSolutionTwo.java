import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class JavaSolutionTwo {
  public static void main(String[] args) {
    BST root = new BST(15);
    root.insert(5).insert(20).insert(2).insert(5).insert(17).insert(22).insert(1).insert(3);
    int k = 3;
    int j = 6;
    System.out.println("JavaSolutuonTwo test below");
    System.out.println(findKthLargestValueInBst(root, k) == 17);
    System.out.println(findKthLargestValueInBst(root, j) == 5);  
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;
    public BST(int value) {
      this.value = value;
    }
    public BST insert(int value) {
      BST current = this; 
      while (current != null) {
        if (value < current.value) {
          if (current.left != null) {
            current = current.left;
          } else {
            current.left = new BST(value); 
            break;
          }  
        } else {
          if (current.right != null) {
            current = current.right;
          } else {
            current.right = new BST(value);
            break; 
          }
        }
      }
      return this; 
    }    
  }
  //O(n) time, O(n) space
  public static int findKthLargestValueInBst(BST root, int k) {
    List<Integer> values = new ArrayList<>();
    findKthLargestValueInBstHelper(root, values);    
    return values.get(k - 1);
  } 
  /*
  public static void findKthLargestValueInBstHelper(BST root, List<Integer> values) {
    if (root.right != null && root.left != null) {
      findKthLargestValueInBstHelper(root.right, values);
      values.add(root.value);
      findKthLargestValueInBstHelper(root.left, values);
    } else if (root.right != null) {
      findKthLargestValueInBstHelper(root.right, values);
      values.add(root.value);
    } else if (root.left != null) {
      values.add(root.value);
      findKthLargestValueInBstHelper(root.left, values);
    } else {
      values.add(root.value);
    } 
  }
  */
  public static void findKthLargestValueInBstHelper(BST root, List<Integer> values) {
    if (root == null) {
      return;
    } else {
      findKthLargestValueInBstHelper(root.right, values);
      values.add(root.value);
      findKthLargestValueInBstHelper(root.left, values);
    }
  }
}
