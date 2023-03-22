function solution(strings, n) {
    return strings.sort((a, b) => a[n] == b[n] ? a.localeCompare(b) : a[n].localeCompare(b[n]));
}

let inps = [
    [["sun", "bed", "car"], 1],
    [["abce", "abcd", "cdx"], 2]
];

inps.forEach(v => console.log(solution(v[0], v[1])));