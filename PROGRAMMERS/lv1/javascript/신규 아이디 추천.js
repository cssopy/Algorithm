function solution(new_id) {
    return new_id
        .toLowerCase()
        .replace(/[^\w-.]/g, '')
        .replace(/\.{2,}/g, '.')
        .replace(/^\.|\.$/g, '')
        .replace(/^$/, 'a')
        .slice(0, 15)
        .replace(/^\.|\.$/g, '')
        .replace(/^.{0,2}$/, (v) => v + v[v.length - 1].repeat(3 - v.length));
}

let inps = [
    "...!@BaT#*..y.abcdefghijklm",
    "z-+.^.",
    "=.=",
    "123_.def",
    "abcdefghijklmn.p"
];

inps.forEach(inp => console.log(solution(inp)));