function solution(money) {
  return [parseInt(money / 5_500), money % 5_500];
}

let inps = [5_500, 15_000];

for (let i of inps) {
  console.log(solution(i));
}
