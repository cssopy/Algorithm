"use strict";

function solution(today, terms, privacies) {
    let termsMap = terms.reduce((a, b) => {
        let v = b.split(' ');
        a.set(v[0], Number(v[1]));
        return a;
    }, new Map());

    return privacies.reduce((a, b, i) => {
        if (isDestroyed(today, b, termsMap)) {
            a.push(i + 1);
        }
        return a;
    }, []);
}

function isDestroyed(today, b, termsMap) {
    let [ts, bs] = [today.split('.'), b.split(/[.| ]/g)];
    let [ty, tm, td] = [Number(ts[0]), Number(ts[1]), Number(ts[2])];
    let [by, bm, bd, bp] = [Number(bs[0]), Number(bs[1]), Number(bs[2]), bs[3]];

    // if (bm + termsMap.get(bp) > 12) {
    //     by += Math.floor((bm + termsMap.get(bp)) / 12);
    //     bm = bd - 1 === 0 ? (bm + termsMap.get(bp)) % 12 - 1 : (bm + termsMap.get(bp)) % 12;
    //     bd = bd - 1 === 0 ? 28 : bd - 1;
    // }
    // else {
    //     bm = bd - 1 === 0 ? bm + termsMap.get(bp) - 1 : bm + termsMap.get(bp);
    //     bd = bd - 1 === 0 ? 28 : bd - 1;
    // }

    if (ty * 12 * 28 + tm * 28 + td > by * 12 * 28 + bm * 28 + bd + termsMap.get(bp) * 28) return true;
    return false;
}

let inps = [
    ["2022.05.19", ["A 6", "B 12", "C 3"], ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]],
    ["2020.01.01", ["Z 3", "D 5"], ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]],
    ["2020.01.02", ["A 1"], ["2020.01.02 A"]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));
