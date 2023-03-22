function solution(s) {
    return s.toLowerCase().split('p').length == s.toLowerCase().split('y').length;
}

let inps = [
    "pPoooyY",
    "Pyy"
];

inps.forEach(v => console.log(solution(v)));