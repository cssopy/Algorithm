function solution(M, N) {
    return M * N - 1;
}

let inps = [
    [2, 2],
    [2, 5],
    [1, 1]
];

inps.forEach(v => console.log(solution(v[0], v[1])));