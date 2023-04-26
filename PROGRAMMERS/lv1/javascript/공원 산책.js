"use strict";
function solution(park, routes) {
    let position = findStartPosition(park);

    const dirs = new Map([
        ['S', [1, 0]],
        ['N', [-1, 0]],
        ['W', [0, -1]],
        ['E', [0, 1]]
    ]);

    for (let i = 0; i < routes.length; i++) {
        const route = routes[i];

        if (isPossible(park, dirs, position, route)) {
            position[0] += dirs.get(route[0])[0] * Number(route[2]);
            position[1] += dirs.get(route[0])[1] * Number(route[2]);
        }
    }

    return position;
}

function isPossible(park, dirs, position, route) {
    const [H, W] = [park.length, park[0].length];

    const dir = route[0];
    const l = Number(route[2]);

    for (let i = 1; i <= l; i++) {
        const nr = position[0] + dirs.get(dir)[0] * i;
        const nc = position[1] + dirs.get(dir)[1] * i;

        if (!(0 <= nr && nr < H && 0 <= nc && nc < W)) return false;
        if (park[nr][nc] === 'X') return false;
    }
    return true;
}

function findStartPosition(park) {
    let position;
    for (let i = 0; i < park.length; i++) {
        if (park[i].includes('S')) {
            position = [i, park[i].indexOf('S')];
            break;
        }
    }

    return position;
}

let inps = [
    [["SOO", "OOO", "OOO"], ["E 2", "S 2", "W 1"]],
    [["SOO", "OXX", "OOO"], ["E 2", "S 2", "W 1"]],
    [["OSO", "OOO", "OXO", "OOO"], ["E 2", "S 3", "W 1"]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));
