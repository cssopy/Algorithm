function solution(n) {
  let GCD = (a, b) => (a % b == 0 ? b : GCD(b, a % b));
  return parseInt(n / GCD(n, 6));
}

let inps = [6, 10, 4];

for (let i of inps) {
  console.log(solution(i));
}
