function solution(my_string) {
    my_string = my_string.split(" ");

    let ans = parseInt(my_string[0]);
    for (let i = 1; i < my_string.length; i += 2) {
        ans += my_string[i] == "+" ? parseInt(my_string[i + 1]) : -parseInt(my_string[i + 1]);
    }

    return ans;
}

let inps = [
    "3 + 4",
]

inps.forEach(v => console.log(solution(v)));