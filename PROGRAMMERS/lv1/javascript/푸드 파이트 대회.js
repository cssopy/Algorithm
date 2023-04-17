"use strict";

function solution(food) {
    let ans = [];
    for (let i = 1; i < food.length; i++) {
        ans.push(String(i).repeat(Math.floor(food[i] / 2)));
    }

    return `${ans.join('')}0${ans.reverse().join('')}`;
}

let inps = [
    [1, 3, 4, 6],
    [1, 7, 1, 2]
];

inps.forEach(inp => console.log(solution(inp)));
