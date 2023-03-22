function solution(numer1, denom1, numer2, denom2) {
  let a = numer1 * denom2 + numer2 * denom1;
  let b = denom1 * denom2;

  let gcd = GCD(a, b);
  return [a / gcd, b / gcd];
}

function GCD(a, b) {
  return a % b == 0 ? b : GCD(b, a % b);
}

let inps = [
  [1, 2, 3, 4],
  [9, 2, 1, 3],
];

for (let i of inps) {
  console.log(solution(i[0], i[1], i[2], i[3]));
}
