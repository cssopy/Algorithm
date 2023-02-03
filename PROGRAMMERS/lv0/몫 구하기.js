function solution(num1, num2) {
  return parseInt(num1 / num2);
}

let inps = [
  [10, 5],
  [7, 2],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
