function solution(num) {
    for (let i = 0; i < 500; i++, num = num % 2 == 0 ? num / 2 : num * 3 + 1) {
        if (num == 1) return i;
    }
    return -1;
}

let inps = [
    1, 6, 16, 626331
];

inps.forEach(v => console.log(solution(v)));

