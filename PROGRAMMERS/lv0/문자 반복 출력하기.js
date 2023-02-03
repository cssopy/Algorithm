function solution(my_string, n) {
  return [...my_string].reduce((a, b) => a + b.repeat(n), "");
}

let inps = [["hello", 3]];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
