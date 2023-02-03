function solution(array) {
  let m = new Map();
  for (let i of array) {
    m.set(i, (m.get(i) || 0) + 1);
  }
  m = [...m].sort((a, b) => b[1] - a[1]);
  return m.length == 1 || m[0][1] > m[1][1] ? m[0][0] : -1;
}

let inps = [[1, 2, 3, 3, 3, 4], [1, 1, 2, 2], [1]];

for (let i of inps) {
  console.log(solution(i));
}
