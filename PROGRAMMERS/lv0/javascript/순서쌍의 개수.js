function solution(n) {
  let ans = 0;
  for (let i = 1; i <= Math.sqrt(n); i++) {
    if (n % i == 0) {
      if (i == Math.sqrt(n)) {
        ans++;
        continue;
      }
      ans += 2;
    }
  }
  return ans;
}

let inps = [20, 100];

for (let i of inps) {
  console.log(solution(i));
}
