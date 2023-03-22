function solution(common) {
    let a = common[2] - common[1];
    let b = common[1] - common[0];

    return Math.abs(a) == Math.abs(b) ? common.pop() + a : common.pop() * a / b;
}

let inps = [
    [1, 2, 3, 4],
    [2, 4, 8]
];

inps.forEach(v => console.log(solution(v)));