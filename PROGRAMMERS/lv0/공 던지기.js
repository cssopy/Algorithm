function solution(numbers, k) {
    return numbers[((k - 1) * 2) % numbers.length];
}

let inps = [
    [[1, 2, 3, 4], 2],
    [[1, 2, 3, 4, 5, 6], 5],
    [[1, 2, 3], 3],
];

inps.forEach((i) => console.log(solution(i[0], i[1])));
