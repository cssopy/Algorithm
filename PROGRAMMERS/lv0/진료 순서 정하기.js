function solution(emergency) {
  let sorted = [...emergency].sort((a, b) => b - a);
  return emergency.map((v) => sorted.indexOf(v) + 1);
}

let inps = [
  [3, 76, 24],
  [1, 2, 3, 4, 5, 6, 7],
  [30, 10, 23, 6, 100],
];

for (let i of inps) {
  console.log(solution(i));
}
