class BST {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
  insert(value) {
    let pointer = this;
    while (true) {
      if (value < pointer.value) {
        if (pointer.left !== null) {
          pointer = pointer.left;
        } else {
          pointer.left = new BST(value);
          break;
        }
      } else {
        if (pointer.right !== null) {
          pointer = pointer.right;
        } else {
          pointer.right = new BST(value);
          break;
        }
      }
    }
    return this;
  } 
  contains(value) {
    let pointer = this;
    while (pointer !== null) {
      if (value < pointer.value) {
        pointer = pointer.left;
      } else if (value > pointer.value) {
        pointer = pointer.right;
      } else return true;
    }
    return false;
  }
  remove(value, parent = null) {
    let pointer = this;
    while (pointer !== null) {
      if (value < pointer.value) {
        parent = pointer;
        pointer = pointer.left;
      } else if (value > pointer.value) {
        parent = pointer;
        pointer = pointer.right;
      } else {
        if (pointer.left !== null && pointer.right !== null) {
          pointer.value = pointer.right.getMin();
          pointer.right.remove(pointer.value, pointer);
          break;
        } else if (parent === null) {
          if (pointer.left !== null) {
            pointer.value = pointer.left.value;
            pointer.right = pointer.left.right;
            pointer.left = pointer.left.left;
            break; 
          } else if (pointer.right !== null) {
            pointer.value = pointer.right.value;
            pointer.left = pointer.right.left;
            pointer.right = pointer.right.right;
            break;
          } else {}
        } else {
          if (parent.left === pointer) {
            if (pointer.left !== null) {
              parent.left = pointer.left;
              break; 
            } else {
              parent.left = pointer.right;
              break;
            }
          } else {
            if (pointer.left !== null) {
              parent.right = pointer.left;
              break; 
            } else {
              parent.right = pointer.right;
              break;
            }
          }
        }
      }
    }
    return this;
  }
  getMin() {
    let current = this;
    while (current.left !== null) {
      current = current.left;
    }
    return current.value;
  }
}
// tests
let root = new BST(10);
root.insert(5).insert(15).insert(2).insert(5).insert(13).insert(22).insert(1).insert(12).insert(14);
console.log(root.left.right.value === 5);
console.log(root.right.left.right.value === 14);
console.log(root.contains(1) === true);
console.log(root.contains(20) === false);
console.log(root.contains(13) === true);
root.remove(1);
console.log(root.contains(1) === false);
console.log(root.contains(15) === true);
root.remove(15);
console.log('remove 15');
console.log(root.contains(15) === false);
