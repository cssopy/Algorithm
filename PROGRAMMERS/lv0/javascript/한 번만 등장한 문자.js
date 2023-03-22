function solution(s) {
    return [...s].filter((v, i) => s.indexOf(v) == s.lastIndexOf(v)).sort().join("");
}

let inps = [
    "abcabcadc",
    "abdc",
    "hello"
]

inps.forEach(v => console.log(solution(v)));