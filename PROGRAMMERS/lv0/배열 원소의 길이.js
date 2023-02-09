function solution(strlist) {
    return strlist.map((v) => v.length);
}

let inps = [
    ["We", "are", "the", "world!"],
    ["I", "Love", "Programmers."],
];

inps.forEach((v) => console.log(solution(v)));
