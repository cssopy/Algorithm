def solution(hp):
    ans = 0

    for v in [5, 3, 1]:
        ans += hp//v
        hp %= v
        
    return ans

inps = [
    23,
    24,
    999
]

for inp in inps:
    print(solution(inp))