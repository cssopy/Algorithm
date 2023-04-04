function solution(n, lost, reserve) {
    let un = Array(n).fill(1);

    lost.sort((a, b) => a - b);
    reserve.sort((a, b) => a - b);

    reserve.forEach(v => un[v - 1]++);
    lost.forEach(v => un[v - 1]--);

    reserve.forEach(v => {
        if (un[v - 1] == 2) {
            if (un[v - 2] == 0) {
                un[v - 1]--;
                un[v - 2]++;
            } else if (un[v] == 0) {
                un[v - 1]--;
                un[v]++;
            }
        }
    });

    return un.filter(v => v != 0).length;
}

let inps = [
    [5, [2, 4, 3], [1, 3, 5]],
    [5, [2, 4], [3]],
    [3, [3], [1]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));