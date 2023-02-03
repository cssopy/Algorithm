function solution(num1, num2) {
  return num1 % num2;
}

let inps = [
  [3, 2],
  [10, 5],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
