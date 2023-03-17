function solution(n) {
    let ans = 0;
    for (let i = 0; i <= Math.sqrt(n); i++) {
        if (n % i == 0) ans += i != n / i ? i + n / i : i;
    }
    return ans;
}

let inps = [
    12, 5
];

inps.forEach(v => console.log(solution(v)));