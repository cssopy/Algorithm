function solution(i, j, k) {
    let a = '';
    for (i; i <= j; i++) {
        a += i;
    }
    return a.split(k).length - 1;

    // let ans = 0;
    // for (i; i <= j; i++) {
    //     i.toString().split("").forEach(v => ans += v == k ? 1 : 0);
    // }
    // return ans;
}

let inps = [
    [1, 13, 1],
    [10, 50, 5],
    [3, 10, 2],
]

inps.forEach(v => console.log(solution(v[0], v[1], v[2])));