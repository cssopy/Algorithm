function solution(n) {
    return parseInt([...n.toString(3)].reverse().join('').toString(10), 3);
}

let inps = [
    45,
    125
];

inps.forEach(inp => console.log(solution(inp)));