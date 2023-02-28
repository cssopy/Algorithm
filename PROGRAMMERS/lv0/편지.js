function solution(message) {
    return message.length * 2;
}

let inps = [
    "happy birthday!",
    "I love you~"
]

inps.forEach(v => console.log(solution(v)));