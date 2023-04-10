function solution(numbers) {
    return 45 - numbers.reduce((a, b) => a + b, 0);
}

let inps = [
    [1, 2, 3, 4, 6, 7, 8, 0],
    [5, 8, 4, 0, 6, 7, 9]
];

inps.forEach(inp => console.log(solution(inp)));