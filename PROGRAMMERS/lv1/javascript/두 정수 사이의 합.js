function solution(a, b) {
    return (Math.abs(a - b) + 1) * (a + b) / 2;
}

let inps = [
    [3, 5],
    [3, 3],
    [5, 3]
];

inps.forEach(v => console.log(solution(v[0], v[1])));