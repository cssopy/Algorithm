def solution(array):
    m = {}
    for v in array:
        m[v] = m[v]+1 if v in m else 1
    m = sorted(m.items(), key=lambda x:x[1], reverse=True)
    return m[0][0] if len(m)==1 or m[0][1] > m[1][1] else -1

inps = [
    [1, 2, 3, 3, 3, 4],
    [1, 1, 2, 2],
    [1],
]

for inp in inps:
    print(solution(inp))