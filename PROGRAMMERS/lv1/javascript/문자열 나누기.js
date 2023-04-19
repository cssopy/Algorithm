"use strict";
function solution(s) {
    s = [...s];

    let ans = 0;
    let pc = '';
    let coc = [0, 0];
    for (let i = 0; i < s.length; i++) {
        if (pc == '') {
            pc = s[i--];
            continue;
        }

        if (pc == s[i]) {
            coc[0]++;
        }
        else {
            coc[1]++;
        }

        if (coc[0] == coc[1]) {
            coc = [0, 0];
            pc = '';
            ans++;
        }
    }

    return ans + (pc != '' ? 1 : 0);
}

let inps = [
    "banana",
    "abracadabra",
    "aaabbaccccabba"
];

inps.forEach(inp => console.log(solution(inp)));
