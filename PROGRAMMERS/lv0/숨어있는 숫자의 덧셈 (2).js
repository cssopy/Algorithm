function solution(my_string) {
    return my_string.split(/\D/g).reduce((a, b) => a + Number(b), 0);
}

let inps = ["aAb1B2cC34oOp", "1a2b3c4d123Z"];

inps.forEach((v) => console.log(solution(v)));
