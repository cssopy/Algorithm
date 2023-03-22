function solution(chicken) {
    let ans = 0;
    while (parseInt(chicken / 10) != 0) {
        ans += parseInt(chicken / 10);
        chicken = parseInt(chicken / 10) + chicken % 10;
    }
    return ans;
}

let inps = [
    100,
    1081
]

inps.forEach(v => console.log(solution(v)));