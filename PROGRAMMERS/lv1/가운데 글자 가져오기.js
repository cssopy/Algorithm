function solution(s) {
    return s.length % 2 == 0 ? s.slice(parseInt(s.length / 2) - 1, parseInt(s.length / 2) + 1) : s[parseInt(s.length / 2)];
}

let inps = [
    "abcde",
    "qwer"
];

inps.forEach(v => console.log(solution(v)));