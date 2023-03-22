function solution(babbling) {
    return babbling.reduce((a, b) => {
        return a += b.split(/aya|ye|woo|ma/g).filter(v => v != '').length != 0 ? 0 : 1;
    }, 0);
}

let inps = [
    ["aya", "yee", "u", "maa", "wyeoo"],
    ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]
];

inps.forEach(v => console.log(solution(v)));