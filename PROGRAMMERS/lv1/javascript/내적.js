function solution(a, b) {
    return a.reduce((x, y, i) => x += y * b[i], 0);
}

let inps = [
    [[1, 2, 3, 4], [-3, -1, 0, 2]],
    [[-1, 0, 1], [1, 0, -1]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));