function solution(arr1, arr2) {
    return arr1.map((v, i) => v.map((vv, j) => vv + arr2[i][j]));
}

let inps = [
    [[[1, 2], [2, 3]], [[3, 4], [5, 6]]],
    [[[1], [2]], [[3], [4]]]
]

inps.forEach(v => console.log(solution(v[0], v[1])));