function solution(n, k) {
  return 12_000 * n + 2_000 * k - 2_000 * parseInt(n / 10);
}

let inps = [
  [10, 3],
  [64, 6],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
