function solution(nums) {
    let ans = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                if (isPN(nums[i] + nums[j] + nums[k])) ans++;
            }
        }
    }

    return ans;
}

function isPN(n) {
    for (let i = 2; i <= n ** 0.5; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

let inps = [
    [1, 2, 3, 4],
    [1, 2, 7, 6, 4]
];

inps.forEach(v => console.log(solution(v)));