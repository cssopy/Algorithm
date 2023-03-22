function solution(price) {
  let dis = [
    [500_000, 0.8],
    [300_000, 0.9],
    [100_000, 0.95],
  ];

  for (let [s, p] of dis) {
    if (price >= s) {
      return parseInt(price * p);
    }
  }
  return price;
}

let inps = [150_000, 580_000];

for (let i of inps) {
  console.log(solution(i));
}
