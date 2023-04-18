"use strict";

function solution(k, score) {
    let list = [];
    let ans = [];
    score.forEach(v => {
        list.push(v);
        list.sort((a, b) => b - a);
        if (list.length > k) {
            ans.push(list[k-1]);
        } else {
            ans.push(list[list.length - 1]);
        }
    });

    return ans;
}

let inps = [
    [3, [10, 100, 20, 150, 1, 100, 200]],
    [4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));
