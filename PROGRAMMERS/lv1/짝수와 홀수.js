function solution(num) {
    return num % 2 == 0 ? "Even" : "Odd";
}

let inps = [
    3, 4
];

inps.forEach(v => console.log(solution(v)));