function solution(n) {
    for (let i = 2; i < n; i++) {
        if (n % i == 1) return i;
    }
}

let inps = [
    10,
    12
];

inps.forEach(inp => console.log(solution(inp)));