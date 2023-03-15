function solution(s) {
    return /^\d{4}(\d{2})?$/.test(s);
    return (s.length == 4 || s.length == 6) && s.split(/[^0-9]/g).length == 1;
}

let inps = [
    "a234",
    "1234",
    "10e1"
];

inps.forEach(v => console.log(solution(v)));