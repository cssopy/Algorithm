function solution(dot) {
    return dot[0] > 0 && dot[1] > 0
        ? 1
        : dot[0] < 0 && dot[1] > 0
        ? 2
        : dot[0] < 0 && dot[1] < 0
        ? 3
        : 4;
}

let inps = [
    [2, 4],
    [-7, 9],
];

for (let i of inps) {
    console.log(solution(i));
}
