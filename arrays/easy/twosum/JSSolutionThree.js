let array = [3, 5, -4, 8, 11, 1, -1, 6];

function twoSum(inputArr, targetSum) {
  let numContainer = [];
  for (let num of inputArr) {
    if (numContainer.includes(targetSum - num)) {
      return [num, targetSum - num];  
    } else {
      numContainer.push(num);
    }
  }
  return [];
}

let result = twoSum(array, 10);
for (let item of result) {
  console.log(item);
}
