function solution(x) {
    return x % [...'' + x].reduce((a, b) => a + Number(b), 0) == 0;
}

let inps = [
    10,
    12,
    11,
    13
];

inps.forEach(v => console.log(solution(v)));