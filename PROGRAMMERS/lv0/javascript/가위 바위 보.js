let map = {
  2: 0,
  0: 5,
  5: 2,
};

function solution(rsp) {
  return [...rsp].map((v) => map[v]).join("");
}

let inps = ["2", "205"];

for (let i of inps) {
  console.log(solution(i));
}
