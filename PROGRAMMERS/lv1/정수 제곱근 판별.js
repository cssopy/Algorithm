function solution(n) {
    return Number.isInteger(n ** 0.5) ? (n ** 0.5 + 1) ** 2 : -1;
}

let inps = [
    121, 3
];

inps.forEach(v => console.log(solution(v)));