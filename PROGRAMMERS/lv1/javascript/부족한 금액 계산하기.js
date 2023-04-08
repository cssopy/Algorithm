function solution(price, money, count) {
    let total = price * (count * (count + 1) / 2);

    return total > money ? total - money : 0;
}

let inps = [
    [3, 20, 4]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));