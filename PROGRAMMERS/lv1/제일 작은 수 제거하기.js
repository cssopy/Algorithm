function solution(arr) {
    arr.splice(arr.indexOf(Math.min(...arr)), 1);
    return arr.length == 0 ? [-1] : arr;
}

let inps = [
    [4, 3, 2, 1],
    [10]
];

inps.forEach(v => console.log(solution(v)));