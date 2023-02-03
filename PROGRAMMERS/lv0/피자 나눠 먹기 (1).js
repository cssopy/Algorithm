function solution(n) {
  return Math.ceil(n / 7);
}

let inps = [7, 1, 15];

for (let i of inps) {
  console.log(solution(i));
}
