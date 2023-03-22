function solution(my_string, num1, num2) {
    my_string = [...my_string];
    [my_string[num1], my_string[num2]] = [my_string[num2], my_string[num1]];
    return my_string.join("");
}

let inps = [
    ["hello", 1, 2],
    ["I love you", 3, 6]
]

inps.forEach(v => console.log(solution(v[0], v[1], v[2])));