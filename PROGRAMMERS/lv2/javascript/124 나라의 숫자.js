function solution(n) {
    let ans = [];
    n = n - 1;
    while (n >= 0) {
        if (n % 3 == 2) ans.push(4);
        else ans.push(n % 3 + 1);

        n = Math.floor(n / 3) - 1;
    }

    return ans.reverse().join('');
}

let inps = [
    1, 2, 3, 4
];

inps.forEach(inp => console.log(solution(inp)));