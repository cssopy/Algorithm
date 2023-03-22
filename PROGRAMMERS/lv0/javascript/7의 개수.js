function solution(array) {
    return array.join("").split("7").length - 1;
}

let inps = [
    [7, 77, 17],
    [10, 29]
];

inps.forEach(v => console.log(solution(v)));