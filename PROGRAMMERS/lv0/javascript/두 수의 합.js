function solution(num1, num2) {
  return num1 + num2;
}

let inps = [
  [2, 3],
  [100, 2],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
