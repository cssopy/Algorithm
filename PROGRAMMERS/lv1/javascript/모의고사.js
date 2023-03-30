function solution(answers) {
    let ps = [
        [[1, 2, 3, 4, 5], 0, 1],
        [[2, 1, 2, 3, 2, 4, 2, 5], 0, 2],
        [[3, 3, 1, 1, 2, 2, 4, 4, 5, 5], 0, 3]
    ];

    for (let i = 0; i < answers.length; i++) {
        for (let j = 0; j < ps.length; j++) {
            ps[j][1] += answers[i] == ps[j][0][i % ps[j][0].length];
        }
    }

    let mv = Math.max(ps[0][1], ps[1][1], ps[2][1]);
    return ps.reduce((a, b) => {
        if (b[1] == mv) {
            a.push(b[2]);
        }
        return a;
    }, []);
}

let inps = [
    [1, 2, 3, 4, 5],
    [1, 3, 2, 4, 2]
];

inps.forEach(inp => console.log(solution(inp)));