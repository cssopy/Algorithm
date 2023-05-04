function solution(n) {
    return Array.from({length: n}, (_, i) => Array.from({length: n}, (_, j) => i == j ? 1 : 0));
}

let inps = [
    3, 6, 1
];

inps.forEach(inp => console.log(solution(inp)));