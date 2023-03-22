function solution(s1, s2) {
    return s1.filter(v => s2.includes(v)).length;
}

let inps = [
    [["a", "b", "c"], ["com", "b", "d", "p", "c"]],
    [["n", "omg"], ["m", "dot"]]
]

inps.forEach(v => console.log(solution(v[0], v[1])));