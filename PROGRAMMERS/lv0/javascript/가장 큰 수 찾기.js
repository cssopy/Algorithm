function solution(array) {
    let ans = [-1, 0];

    array.forEach((v, i) => {
        if (v > ans[0]) {
            ans[0] = v;
            ans[1] = i;
        }
    });

    return ans;
}

let inps = [
    [1, 8, 3],
    [9, 10, 11, 8]
];

inps.forEach(v => console.log(solution(v)));