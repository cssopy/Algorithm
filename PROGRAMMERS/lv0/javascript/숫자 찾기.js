function solution(num, k) {
    return num.toString().indexOf(k) == -1 ? -1 : num.toString().indexOf(k) + 1;
}

let inps = [
    [29183, 1],
    [232443, 4],
    [123456, 7]
];

inps.forEach(v => console.log(solution(v[0], v[1])));