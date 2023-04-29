function solution(n) {
    let ans = Array.from({length: n}, () => Array.from({length: n}, () => 0));

    let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    let [r, c] = [0, -1];
    for (let i = 1, dir = 0; i <= n ** 2;) {
        let nr = r + dirs[dir][0];
        let nc = c + dirs[dir][1];

        if (!(0 <= nr && nr < n && 0 <= nc && nc < n) || ans[nr][nc] !== 0) {
            dir = (dir + 1) % 4;
        } else {
            ans[nr][nc] = i++;
            r = nr;
            c = nc;
        }
    }

    return ans;
}

let inps = [
    4, 5
];

inps.forEach(inp => console.log(solution(inp)));