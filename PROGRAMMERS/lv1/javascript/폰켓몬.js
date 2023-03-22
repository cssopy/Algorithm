function solution(nums) {
    let l = new Set(nums).size;
    return l > nums.length / 2 ? nums.length / 2 : l;
}

let inps = [
    [3, 1, 2, 3],
    [3, 3, 3, 2, 2, 4],
    [3, 3, 3, 2, 2, 2]
];

inps.forEach(v => console.log(solution(v)));