function solution(x, n) {
    return [...Array(n).keys()].map(v => (v + 1) * x);
}

let inps = [
    [2, 5],
    [4, 3],
    [-4, 2]
];

inps.forEach(v => console.log(solution(v[0], v[1])));