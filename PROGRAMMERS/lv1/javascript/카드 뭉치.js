"use strict";
function solution(cards1, cards2, goal) {
    for (let i = 0; i < goal.length; i++) {
        let word = goal[i];

        if (word !== cards1[0] && word !== cards2[0])
            return 'No';

        if (word === cards1[0])
            cards1.splice(0, 1);
        else
            cards2.splice(0, 1);
    }
    return 'Yes';
}

let inps = [
    [["i", "drink", "water"], ["want", "to"], ["i", "want", "to", "drink", "water"]],
    [["i", "water", "drink"], ["want", "to"], ["i", "want", "to", "drink", "water"]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
