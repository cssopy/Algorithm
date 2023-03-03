function solution(A, B) {
    return (B + B).indexOf(A);
}

let inps = [
    ["hello", "ohell"],
    ["apple", "elppa"],
    ["atat", "tata"],
    ["abc", "abc"],
];

inps.forEach(v => console.log(solution(v[0], v[1])));