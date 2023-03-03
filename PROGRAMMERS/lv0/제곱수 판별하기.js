function solution(n) {
    return Number.isInteger(Math.sqrt(n)) ? 1 : 2;
}

let inps = [
    144,
    976
];

inps.forEach(v => console.log(solution(v)));