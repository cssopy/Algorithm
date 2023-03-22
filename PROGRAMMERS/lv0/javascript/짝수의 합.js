function solution(n) {
  let h = parseInt(n / 2);
  return h * (h + 1);
}

let inps = [10, 4];

for (let i of inps) {
  console.log(solution(i));
}
