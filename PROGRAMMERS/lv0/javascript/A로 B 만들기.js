function solution(before, after) {
    return before.split("").sort().join("") == after.split("").sort().join("") ? 1 : 0;
}

let inps = [
    ["olleh", "hello"],
    ["allpe", "apple"]
]

inps.forEach(v => console.log(solution(v[0], v[1])));