"use strict";
function solution(wallpaper) {
    let ans = [wallpaper.length, wallpaper[0].length, 0, 0];
    wallpaper.forEach((r, i) => {
        if(r.includes('#')){
            ans[0] = Math.min(ans[0], i);
            ans[1] = Math.min(ans[1], r.indexOf('#'));
            ans[2] = Math.max(ans[2], i + 1);
            ans[3] = Math.max(ans[3], r.lastIndexOf('#') + 1);
        }
    });

    return ans;
}

let inps = [
    [".#...", "..#..", "...#."],
    ["..........", ".....#....", "......##..", "...##.....", "....#....."],
    [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."],
    ["..", "#."]
];

inps.forEach(inp => console.log(solution(inp)));
