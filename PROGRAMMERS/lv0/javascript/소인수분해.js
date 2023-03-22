function solution(n) {
    let ans = [],
        i = 2;
    while (n != 1) {
        if (n % i == 0) {
            if (ans[ans.length - 1] != i) {
                ans.push(i);
            }
            n /= i;
        } else {
            i++;
        }
    }
    return ans;
}

let inps = [12, 17, 420];

inps.forEach((v) => console.log(solution(v)));
