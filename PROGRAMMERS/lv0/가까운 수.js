function solution(array, n) {
    return array.sort((a, b) => Math.abs(n - a) - Math.abs(n - b) || a - b)[0];
}

let inps = [
    [[3, 10, 28], 20],
    [[10, 11, 12], 13]
]

inps.forEach(v => console.log(solution(v[0], v[1])));