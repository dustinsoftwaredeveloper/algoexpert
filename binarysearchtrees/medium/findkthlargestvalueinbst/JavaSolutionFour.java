import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class JavaSolutionFour {
  public static void main(String[] args) {
    BST root = new BST(15);
    root.insert(5).insert(20).insert(2).insert(5).insert(17).insert(22).insert(1).insert(3);
    int k = 3;
    int l = 4;
    int j = 6;
    System.out.println("JavaSolutuonTwo test below");
    System.out.println(findKthLargestValueInBst(root, k));
    System.out.println(findKthLargestValueInBst(root, l));
    System.out.println(findKthLargestValueInBst(root, j));  
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
  //O(h + k) time, O(h) space
  static class NodeData {
    int currentIdx;
    int currentValue;
    public NodeData(int currentIdx, int currentValue) {
      this.currentIdx = currentIdx;
      this.currentValue = currentValue;
    } 
  }
  public static int findKthLargestValueInBst(BST root, int k) {
    NodeData nodedata = new NodeData(0, -1); 
    reverseTraversal(root, k, nodedata);
    return nodedata.currentValue;
  }
  public static void reverseTraversal(BST node, int k, NodeData nodedata) {
    //stopping condition first
    if (node == null || nodedata.currentIdx >= k) return; 
    reverseTraversal(node.right, k, nodedata);
    if (nodedata.currentIdx < k) {
      nodedata.currentValue = node.value;
      nodedata.currentIdx += 1;
      reverseTraversal(node.left, k, nodedata); 
    } 
  }
}
