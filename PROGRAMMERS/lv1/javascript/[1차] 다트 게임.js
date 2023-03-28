function solution(dartResult) {
    let scores = dartResult.split(/\D{1,}/g).slice(0, -1).map(v => Number(v));
    let bonusAndOption = dartResult.split(/\d{1,}/g).slice(1,).map(v => [...v]);

    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < bonusAndOption[i].length; j++) {
            if (bonusAndOption[i][j] == 'D') {
                scores[i] **= 2;
            }

            if (bonusAndOption[i][j] == 'T') {
                scores[i] **= 3;
            }

            if (bonusAndOption[i][j] == '*') {
                scores[i] *= 2;
                scores[i - 1] *= 2;
            }

            if (bonusAndOption[i][j] == '#') {
                scores[i] *= -1;
            }
        }
    }

    return scores.reduce((a, b) => a + b, 0);
}

let inps = [
    '1S2D*3T',
    '1D2S#10S',
    '1D2S0T',
    '1S*2T*3S',
    '1D#2S*3S',
    '1T2D3D#',
    '1D2S3T*'
];

inps.forEach(inp => console.log(solution(inp)));