function solution(d, budget) {
    d.sort((a, b) => a - b);

    let ans = 0;
    for (let i = 0; i < d.length; i++) {
        if (d[i] > budget) break;

        ans++;
        budget -= d[i];
    }

    return ans;
}

let inps = [
    [[1, 3, 2, 5, 4], 9],
    [[2, 2, 3, 3], 10]
];

inps.forEach(v => console.log(solution(v[0], v[1])));