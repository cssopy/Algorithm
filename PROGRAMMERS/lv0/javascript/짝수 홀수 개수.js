function solution(num_list) {
  let ans = [0, 0];

  for (let i of num_list) {
    ans[i % 2]++;
  }

  return ans;
}

let inps = [
  [1, 2, 3, 4, 5],
  [1, 3, 5, 7],
];

for (let i of inps) {
  console.log(solution(i));
}
