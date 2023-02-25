function solution(sides) {
    sides = sides.sort();
    return sides[2] < sides[0] + sides[1] ? 1 : 2;
}

let inps = [
    [1, 2, 3],
    [3, 6, 2],
    [199, 72, 222]
]

inps.forEach(v => console.log(solution(v)));