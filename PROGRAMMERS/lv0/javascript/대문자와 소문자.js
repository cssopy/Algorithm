function solution(my_string) {
    return [...my_string].reduce((a, b) => a += b <= 'Z' ? b.toLowerCase() : b.toUpperCase(), '');
}

let inps = [
    "cccCCC",
    "abCdEfghIJ"
]

inps.forEach(v => console.log(solution(v)));