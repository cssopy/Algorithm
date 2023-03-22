function solution(arr) {
    return arr.reduce((a, b) => a + b, 0) / arr.length;
}

let inps = [
    [1, 2, 3, 4],
    [5, 5]
];

inps.forEach(v => console.log(solution(v)));