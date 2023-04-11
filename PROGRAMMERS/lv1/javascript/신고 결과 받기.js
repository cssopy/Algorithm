function solution(id_list, report, k) {
    report = [...new Set(report)];

    let r = new Map();
    let t = new Map();
    let ft = new Set();
    report.forEach(v => {
        let rt = v.split(' ');

        if (!r.get(rt[0])) r.set(rt[0], []);
        r.get(rt[0]).push(rt[1]);

        t.set(rt[1], t.get(rt[1]) + 1||1);

        if (t.get(rt[1]) >= k) ft.add(rt[1]);
    });

    let ans = [];
    id_list.forEach(id => {
        let c = 0;
        if (r.get(id)) {
            r.get(id).forEach(t => {
                if (ft.has(t)) c++;
            });
        }
        ans.push(c);
    });

    return ans;
}

let inps = [
    [["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2],
    [["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1], inp[2])));