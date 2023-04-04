function solution(board, moves) {
    let dc = Array.from({length: board.length + 1}, () => []);
    for (let i = 1; i <= board.length; i++) {
        for (let j = board.length - 1; j >= 0; j--) {
            if (board[j][i - 1] == 0) break;
            dc[i].push(board[j][i - 1]);
        }
    }

    let basket = [];
    let ans = 0;
    for (let i = 0; i < moves.length; i++) {
        let move = moves[i];

        if (dc[move].length != 0) {
            basket.push(dc[move].pop());
        }

        if (basket.length != 0 && basket[basket.length - 1] == basket[basket.length - 2]) {
            for (let j = 0; j < 2; j++) {
                basket.pop();
            }
            ans += 2;
        }
    }

    return ans;
}

let inps = [
    [[[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]], [1, 5, 3, 5, 1, 2, 1, 4]],
    [[[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]], [1, 2, 3, 4]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));