function solution(phone_number) {
    return phone_number.replace(/.(?=.{4})/g, "*");
    return '*'.repeat(phone_number.length - 4) + phone_number.slice(-4);
}

let inps = [
    "01033334444",
    "027778888",
    "1234"
];

inps.forEach(v => console.log(solution(v)));