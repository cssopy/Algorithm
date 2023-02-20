function solution(id_pw, db) {
    let jd = [];
    db.forEach(v => {
        if (v[0] == id_pw[0] && v[1] == id_pw[1]) jd[0] = true;
        if (v[0] == id_pw[0] && v[1] != id_pw[1]) jd[1] = true;
    });
    return jd[0] ? 'login' : !jd[0] && jd[1] ? 'wrong pw' : 'fail';
}

let inps = [
    [["meosseugi", "1234"], [["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]],
    [["programmer01", "15789"], [["programmer02", "111111"], ["programmer00", "134"], ["programmer01", "1145"]]],
    [["rabbit04", "98761"], [["jaja11", "98761"], ["krong0313", "29440"], ["rabbit00", "111333"]]]
]

inps.forEach(v => console.log(solution(v[0], v[1])));