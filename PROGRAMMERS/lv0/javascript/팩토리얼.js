function solution(n) {
    let fac = 1;
    for (let i = 1; ; i++) {
        fac *= i;
        if (fac > n) {
            return i - 1;
        }
    }
}

let inps = [3628800, 7];

inps.forEach((v) => console.log(solution(v)));
