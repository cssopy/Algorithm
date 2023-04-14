function solution(ingredient) {
    let top = -1;
    let stack = [];

    let ans = 0;
    ingredient.forEach(v => {
        stack[++top] = v;
        if (stack[top - 3] === 1 && stack[top - 2] === 2 && stack[top - 1] === 3 && stack[top] === 1) {
            top -= 4;
            ans++;
        }
    });

    return ans;
}

let inps = [
    [2, 1, 1, 2, 3, 1, 2, 3, 1],
    [1, 3, 2, 1, 2, 1, 3, 1, 2]
];

inps.forEach(inp => console.log(solution(inp)));