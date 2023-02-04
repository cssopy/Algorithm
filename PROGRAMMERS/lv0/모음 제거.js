function solution(my_string) {
    let vw = ["a", "e", "i", "o", "u"];
    return [...my_string].filter((v) => !vw.includes(v)).join("");
}

let inps = ["bus", "nice to meet \nyou"];

inps.forEach((v) => console.log(solution(v)));
