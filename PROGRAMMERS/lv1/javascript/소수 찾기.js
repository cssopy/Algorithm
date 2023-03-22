function solution(n) {
    let s = Array.from({length: n}, (_, i) => i);
    for (let i = 2; i <= n ** 0.5; i++) {
        for (let j = 2; j <= (n - i) / i + 1; j++) {
            s[i * j - 1] = 0;
        }
    }
    return s.filter(v => v != 0).length;
}

let inps = [
    10, 5
];

inps.forEach(v => console.log(solution(v)));