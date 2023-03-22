function solution(my_string) {
    return my_string
        .match(/\d/g)
        .sort((a, b) => a - b)
        .map((v) => Number(v));
}

let inps = ["hi12392", "p2o4i8gj2", "abcde0"];

inps.forEach((v) => console.log(solution(v)));
