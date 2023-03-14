function solution(s) {
    return [...s].sort().reverse().join("");
}

let inps = [
    "Zbcdefg"
];

inps.forEach(v => console.log(solution(v)));