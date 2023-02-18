function solution(n) {
    for (let t = 1, th = 1; ; t++, th++) {
        for (; th % 3 == 0 || th.toString().includes("3"); ) {
            th++;
        }

        if (t == n) {
            return th;
        }
    }
}

let inps = [15, 40];

inps.forEach((v) => console.log(solution(v)));
