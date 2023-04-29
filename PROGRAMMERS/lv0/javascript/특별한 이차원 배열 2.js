function solution(arr) {
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length; j++) {
            if (arr[i][j] != arr[j][i]) return 0;
        }
    }
    return 1;
}

let inps = [
    [[5, 192, 33], [192, 72, 95], [33, 95, 999]],
    [[19, 498, 258, 587], [63, 93, 7, 754], [258, 7, 1000, 723], [587, 754, 723, 81]]
];

inps.forEach(inp => console.log(solution(inp)));