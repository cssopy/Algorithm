function solution(bin1, bin2) {
    bin1 = bin1.length > bin2.length ? bin1 : '0'.repeat(Math.abs(bin1.length - bin2.length)) + bin1;
    bin2 = bin2.length > bin1.length ? bin2 : '0'.repeat(Math.abs(bin1.length - bin2.length)) + bin2;

    let ans = Array.from({length: bin1.length + 1}, () => 0);
    for (let i = bin1.length - 1; i >= 0; i--) {
        ans[i + 1] += bin1[i] == '1' ? 1 : 0;
        ans[i + 1] += bin2[i] == '1' ? 1 : 0;

        if (ans[i + 1] >= 2) {
            ans[i] += 1;
            ans[i + 1] = ans[i + 1] % 2;
        }
    }

    return parseInt(ans.join('')).toString();
    // return (parseInt(bin1, 2) + parseInt(bin2, 2)).toString(2);
}

let inps = [
    ["10", "111"],
    ["10", "11"],
    ["1001", "1111"],
    ["0", "1111"]
]

inps.forEach(v => console.log(solution(v[0], v[1])));
