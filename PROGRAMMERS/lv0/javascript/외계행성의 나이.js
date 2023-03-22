function solution(age) {
  return age
    .toString()
    .split("")
    .map((i) => String.fromCharCode(Number(i) + "a".charCodeAt(0)))
    .join("");
}

let inps = [23, 51, 100];

for (let i of inps) {
  console.log(solution(i));
}
