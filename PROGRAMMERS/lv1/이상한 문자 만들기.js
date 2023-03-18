function solution(s) {
    return s.toUpperCase()
        .replace(/[a-zA-Z]{2}/g, (a) => a[0].toUpperCase() + a[1].toLowerCase());
    return s.toLowerCase()
        .split(" ")
        .map(v => [...v].map((v, i) => i % 2 == 0 ? v.toUpperCase() : v).join(""))
        .join(" ");
}

let inps = [
    "try  hello world"
];

inps.forEach(v => console.log(solution(v)));