function twoSum(inputArr, targetSum) {
  for (i = 0; i < inputArr.length - 1; i++) {
    let numOne = inputArr[i];
    for (j = i + 1; j < inputArr.length; j++) {
      let numTwo = inputArr[j];
      if (numOne + numTwo === targetSum) {
        return [numOne, numTwo];    
      } 
    }
  }
  return [];
}

let output = twoSum([3, 5, -4, 8, 11, 1, -1, 6], 10);
for (idx = 0; idx < output.length; idx++) {
  console.log(output[idx]);
}
