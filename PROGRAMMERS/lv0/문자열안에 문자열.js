function solution(str1, str2) {
    return str1.includes(str2) ? 1 : 2;
}

let inps = [
    ["ab6CDE443fgh22iJKlmn1o", "6CD"],
    ["ppprrrogrammers", "pppp"],
    ["AbcAbcA", "AAA"]
];

inps.forEach(v => console.log(solution(v[0], v[1])));