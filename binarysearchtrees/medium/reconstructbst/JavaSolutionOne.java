import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JavaSolutionOne {
  public static void main(String[] args) {
    ArrayList<Integer> inputArr = new ArrayList<Integer>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
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
  public static BST reconstructBst(ArrayList<Integer> inputArr) {
    BST root = null;
    BST current = root;
    for (int idx = 0;idx < inputArr.size(); idx++) {
      if (idx == 0) {
        root = new BST(inputArr.get(idx));
      } else {
        while (true) {
          if (inputArr.get(idx) < current.value) {
            if (current.left != null) {
              current = current.left;
            } else {
              current.left = new BST(inputArr.get(idx));
              break;
            }   
          } else {
            if (current.right != null) {
              current = current.right;
            } else {
              current.right = new BST(inputArr.get(idx));
              break;
            }   
          }  
        }
      }
    } 
    return root;  
  }
}
