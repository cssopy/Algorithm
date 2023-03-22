function solution(n, m) {
    let gcd = GCD(n, m);
    return [gcd, n * m / gcd];
}

function GCD(a, b) {
    return b == 0 ? a : GCD(b, a % b);
}

let inps = [
    [3, 12],
    [2, 5]
];

inps.forEach(v => console.log(solution(v[0], v[1])));