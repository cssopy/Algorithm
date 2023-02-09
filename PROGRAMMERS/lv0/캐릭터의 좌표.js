let map = {
    up: [1, 1],
    down: [1, -1],
    left: [0, -1],
    right: [0, 1],
};

function solution(keyinput, board) {
    let ans = [0, 0];
    keyinput.forEach((v) => {
        ans[map[v][0]] +=
            Math.abs(ans[map[v][0]] + map[v][1]) <=
            parseInt(board[map[v][0]] / 2)
                ? map[v][1]
                : 0;
    });
    return ans;
}

let inps = [
    [
        ["left", "right", "up", "right", "right"],
        [11, 11],
    ],
    [
        ["down", "down", "down", "down", "down"],
        [7, 9],
    ],
];

inps.forEach((v) => console.log(solution(v[0], v[1])));
