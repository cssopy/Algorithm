"use strict";
function solution(number, limit, power) {
    let ans = 0;
    for (let i = 1; i <= number; i++) {
        let r = countDivisor(i);
        ans += r > limit ? power : r;
    }

    return ans;
}
function countDivisor(n) {
    let set = new Set();
    for (let i = 1; i <= n ** 0.5; i++) {
        if (n % i == 0) {
            set.add(i);
            set.add(n / i);
        }
    }

    return set.size;
}

let inps = [
    [5, 3, 2],
    [10, 3, 2]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
