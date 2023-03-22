function solution(my_string) {
  return [...my_string].reverse().join("");
}

let inps = ["jaron", "bread"];

for (let i of inps) {
  console.log(solution(i));
}
