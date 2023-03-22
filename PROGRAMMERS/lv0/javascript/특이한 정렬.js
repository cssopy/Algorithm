function solution(numlist, n) {
    return numlist.sort((a, b) => Math.abs(a - n) - Math.abs(b - n) || b - a);
}

let inps = [
    [[1, 2, 3, 4, 5, 6], 4],
    [[10000, 20, 36, 47, 40, 6, 10, 7000], 30],
]

inps.forEach(v => console.log(solution(v[0], v[1])));