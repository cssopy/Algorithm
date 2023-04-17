"use strict";
function solution(k, m, score) {
    score.sort((a, b) => b - a);

    let ans = 0;
    for (let i = m - 1; i < score.length; i += m) {
        ans += score[i] * m;
    }

    return ans;
}

let inps = [
    [3, 4, [1, 2, 3, 1, 2, 3, 1]],
    [4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
