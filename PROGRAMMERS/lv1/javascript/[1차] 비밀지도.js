function solution(n, arr1, arr2) {
    let ans = [];

    for (let i = 0; i < n; i++) {
        let ar = addZero(n, (arr1[i] | arr2[i]).toString(2)).replace(/1|0/g, v => Number(v) ? '#' : ' ');
        ans.push(ar);
    }

    return ans;
}

function addZero(n, s) {
    return '0'.repeat(n - s.length) + s;
}

let inps = [
    [5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]],
    [6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));