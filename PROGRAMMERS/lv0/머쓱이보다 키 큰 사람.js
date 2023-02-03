function solution(array, height) {
  return array.filter((i) => i > height).length;
}

let inp = [
  [[149, 180, 192, 170], 167],
  [[180, 120, 140], 190],
];

for (let i of inp) {
  console.log(solution(i[0], i[1]));
}
