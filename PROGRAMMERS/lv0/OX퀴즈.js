function solution(quiz) {
    return quiz.reduce((a, b) => {
        b = b.split(" ");

        for (let i = 1, s = parseInt(b[0]); i < b.length; i += 2) {
            if (b[i] == '=') return a += (s == parseInt(b[i + 1]) ? "O" : "X");

            s += b[i] == '-' ? -parseInt(b[i + 1]) : parseInt(b[i + 1]);
        }
    }, "").split("");
}

let inps = [
    ["3 - 4 = -3", "5 + 6 = 11"],
    ["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"]
];

inps.forEach(v => console.log(solution(v)));