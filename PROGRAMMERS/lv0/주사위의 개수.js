function solution(box, n) {
    return box.reduce((a, b) => a * parseInt(b / n), 1);
}

let inps = [
    [[1, 1, 1], 1],
    [[10, 8, 6], 3],
];

inps.forEach((v) => console.log(solution(v[0], v[1])));
