function solution(num1, num2) {
  return parseInt((num1 / num2) * 1000);
}

let inps = [
  [3, 2],
  [7, 3],
  [1, 16],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
