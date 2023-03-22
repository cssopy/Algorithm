function solution(seoul) {
    return `김서방은 ${seoul.indexOf("Kim")}에 있다`;
}

let inps = [
    ["Jane", "Kim"]
];

inps.forEach(v => console.log(solution(v)));