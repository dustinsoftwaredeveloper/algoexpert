const inputArr = [3, 5, -4, 8, 11, 1, -1, 6];

function twoSum(inputArr, targetSum) {
  let left = 0;
  let right = inputArr.length - 1;
  while (left != right) {
    if (inputArr[left] + inputArr[right] > targetSum) {
      right -= 1;
    } else if (inputArr[left] + inputArr[right] < targetSum) {
      left += 1;
    } else {
      return [inputArr[left], inputArr[right]];
    }
  }
  return [];
}

let result = twoSum(inputArr, 10);
for (let num of result) {
  console.log(num);
}
console.log("this is js solution two");
