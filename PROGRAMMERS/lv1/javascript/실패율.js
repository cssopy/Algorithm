function solution(N, stages) {
    let scn = Array.from({length: N + 1}, (_, i) => [i + 1, 0, 0]);

    stages.forEach(stage => {
        scn[stage - 1][1]++;

        for (let i = 1; i <= stage; i++) {
            scn[i - 1][2]++;
        }
    });

    return scn.sort((a, b) => b[1] / b[2] - a[1] / a[2])
        .reduce((a, b) => {
            if (b[0] <= N) {
                a.push(b[0]);
            }
            return a;
        }, []);
}

let inps = [
    [5, [2, 1, 2, 6, 2, 4, 3, 3]],
    [4, [4, 4, 4, 4, 4]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));