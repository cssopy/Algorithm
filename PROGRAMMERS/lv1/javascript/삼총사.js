function solution(number) {
    let ans = 0;
    for (let i = 0; i < number.length; i++) {
        for (let j = i + 1; j < number.length; j++) {
            for (let k = j + 1; k < number.length; k++) {
                if(number[i]+number[j]+number[k]===0) ans++;
            }
        }
    }
    return ans;
}

let inps = [
    [-2, 3, 0, 2, -5],
    [-3, -2, -1, 0, 1, 2, 3],
    [-1, 1, -1, 1]
];

inps.forEach(inp => console.log(solution(inp)));