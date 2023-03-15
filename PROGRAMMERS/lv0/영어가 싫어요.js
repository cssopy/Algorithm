let map = {
    zero: 0,
    one: 1,
    two: 2,
    three: 3,
    four: 4,
    five: 5,
    six: 6,
    seven: 7,
    eight: 8,
    nine: 9,
}

let reg = /zero|one|two|three|four|five|six|seven|eight|nine/g;

function solution(numbers) {
    return parseInt(numbers.replace(reg, v => map[v]));
}

let inps = [
    "onetwothreefourfivesixseveneightnine",
    "onefourzerosixseven"
]

inps.forEach(v => console.log(solution(v)));