function solution(my_string) {
    return my_string.match(/\d/g).reduce((a, b) => a + Number(b), 0);
}

let inps = ["aAb1B2cC34oOp", "1a2b3c4d123"];

inps.forEach((v) => console.log(solution(v)));
