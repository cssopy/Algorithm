function solution(sides) {
    return Math.min(...sides) * 2 - 1;
}

let inps = [
    [1, 2],
    [3, 6],
    [11, 7],
];

inps.forEach((v) => console.log(solution(v)));
