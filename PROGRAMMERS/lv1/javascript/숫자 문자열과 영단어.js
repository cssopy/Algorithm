const map = {
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
};

function solution(s) {
    return Number(s.replace(/zero|one|two|three|four|five|six|seven|eight|nine/g, (v) => map[v]));
}

let inps = [
    "one4seveneight",
    "23four5six7",
    "2three45sixseven",
    "123"
];

inps.forEach(inp => console.log(solution(inp)));