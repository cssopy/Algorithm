function solution(sizes) {
    let max = 0, min = 0;
    sizes.forEach(size => {
        max = Math.max(max, Math.max(...size));
        min = Math.max(min, Math.min(...size));
    });

    return max * min;
}

let inps = [
    [[60, 50], [30, 70], [60, 30], [80, 40]],
    [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]],
    [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
];

inps.forEach(inp => console.log(solution(inp)));