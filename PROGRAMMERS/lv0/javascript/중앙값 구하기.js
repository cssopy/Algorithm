function solution(array) {
  array.sort((a, b) => a - b);
  return array[parseInt(array.length / 2)];
}

let inps = [
  [1, 2, 7, 10, 11],
  [9, -1, 0],
];

for (let i of inps) {
  console.log(solution(i));
}
