function solution(n) {
    return Number([..."" + n].sort((a, b) => b - a).join(""));
}

let inps = [
    118372
];

inps.forEach(v => console.log(solution(v)));