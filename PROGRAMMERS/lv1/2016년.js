function solution(a, b) {
    return new Date(`2016/${a}/${b}`).toString().slice(0, 3).toUpperCase();
}

let inps = [
    [5, 24]
];

inps.forEach(v => console.log(solution(v[0], v[1])));