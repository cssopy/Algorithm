function solution(slice, n) {
  return Math.ceil(n / slice);
}

let inps = [
  [7, 10],
  [4, 12],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
