function solution(num_list) {
  return num_list.reverse();
}

let inps = [
  [1, 2, 3, 4, 5],
  [1, 1, 1, 1, 1, 2],
  [1, 0, 1, 1, 1, 3, 5],
];

for (let i of inps) {
  console.log(solution(i));
}
