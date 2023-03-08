function solution(arr) {
    return arr.reduce((a, b, i) => {
        if (arr[i - 1] != b) {
            a.push(b);
        }
        return a;
    }, []);
}

let inps = [
    [1, 1, 3, 3, 0, 1, 1],
    [4, 4, 4, 3, 3]
];

inps.forEach(v => console.log(solution(v)));