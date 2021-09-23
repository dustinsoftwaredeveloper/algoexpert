import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static java.lang.Math.floor;

class JavaSolutionOne {
  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
    BST newRoot = minHeightBst(values);
    System.out.println(newRoot.value);
    System.out.println(newRoot.left.value);
    System.out.println(newRoot.right.value);
    System.out.println(newRoot.left.left.value);
    System.out.println(newRoot.left.right.value);
    System.out.println(newRoot.right.left.value);
    System.out.println(newRoot.right.right.value);
    System.out.println(newRoot.left.right.right.value);
    System.out.println(newRoot.right.right.right.value);
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
    public boolean contains(int value) {
      BST current = this;
      while (current != null) {
        if (value < current.value) {
          if (current.left != null) {
            current = current.left;
          } else {
            break;
          }
        } else if (value > current.value) {
          if (current.right != null) {
            current = current.right;
          } else {
            break;
          }
        } else {
          return true;
        }
      }
      return false;
    }
    public BST remove(int value, BST parent) {
      BST current = this;
      while (current != null) {
        if (value < current.value) {
          if (current.left != null) {
            parent = current;
            current = current.left;
          } else {
            break;
          }  
        } else if (value > current.value) {
          if (current.right != null) {
            parent = current;
            current = current.right;
          } else {
            break; 
          }
        } else {
          if (current.left != null && current.right != null) {
            current.value = current.right.getMin();
            current.right.remove(current.value, current);
            break;
          } else if (parent == null) {
            if (current.left != null) {
              current.value = current.left.value;
              current.right = current.left.right;
              current.left = current.left.left;
              break;
            } else if (current.right != null) {
              current.value = current.right.value;
              current.left = current.right.left; 
              current.right = current.right.right;
              break;
            } else {
             
            }
          } else {
            if (parent.left == current) {
              if (current.left != null) {
                parent.left = current.left;
                break;
              } else {
                parent.left = current.right;
                break;
              }
            } else {
              if (current.left != null) {
                parent.right = current.left;
                break;
              } else {
                parent.right = current.right;
                break;
              }
            }
          }
        }
      }
      return this;
    }
    public BST remove(int value) {
      return remove(value, null);
    }
    public int getMin() {
      BST current = this;
      while (current.left != null) {
        current = current.left;
      }
      return current.value;
    }
    
  }
    // Big O n * log(n) time, O(n) space
    public static BST minHeightBst(List<Integer> inputArr) {
      return minHeightBstHelper(inputArr, 0, inputArr.size() - 1); 
    }
    public static BST minHeightBstHelper(List<Integer> inputArr, int startIdx, int endIdx) {
      return minHeightBstHelper(inputArr, null, startIdx, endIdx);
    }
    public static BST minHeightBstHelper(List<Integer> inputArr, BST node, int startIdx, int endIdx) {
      if (startIdx > endIdx) { return null; } 
      BST current = node;
      int midIdx = (int) Math.floor((startIdx + endIdx) / 2);
      if (node == null) {
        current = new BST(inputArr.get(midIdx));
      } else {
        current.insert(inputArr.get(midIdx));
      }
      minHeightBstHelper(inputArr, current, startIdx, midIdx - 1);
      minHeightBstHelper(inputArr, current, midIdx + 1, endIdx);
      return current; 
    }
}
