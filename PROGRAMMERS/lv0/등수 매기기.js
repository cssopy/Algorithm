function solution(score) {
    score = score.map((v) => v[0] + v[1]);
    let sorted = [...score].sort((a, b) => b - a);
    return score.map(v => sorted.indexOf(v) + 1);
}

let inps = [
    [[80, 70], [90, 50], [40, 70], [50, 80]],
    [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]],
]

inps.forEach(v => console.log(solution(v)));