function solution(num, total) {
    let ans = [];

    for (let i = Math.ceil(total / num - parseInt(num / 2)); ans.length != num; i++) {
        ans.push(i);
    }

    return ans;
}

let inps = [
    [3, 12],
    [5, 15],
    [4, 14],
    [5, 5],
    [6, 21]
];

inps.forEach(v => console.log(solution(v[0], v[1])));