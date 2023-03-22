function solution(order) {
    return ("" + order).split(/[369]/g).length - 1;
}

let inps = [
    3, 29423
]

inps.forEach(v => console.log(solution(v)));