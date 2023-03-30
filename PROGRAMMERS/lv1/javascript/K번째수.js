function solution(participant, completion) {
    let dic = completion.reduce((a, b) => {
        a[b] = a[b] == undefined ? 1 : a[b] + 1;
        return a;
    }, {});

    return participant.filter(v => {
        if (dic[v] >= 1) {
            dic[v]--;
            return false;
        }
        return true;
    })[0];
}

let inps = [
    [["leo", "kiki", "eden"], ["eden", "kiki"]],
    [["marina", "josipa", "nikola", "vinko", "filipa"], ["josipa", "filipa", "marina", "nikola"]],
    [["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));