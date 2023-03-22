function solution(my_string) {
    return [...my_string.toLowerCase()].sort().join("");
}

let inps = [
    "Bcad",
    "heLLo",
    "Python"
];

inps.forEach(v => console.log(solution(v)));