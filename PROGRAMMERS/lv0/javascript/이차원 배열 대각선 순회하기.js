function solution(board, k) {
    let ans = 0;
    for (let i = 0; i < board.length && i <= k; i++) {
        for (let j = 0; j < board[0].length && j <= k; j++) {
            if (i + j <= k) ans += board[i][j];
        }
    }

    return ans;
}

let inps = [
    [[[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5]], 2]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));