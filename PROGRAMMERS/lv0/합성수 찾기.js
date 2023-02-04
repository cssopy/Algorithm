function solution(n) {
    let ans = Array(n + 1).fill(true);
    ans.forEach((v, i) => {
        if (i >= 2 && i <= Math.ceil(Math.sqrt(n))) {
            if (v == true) {
                let j = 2;
                while (i * j <= n) {
                    ans[i * j] = false;
                    j++;
                }
            }
        }
    });
    return ans.filter((v) => !v).length;
}

let inps = [10, 15];

inps.forEach((v) => console.log(solution(v)));
