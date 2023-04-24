"use strict";

function solution(s, skip, index) {
    let skipSet = new Set(skip);

    return [...s].map(v => {
        let vCode = v.charCodeAt(0);
        for (let i = 0; i < index; i++) {
            vCode++;
            if (vCode === 'z'.charCodeAt(0) + 1) {
                vCode = 'a'.charCodeAt(0);
            }
            while (skipSet.has(String.fromCharCode(vCode))) {
                vCode++;
                if (vCode === 'z'.charCodeAt(0) + 1) {
                    vCode = 'a'.charCodeAt(0);
                }
            }
        }

        return String.fromCharCode(vCode);
    }).join('');
}

let inps = [
    ["aukks", "wbqd", 5],
    ["zzzzzz", "abcdefghijklmnopqrstuvwxy", 6]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
