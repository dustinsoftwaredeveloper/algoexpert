import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class JavaSolutionOne {
  public static void main(String[] args) {
    BST root = new BST(15);
    root.insert(5).insert(20).insert(2).insert(5).insert(17).insert(22).insert(1).insert(3);
    int k = 3;
    System.out.println("test below");
    System.out.println(findKthLargestValueInBst(root, k) == 17);
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
  public static int findKthLargestValueInBst(BST root, int k) {
    List<Integer> values = new ArrayList<>(); 
    findKthLargestValueInBstHelper(root, values);
    return values.get(k - 1);
  } 

  public static void findKthLargestValueInBstHelper(BST root, List<Integer> values) {
    BST current = root;
    if (current.left != null && current.right != null) {
      values.add(current.value);
      findKthLargestValueInBstHelper(current.left, values);
      findKthLargestValueInBstHelper(current.right, values);
    } else if (current.left != null) {
      values.add(current.value);
      findKthLargestValueInBstHelper(current.left, values);
    } else if (current.right != null) {
      values.add(current.value);
      findKthLargestValueInBstHelper(current.right, values);
    } else {
      values.add(current.value);
    }
    Collections.sort(values);
    Collections.reverse(values);
  }
}
