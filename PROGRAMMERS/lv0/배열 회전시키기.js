function solution(numbers, direction) {
    return direction == "right"
        ? numbers.splice(numbers.length - 1, 1).concat(numbers)
        : numbers.concat(numbers.splice(0, 1));
}

let inps = [
    [[1, 2, 3], "right"],
    [[4, 455, 6, 4, -1, 45, 6], "left"],
];

inps.forEach((v) => console.log(solution(v[0], v[1])));
