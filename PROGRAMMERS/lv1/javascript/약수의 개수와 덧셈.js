function solution(left, right) {
    let ans = 0;
    for (let i = left; i <= right; i++) {
        ans += Number.isInteger(i ** 0.5) ? -i : i;
    }

    return ans;
}

let inps = [
    [13, 17],
    [24, 27]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));