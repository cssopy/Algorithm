function solution(n, t) {
    return n << t;
}

let inps = [
    [2, 10],
    [7, 15]
];

inps.forEach(v => console.log(solution(v[0], v[1])));
