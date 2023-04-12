function solution(survey, choices) {
    let result = {
        R: 0,
        T: 0,
        C: 0,
        F: 0,
        J: 0,
        M: 0,
        A: 0,
        N: 0
    };

    for (let i = 0; i < survey.length; i++) {
        if (choices[i] == 4) continue;

        if (choices[i] - 4 < 0) {
            result[survey[i][0]] += -(choices[i] - 4);
            continue;
        }
        result[survey[i][1]] += choices[i] - 4;
    }

    return ['RT', 'CF', 'JM', 'AN'].reduce((a, b) => {
        if (result[b[0]] < result[b[1]]) return a + b[1];
        return a + b[0];
    }, '');
}

let inps = [
    [["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]],
    [["TR", "RT", "TR"], [7, 1, 3]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));