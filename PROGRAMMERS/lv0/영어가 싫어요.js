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

function solution(numbers) {
    for (let k in map) {
        numbers = numbers.replaceAll(k, v=>map[v]);
    }
}

let inps = [
    "onetwothreefourfivesixseveneightnine",
    "onefourzerosixseven"
]

inps.forEach(v => console.log(solution(v)));