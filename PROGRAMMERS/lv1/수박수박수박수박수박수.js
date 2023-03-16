function solution(n) {
    return "수박".repeat(parseInt((n + 1) / 2)).slice(0, n);
}

let inps = [
    3, 4
];

inps.forEach(v => console.log(solution(v)));