function solution(my_string, letter) {
  return my_string.split(letter).join("");
}

let inps = [
  ["abcdef", "f"],
  ["BCBdbe", "B"],
];

for (let i of inps) {
  console.log(solution(i[0], i[1]));
}
