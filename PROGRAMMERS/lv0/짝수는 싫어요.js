function solution(n) {
  return Array(n)
    .fill(1)
    .map((v, i) => v + i)
    .filter((v) => v % 2 != 0);
}

let inps = [10, 15];

for (let i of inps) {
  console.log(solution(i));
}
