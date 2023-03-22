function solution(n) {
    return [..."" + n].reduce((a, b) => a += Number(b), 0);
}

let inps = [
    123, 987
];

inps.forEach(v => console.log(solution(v)));