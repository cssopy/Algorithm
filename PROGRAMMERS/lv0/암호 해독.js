function solution(cipher, code) {
    return [...cipher].reduce((a, b, i) => a += (i + 1) % code == 0 ? b : '', '');
}

let inps = [
    ["dfjardstddetckdaccccdegk", 4],
    ["pfqallllabwaoclk", 2]
]

inps.forEach(v => console.log(solution(v[0], v[1])));