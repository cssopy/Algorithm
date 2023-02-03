function solution(numbers, num1, num2) {
  return numbers.slice(num1, num2 + 1);
}

let inps = [
  [[1, 2, 3, 4, 5], 1, 3],
  [[1, 3, 5], 1, 2],
];

for (let i of inps) {
  console.log(solution(i[0], i[1], i[2]));
}
