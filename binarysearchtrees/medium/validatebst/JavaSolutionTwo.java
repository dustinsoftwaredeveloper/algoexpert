class JavaSolutionTwo {
  public static void main(String[] args) {
    BST root = new BST(10);
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14);
    System.out.println(root.left.right.value == 5);
    System.out.println(root.right.left.right.value == 14);
    System.out.println(root.contains(14) == true);
    System.out.println(root.contains(3) == false);
    root.remove(14).remove(10);
    System.out.println(root.contains(14) == false);
    System.out.println(root.value == 13);
    System.out.println("validate BST below");
    System.out.println(validateBst(root));
    BST invalidBst = new BST(10);
    invalidBst.left = new BST(22);
    invalidBst.right = new BST(2);
    invalidBst.left.left = new BST(10);
    invalidBst.right.left = new BST(1);
    System.out.println(validateBst(invalidBst) == false);
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
  // O(n) time, O(d) space
  public static boolean validateBst(BST root) {
    return validateBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);     
  }
  public static boolean validateBstHelper(BST root, Integer minValue, Integer maxValue) {
    if (root == null) {
      return true;
    } else if (root.value < minValue || root.value >= maxValue) {
      return false;
    } else {
      return !validateBstHelper(root.left, minValue, root.value) == false && !validateBstHelper(root.right, root.value, maxValue) == false;
    }
  }
}
