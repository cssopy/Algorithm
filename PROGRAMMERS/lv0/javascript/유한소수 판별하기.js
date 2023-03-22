function solution(a, b) {
    b /= GCD(a, b);

    while (b % 2 == 0) b /= 2;
    while (b % 5 == 0) b /= 5;

    return b == 1 ? 1 : 2;
}

function GCD(a, b) {
    return a % b == 0 ? b : GCD(b, a % b);
}

let inps = [
    [7, 20],
    [11, 22],
    [12, 21]
]

inps.forEach(v => console.log(solution(v[0], v[1])));