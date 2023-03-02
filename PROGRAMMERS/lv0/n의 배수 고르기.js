function solution(n, numlist) {
    return numlist.filter(v => v % n == 0);
}

let inps = [
    [3, [4, 5, 6, 7, 8, 9, 10, 11, 12]],
    [5, [1, 9, 3, 10, 13, 5]],
    [12, [2, 100, 120, 600, 12, 12]]
];

inps.forEach(v => console.log(solution(v[0], v[1])));