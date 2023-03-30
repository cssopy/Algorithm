function solution(array, commands) {
    return commands.reduce((a, b) => {
        a.push(array.slice(b[0] - 1, b[1]).sort((a, b) => a - b)[b[2] - 1]);
        return a;
    }, []);
}

let inps = [
    [[1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));