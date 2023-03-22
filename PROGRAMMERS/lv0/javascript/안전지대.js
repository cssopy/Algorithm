let dx = [0, 0, -1, 1, -1, 1, -1, 1];
let dy = [-1, 1, 0, 0, -1, -1, 1, 1];

function solution(board) {
    let size = board.length;
    let ans = 0;
    for (let i = 0; i < size; i++) {
        for (let j = 0; j < size; j++) {
            if (board[i][j] == 1) {
                for (let dir = 0; dir < 8; dir++) {
                    let ni = i + dy[dir];
                    let nj = j + dx[dir];

                    if (
                        0 <= ni &&
                        ni <= size - 1 &&
                        0 <= nj &&
                        nj <= size - 1
                    ) {
                        board[ni][nj] = board[ni][nj] != 1 ? 2 : 1;
                    }
                }
            }
        }
    }
    return board.reduce(
        (a, b) => a + b.reduce((c, d) => (d == 0 ? c + 1 : c), 0),
        0
    );
}

let inps = [
    [
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 1, 0, 0],
        [0, 0, 0, 0, 0],
    ],
    [
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0],
        [0, 0, 1, 1, 0],
        [0, 0, 0, 0, 0],
    ],
    [
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1, 1],
    ],
];

inps.forEach((v) => console.log(solution(v)));
