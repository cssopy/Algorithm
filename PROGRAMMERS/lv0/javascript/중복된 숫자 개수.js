function solution(array, n) {
  return array.filter((i) => i === n).length;
}

let inp = [
  [[1, 1, 2, 3, 4, 5], 1],
  [[0, 2, 3, 4], 1],
];

for (let i of inp) {
  console.log(solution(i[0], i[1]));
}
