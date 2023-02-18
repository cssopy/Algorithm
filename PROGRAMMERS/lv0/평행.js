let getSlope = (d1, d2) => (d1[1] - d2[1]) / (d1[0] - d2[0]);

function solution(dots) {
    for (let i = 1; i < dots.length; i++) {
        let ods = [];
        for (let j = 0; j < dots.length; j++) {
            if (j != 0 && j != i) {
                ods.push(dots[j]);
            }
        }

        if (getSlope(dots[0], dots[i]) == getSlope(ods[0], ods[1])) {
            return 1;
        }
    }
    return 0;
}

let inps = [
    [
        [1, 4],
        [9, 2],
        [3, 8],
        [11, 6],
    ],
    [
        [3, 5],
        [4, 1],
        [2, 4],
        [5, 10],
    ],
];

inps.forEach((v) => console.log(solution(v)));
