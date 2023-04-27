"use strict";

function solution(players, callings) {
    let ps = new Map();
    players.forEach((player, i) => {
        ps.set(player, i);
    });

    callings.forEach(calling => {
        let ci = ps.get(calling);
        let ti = ci - 1;

        ps.set(calling, ti);
        ps.set(players[ti], ci);

        [players[ti], players[ci]] = [players[ci], players[ti]];
    });

    return players;
}

let inps = [
    [["mumu", "soe", "poe", "kai", "mine"], ["kai", "kai", "mine", "mine"]],
];
inps.forEach(inp => console.log(solution(inp[0], inp[1])));
