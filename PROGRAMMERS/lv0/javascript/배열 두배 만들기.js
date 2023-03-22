function solution(numbers) {
  return numbers.map((i) => i * 2);
  // return numbers.reduce((a, b) => {
  //     console.log([...a, b * 2]);
  //     return [...a, b * 2];
  // }, []);
}

let inps = [
  [1, 2, 3, 4, 5],
  [1, 2, 100, -99, 1, 2, 3],
];

for (let i of inps) {
  console.log(solution(i));
}
