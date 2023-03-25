def solution(emergency):
    se = sorted(emergency, reverse=True)
    dic = {v:i+1 for (i, v) in enumerate(se)}
    return [dic[v] for v in emergency]

inps = [
    [3, 76, 24],
    [1, 2, 3, 4, 5, 6, 7],
    [30, 10, 23, 6, 100]
]

for inp in inps:
    print(solution(inp))