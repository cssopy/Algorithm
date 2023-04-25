"use strict";
function solution(n, m, section) {
    let ans = 0;
    for (let ci = 0, si = 0; ci <= section[section.length - 1]; si++) {
        if (ci <= section[si]) {
            ans++;
            ci = section[si] + m;
        }
    }

    return ans;
}

let inps = [
    [8, 4, [2, 3, 6]],
    [5, 4, [1, 3]],
    [4, 1, [1, 2, 3, 4]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
