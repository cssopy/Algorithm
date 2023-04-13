function solution(a, b, n) {
    let ans = 0;
    while (n >= a) {
        let mo = Math.floor(n / a) * b;
        let na = n % a;
        n = mo + na;
        ans += mo;
    }
    return ans;
}

let inps = [
    [2, 1, 20],
    [3, 1, 20],
    [5, 3, 21]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));