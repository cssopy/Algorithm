function solution(my_str, n) {
    let ans = [];
    for(let i =0; i<my_str.length; i+=n){
        ans.push(my_str.slice(i, i+n));
    }
    return ans;
}

let inps = [
    ["abc1Addfggg4556b", 6],
    ["abcdef123", 3]
];

inps.forEach(v => console.log(solution(v[0], v[1])));