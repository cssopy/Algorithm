function solution(n) {
    return [...n.toString()].reduce((a, b) => a + parseInt(b), 0);
}

let inps = [
    1234,
    930211
]

inps.forEach(v => console.log(solution(v)));