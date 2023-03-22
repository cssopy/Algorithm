function solution(numbers) {
    numbers.sort((a, b) => a - b);
    let a = numbers[0] * numbers[1];
    let b = numbers[numbers.length - 1] * numbers[numbers.length - 2];
    return Math.max(a, b);
}

let inps = [
    [1, 2, -3, 4, -5],
    [0, -31, 24, 10, 1, 9],
    [10, 20, 30, 5, 5, 20, 5],
];

inps.forEach((v) => console.log(solution(v)));
