function solution(my_string) {
    return [...new Set(my_string)].join("");
    return [...my_string].reduce((a, b, i) => a += my_string.indexOf(b) == i ? b : '', '');
}

let inps = [
    "people",
    "We are the world"
]

inps.forEach(v => console.log(solution(v)));