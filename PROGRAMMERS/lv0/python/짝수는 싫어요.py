def solution(n):
    return list(range(1, n+1, 2))

inps = [
    10,
    15,
    1
]

for inp in inps:
    print(solution(inp))