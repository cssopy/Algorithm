function solution(num1, num2) {
  return num1 === num2 ? 1 : -1;
}

let inps = [
  [2, 3],
  [11, 11],
  [7, 99],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
