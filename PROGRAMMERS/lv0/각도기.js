function solution(angle) {
  return [0, 90, 91, 180].filter((x) => angle >= x).length;
}

let inps = [70, 91, 180];

for (let i of inps) {
  console.log(solution(i));
}
