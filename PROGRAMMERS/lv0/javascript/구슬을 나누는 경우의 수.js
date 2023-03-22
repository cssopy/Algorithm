let fac = (n) => (n == 0 ? 1 : n * fac(n - 1));

function solution(balls, share) {
    return Math.round(fac(balls) / fac(balls - share) / fac(share));
}

let inps = [
    [3, 2],
    [5, 3],
];

for (let i of inps) {
    console.log(solution(i[0], i[1]));
}
