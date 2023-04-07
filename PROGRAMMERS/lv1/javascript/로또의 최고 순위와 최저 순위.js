const rank = [6, 6, 5, 4, 3, 2, 1];

function solution(lottos, win_nums) {
    let lotto_result = lottos.reduce((a, b) => {
        if (win_nums.includes(b)) {
            a[0]++;
        }
        if (b == 0) {
            a[1]++;
        }
        return a;
    }, [0, 0]);

    let max_mc = lotto_result[0] + lotto_result[1];
    let min_mc = lotto_result[0];
    return [rank[max_mc], rank[min_mc]];
}

let inps = [
    [[44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]],
    [[0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]],
    [[45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));