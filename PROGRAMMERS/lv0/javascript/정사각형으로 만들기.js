function solution(arr) {
    const ml = Math.max(arr.length, arr[0].length);
    let ans = Array.from({length: ml}, () => Array.from({length: ml}, () => 0));
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[0].length; j++) {
            ans[i][j] = arr[i][j];
        }
    }

    return ans;
}

let inps = [
    [[572, 22, 37], [287, 726, 384], [85, 137, 292], [487, 13, 876]],
    [[57, 192, 534, 2], [9, 345, 192, 999]],
    [[1, 2], [3, 4]]
];

inps.forEach(inp => console.log(solution(inp)));