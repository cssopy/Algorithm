function solution(polynomial) {
    polynomial = polynomial.split("+");

    let c = polynomial.reduce(
        (a, b) => {
            if (b.includes("x")) {
                b = b.replace("x", "");
                b = b == 0 ? 1 : b;
                a[0] += Number(b);
            } else {
                a[1] += Number(b);
            }
            return a;
        },
        [0, 0]
    );

    let ans = [];
    if (c[0]) {
        ans.push(`${c[0] == 1 ? "" : c[0]}x`);
    }
    if (c[1]) {
        ans.push(c[1]);
    }

    return ans.join(" + ");
}

let inps = ["3x + 7 + x", "x + x + x", "7 + x", "1x", "15"];

inps.forEach((v) => console.log(solution(v)));
