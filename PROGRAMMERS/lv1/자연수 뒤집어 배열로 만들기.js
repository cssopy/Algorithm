function solution(n) {
    return [..."" + n].map(v => Number(v)).reverse();
}

let inps = [
    12345
];

inps.forEach(v => console.log(solution(v)));