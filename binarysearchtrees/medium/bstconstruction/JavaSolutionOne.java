class JavaSolutionOne {
  public static void main(String[] args) {
    BST root = new BST(10);
    root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(14);
    System.out.println(root.left.value);
    System.out.println(root.left.right.value);
    System.out.println(root.right.left.right.value);
    System.out.println(root.contains(1));
    root.remove(1);
    System.out.println(root.contains(1) == false);
    root.remove(14);
    System.out.println(root.contains(14) == false);
  }
  // static means it isn't associated with an instance of the bigger class
  // this class belongs to the bigger class itself, not an instance
  // can access without first creating an instance of the bigger class
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
          if (current.left == null) {
            current.left = new BST(value);
            break; 
          }
          else {
            current = current.left; 
          }
        }
        else {
          if (current.right == null) {
            current.right = new BST(value);
            break;
          }
          else { 
            current = current.right;
          }
        }
      }
      return this; 
    }
    public boolean contains(int value) {
      BST pointer = this;
      while (pointer != null) {
        if (value < pointer.value) {
          if (pointer.left != null) {
            pointer = pointer.left;
          } else {
            return false;
          }
        } else if (value > pointer.value) { 
          if (pointer.right != null) {
            pointer = pointer.right;
          } else {
            return false;
          }
        } else {
          return true;
        }
      } 
      return false;
    }
    public BST remove(int value) {
      remove(value, null);
      return this;
    }
    public void remove(int value, BST parent) {
      BST pointer = this;
      while (pointer != null) {
        if (value < pointer.value) {
          if (pointer.left != null) {
            parent = pointer;
            pointer = pointer.left;
          } else {
            break;
          }
        } else if (value > pointer.value) {
          if (pointer.right != null) {
            parent = pointer;
            pointer = pointer.right;
          } else {
            break;
          }
        } else {
          if (pointer.left != null && pointer.right != null) {
            pointer.value = findMin(pointer.right);
            pointer.right.remove(pointer.value);
            break;
          } else if (parent == null) {
            if (pointer.left != null) {
              pointer.value = pointer.left.value;
              pointer.right = pointer.left.right;
              pointer.left = pointer.left.left;
              break;
            } else if (pointer.right != null) {
              pointer.value = pointer.right.value;
              pointer.left = pointer.right.left;
              pointer.right = pointer.right.right;
              break;
            } else {
              break;   
            }
          } else {
            if (parent.left == pointer) {
              parent.right = parent.left.right;
              parent.left = parent.left.left;
              break;
            } else {
              parent.left = parent.right.left;
              parent.right = parent.right.right;
              break;
            }
          }
        }
      }
    }
    public int findMin(BST node) {
      BST pointer = node;
      while (pointer.left != null) {
        pointer = pointer.left;
      }
      return pointer.value;
    }
  }
}

