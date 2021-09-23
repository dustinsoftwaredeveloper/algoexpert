import java.util.ArrayList;
import java.util.List;
/*
Big O
O(n) time, O(n) space
*/
class JavaSolutionOne {
  public static void main(String[] args) {
    BST root = new BST(10);
    root.insert(5).insert(15).insert(2).insert(5).insert(22).insert(1);
    List<Integer> inputArr1 = new ArrayList<>();
    preOrderTraverse(root, inputArr1);
    System.out.println("pre order");
    for(Integer num : inputArr1) {
      System.out.println(num);
    }
    List<Integer> inputArr2 = new ArrayList<>();
    inOrderTraverse(root, inputArr2);
    System.out.println("in order");
    for(Integer num : inputArr2) {
      System.out.println(num);
    }
    List<Integer> inputArr3 = new ArrayList<>();
    postOrderTraverse(root, inputArr3);
    System.out.println("post order");
    for(Integer num : inputArr3) {
      System.out.println(num);
    }
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

  public static List<Integer> preOrderTraverse(BST root, List<Integer> inputArr) {
    preOrderTraverseHelper(root, inputArr);
    return inputArr;
  }
  public static void preOrderTraverseHelper(BST root, List<Integer> inputArr) {
    if (root.left != null && root.right != null) {
      inputArr.add(root.value);
      preOrderTraverse(root.left, inputArr);
      preOrderTraverse(root.right, inputArr);
    } else if (root.left != null) {
      inputArr.add(root.value);
      preOrderTraverse(root.left, inputArr); 
    } else if (root.right != null) {
      inputArr.add(root.value);
      preOrderTraverse(root.right, inputArr);
    } else {
      inputArr.add(root.value);
    }
  }  
  public static List<Integer> inOrderTraverse(BST root, List<Integer> inputArr) {
    inOrderTraverseHelper(root, inputArr);
    return inputArr;
  }
  public static void inOrderTraverseHelper(BST root, List<Integer> inputArr) {
    if (root.left != null && root.right != null) {
      inOrderTraverse(root.left, inputArr);
      inputArr.add(root.value);
      inOrderTraverse(root.right, inputArr);
    } else if (root.left != null) {
      inOrderTraverse(root.left, inputArr); 
      inputArr.add(root.value);
    } else if (root.right != null) {
      inputArr.add(root.value);
      inOrderTraverse(root.right, inputArr);
    } else {
      inputArr.add(root.value);
    }
  }
  public static List<Integer> postOrderTraverse(BST root, List<Integer> inputArr) {
    postOrderTraverseHelper(root, inputArr);
    return inputArr;
  }
  public static void postOrderTraverseHelper(BST root, List<Integer> inputArr) {
    if (root.left != null && root.right != null) {
      postOrderTraverse(root.left, inputArr);
      postOrderTraverse(root.right, inputArr);
      inputArr.add(root.value);
    } else if (root.left != null) {
      postOrderTraverse(root.left, inputArr); 
      inputArr.add(root.value);
    } else if (root.right != null) {
      postOrderTraverse(root.right, inputArr);
      inputArr.add(root.value);
    } else {
      inputArr.add(root.value);
    }
  }
}
