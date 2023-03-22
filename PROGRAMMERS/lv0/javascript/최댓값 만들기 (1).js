function solution(numbers) {
    numbers.sort((a, b) => b - a);
    return numbers[0] * numbers[1];
}

let inps = [
    [1, 2, 3, 4, 5],
    [0, 31, 24, 10, 1, 9],
];

inps.forEach((v) => console.log(solution(v)));
