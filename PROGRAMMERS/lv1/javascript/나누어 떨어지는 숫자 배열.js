function solution(arr, divisor) {
    let ans = arr.sort((a, b) => a - b).filter(v => v % divisor == 0);
    return ans.length == 0 ? [-1] : ans;
}

let inps = [
    [[5, 9, 7, 10], 5],
    [[2, 36, 1, 3], 1],
    [[3, 2, 6], 10]
];

inps.forEach(v => console.log(solution(v[0], v[1])));