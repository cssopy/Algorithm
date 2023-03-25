def solution(balls, share):
    ans = 1

    for v in range(1, balls+1):
        ans *= v
        if(v <= balls-share): ans /= v
        if(v <= share): ans /= v

    return int(ans)

inps = [
    [3, 2],
    [5, 3],
    [1, 1]
]

for (b, s) in inps:
    print(solution(b, s))