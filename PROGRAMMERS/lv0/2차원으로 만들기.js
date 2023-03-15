function solution(num_list, n) {
    let ans = [];
    for (let i = 0; i < num_list.length; i += n) {
        ans.push(num_list.slice(i, i + n));
    }
    return ans;
}

let inps = [[[1, 2, 3, 4, 5, 6, 7, 8], 2]];

for (let i of inps) {
    console.log(solution(i[0], i[1]));
}