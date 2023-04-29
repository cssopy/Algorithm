function solution(n) {
    let ans = [];
    ans[1] = 1;
    ans[2] = 2;

    if (n <= 2) return ans[n];

    for (let i = 3; i <= n; i++) {
        ans[i] = (ans[i - 1] + ans[i - 2]) % 1_000_000_007;
    }

    return ans[n];
}

let inps = [
    4
];

inps.forEach(inp => console.log(solution(inp)));