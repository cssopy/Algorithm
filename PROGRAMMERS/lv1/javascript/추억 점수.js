"use strict";
function solution(name, yearning, photo) {
    let memoryScore = new Map();
    name.forEach((n, i) => {
        memoryScore.set(n, yearning[i]);
    });

    return photo.map(p => {
        let sum = 0;
        p.forEach(n => {
            if (memoryScore.has(n))
                sum += memoryScore.get(n);
        });

        return sum;
    });
}

let inps = [
    [["may", "kein", "kain", "radi"], [5, 10, 1, 3], [["may", "kein", "kain", "radi"], ["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]],
    [["kali", "mari", "don"], [11, 1, 55], [["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]],
    [["may", "kein", "kain", "radi"], [5, 10, 1, 3], [["may"], ["kein", "deny", "may"], ["kon", "coni"]]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
