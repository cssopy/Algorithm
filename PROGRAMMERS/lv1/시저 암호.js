function solution(s, n) {
    let az = Array.from({length: 26}, (_, i) => String.fromCharCode(i + 'a'.charCodeAt(0)));
    let AZ = Array.from({length: 26}, (_, i) => String.fromCharCode(i + 'A'.charCodeAt(0)));
    return [...s].map(v => v == ' ' ? v : az.includes(v) ? az[(v.charCodeAt(0) - 'a'.charCodeAt(0) + n) % 26] : AZ[(v.charCodeAt(0) - 'A'.charCodeAt(0) + n) % 26]).join("");
}

let inps = [
    ["AB", 1],
    ["z", 1],
    ["a B z", 4]
];

inps.forEach(v => console.log(solution(v[0], v[1])));