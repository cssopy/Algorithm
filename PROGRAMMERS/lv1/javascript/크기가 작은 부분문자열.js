"use strict";
function solution(t, p) {
    let ans = 0;
    for (let i = 0; i < t.length - p.length + 1; i++) {
        if (Number(t.slice(i, i + p.length)) <= Number(p))
            ans++;
    }

    return ans;
}

let inps = [
    ["3141592", "271"],
    ["500220839878", "7"],
    ["10203", "15"]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));
