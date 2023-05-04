function solution(myString) {
    return myString.replace(/[a-k]/g, 'l');
}

let inps = [
    "abcdevwxyz",
    "jjnnllkkmm"
];

inps.forEach(inp => console.log(solution(inp)));