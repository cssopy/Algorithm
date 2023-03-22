function solution(dots) {
    dots = dots.map((v) => [v[0] + v[1], v]).sort((a, b) => a[0] - b[0]);
    return (
        (dots[dots.length - 1][1][0] - dots[0][1][0]) *
        (dots[dots.length - 1][1][1] - dots[0][1][1])
    );
}

let inps = [
    [
        [1, 1],
        [2, 1],
        [2, 2],
        [1, 2],
    ],
    [
        [-1, -1],
        [1, 1],
        [1, -1],
        [-1, 1],
    ],
];

inps.forEach((v) => console.log(solution(v)));
