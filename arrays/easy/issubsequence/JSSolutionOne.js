let array = [5, 1, 22, 25, 6, -1, 8, 10];
let sequence = [1, 6, -1, 10];

function isSubSequence(inputArr, inputSeq) {
  for (let i=0; i < inputSeq.length; i++) {
    if (inputArr.includes(inputSeq[i]) === false) {
      return false;
    }
  }
  return true;
}

console.log(isSubSequence(array, sequence))
