"use strict";
function solution(keymap, targets) {
    return targets.map(target => {
        let c = 0;
        [...target].forEach(key => {
            let ks = keymap.map(km => km.indexOf(key) + 1).filter(km => km);
            c += Math.min(...ks);
        });
        return c;
    }).map(target => target === Infinity ? -1 : target);
}

let inps = [
    [["ABACD", "BCEFD"], ["ABCD", "AABB"]],
    [["AA"], ["B"]],
    [["AGZ", "BSSS"], ["ASA", "BGZ"]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));