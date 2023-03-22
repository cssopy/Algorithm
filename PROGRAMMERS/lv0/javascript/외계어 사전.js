function solution(spell, dic) {
    return dic.reduce((a, b) => (spell.every((v) => b.includes(v)) ? 1 : a), 2);
}

let inps = [
    [
        ["p", "o", "s"],
        ["sod", "eocd", "qixm", "adio", "soo"],
    ],
    [
        ["z", "d", "x"],
        ["def", "dww", "dzx", "loveaw"],
    ],
    [
        ["s", "o", "m", "d"],
        ["moos", "dzx", "smm", "sunmmo", "som"],
    ],
    [["p", "o", "s"], ["ppooss"]],
];

inps.forEach((v) => console.log(solution(v[0], v[1])));

console.log(["p", "o", "s"].every((v) => "ppooss".includes(v)));
