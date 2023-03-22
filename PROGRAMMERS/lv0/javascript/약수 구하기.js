function solution(n) {
    let set = new Set();

    Array.from({length: Math.sqrt(n)}, (v, i) => i + 1).forEach(v => {
        if (n % v == 0) {
            set.add(v);
            set.add(n / v);
        }
    });

    return Array.from(set).sort((a, b) => a - b);
}

let inps = [
    24, 29
]

inps.forEach(v => console.log(solution(v)));