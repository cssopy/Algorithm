function solution(s) {
    s = s.split(" ").reverse();
    let ans = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] == "Z") {
            i++;
            continue;
        }
        ans += Number(s[i]);
    }
    return ans;
}

let inps = ["1 2 Z 3", "10 20 30 40", "10 Z 20 Z 1", "10 Z 20 Z", "-1 -2 -3 Z"];

inps.forEach((v) => console.log(solution(v)));
