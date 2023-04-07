function solution(absolutes, signs) {
    return absolutes.reduce((a, b, i) => a += (signs[i] ? b : -b), 0);
}

let inps = [
    [[4, 7, 12], [true, false, true]],
    [[1, 2, 3], [false, false, true]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));