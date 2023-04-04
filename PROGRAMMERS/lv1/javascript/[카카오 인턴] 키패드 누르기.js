const keyPad = {
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    0: [3, 1],
};

function solution(numbers, hand) {
    let lfp = [3, 0], rfp = [3, 2];
    let result = '';
    for (let i = 0; i < numbers.length; i++) {
        const num = numbers[i];

        if (num == 1 || num == 4 || num == 7) {
            result += 'L';
            lfp = keyPad[num];
            continue;
        }

        if (num == 3 || num == 6 || num == 9) {
            result += 'R';
            rfp = keyPad[num];
            continue;
        }

        const [lp, rp, r] = decideFinger(lfp, rfp, num, hand);
        lfp = lp, rfp = rp;
        result += r;
    }

    return result;
}

function decideFinger(lfp, rfp, num, hand) {
    const lp = getDistance(lfp, keyPad[num]);
    const rp = getDistance(rfp, keyPad[num]);

    if (lp == rp) {
        if (hand[0] == 'l') {
            lfp = keyPad[num];
            return [lfp, rfp, 'L'];
        }
        rfp = keyPad[num];
        return [lfp, rfp, 'R'];
    }

    if (lp < rp) {
        lfp = keyPad[num];
        return [lfp, rfp, 'L'];
    }

    rfp = keyPad[num];
    return [lfp, rfp, 'R'];
}

function getDistance(p1, p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
}

let inps = [
    [[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"],
    [[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"],
    [[1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"]
];

inps.forEach(inp => console.log(solution(inp[0], inp[1])));