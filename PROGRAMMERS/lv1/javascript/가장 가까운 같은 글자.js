"use strict";

function solution(s) {
    let map = new Map();

    return [...s].reduce((a, b, i) => {
        if (map.get(b) == undefined) {
            a.push(-1);
        } else {
            a.push(i - map.get(b));
        }
        map.set(b, i);
        return a;
    }, []);
}

let inps = [
    "banana",
    "foobar",
    "abcda"
];

inps.forEach(inp => console.log(solution(inp)));
