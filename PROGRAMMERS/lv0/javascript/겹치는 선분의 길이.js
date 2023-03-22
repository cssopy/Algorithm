function solution(lines) {
    let map = new Map();

    lines.forEach(v => {
        for (let i = v[0]; i < v[1]; i++) {
            map.set(i, isNaN(map.get(i)) ? 1 : map.get(i) + 1);
        }
    })

    let ans = 0;
    for (const [_, v] of map) {
        ans += v >= 2 ? 1 : 0;
    }

    return ans;
}

let inps = [
    [
        [0, 1],
        [2, 5],
        [3, 9],
    ],
    [
        [-1, 1],
        [1, 3],
        [3, 9],
    ],
    [
        [0, 5],
        [3, 9],
        [1, 10],
    ],
];

inps.forEach((v) => console.log(solution(v)));
