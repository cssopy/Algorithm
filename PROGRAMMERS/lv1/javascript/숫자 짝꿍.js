function solution(X, Y) {
    let y = new Map();
    [...Y].forEach(v => {
        y.set(v, y.get(v) + 1 || 1);
    });

    let goo = [];
    [...X].forEach(v => {
        if (y.get(v) >= 1) {
            goo.push(v);
            y.set(v, y.get(v) - 1);
        }
    });

    let ans = goo.map(v => Number(v)).sort((a, b) => b - a).join('');
    return ans.length == 0 ? '-1' : ans[0] == '0' ? '0' : ans;
}

let inps = [
    ["100", "2345"],
    ["100", "203045"],
    ["100", "123450"],
    ["12321", "42531"],
    ["5525", "1255"]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));