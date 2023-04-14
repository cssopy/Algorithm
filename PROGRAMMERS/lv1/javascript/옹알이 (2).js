function solution(babbling) {
    const reg1 = /(aya|ye|woo|ma)\1+/;
    const reg2 = /^(aya|ye|woo|ma)+$/;

    return babbling.reduce((a, b) => !reg1.test(b) && reg2.test(b) ? a + 1 : a, 0);
}

let inps = [
    ["aya", "yee", "u", "maa"],
    ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]
];

inps.forEach(inp => console.log(solution(inp)));